package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.domain.PricePoint;
import pcbuilder.domain.Product;
import pcbuilder.domain.Shop;
import pcbuilder.repository.ComponentRepository;
import pcbuilder.repository.PricePointRepository;
import pcbuilder.repository.ProductRepository;
import pcbuilder.repository.ShopRepository;

import java.util.Date;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private PricePointRepository pricePointRepository;

    @RequestMapping(value="/product/add", method= RequestMethod.POST)
    public ResponseEntity<String> createProduct(@RequestBody Product product) {

        boolean shopExists = false, componentExists = false;

        if (shopRepository.findByName(product.getShop().getName()).isEmpty()) {
            product.setShop(shopRepository.save(product.getShop()));
        } else {
            product.setShop(shopRepository.findByName(product.getShop().getName()).get(0));
        }

        if (componentRepository.findByEuropeanArticleNumber(product.getComponent().getEuropeanArticleNumber()).isEmpty()) {
            product.setComponent(componentRepository.save(product.getComponent()));
        } else {
            product.setComponent(componentRepository.findByEuropeanArticleNumber(product.getComponent().getEuropeanArticleNumber()).get(0));
        }

        if (productRepository.findByComponentAndShop(product.getComponent(), product.getShop()).isEmpty()) {
            productRepository.save(product);
        }

        pricePointRepository.save(new PricePoint(product, new Date(), product.getCurrentPrice()));

        return new ResponseEntity<String>("Product has been added!", HttpStatus.CREATED);
    }

    @RequestMapping(value="/product/getall", method=RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
