package pcbuilder.controllers.transport;

import pcbuilder.domain.Product;

public class AlternativeShopItem {
    private String shop;
    private String url;
    private Float price;

    public AlternativeShopItem(Product product) {
        shop = product.getShop().getName();
        url = product.getProductUrl();
        price = product.getCurrentPrice();
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
