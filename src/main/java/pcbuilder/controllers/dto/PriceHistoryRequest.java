package pcbuilder.controllers.dto;

import java.util.Date;

/**
 * Request data for which to receive a Price History
 */
public class PriceHistoryRequest {

    private long componentId;
    private Date fromDate;
    private Date toDate;
    private boolean min;

    /**
     *
     * @return long
     */
    public long getComponentId() {
        return componentId;
    }

    /**
     *
     * @param componentId long
     */
    public void setComponentId(long componentId) {
        this.componentId = componentId;
    }

    /**
     *
     * @return Date
     */
    public Date getFromDate() {
        return fromDate;
    }

    /**
     *
     * @param fromDate Date
     */
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    /**
     *
     * @return Date
     */
    public Date getToDate() {
        return toDate;
    }

    /**
     *
     * @param toDate Date
     */
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    /**
     *
     * @return boolean
     */
    public boolean isMin() {
        return min;
    }

    /**
     *
     * @param min boolean
     */
    public void setMin(boolean min) {
        this.min = min;
    }
}
