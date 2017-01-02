package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.transport.ComponentItem;
import pcbuilder.controllers.transport.ComponentItemResponse;
import pcbuilder.controllers.transport.ComponentMatchingSearch;
import pcbuilder.domain.Component;
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
        //return componentRepository.findByType(request.getType());
        //return componentRepository.findByNameContainingAndType(request.getFilter(), request.getType());
        PageRequest pageRequest = new PageRequest(request.getPage().intValue(),request.getMaxItems().intValue());
        Page<Component> components = componentRepository.findByNameContainingAndType(request.getFilter(), request.getType(),pageRequest);
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
