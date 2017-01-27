package pcbuilder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "min_daily_price_view")
public class MinDailyPriceView {

    @Id
    @Column(name = "pricepoint_id")
    private Long pricepoint_id;

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

    public Long getPricepoint_id() {
        return pricepoint_id;
    }

    public void setPricepoint_id(Long pricepoint_id) {
        this.pricepoint_id = pricepoint_id;
    }
}
