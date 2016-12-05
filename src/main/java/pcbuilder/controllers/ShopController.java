package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pcbuilder.domain.Shop;
import pcbuilder.repository.ShopRepository;

@RestController
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    @RequestMapping(value="/shop/getall", method= RequestMethod.GET)
    public Iterable<Shop> getAllShops() {
        return shopRepository.findAll();
    }
}
