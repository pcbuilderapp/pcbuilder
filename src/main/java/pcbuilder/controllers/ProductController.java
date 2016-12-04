package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pcbuilder.domain.Component;
import pcbuilder.domain.Product;
import pcbuilder.repository.ProductRepository;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value="/product/add", method= RequestMethod.POST)
    public String createVideoCard(@RequestBody Product product) {
        productRepository.save(product);
        return "Product has been added!";
    }

    @RequestMapping(value="/product/getall", method=RequestMethod.GET)
    public Iterable<Product> getAllComponentsCard() {
        return productRepository.findAll();
    }

}
