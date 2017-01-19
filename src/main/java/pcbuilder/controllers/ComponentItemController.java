package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

@RestController
public class ComponentItemController {
    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private ProductRepository productRepository;

    // TODO: matching
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/componentitem/getmatchingcomponents", method= RequestMethod.POST)
    public ComponentItemResponse getMatchingComponents(@RequestBody ComponentMatchingSearch request) {
        Configuration configuration = request.getConfiguration();

        // creating a page request to setup paginated query results
        PageRequest pageRequest = new PageRequest(request.getPage().intValue(), request.getMaxItems().intValue());

        Page<Component> components;
        List<Connector> connectors = new LinkedList<>();
        //List<Component> cfgComponents = new LinkedList<>();
        if (configuration.getMotherboard() != null && request.getType() != CType.MOTHERBOARD) {
            connectors = (componentRepository.getOne(configuration.getMotherboard().getId())).getConnectors();
        } else if (request.getType() == CType.MOTHERBOARD) {
            for (ComponentRef componentRef : configuration) {
                if (componentRef == null) continue;
                if (componentRef == configuration.getMotherboard()) continue;
                connectors.addAll(componentRepository.getOne(componentRef.getId()).getConnectors());
            }
        }

        if (configuration.getMotherboard() != null && request.getType() != CType.MOTHERBOARD) {
            // we hebben een moederbord
            components = componentRepository.findByNameContainingAndTypeAndConnectorsIn(request.getFilter(), request.getType(),connectors,pageRequest);
        } else if (connectors.size()>0 && request.getType() == CType.MOTHERBOARD) {
            // geen moederbord, wel componenten, nu een moederbord aan het kiezen
            components = componentRepository.findByNameContainingAndWithAllConnectors(request.getFilter(), request.getType(),connectors,Long.valueOf(connectors.size()),pageRequest);
        } else {
            // geen moederbord, nu niet een moederbord aan het kiezen
            components = componentRepository.findByNameContainingAndType(request.getFilter(), request.getType(),pageRequest);
        }

        ComponentItemResponse response = new ComponentItemResponse();
        List<ComponentItem> componentItemList = new LinkedList<>();
        for (Component component : components.getContent()) {
            List<Product> products = productRepository.findByComponentOrderByCurrentPriceAsc(component);
            assert(products.size() > 0);
            ComponentItem item = new ComponentItem(component,products.get(0),products.subList(1,products.size()));
            componentItemList.add(item);
        }
        response.setComponents(componentItemList);
        response.setPage(components.getNumber());
        response.setPageCount(components.getTotalPages());
        return response;
    }
}
