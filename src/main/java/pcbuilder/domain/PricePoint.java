package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PricePoint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    Product product;

    private Date pricingDate;
    private Float price;

    public Date getPricingDate() {
        return pricingDate;
    }

    public void setPricingDate(Date pricingDate) {
        this.pricingDate = pricingDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PricePoint{" +
                "id=" + id +
                ", product=" + product +
                ", pricingDate=" + pricingDate +
                ", price=" + price +
                '}';
    }
}
