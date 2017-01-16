package pcbuilder.controllers.transport;

import pcbuilder.domain.CType;
import pcbuilder.domain.Component;
import pcbuilder.domain.Product;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.LinkedList;
import java.util.List;

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

    public ComponentItem(Component component, Product product, Iterable<Product> alternativeProducts) {
        id = component.getId();
        name = component.getName();
        brand = component.getBrand();
        europeanArticleNumber = component.getEuropeanArticleNumber();
        manufacturerPartNumber = component.getManufacturerPartNumber();
        type = component.getType();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEuropeanArticleNumber() {
        return europeanArticleNumber;
    }

    public void setEuropeanArticleNumber(String europeanArticleNumber) {
        this.europeanArticleNumber = europeanArticleNumber;
    }

    public String getManufacturerPartNumber() {
        return manufacturerPartNumber;
    }

    public void setManufacturerPartNumber(String manufacturerPartNumber) {
        this.manufacturerPartNumber = manufacturerPartNumber;
    }

    public CType getType() {
        return type;
    }

    public void setType(CType type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public List<AlternativeShopItem> getAlternativeShops() {
        return alternativeShops;
    }

    public void setAlternativeShops(List<AlternativeShopItem> alternativeShops) {
        this.alternativeShops = alternativeShops;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
