package model;

public class Pageable {
    private String kw;
    private int productType;
    private int page;
    private int limit;
    private int total;

    public Pageable() {
    }

    public Pageable(String kw, int productType, int page, int limit, int total) {
        this.kw = kw;
        this.productType = productType;
        this.page = page;
        this.limit = limit;
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Pageable(String kw, int productType, int page, int limit) {
        this.kw = kw;
        this.productType = productType;
        this.page = page;
        this.limit = limit;
    }

    public String getKw() {
        return kw;
    }

    public void setKw(String kw) {
        this.kw = kw;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
