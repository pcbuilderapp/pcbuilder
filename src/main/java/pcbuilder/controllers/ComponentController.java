package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.dto.MinDailyPriceResponse;
import pcbuilder.controllers.dto.PriceHistoryResponse;
import pcbuilder.controllers.dto.PricePointData;
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
    public PriceHistoryResponse getComponentMinPriceHistory(long componentId) {

        return priceHistoryResponseFromMinDailyPriceView(minDailyPriceViewRepository.findByComponentIdOrderByDate(componentId));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/component/getmaxpricehistory", method=RequestMethod.GET)
    public PriceHistoryResponse getComponentMaxPriceHistory(long componentId) {

        return priceHistoryResponseFromMaxDailyPriceView(maxDailyPriceViewRepository.findByComponentIdOrderByDate(componentId));
    }

    private PriceHistoryResponse priceHistoryResponseFromMinDailyPriceView(List<MinDailyPriceView> minDailyPriceViews) {
        PriceHistoryResponse priceHistoryResponse = new PriceHistoryResponse();
        for (MinDailyPriceView minDailyPriceView : minDailyPriceViews) {
            PricePointData pricePointData = new PricePointData(minDailyPriceView.getDate(), minDailyPriceView.getPrice());
            priceHistoryResponse.addPriceHistory(pricePointData);
        }
        return priceHistoryResponse;
    }

    private PriceHistoryResponse priceHistoryResponseFromMaxDailyPriceView(List<MaxDailyPriceView> maxDailyPriceViews) {
        PriceHistoryResponse priceHistoryResponse = new PriceHistoryResponse();
        for (MaxDailyPriceView maxDailyPriceView : maxDailyPriceViews) {
            PricePointData pricePointData = new PricePointData(maxDailyPriceView.getDate(), maxDailyPriceView.getPrice());
            priceHistoryResponse.addPriceHistory(pricePointData);
        }
        return priceHistoryResponse;
    }
}
