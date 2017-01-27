package pcbuilder.controllers.transport;

import java.util.List;

/**
 * The Class ComponentItemResponse.
 */
public class ComponentItemResponse {

    private List<ComponentItem> components;
    private int page;
    private int pageCount;

    /**
     * Gets the components.
     *
     * @return components
     */
    @SuppressWarnings("unused")
    public List<ComponentItem> getComponents() {
        return components;
    }

    /**
     * Sets the components.
     *
     * @param components List
     */
    public void setComponents(List<ComponentItem> components) {
        this.components = components;
    }

    /**
     * Gets the page.
     *
     * @return page
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the page.
     *
     * @param page int
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Gets the page count.
     *
     * @return the page count
     */
    @SuppressWarnings("unused")
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Sets the page count.
     *
     * @param pageCount int
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
