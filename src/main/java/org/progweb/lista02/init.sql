\c ecommerce;

CREATE TABLE Product (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    schema JSONB NOT NULL
);

CREATE TABLE Sku (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product_id INT NOT NULL,   -- Dependent entity relative to Product
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    photo VARCHAR(255),   -- Photo URL
    stock INT NOT NULL,
    description TEXT NOT NULL,
    attributes JSONB NOT NULL,

    FOREIGN KEY (product_id) REFERENCES Product(id)
);