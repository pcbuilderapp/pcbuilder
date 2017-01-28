package pcbuilder.controllers.dto;

import pcbuilder.domain.PricePoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Data transfer object to supply PriceHistory data to the frontend.
 */
public class PriceHistoryResponse {

    private List<PricePointData> priceHistory = new ArrayList<>();

    private boolean priceFalling;

    /**
     * Gets the list with PriceHistory data
     * @return List
     */
    public List<PricePointData> getPriceHistory() {
        return priceHistory;
    }

    /**
     * Sets the list with PriceHistory data
     * @param priceHistory List
     */
    public void setPriceHistory(List<PricePointData> priceHistory) {
        this.priceHistory = priceHistory;
        calculatePriceFalling();
    }

    /**
     * Adds a PricePointData object to the list of PricePointData objects
     * @param pricePointData PricePointData
     */
    public void addPriceHistory(PricePointData pricePointData) {

        priceHistory.add(pricePointData);
        calculatePriceFalling();
    }

    /**
     * Has the price of this history gone up or down?
     * @return boolean
     */
    public boolean isPriceFalling() {
        return priceFalling;
    }

    /**
     * Sets if the price of this history has gone up or down
     * @param priceFalling boolean
     */
    private void setPriceFalling(boolean priceFalling) {
        this.priceFalling = priceFalling;
    }

    private void calculatePriceFalling() {
        PricePointData first = priceHistory.get(0);
        PricePointData last = priceHistory.get(priceHistory.size()-1);
        if (first.getPrice() > last.getPrice()) {
            setPriceFalling(true);
        } else {
            setPriceFalling(false);
        }
    }
}
