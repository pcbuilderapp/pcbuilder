package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pcbuilder.controllers.transport.PricePointResponse;
import pcbuilder.domain.PricePoint;
import pcbuilder.repository.ComponentRepository;
import pcbuilder.repository.PricePointRepository;

import java.util.List;

/**
 * The Class PricePointController.
 */
@RestController
public class PricePointController {

    /** The price point repository. */
    @Autowired
    private PricePointRepository pricePointRepository;

    /** The component repository. */
    @Autowired
    private ComponentRepository componentRepository;

    /**
     * Gets all the price points.
     *
     * @return all the price points
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/pricepoint/getall", method= RequestMethod.GET)
    public Iterable<PricePoint> getAllPricePoints() {
        return pricePointRepository.findAll();
    }

    /**
     * Gets an historical list of pricepoints for a given component
     *
     * @param long componentId
     * @return PricePointResponse
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/pricepoint/gethistorybycomponent", method=RequestMethod.GET)
    public PricePointResponse getPriceHistory(long componentId) {

        Sort sort = new Sort("pricingDate");
        List<PricePoint> pricepoints = pricePointRepository.findByProductComponent(
                componentRepository.getOne(componentId), sort);

        PricePointResponse pricePointResponse = new PricePointResponse();
        pricePointResponse.setPricePoints(pricepoints);

        return pricePointResponse;
    }
}
