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
	private boolean discounted;

	/**
	 * Gets the component.
	 *
	 * @return Component
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
	 * @return Float
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
	 * @return Shop
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
	 * @return String
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

    /**
     * Gets if a product is discounted.
     *
     * @return boolean
     */
    public boolean isDiscounted() {
        return discounted;
    }

    /**
     * Sets if a product is discounted.
     *
     * @param discounted boolean
     */
    public void setDiscounted(boolean discounted) {
        this.discounted = discounted;
    }

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", component=" + component +
				", shop=" + shop +
				", currentPrice=" + currentPrice +
				", productUrl='" + productUrl + '\'' +
				", discounted=" + discounted +
				'}';
	}
}
