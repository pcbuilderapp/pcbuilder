package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pcbuilder.domain.Component;
import pcbuilder.repository.ComponentRepository;

@RestController
public class ComponentController {

    @Autowired
    private ComponentRepository componentRepository;

    @RequestMapping(value="/component/create", method=RequestMethod.POST)
    public String createVideoCard(@RequestBody Component component) {
        componentRepository.save(component);
        return "Component has been created!";
    }

    @RequestMapping(value="/component/getall", method=RequestMethod.GET)
    public Iterable<Component> getAllComponentsCard() {
        return componentRepository.findAll();
    }

}
