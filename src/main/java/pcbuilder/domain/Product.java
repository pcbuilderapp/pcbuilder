package pcbuilder.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private Component component;
	private Float currentPrice;
	private Shop shop;
	private String productUrl;

	public Product(Component component, Float currentPrice, Shop shop, String productUrl) {
		this.component = component;
		this.currentPrice = currentPrice;
		this.shop = shop;
		this.productUrl = productUrl;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public Float getPrice() {
		return currentPrice;
	}

	public void setPrice(Float price) {
		this.currentPrice = price;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	@Override
	public String toString() {
		return "Product{" +
				"component=" + component +
				", currentPrice=" + currentPrice +
				", shop=" + shop +
				", productUrl='" + productUrl + '\'' +
				'}';
	}
}
