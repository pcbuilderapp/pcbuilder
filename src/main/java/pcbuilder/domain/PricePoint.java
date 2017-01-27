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
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    /** The pricing date. */
    @Column(nullable = false)
    private Date pricingDate;

    /** The price. */
    @Column(nullable = false)
    private Float price;

    /**
     * Instantiates a new price point.
     */
    @SuppressWarnings("unused")
    public PricePoint(){
        //needs to be empty for SpringBoot
    }

    /**
     * Instantiates a new price point.
     *
     * @param product Product
     * @param pricingDate Date
     * @param price Float
     */
    public PricePoint(Product product, Date pricingDate, Float price){
        this.product = product;
        this.pricingDate = pricingDate;
        this.price = price;
    }

    /**
     * Gets the pricing date.
     *
     * @return the pricing date
     */
    @SuppressWarnings("unused")
    public Date getPricingDate() {
        return pricingDate;
    }

    /**
     * Sets the pricing date.
     *
     * @param pricingDate Date
     */
    @SuppressWarnings("unused")
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
     * @param price Float
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Gets the product.
     *
     * @return the product
     */
    @SuppressWarnings("unused")
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product.
     *
     * @param product Product
     */
    @SuppressWarnings("unused")
    public void setProduct(Product product) {
        this.product = product;
    }
}
