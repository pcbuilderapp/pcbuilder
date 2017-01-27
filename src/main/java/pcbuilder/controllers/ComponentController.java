package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.transport.MinDailyPriceResponse;
import pcbuilder.domain.Component;
import pcbuilder.domain.MinDailyPriceView;
import pcbuilder.repository.ComponentRepository;
import pcbuilder.repository.MinDailyPriceViewRepository;

import java.util.List;

/**
 * The Class ComponentController.
 */
@RestController
public class ComponentController {

    /** The component repository. */
    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private MinDailyPriceViewRepository minDailyPriceViewRepository;

    /**
     * Creates the component.
     *
     * @param component
     * @return the response entity
     */
    @RequestMapping(value="/component/create", method=RequestMethod.POST)
    public ResponseEntity<String> createComponent(@RequestBody Component component) {
        if (componentRepository.findByManufacturerPartNumber(component.getManufacturerPartNumber()) == null) {
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




    @CrossOrigin(origins = "*")
    @RequestMapping(value="/component/getpricehistory", method=RequestMethod.GET)
    public MinDailyPriceResponse getGroupedPriceHistory(long componentId) {

        List<MinDailyPriceView> minDailyPriceViews = minDailyPriceViewRepository.findAllByComponentId(componentId);

        MinDailyPriceResponse minDailyPriceResponse = new MinDailyPriceResponse();
        minDailyPriceResponse.setMinDailyPriceViewList(minDailyPriceViews);

        return minDailyPriceResponse;
    }
}
