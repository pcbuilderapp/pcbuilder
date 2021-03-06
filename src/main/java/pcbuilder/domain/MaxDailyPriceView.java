package pcbuilder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "max_daily_price_view")
public class MaxDailyPriceView {

    @Id
    @Column(name = "pricepoint_id")
    private Long pricepointId;

    @Column(name = "component_id")
    private Long componentId;

    @Column(name = "date")
    private Date date;

    @Column(name = "price")
    private Double price;

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getPricepointId() {
        return pricepointId;
    }

    public void setPricepointId(Long pricepointId) {
        this.pricepointId = pricepointId;
    }
}
