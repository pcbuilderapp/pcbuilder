package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.transport.*;
import pcbuilder.domain.CType;
import pcbuilder.domain.Component;
import pcbuilder.domain.Connector;
import pcbuilder.domain.Product;
import pcbuilder.repository.ComponentRepository;
import pcbuilder.repository.ProductRepository;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class ComponentItemController.
 */
@RestController
public class ComponentItemController {
    
    /** The component repository. */
    @Autowired
    private ComponentRepository componentRepository;

    /** The product repository. */
    @Autowired
    private ProductRepository productRepository;

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

        Page<Component> components;
        List<Connector> connectors = getConnectors(configuration, request);

        if (configuration.getMotherboard() != null && request.getType() != CType.MOTHERBOARD) {
            // we hebben een moederbord
            components = componentRepository.findByNameContainingAndTypeAndConnectorsIn(request.getFilter(), request.getType(), connectors, pageRequest);

        } else if (connectors.isEmpty() && request.getType() == CType.MOTHERBOARD) {
            // geen moederbord, wel componenten, nu een moederbord aan het kiezen
            components = componentRepository.findByNameContainingAndWithAllConnectorsPaged(request.getFilter(), request.getType(), connectors, (long) connectors.size(), pageRequest);

        } else if (connectors.isEmpty()) {
            // geen moederbord, wel components, nu niet een moederbord aan het kiezen
            List<Component> motherboards = componentRepository.findByNameContainingAndWithAllConnectors("", CType.MOTHERBOARD, connectors, (long) connectors.size());
            // bouw connector lijst op basis van deze moederborden

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

        List<Connector> motherboardConnectors = new LinkedList<>();

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

        for (Component component : components) {

            List<Product> products = productRepository.findByComponentOrderByCurrentPriceAsc(component);

            if (products.isEmpty()) {
                ComponentItem item = new ComponentItem(component, products.get(0), products.subList(1, products.size()));
                componentItemList.add(item);
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
}
