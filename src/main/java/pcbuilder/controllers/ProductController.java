package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.transport.ConnectorData;
import pcbuilder.controllers.transport.ProductData;
import pcbuilder.controllers.transport.ProductSearch;
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
    public ResponseEntity<String> addProducts(@RequestBody List<ProductData> productDataList) {

        for (ProductData productData : productDataList) {
            addProduct(productData);
        }

        return new ResponseEntity<String>("All products have been added!", HttpStatus.CREATED);
    }

    @RequestMapping(value="/product/add", method= RequestMethod.POST)
    public ResponseEntity<String> addProduct(@RequestBody ProductData productData) {

        List<Product> products;
        List<Shop> shops = shopRepository.findByName(productData.getShop());
        Product product = new Product();

        if (shops.isEmpty()) {
            return new ResponseEntity<String>("Found an invalid shopname!", HttpStatus.NOT_ACCEPTABLE);
        } else {
            product.setShop(shops.get(0));
        }

        product.setComponent(componentRepository.save(persistComponent(componentRepository.findByBrandAndManufacturerPartNumber(productData.getBrand(), productData.getMpn()), productData)));
        products = productRepository.findByComponentAndShop(product.getComponent(), product.getShop());

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
        System.out.println("Product '" +product.getComponent().getName()+ "' has been added!");
        return new ResponseEntity<String>("Product '" +product.getComponent().getName()+ "' has been added!", HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/product/getall", method=RequestMethod.GET)
    public Iterable<Product> getAllProducts(ProductSearch request) {
        Sort sort;

        if (request.getSort() == null || request.getSort().equals("")) {
            sort = new Sort("name");
        } else {
            sort = new Sort(request.getSort());
        }

        // creating a page request to setup paginated query results
        PageRequest pageRequest = new PageRequest(request.getPage().intValue(), request.getMaxItems().intValue(), sort);
        return productRepository.findByNameContaining(request.getFilter(),pageRequest);
    }

    private Component persistComponent(List<Component> components, ProductData productData) {

        Component component;

        if (components.isEmpty()) {

            component = new Component(productData.getName(), productData.getBrand(), productData.getEan(), productData.getMpn(), productData.getType(), productData.getPictureUrl());

        } else {

            component = components.get(0);
            component.setName(productData.getName());
            component.setBrand(productData.getBrand());
            component.setType(productData.getType());
            component.setEuropeanArticleNumber(productData.getEan());
            component.setManufacturerPartNumber(productData.getMpn());
            component.setPictureUrl(productData.getPictureUrl());
        }

        for (ConnectorData connectorData : productData.getConnectors()) {

            if (!component.hasConnector(connectorData.getName(), connectorData.getType())) {

                component.addConnector(persistConnector(connectorData));
            }
        }

        return component;
    }

    private Connector persistConnector(ConnectorData connectorData) {

        Connector connector = connectorRepository.findByNameAndType(connectorData.getName(), connectorData.getType());

        if (connector == null) {
            connector = new Connector(connectorData.getName(), connectorData.getType());
            connectorRepository.save(connector);
        }

        return connector;
    }
}
