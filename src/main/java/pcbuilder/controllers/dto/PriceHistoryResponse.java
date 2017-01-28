package pcbuilder.controllers.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Data transfer object to supply PriceHistory data to the frontend.
 */
public class PriceHistoryResponse {

    private List<PricePointData> priceHistory = new ArrayList<>();

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
    }

    /**
     * Adds a PricePointData object to the list of PricePointData objects
     * @param pricePointData PricePointData
     */
    public void addPriceHistory(PricePointData pricePointData) {
        priceHistory.add(pricePointData);
    }
}
