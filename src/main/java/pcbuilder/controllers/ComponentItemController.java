package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.dto.*;
import pcbuilder.domain.*;
import pcbuilder.repository.ComponentRepository;
import pcbuilder.repository.MinDailyPriceViewRepository;
import pcbuilder.repository.ProductRepository;

import java.util.*;

/**
 * The Class ComponentItemController.
 */
@RestController
public class ComponentItemController {
    
    /** The ComponentRepository. */
    @Autowired
    private ComponentRepository componentRepository;

    /** The ProductRepository. */
    @Autowired
    private ProductRepository productRepository;

    /** The MinDailyPriceViewRepository. */
    @Autowired
    private MinDailyPriceViewRepository minDailyPriceViewRepository;

    /**
     * Gets the matching components.
     *
     * @param request ComponentMatchingSearch
     * @return ComponentItemResponse
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/componentitem/getmatchingcomponents", method = RequestMethod.POST)
    public ComponentItemResponse getMatchingComponents(@RequestBody ComponentMatchingSearch request) {

        Configuration configuration = request.getConfiguration();

        Sort sort = createSort(request.getSort());

        // creating a page request to setup paginated query results
        PageRequest pageRequest = new PageRequest(request.getPage().intValue(), request.getMaxItems().intValue(), sort);

        List<Connector> connectors = getConnectors(configuration, request);

        Page<Component> components;
        if (configuration.getMotherboard() != null && request.getType() != CType.MOTHERBOARD) {
            // we hebben een moederbord
            components = componentRepository.findByNameContainingAndTypeAndConnectorsIn(request.getFilter(), request.getType(), connectors, pageRequest);

        } else if (!connectors.isEmpty() && request.getType() == CType.MOTHERBOARD) {
            // geen moederbord, wel componenten, nu een moederbord aan het kiezen
            components = componentRepository.findMotherboardByConnectorsIn(request.getFilter(), connectors, pageRequest);

        } else if (!connectors.isEmpty()) {

            // geen moederbord, wel components, nu niet een moederbord aan het kiezen
            List<Component> motherboards = componentRepository.findByTypeAndConnectorsIn(CType.MOTHERBOARD, connectors);

            // geef componenten
            components = componentRepository.findByNameContainingAndTypeAndConnectorsIn(request.getFilter(), request.getType(), getMotherboardConnectors(motherboards), pageRequest);

        } else {
            // geen moederbord, nu niet een moederbord aan het kiezen
            components = componentRepository.findByNameContainingAndType(request.getFilter(), request.getType(), pageRequest);
        }

        return generateComponentItemResponse(components);
    }

    private Sort createSort(String sortingColumn) {

        Sort sort;

        if (sortingColumn == null || "".equals(sortingColumn)) {
            sort = new Sort("name");
        } else {
            if ("brand".equals(sortingColumn)) {
                sort = new Sort(sortingColumn);
            } else {
                sort = new Sort("name");
            }
        }

        return sort;
    }

    private List<Connector> getMotherboardConnectors(List<Component> motherboards) {

        List<Connector> motherboardConnectors = new ArrayList<>();

        for (Component motherboard : motherboards) {
            for (Connector connector : motherboard.getConnectors()) {
                if (motherboardConnectors.contains(connector))
                    continue;
                motherboardConnectors.add(connector);
            }
        }

        return motherboardConnectors;
    }

    private ComponentItemResponse generateComponentItemResponse(Page<Component> components) {

        ComponentItemResponse componentItemResponse = new ComponentItemResponse();

        List<ComponentItem> componentItemList = new LinkedList<>();

        Date toDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(toDate);
        c.add(Calendar.DAY_OF_MONTH, -7);
        Date fromDate = c.getTime();

        for (Component component : components) {

            List<MinDailyPriceView> pricePoints = minDailyPriceViewRepository
                    .findByComponentIdAndDateBetweenOrderByDate(component.getId(), fromDate, toDate);
            List<Product> products = productRepository.findByComponentOrderByCurrentPriceAsc(component);

            if (!products.isEmpty()) {

                ComponentItem item = new ComponentItem(component, products.get(0), products.subList(1, products.size()));
                componentItemList.add(setPriceFallingIndicator(pricePoints, item));
            }
        }

        componentItemResponse.setComponents(componentItemList);
        componentItemResponse.setPage(components.getNumber());
        componentItemResponse.setPageCount(components.getTotalPages());

        return componentItemResponse;
    }

    private List<Connector> getConnectors(Configuration configuration, ComponentMatchingSearch request) {

        List<Connector> connectors = new LinkedList<>();

        if (configuration.getMotherboard() != null && request.getType() != CType.MOTHERBOARD) {
            connectors = (componentRepository.getOne(configuration.getMotherboard().getId())).getConnectors();

        } else if (request.getType() == CType.MOTHERBOARD || configuration.hasComponents()) {
            for (ComponentRef componentRef : configuration) {
                if (componentRef != null && componentRef != configuration.getMotherboard())
                    connectors.addAll(componentRepository.getOne(componentRef.getId()).getConnectors());
            }
        }

        return connectors;
    }

    private ComponentItem setPriceFallingIndicator(List<MinDailyPriceView> pricePoints, ComponentItem item) {

        if (!pricePoints.isEmpty()) {

            if (pricePoints.get(0).getPrice() > pricePoints.get(pricePoints.size() - 1).getPrice()) {
                item.setPriceFalling(false);
            } else {
                item.setPriceFalling(true);
            }

        } else {
            item.setPriceFalling(false);
        }

        return item;
    }
}
