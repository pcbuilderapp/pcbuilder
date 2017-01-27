package pcbuilder.controllers.transport;

import pcbuilder.domain.Product;

/**
 * The Class AlternativeShopItem.
 */
public class AlternativeShopItem {

    private String shop;
    private String url;
    private Float price;

    /**
     * Instantiates a new alternative shop item.
     *
     * @param product Product
     */
    AlternativeShopItem(Product product) {
        shop = product.getShop().getName();
        url = product.getProductUrl();
        price = product.getCurrentPrice();
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
     * Gets the url.
     *
     * @return url
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
     * @param price Float
     */
    public void setPrice(Float price) {
        this.price = price;
    }
}
