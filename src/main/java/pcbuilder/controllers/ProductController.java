package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.transport.ConnectorData;
import pcbuilder.controllers.transport.ProductData;
import pcbuilder.controllers.transport.ProductSearch;
import pcbuilder.controllers.transport.ProductsResponse;
import pcbuilder.domain.*;
import pcbuilder.repository.*;
import java.util.Date;
import java.util.List;

/**
 * The Class ProductController.
 */
@RestController
public class ProductController {

    /** The product repository. */
    @Autowired
    private ProductRepository productRepository;

    /** The component repository. */
    @Autowired
    private ComponentRepository componentRepository;

    /** The shop repository. */
    @Autowired
    private ShopRepository shopRepository;

    /** The price point repository. */
    @Autowired
    private PricePointRepository pricePointRepository;

    /** The connector repository. */
    @Autowired
    private ConnectorRepository connectorRepository;

    /**
     * Adds the products.
     *
     * @param List<ProductData>
     * @return ResponseEntity<String>
     */
    @RequestMapping(value="/products/add", method= RequestMethod.POST)
    public ResponseEntity<String> addProducts(@RequestBody List<ProductData> productDataList) {

        for (ProductData productData : productDataList) {
            addProduct(productData);
        }

        return new ResponseEntity<String>("All products have been added!", HttpStatus.CREATED);
    }

    /**
     * Adds the product.
     *
     * @param ProductData
     * @return ResponseEntity<String>
     */
    @RequestMapping(value="/product/add", method= RequestMethod.POST)
    public ResponseEntity<String> addProduct(@RequestBody ProductData productData) {

        Product product = new Product();
        Shop shop = shopRepository.findByName(productData.getShop());

        if (shop == null) {
            return new ResponseEntity<String>("Found an invalid shopname!", HttpStatus.NOT_ACCEPTABLE);
        } else {
            product.setShop(shop);
        }

        product.setComponent(persistComponent(findComponent(productData), productData));

        product = persistProduct(productData, product);

        pricePointRepository.save(new PricePoint(product, new Date(), productData.getPrice()));

        System.out.println("Product '" +product.getComponent().getName()+ "' has been added!");
        return new ResponseEntity<String>("Product '" +product.getComponent().getName()+ "' has been added!", HttpStatus.CREATED);
    }

    /**
     * Searches for an existing component based on the MPN number, EAN number, or name.
     *
     * @param ProductData
     * @return Component
     */
    private Component findComponent(ProductData productData) {

        Component component = componentRepository.findByManufacturerPartNumber(productData.getMpn());

        if (component == null && !productData.getEan().equals("9999999999999") && productData.getEan() != null) {
            component = componentRepository.findByEuropeanArticleNumber(productData.getEan());
        }

        if (component == null) {
            component = componentRepository.findByName(productData.getName());
        }

        return component;
    }

    /**
     * Persists a Product
     *
     * @param ProductData
     * @param Product
     * @return Product
     */
    private Product persistProduct(ProductData productData, Product product) {

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
     * Get products.
     *
     * @param List<Component>
     * @param ProductData
     * @return Component
     */

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/product/getall", method=RequestMethod.GET)
    public List<Product> getAllProducts() { return productRepository.findAll(); }

    /**
     * Get matching products.
     *
     * @param List<Component>
     * @param ProductData
     * @return Component
     */

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/product/getmatching", method=RequestMethod.POST)
    public ProductsResponse getMatchingProducts(ProductSearch request) {

        Sort sort;

        if (request.getSort() == null || request.getSort().equals("")) {
            sort = new Sort("name");
        } else {
            sort = new Sort(request.getSort());
        }

        // creating a page request to setup paginated query results
        PageRequest pageRequest = new PageRequest(request.getPage().intValue(), request.getMaxItems().intValue(), sort);

        Page<Product> page = productRepository.findByNameContaining(request.getFilter(), pageRequest);

        ProductsResponse response = new ProductsResponse();
        response.setProducts(page.getContent());
        response.setPage(page.getNumber());
        response.setPageCount(page.getTotalPages());

        return response;
    }

    /**
     * Persist component.
     *
     * @param List<Component>
     * @param ProductData
     * @return Component
     */
    private Component persistComponent(Component component, ProductData productData) {

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
     * @param ConnectorData
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
