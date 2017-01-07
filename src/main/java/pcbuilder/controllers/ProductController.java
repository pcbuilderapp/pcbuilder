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

    @RequestMapping(value="/products/add", method= RequestMethod.POST)
    public ResponseEntity<String> createProducts(@RequestBody List<ProductData> productDataList) {

        for (ProductData productData : productDataList) {
            createProduct(productData);
        }

        return new ResponseEntity<String>("All products have been added!", HttpStatus.CREATED);
    }


    @RequestMapping(value="/product/add", method= RequestMethod.POST)
    public ResponseEntity<String> createProduct(@RequestBody ProductData productData) {

        List<Product> products;
        List<Shop> shops;
        List<Component> components;
        Product product;
        Shop shop;
        Component component;
        Connector connector;

        product = new Product();

        shops = shopRepository.findByName(productData.getShop());
        if (shops.isEmpty()) {
            return new ResponseEntity<String>("Found an invalid shopname!", HttpStatus.NOT_ACCEPTABLE);
        } else {
            shop = shops.get(0);
            product.setShop(shop);
        }

        components = componentRepository.findByBrandAndManufacturerPartNumber(productData.getBrand(), productData.getMpn());
        if (components.isEmpty()) {
            component = new Component(productData.getName(), productData.getBrand(), productData.getEan(), productData.getMpn(), productData.getType());
            productData.getPictureUrls().forEach(component::addPictureUrl);
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
            component.setEuropeanArticleNumber(productData.getEan());
            component.setManufacturerPartNumber(productData.getMpn());
            productData.getPictureUrls().forEach(component::addPictureUrl);
            product.setComponent(componentRepository.save(component));
        }

        products = productRepository.findByComponentAndShop(product.getComponent(), shop);
        if (products.isEmpty()) {
            product.setCurrentPrice(productData.getPrice());
            product.setProductUrl(productData.getUrl());
            productRepository.save(product);
        } else {
            product = products.get(0);
            product.setCurrentPrice(productData.getPrice());
            productRepository.save(product);
        }

        pricePointRepository.save(new PricePoint(product, new Date(), productData.getPrice()));
        System.out.println("Product '" +component.getName()+ "' has been added!");
        return new ResponseEntity<String>("Product '" +component.getName()+ "' has been added!", HttpStatus.CREATED);
    }

    @RequestMapping(value="/product/getall", method=RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
