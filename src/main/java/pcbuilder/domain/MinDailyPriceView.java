package pcbuilder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "min_daily_price_view")
public class MinDailyPriceView {

    @Id
    @Column(name = "pricepoint_id")
    private Long pricepointId;

    @Column(name = "component_id")
    private Long componentId;

    @Column(name = "date")
    private Date date;

    @Column(name = "price")
    private Double price;

    @SuppressWarnings("unused")
    public Long getComponentId() {
        return componentId;
    }

    @SuppressWarnings("unused")
    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    @SuppressWarnings("unused")
    public Date getDate() {
        return date;
    }

    @SuppressWarnings("unused")
    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @SuppressWarnings("unused")
    public Long getPricepointId() {
        return pricepointId;
    }

    @SuppressWarnings("unused")
    public void setPricepointId(Long pricepointId) {
        this.pricepointId = pricepointId;
    }
}
