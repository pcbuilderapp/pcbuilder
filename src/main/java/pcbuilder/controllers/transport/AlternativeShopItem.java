package pcbuilder.controllers.transport;

import pcbuilder.domain.Product;

/**
 * The Class AlternativeShopItem.
 */
public class AlternativeShopItem {
    
    /** The shop. */
    private String shop;
    
    /** The url. */
    private String url;
    
    /** The price. */
    private Float price;

    /**
     * Instantiates a new alternative shop item.
     *
     * @param product the product
     */
    public AlternativeShopItem(Product product) {
        shop = product.getShop().getName();
        url = product.getProductUrl();
        price = product.getCurrentPrice();
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
}
