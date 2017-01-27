package pcbuilder.controllers.transport;

import pcbuilder.domain.Product;

import java.util.List;

public class ProductsResponse {
    private List<Product> products;
    private int page;
    private int pageCount;

    @SuppressWarnings("unused")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @SuppressWarnings("unused")
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
