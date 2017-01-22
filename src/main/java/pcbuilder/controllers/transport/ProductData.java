package pcbuilder.controllers.transport;

import pcbuilder.domain.CType;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductData.
 */
public class ProductData {

    /** The name. */
    private String name;
    
    /** The brand. */
    private String brand;
    
    /** The ean. */
    private String ean;
    
    /** The mpn. */
    private String mpn;
    
    /** The price. */
    private Float price;
    
    /** The url. */
    private String url;
    
    /** The shop. */
    private String shop;
    
    /** The type. */
    private CType type;
    
    /** The picture url. */
    private String pictureUrl;
    
    /** The connectors. */
    private List<ConnectorData> connectors;

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
     * Gets the ean.
     *
     * @return the ean
     */
    public String getEan() {
        return ean;
    }

    /**
     * Sets the ean.
     *
     * @param ean the new ean
     */
    public void setEan(String ean) {
        this.ean = ean;
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
     * Gets the connectors.
     *
     * @return the connectors
     */
    public List<ConnectorData> getConnectors() {
        return connectors;
    }

    /**
     * Sets the connectors.
     *
     * @param connectors the new connectors
     */
    public void setConnectors(List<ConnectorData> connectors) {
        this.connectors = connectors;
    }

    /**
     * Gets the mpn.
     *
     * @return the mpn
     */
    public String getMpn() {
        return mpn;
    }

    /**
     * Sets the mpn.
     *
     * @param mpn the new mpn
     */
    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    /**
     * Gets the picture url.
     *
     * @return the picture url
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * Sets the picture urls.
     *
     * @param pictureUrl the new picture urls
     */
    public void setPictureUrls(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
