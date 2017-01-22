package pcbuilder.controllers.transport;

import pcbuilder.domain.CType;
import pcbuilder.domain.Component;
import pcbuilder.domain.Connector;
import pcbuilder.domain.Product;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.LinkedList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponentItem.
 */
public class ComponentItem {
    
    /** The id. */
    private Long id;
    
    /** The name. */
    private String name;
    
    /** The brand. */
    private String brand;

    /** The european article number. */
    private String europeanArticleNumber;
    
    /** The manufacturer part number. */
    private String manufacturerPartNumber;

    /** The type. */
    @Enumerated(EnumType.STRING)
    private CType type;

    /** The price. */
    private Float price;
    
    /** The url. */
    private String url;
    
    /** The shop. */
    private String shop;
    
    /** The image. */
    private String image;

    /** The alternative shops. */
    private List<AlternativeShopItem> alternativeShops;
    
    /** The connectors. */
    private List<Connector> connectors;

    /**
     * Instantiates a new component item.
     *
     * @param component the component
     * @param product the product
     * @param alternativeProducts the alternative products
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
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the brand.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand.
     *
     * @param brand the new brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the european article number.
     *
     * @return the european article number
     */
    public String getEuropeanArticleNumber() {
        return europeanArticleNumber;
    }

    /**
     * Sets the european article number.
     *
     * @param europeanArticleNumber the new european article number
     */
    public void setEuropeanArticleNumber(String europeanArticleNumber) {
        this.europeanArticleNumber = europeanArticleNumber;
    }

    /**
     * Gets the manufacturer part number.
     *
     * @return the manufacturer part number
     */
    public String getManufacturerPartNumber() {
        return manufacturerPartNumber;
    }

    /**
     * Sets the manufacturer part number.
     *
     * @param manufacturerPartNumber the new manufacturer part number
     */
    public void setManufacturerPartNumber(String manufacturerPartNumber) {
        this.manufacturerPartNumber = manufacturerPartNumber;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public CType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(CType type) {
        this.type = type;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     *
     * @param url the new url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the shop.
     *
     * @return the shop
     */
    public String getShop() {
        return shop;
    }

    /**
     * Sets the shop.
     *
     * @param shop the new shop
     */
    public void setShop(String shop) {
        this.shop = shop;
    }

    /**
     * Gets the alternative shops.
     *
     * @return the alternative shops
     */
    public List<AlternativeShopItem> getAlternativeShops() {
        return alternativeShops;
    }

    /**
     * Sets the alternative shops.
     *
     * @param alternativeShops the new alternative shops
     */
    public void setAlternativeShops(List<AlternativeShopItem> alternativeShops) {
        this.alternativeShops = alternativeShops;
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image.
     *
     * @param image the new image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the connectors.
     *
     * @return the connectors
     */
    public List<Connector> getConnectors() {
        return connectors;
    }

    /**
     * Sets the connectors.
     *
     * @param connectors the new connectors
     */
    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }
}
