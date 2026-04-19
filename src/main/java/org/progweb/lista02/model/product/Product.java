package org.progweb.lista02.model.product;

public class Product {

    private int id;
    private String schema;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return id == product.id && schema.equals(product.schema);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + schema.hashCode();
        return result;
    }
}
