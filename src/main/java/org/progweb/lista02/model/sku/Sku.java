package org.progweb.lista02.model.sku;

import java.math.BigDecimal;
import java.util.Objects;

/*
 SKU (Stock Keeping Unit) é um identificador único para cada item em estoque.
 Cada SKU representa uma variação específica de um produto, como cor, tamanho ou modelo.
*/
public class Sku {

    private int id;
    private int productId;
    private String name;
    private BigDecimal price;
    private String photo;
    private int stock;
    private String description;
    private String attributes;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Sku sku = (Sku) o;
        return id == sku.id && productId == sku.productId && stock == sku.stock && name.equals(sku.name) && price.equals(sku.price) && Objects.equals(photo, sku.photo) && description.equals(sku.description) && attributes.equals(sku.attributes);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + productId;
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + Objects.hashCode(photo);
        result = 31 * result + stock;
        result = 31 * result + description.hashCode();
        result = 31 * result + attributes.hashCode();
        return result;
    }
}
