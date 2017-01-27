package pcbuilder.controllers.transport;

import pcbuilder.domain.CType;
import pcbuilder.domain.Component;
import pcbuilder.domain.Connector;
import pcbuilder.domain.Product;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.LinkedList;
import java.util.List;

/**
 * The Class ComponentItem.
 */
public class ComponentItem {

    private Long id;
    private String name;
    private String brand;
    private String europeanArticleNumber;
    private String manufacturerPartNumber;

    @Enumerated(EnumType.STRING)
    private CType type;
    private Float price;
    private String url;
    private String shop;
    private String image;

    private List<AlternativeShopItem> alternativeShops;
    private List<Connector> connectors;

    /**
     * Instantiates a new component item.
     *
     * @param component Component
     * @param product Product
     * @param alternativeProducts Iterable<Product>
     */
    public ComponentItem(Component component, Product product, Iterable<Product> alternativeProducts) {

        id = component.getId();
        name = component.getName();
        brand = component.getBrand();
        europeanArticleNumber = component.getEuropeanArticleNumber();
        manufacturerPartNumber = component.getManufacturerPartNumber();
        type = component.getType();
        connectors = component.getConnectors();

        price = product.getCurrentPrice();
        url = product.getProductUrl();
        shop = product.getShop().getName();
        image = component.getPictureUrl();
        alternativeShops = new LinkedList<>();

        for (Product p : alternativeProducts) {
            AlternativeShopItem alternativeShopItem = new AlternativeShopItem(p);
            alternativeShops.add(alternativeShopItem);
        }
    }

    /**
     * Gets the id.
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id Long
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the brand.
     *
     * @return brand
     */
    @SuppressWarnings("unused")
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand.
     *
     * @param brand String
     */
    @SuppressWarnings("unused")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the european article number.
     *
     * @return europeanArticleNumber
     */
    @SuppressWarnings("unused")
    public String getEuropeanArticleNumber() {
        return europeanArticleNumber;
    }

    /**
     * Sets the european article number.
     *
     * @param europeanArticleNumber String
     */
    @SuppressWarnings("unused")
    public void setEuropeanArticleNumber(String europeanArticleNumber) {
        this.europeanArticleNumber = europeanArticleNumber;
    }

    /**
     * Gets the manufacturer part number.
     *
     * @return the manufacturer part number
     */
    @SuppressWarnings("unused")
    public String getManufacturerPartNumber() {
        return manufacturerPartNumber;
    }

    /**
     * Sets the manufacturer part number.
     *
     * @param manufacturerPartNumber String
     */
    @SuppressWarnings("unused")
    public void setManufacturerPartNumber(String manufacturerPartNumber) {
        this.manufacturerPartNumber = manufacturerPartNumber;
    }

    /**
     * Gets the type.
     *
     * @return type
     */
    public CType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type CType
     */
    public void setType(CType type) {
        this.type = type;
    }

    /**
     * Gets the price.
     *
     * @return price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price Float
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Gets the url.
     *
     * @return url
     */
    @SuppressWarnings("unused")
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     *
     * @param url String
     */
    @SuppressWarnings("unused")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the shop.
     *
     * @return shop
     */
    public String getShop() {
        return shop;
    }

    /**
     * Sets the shop.
     *
     * @param shop String
     */
    public void setShop(String shop) {
        this.shop = shop;
    }

    /**
     * Gets the alternative shops.
     *
     * @return alternativeShops
     */
    @SuppressWarnings("unused")
    public List<AlternativeShopItem> getAlternativeShops() {
        return alternativeShops;
    }

    /**
     * Sets the alternative shops.
     *
     * @param alternativeShops List<AlternativeShopItem>
     */
    @SuppressWarnings("unused")
    public void setAlternativeShops(List<AlternativeShopItem> alternativeShops) {
        this.alternativeShops = alternativeShops;
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    @SuppressWarnings("unused")
    public String getImage() {
        return image;
    }

    /**
     * Sets the image.
     *
     * @param image String
     */
    @SuppressWarnings("unused")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the connectors.
     *
     * @return the connectors
     */
    @SuppressWarnings("unused")
    public List<Connector> getConnectors() {
        return connectors;
    }

    /**
     * Sets the connectors.
     *
     * @param connectors List<Connector>
     */
    @SuppressWarnings("unused")
    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }
}
