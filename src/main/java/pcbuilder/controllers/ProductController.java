package pcbuilder.controllers;

import javassist.bytecode.stackmap.TypeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.dto.ConnectorData;
import pcbuilder.controllers.dto.ProductData;
import pcbuilder.controllers.dto.ProductSearch;
import pcbuilder.controllers.dto.ProductsResponse;
import pcbuilder.domain.*;
import pcbuilder.repository.*;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class ProductController.
 */
@RestController
public class ProductController {

    private static final Logger LOGGER = Logger.getLogger( TypeData.ClassName.class.getName() );

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

    /**
     * Adds the products.
     *
     * @param productDataList List
     * @return ResponseEntity
     */
    @RequestMapping(value="/products/add", method= RequestMethod.POST)
    public ResponseEntity<String> addProducts(@RequestBody List<ProductData> productDataList) {

        for (ProductData productData : productDataList) {
            addProduct(productData);
        }

        return new ResponseEntity<>("All products have been added!", HttpStatus.CREATED);
    }

    /**
     * Adds the product.
     *
     * @param productData ProductData
     * @return ResponseEntity
     */
    @RequestMapping(value="/product/add", method= RequestMethod.POST)
    public ResponseEntity<String> addProduct(@RequestBody ProductData productData) {

        Product product = new Product();
        Shop shop = shopRepository.findByName(productData.getShop());

        if (shop == null) {
            return new ResponseEntity<>("Found an invalid shopname!", HttpStatus.NOT_ACCEPTABLE);
        } else {
            product.setShop(shop);
        }

        product.setComponent(persistComponent(findComponent(productData), productData));

        product = persistProduct(productData, product);

        pricePointRepository.save(new PricePoint(product, new Date(), productData.getPrice()));

/*        LOGGER.log(Level.INFO, "Product '" +product.getComponent().getName()+ "' has been added!");*/

        LOGGER.log(Level.INFO, "Product '" +product.toString()+ "' has been added!");

        return new ResponseEntity<>("Product '" +product.getComponent().getName()+ "' has been added!", HttpStatus.CREATED);
    }

    /**
     * Get products.
     *
     * @return List
     */

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/product/getall", method=RequestMethod.GET)
    public List<Product> getAllProducts() { return productRepository.findAll(); }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/product/getmatching", method=RequestMethod.POST)
    public ProductsResponse getMatchingProducts(@RequestBody ProductSearch request) {

        // creating a page request to setup paginated query results
        PageRequest pageRequest = new PageRequest(request.getPage(), request.getMaxItems());

        Page<Product> page = productRepository.findByComponentNameContaining(request.getFilter(), pageRequest);

        ProductsResponse response = new ProductsResponse();
        response.setProducts(page.getContent());
        response.setPage(page.getNumber());
        response.setPageCount(page.getTotalPages());

        return response;
    }

    /**
     * Searches for an existing component based on the MPN number, EAN number, or name.
     *
     * @param productData ProductData
     * @return Component
     */
    private Component findComponent(ProductData productData) {

        Component component = componentRepository.findByManufacturerPartNumber(productData.getMpn());

        if (component == null && productData.getEan() != null && !"9999999999999".equals(productData.getEan()) && !"".equals(productData.getEan()) ) {
            component = componentRepository.findByEuropeanArticleNumber(productData.getEan()).get(0);
        }

        return component;
    }

    /**
     * Persists a Product
     *
     * @param productData ProductData
     * @param persistProduct Product
     * @return Product
     */
    private Product persistProduct(ProductData productData, Product persistProduct) {
        Product product = persistProduct;
        Product searchProduct = productRepository.findByComponentAndShop(product.getComponent(), product.getShop());

        if (searchProduct == null) {

            product.setCurrentPrice(productData.getPrice());
            product.setProductUrl(productData.getUrl());

        } else {

            product = searchProduct;
            product.setCurrentPrice(productData.getPrice());

        }

        return productRepository.save(product);
    }

    /**
     * Persist component.
     *
     * @param productData ProductData
     * @param persistComponent Component
     * @return Component
     */
    private Component persistComponent(Component persistComponent, ProductData productData) {

        Component component = persistComponent;

        if (component == null) {

            component = new Component(productData.getName(), productData.getBrand(), productData.getEan(), productData.getMpn(), productData.getType(), productData.getPictureUrl());

        } else {

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

        return componentRepository.save(component);
    }

    /**
     * Persist connector.
     *
     * @param connectorData ConnectorData
     * @return Connector
     */
    private Connector persistConnector(ConnectorData connectorData) {

        Connector connector = connectorRepository.findByNameAndType(connectorData.getName(), connectorData.getType());

        if (connector == null) {
            connector = new Connector(connectorData.getName(), connectorData.getType());
            connectorRepository.save(connector);
        }

        return connector;
    }
}
