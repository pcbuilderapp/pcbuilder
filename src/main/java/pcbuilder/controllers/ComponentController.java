package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.dto.PriceHistoryRequest;
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

    /**
     *
     * @param priceHistoryRequest PriceHistoryRequest
     * @return PriceHistoryResponse
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/component/pricehistory", method=RequestMethod.POST)
    public PriceHistoryResponse getComponentPriceHistory(@RequestBody PriceHistoryRequest priceHistoryRequest) {

        if (priceHistoryRequest.isMin()) {

            List<MinDailyPriceView> minDailyPriceViews;

            if (priceHistoryRequest.getFromDate() == null || priceHistoryRequest.getToDate() == null) {

                minDailyPriceViews = minDailyPriceViewRepository.findByComponentIdOrderByDate(
                        priceHistoryRequest.getComponentId());

            } else {

                minDailyPriceViews = minDailyPriceViewRepository.findByComponentIdAndDateBetweenOrderByDate(
                        priceHistoryRequest.getComponentId(),
                        priceHistoryRequest.getFromDate(),
                        priceHistoryRequest.getToDate());
            }

            return priceHistoryResponseFromMinDailyPriceView(minDailyPriceViews);

        } else {

            List<MaxDailyPriceView> maxDailyPriceViews;

            if (priceHistoryRequest.getFromDate() == null || priceHistoryRequest.getToDate() == null) {

                maxDailyPriceViews = maxDailyPriceViewRepository.findByComponentIdOrderByDate(
                        priceHistoryRequest.getComponentId());

            } else {

                maxDailyPriceViews = maxDailyPriceViewRepository.findByComponentIdAndDateBetweenOrderByDate(
                        priceHistoryRequest.getComponentId(),
                        priceHistoryRequest.getFromDate(),
                        priceHistoryRequest.getToDate());
            }

            return priceHistoryResponseFromMaxDailyPriceView(maxDailyPriceViews);
        }
    }

    /**
     *
     * @param minDailyPriceViews List
     * @return PriceHistoryResponse
     */
    private PriceHistoryResponse priceHistoryResponseFromMinDailyPriceView(List<MinDailyPriceView> minDailyPriceViews) {

        PriceHistoryResponse priceHistoryResponse = new PriceHistoryResponse();

        for (MinDailyPriceView minDailyPriceView : minDailyPriceViews) {
            PricePointData pricePointData = new PricePointData(minDailyPriceView.getDate(), minDailyPriceView.getPrice());
            priceHistoryResponse.addPriceHistory(pricePointData);
        }

        return priceHistoryResponse;
    }

    /**
     *
     * @param maxDailyPriceViews List
     * @return PriceHistoryResponse
     */
    private PriceHistoryResponse priceHistoryResponseFromMaxDailyPriceView(List<MaxDailyPriceView> maxDailyPriceViews) {

        PriceHistoryResponse priceHistoryResponse = new PriceHistoryResponse();

        for (MaxDailyPriceView maxDailyPriceView : maxDailyPriceViews) {

            PricePointData pricePointData = new PricePointData(maxDailyPriceView.getDate(), maxDailyPriceView.getPrice());
            priceHistoryResponse.addPriceHistory(pricePointData);
        }

        return priceHistoryResponse;
    }
}
