package pcbuilder.controllers.dto;

import java.util.Date;

public class PricePointData {

    private Date date;
    private Double price;

    public PricePointData(Date date, Double price) {
        this.date = date;
        this.price = price;
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
}
