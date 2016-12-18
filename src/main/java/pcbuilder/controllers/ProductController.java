package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.transport.ConnectorData;
import pcbuilder.controllers.transport.ProductData;
import pcbuilder.domain.*;
import pcbuilder.repository.*;

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

    @Autowired
    private ConnectorRepository connectorRepository;

    @RequestMapping(value="/product/add", method= RequestMethod.POST)
    public ResponseEntity<String> createProducts(@RequestBody List<ProductData> productDataList) {

        List<Product> products;
        List<Shop> shops;
        List<Component> components;
        Product product;
        Shop shop;
        Component component;
        Connector connector;

        for (ProductData productData : productDataList) {

            product = new Product();

            shops = shopRepository.findByName(productData.getShopName());
            if (shops.isEmpty()) {
                return new ResponseEntity<String>("Found an invalid shopname!", HttpStatus.NOT_ACCEPTABLE);
            } else {
                shop = shops.get(0);
                product.setShop(shop);
            }

            components = componentRepository.findByEuropeanArticleNumber(productData.getEan());
            if (components.isEmpty()) {
                component = new Component(productData.getName(), productData.getBrand(), productData.getEan(), productData.getType());
                for (ConnectorData connectorData : productData.getConnectors()) {
                    connector = connectorRepository.findByName(connectorData.getName());
                    if (connector == null) {
                        connector = new Connector(connectorData.getName(), connectorData.getType());
                        connectorRepository.save(connector);
                    }
                    component.addConnector(connector);
                }
                product.setComponent(componentRepository.save(component));
            } else {
                component = components.get(0);
                component.setName(productData.getName());
                component.setBrand(productData.getBrand());
                component.setType(productData.getType());
                product.setComponent(componentRepository.save(component));
            }

            products = productRepository.findByComponentAndShop(product.getComponent(), shop);
            if (products.isEmpty()) {
                product.setCurrentPrice(productData.getPrice());
                product.setProductUrl(productData.getUrl());
                productRepository.save(product);
            } else {
                product = products.get(0);
            }

            pricePointRepository.save(new PricePoint(product, new Date(), productData.getPrice()));
        }

        return new ResponseEntity<String>("Products have been added!", HttpStatus.CREATED);
    }

    @RequestMapping(value="/product/getall", method=RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
