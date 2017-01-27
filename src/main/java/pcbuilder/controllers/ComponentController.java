package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.transport.MaxDailyPriceResponse;
import pcbuilder.controllers.transport.MinDailyPriceResponse;
import pcbuilder.domain.Component;
import pcbuilder.domain.MaxDailyPriceView;
import pcbuilder.domain.MinDailyPriceView;
import pcbuilder.repository.ComponentRepository;
import pcbuilder.repository.MaxDailyPriceViewRepository;
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

    @Autowired
    private MaxDailyPriceViewRepository maxDailyPriceViewRepository;
    /**
     * Creates the component.
     *
     * @param component Component
     * @return the response entity
     */
    @RequestMapping(value="/component/create", method=RequestMethod.POST)
    public ResponseEntity<String> createComponent(@RequestBody Component component) {
        if (componentRepository.findByManufacturerPartNumber(component.getManufacturerPartNumber()) == null) {
            componentRepository.save(component);
        } else {
            return new ResponseEntity<>("Component already exists!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Component has been created!", HttpStatus.CREATED);
    }

    /**
     * Gets all the components.
     *
     * @return Iterable
     */
    @RequestMapping(value="/component/getall", method=RequestMethod.GET)
    public Iterable<Component> getAllComponents() {
        return componentRepository.findAll();
    }

    /**
     * Gets component by id.
     *
     * @param id Long
     * @return Component
     */
    public Component getById(Long id) {
        return componentRepository.getOne(id);
    }




    @CrossOrigin(origins = "*")
    @RequestMapping(value="/component/getminpricehistory", method=RequestMethod.GET)
    public MinDailyPriceResponse getComponentMinPriceHistory(long componentId) {

        List<MinDailyPriceView> minDailyPriceViews = minDailyPriceViewRepository.findByComponentIdOrderByDate(componentId);

        MinDailyPriceResponse minDailyPriceResponse = new MinDailyPriceResponse();
        minDailyPriceResponse.setMinDailyPriceViewList(minDailyPriceViews);

        return minDailyPriceResponse;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/component/getmaxpricehistory", method=RequestMethod.GET)
    public MaxDailyPriceResponse getComponentMaxPriceHistory(long componentId) {

        List<MaxDailyPriceView> maxDailyPriceViews = maxDailyPriceViewRepository.findByComponentIdOrderByDate(componentId);

        MaxDailyPriceResponse maxDailyPriceResponse = new MaxDailyPriceResponse();
        maxDailyPriceResponse.setMaxDailyPriceViewList(maxDailyPriceViews);

        return maxDailyPriceResponse;
    }
}
