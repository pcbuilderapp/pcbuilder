package pcbuilder.domain;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Component component;

	@OneToOne
	private Shop shop;

	private Float currentPrice;
	private String productUrl;

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
