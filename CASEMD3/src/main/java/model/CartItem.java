package model;

import java.math.BigDecimal;

public class CartItem {
    private long id;
    private long idProduct;
    private long idCart;
    private Product product;
    private BigDecimal price;
    private long quantity;
    private double total;

    public CartItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public long getIdCart() {
        return idCart;
    }

    public void setIdCart(long idCart) {
        this.idCart = idCart;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public CartItem(long id, long idProduct, long idCart, BigDecimal price, long quantity) {
        this.id = id;
        this.idProduct = idProduct;
        this.idCart = idCart;
        this.price = price;
        this.quantity = quantity;
    }
    public CartItem(long idProduct, long idCart, BigDecimal price, long quantity) {
        this.idProduct = idProduct;
        this.idCart = idCart;
        this.price = price;
        this.quantity = quantity;
    }
    public CartItem(long idProduct, BigDecimal price, long quantity) {
        this.idProduct = idProduct;
        this.price = price;
        this.quantity = quantity;
    }

    public CartItem(long id, long idProduct, long idCart, Product product, BigDecimal price, long quantity, double total) {
        this.id = id;
        this.idProduct = idProduct;
        this.idCart = idCart;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }
}