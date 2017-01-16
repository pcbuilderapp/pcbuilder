package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.domain.Component;
import pcbuilder.repository.ComponentRepository;

@RestController
public class ComponentController {

    @Autowired
    private ComponentRepository componentRepository;

    @RequestMapping(value="/component/create", method=RequestMethod.POST)
    public ResponseEntity<String> createComponent(@RequestBody Component component) {
        if (componentRepository.findByBrandAndManufacturerPartNumber(component.getBrand(), component.getEuropeanArticleNumber()).isEmpty()) {
            componentRepository.save(component);
        } else {
            return new ResponseEntity<String>("Component already exists!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>("Component has been created!", HttpStatus.CREATED);
    }

    @RequestMapping(value="/component/getall", method=RequestMethod.GET)
    public Iterable<Component> getAllComponents() {
        return componentRepository.findAll();
    }

}