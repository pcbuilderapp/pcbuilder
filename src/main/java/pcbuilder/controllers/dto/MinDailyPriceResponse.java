package pcbuilder.controllers.dto;

import pcbuilder.domain.MinDailyPriceView;

import java.util.List;

public class MinDailyPriceResponse {

    private List<MinDailyPriceView> minDailyPriceViewList;

    public List<MinDailyPriceView> getMinDailyPriceViewList() {
        return minDailyPriceViewList;
    }

    public void setMinDailyPriceViewList(List<MinDailyPriceView> minDailyPriceViewList) {
        this.minDailyPriceViewList = minDailyPriceViewList;
    }
}
