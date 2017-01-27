package pcbuilder.controllers.transport;

import pcbuilder.domain.MaxDailyPriceView;

import java.util.List;

public class MaxDailyPriceResponse {

    private List<MaxDailyPriceView> maxDailyPriceViewList;

    public List<MaxDailyPriceView> getMaxDailyPriceViewList() {
        return maxDailyPriceViewList;
    }

    public void setMaxDailyPriceViewList(List<MaxDailyPriceView> maxDailyPriceViewList) {
        this.maxDailyPriceViewList = maxDailyPriceViewList;
    }
}
