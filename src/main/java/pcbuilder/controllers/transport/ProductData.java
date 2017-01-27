package pcbuilder.controllers.transport;

import pcbuilder.domain.CType;

import java.util.List;

/**
 * The Class ProductData.
 */
public class ProductData {

    private String name;
    private String brand;
    private String ean;
    private String mpn;
    private Float price;
    private String url;
    private String shop;
    private CType type;
    private String pictureUrl;
    
    /** The connectors. */
    private List<ConnectorData> connectors;

    /**
     * Gets the price.
     *
     * @return String
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
     * @return String
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     *
     * @param url String
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the shop.
     *
     * @return String
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
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the brand.
     *
     * @return String
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand.
     *
     * @param brand String
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the ean.
     *
     * @return String
     */
    public String getEan() {
        return ean;
    }

    /**
     * Sets the ean.
     *
     * @param ean String
     */
    public void setEan(String ean) {
        this.ean = ean;
    }

    /**
     * Gets the type.
     *
     * @return CType
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
     * Gets the connectors.
     *
     * @return List
     */
    public List<ConnectorData> getConnectors() {
        return connectors;
    }

    /**
     * Sets the connectors.
     *
     * @param connectors List
     */
    public void setConnectors(List<ConnectorData> connectors) {
        this.connectors = connectors;
    }

    /**
     * Gets the mpn.
     *
     * @return String
     */
    public String getMpn() {
        return mpn;
    }

    /**
     * Sets the mpn.
     *
     * @param mpn String
     */
    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    /**
     * Gets the picture url.
     *
     * @return String
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * Sets the picture urls.
     *
     * @param pictureUrl String
     */
    public void setPictureUrls(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", ean='" + ean + '\'' +
                ", mpn='" + mpn + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", shop='" + shop + '\'' +
                ", type=" + type +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", connectors=" + connectors +
                '}';
    }
}
