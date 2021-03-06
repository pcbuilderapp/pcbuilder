package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pcbuilder.domain.Shop;
import pcbuilder.repository.ShopRepository;


/**
 * The Class ShopController.
 */
@RestController
public class ShopController {


    /** The shop repository. */
    @Autowired
    private ShopRepository shopRepository;


    /**
     * Gets all the shops.
     *
     * @return shopRepository.findAll()
     */
    @RequestMapping(value="/shop/getall", method= RequestMethod.GET)
    public Iterable<Shop> getAllShops() {
        return shopRepository.findAll();
    }


    /**
     * Creates the component.
     *
     * @param shop Shop
     * @return ResponseEntity
     */
    @RequestMapping(value="/shop/create", method=RequestMethod.POST)
    public ResponseEntity<String> createShop(@RequestBody Shop shop) {

        if (shopRepository.findByName(shop.getName()) == null) {

            shopRepository.save(shop);

        } else {

            return new ResponseEntity<>("Shop already exists!", HttpStatus.CONFLICT);

        }

        return new ResponseEntity<>("Shop '"+shop.getName()+"' has been created!", HttpStatus.OK);
    }
}
