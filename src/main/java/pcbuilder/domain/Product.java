package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Component component;

	@OneToOne(cascade = CascadeType.ALL)
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

}
