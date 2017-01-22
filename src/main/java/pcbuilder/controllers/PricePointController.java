package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pcbuilder.domain.PricePoint;
import pcbuilder.repository.PricePointRepository;

/**
 * The Class PricePointController.
 */
@RestController
public class PricePointController {

    /** The price point repository. */
    @Autowired
    private PricePointRepository pricePointRepository;

    /**
     * Gets all the price points.
     *
     * @return all the price points
     */
    @RequestMapping(value="/pricepoint/getall", method= RequestMethod.GET)
    public Iterable<PricePoint> getAllPricePoints() {
        return pricePointRepository.findAll();
    }
}
