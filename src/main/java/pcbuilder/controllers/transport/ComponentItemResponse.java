package pcbuilder.controllers.transport;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponentItemResponse.
 */
public class ComponentItemResponse {
    
    /** The components. */
    private List<ComponentItem> components;
    
    /** The page. */
    private int page;
    
    /** The page count. */
    private int pageCount;

    /**
     * Gets the components.
     *
     * @return the components
     */
    public List<ComponentItem> getComponents() {
        return components;
    }

    /**
     * Sets the components.
     *
     * @param components the new components
     */
    public void setComponents(List<ComponentItem> components) {
        this.components = components;
    }

    /**
     * Gets the page.
     *
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the page.
     *
     * @param page the new page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Gets the page count.
     *
     * @return the page count
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Sets the page count.
     *
     * @param pageCount the new page count
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
