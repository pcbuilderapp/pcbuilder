package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.domain.Product;
import pcbuilder.repository.ProductRepository;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value="/product/add", method= RequestMethod.POST)
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return new ResponseEntity<String>("Product has been added!", HttpStatus.CREATED);
    }

    @RequestMapping(value="/product/getall", method=RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
