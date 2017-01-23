package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The Class PricePoint.
 */
@Entity
public class PricePoint implements Serializable {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The product. */
    @ManyToOne(cascade = CascadeType.ALL)
    Product product;

    /**
     * Instantiates a new price point.
     */
    public PricePoint(){}

    /**
     * Instantiates a new price point.
     *
     * @param product
     * @param pricingDate
     * @param price
     */
    public PricePoint(Product product, Date pricingDate, Float price){
        this.product = product;
        this.pricingDate = pricingDate;
        this.price = price;
    }

    /** The pricing date. */
    @Column(nullable = false)
    private Date pricingDate;

    /** The price. */
    @Column(nullable = false)
    private Float price;

    /**
     * Gets the pricing date.
     *
     * @return the pricing date
     */
    public Date getPricingDate() {
        return pricingDate;
    }

    /**
     * Sets the pricing date.
     *
     * @param pricingDate 
     */
    public void setPricingDate(Date pricingDate) {
        this.pricingDate = pricingDate;
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
     * @param price 
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Gets the product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product.
     *
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}
