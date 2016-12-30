package pcbuilder.controllers.transport;

import java.util.List;

public class ComponentItemResponse {
    private List<ComponentItem> components;
    private int page;
    private int pageCount;

    public List<ComponentItem> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentItem> components) {
        this.components = components;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
