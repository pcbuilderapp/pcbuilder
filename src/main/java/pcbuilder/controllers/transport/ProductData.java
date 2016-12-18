package pcbuilder.controllers.transport;

import pcbuilder.domain.CType;
import java.util.List;

public class ProductData {

    private String name;
    private String brand;
    private String ean;
    private Float price;
    private String url;
    private String shopName;
    private CType type;
    private List<ConnectorData> connectors;

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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
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

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public CType getType() {
        return type;
    }

    public void setType(CType type) {
        this.type = type;
    }

    public List<ConnectorData> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<ConnectorData> connectors) {
        this.connectors = connectors;
    }
}
