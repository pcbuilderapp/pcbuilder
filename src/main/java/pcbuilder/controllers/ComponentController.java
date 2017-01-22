package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.domain.Component;
import pcbuilder.repository.ComponentRepository;

/**
 * The Class ComponentController.
 */
@RestController
public class ComponentController {

    /** The component repository. */
    @Autowired
    private ComponentRepository componentRepository;

    /**
     * Creates the component.
     *
     * @param component
     * @return the response entity
     */
    @RequestMapping(value="/component/create", method=RequestMethod.POST)
    public ResponseEntity<String> createComponent(@RequestBody Component component) {
        if (componentRepository.findByBrandAndManufacturerPartNumber(component.getBrand(), component.getEuropeanArticleNumber()).isEmpty()) {
            componentRepository.save(component);
        } else {
            return new ResponseEntity<String>("Component already exists!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>("Component has been created!", HttpStatus.CREATED);
    }

    /**
     * Gets all the components.
     *
     * @return all the components
     */
    @RequestMapping(value="/component/getall", method=RequestMethod.GET)
    public Iterable<Component> getAllComponents() {
        return componentRepository.findAll();
    }

    /**
     * Gets component by id.
     *
     * @param id
     * @return Component
     */
    public Component getById(Long id) {
        return componentRepository.getOne(id);
    }
}
