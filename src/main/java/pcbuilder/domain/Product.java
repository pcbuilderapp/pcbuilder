package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Class Product.
 */
@Entity
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames = {"component_id", "shop_id"})
})
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Component component;
	@OneToOne(cascade = CascadeType.ALL)
	private Shop shop;
	@Column(nullable = false)
	private Float currentPrice;
	private String productUrl;

	/**
	 * Gets the component.
	 *
	 * @return the component
	 */
	public Component getComponent() {
		return component;
	}

	/**
	 * Sets the component.
	 *
	 * @param component Component
	 */
	public void setComponent(Component component) {
		this.component = component;
	}

	/**
	 * Gets the current price.
	 *
	 * @return the current price
	 */
	public Float getCurrentPrice() {
		return currentPrice;
	}

	/**
	 * Sets the current price.
	 *
	 * @param currentPrice Float
	 */
	public void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}

	/**
	 * Gets the shop.
	 *
	 * @return the shop
	 */
	public Shop getShop() {
		return shop;
	}

	/**
	 * Sets the shop.
	 *
	 * @param shop Shop
	 */
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	/**
	 * Gets the product url.
	 *
	 * @return the product url
	 */
	public String getProductUrl() {
		return productUrl;
	}

	/**
	 * Sets the product url.
	 *
	 * @param productUrl String
	 */
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

}
