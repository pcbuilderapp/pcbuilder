package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pcbuilder.domain.PricePoint;
import pcbuilder.repository.PricePointRepository;

@RestController
public class PricePointController {

    @Autowired
    private PricePointRepository pricePointRepository;

    @RequestMapping(value="/pricepoint/getall", method= RequestMethod.GET)
    public Iterable<PricePoint> getAllPricePoints() {
        return pricePointRepository.findAll();
    }
}
