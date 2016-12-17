package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.transport.ProductData;
import pcbuilder.domain.*;
import pcbuilder.repository.ComponentRepository;
import pcbuilder.repository.PricePointRepository;
import pcbuilder.repository.ProductRepository;
import pcbuilder.repository.ShopRepository;

import java.util.Date;
import java.util.List;

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

    @RequestMapping(value="/product/addList", method= RequestMethod.POST)
    public ResponseEntity<String> addProducts(@RequestBody List<ProductData> productDataList) {

        Product product;
        List<Shop> shops;
        List<Component> components;

        for (ProductData productData : productDataList) {

            product = new Product();

            shops = shopRepository.findByName(productData.getShopName());
            if (shops.isEmpty()) {
                return new ResponseEntity<String>("Found an invalid shopname!", HttpStatus.NOT_ACCEPTABLE);
            } else {
                product.setShop(shops.get(0));
            }

            components = componentRepository.findByEuropeanArticleNumber(productData.getEuropeanArticleNumber());
            if (components.isEmpty()) {
                product.setComponent(
                        componentRepository.save(
                                new Component(
                                        productData.getName(),
                                        productData.getBrand(),
                                        productData.getEuropeanArticleNumber(),
                                        productData.getType(),
                                        productData.getConnectors())));
            } else {
                product.setComponent(components.get(0));
            }

            if (productRepository.findByComponentAndShop(product.getComponent(), product.getShop()).isEmpty()) {
                productRepository.save(product);
            }

            pricePointRepository.save(new PricePoint(product, new Date(), product.getCurrentPrice()));
        }

        return new ResponseEntity<String>("Products have been added!", HttpStatus.CREATED);
    }

    @RequestMapping(value="/product/add", method= RequestMethod.POST)
    public ResponseEntity<String> createProduct(@RequestBody ProductData productData) {

        Product product = new Product();
        List<Shop> shops;
        List<Component> components;

        shops = shopRepository.findByName(productData.getShopName());
        if (shops.isEmpty()) {
            return new ResponseEntity<String>("Found an invalid shopname!", HttpStatus.NOT_ACCEPTABLE);
        } else {
            product.setShop(shops.get(0));
        }

        components = componentRepository.findByEuropeanArticleNumber(productData.getEuropeanArticleNumber());
        if (components.isEmpty()) {
            product.setComponent(
                    componentRepository.save(
                            new Component(
                                    productData.getName(),
                                    productData.getBrand(),
                                    productData.getEuropeanArticleNumber(),
                                    productData.getType(),
                                    productData.getConnectors())));
        } else {
            product.setComponent(components.get(0));
        }

        if (productRepository.findByComponentAndShop(product.getComponent(), product.getShop()).isEmpty()) {
            productRepository.save(product);
        }

        pricePointRepository.save(new PricePoint(product, new Date(), product.getCurrentPrice()));

        pricePointRepository.save(new PricePoint(product, new Date(), product.getCurrentPrice()));

        return new ResponseEntity<String>("Product has been added!", HttpStatus.CREATED);
    }

    @RequestMapping(value="/product/getall", method=RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
