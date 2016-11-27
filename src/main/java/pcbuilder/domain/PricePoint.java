package pcbuilder.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PricePoint {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    Date pricingDate;
    Float price;

    public PricePoint(Date pricingDate, Float price) {
        this.pricingDate = pricingDate;
        this.price = price;
    }

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
}
