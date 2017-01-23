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

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The component. */
	@OneToOne(cascade = CascadeType.ALL)
	private Component component;

	/** The shop. */
	@OneToOne(cascade = CascadeType.ALL)
	private Shop shop;

	/** The current price. */
	@Column(nullable = false)
	private Float currentPrice;

	/** The product url. */
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
	 * @param component
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
	 * @param currentPrice
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
	 * @param shop
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
	 * @param productUrl
	 */
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

}
