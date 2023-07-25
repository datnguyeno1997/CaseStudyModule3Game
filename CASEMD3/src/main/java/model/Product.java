package model;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class Product {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate createAt;
    private int idProductType;
    private ProductType productType;
    private Instant updateAt;
    private int quantity;
    private String img;
    private Action action;

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Product() {
    }

    public Product(long id, String name, String description, BigDecimal price, LocalDate createAt, int idProductType, ProductType productType, Instant updateAt, int quantity, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
        this.idProductType = idProductType;
        this.productType = productType;
        this.updateAt = updateAt;
        this.quantity = quantity;
        this.img = img;
    }

    public Product(long id, String name, String description, BigDecimal price, LocalDate createAt, int quantity, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
        this.quantity = quantity;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public int getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(int idProductType) {
        this.idProductType = idProductType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
