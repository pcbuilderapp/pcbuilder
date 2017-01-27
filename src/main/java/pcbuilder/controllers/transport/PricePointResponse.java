package pcbuilder.controllers.transport;

import pcbuilder.domain.PricePoint;

import java.util.List;

public class PricePointResponse {

    private List<PricePoint> pricePoints;

    public List<PricePoint> getPricePoints() {
        return pricePoints;
    }

    public void setPricePoints(List<PricePoint> pricePoints) {
        this.pricePoints = pricePoints;
    }
}
