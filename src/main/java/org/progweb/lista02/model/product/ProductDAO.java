package org.progweb.lista02.model.product;

import org.progweb.lista02.model.JdbcDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/*
    Classe concreta que implementa as operações de CRUD para a entidade Product, utilizando os métodos genéricos definidos na classe abstrata.
    Ela mapeia os resultados do banco de dados para objetos Product e fornece métodos específicos para listar, obter por ID, criar, atualizar e deletar produtos.
*/
public class ProductDAO extends JdbcDAO {

    private static final Logger logger = Logger.getLogger(ProductDAO.class.getName());

    @Override
    protected Logger logger() {
        return logger;
    }

    private Product mapProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setSchema(resultSet.getString("schema"));
        return product;
    }

    public List<Product> listAll() {
        return queryList(
                "SELECT id, schema FROM product",
                preparedStatement -> {
                },
                this::mapProduct,
                "Error listing products"
        );
    }

    public Product getById(int id) {
        return queryOne(
                "SELECT id, schema FROM product WHERE id = ?",
                preparedStatement -> preparedStatement.setInt(1, id),
                this::mapProduct,
                "Error getting product by ID"
        );
    }

    public boolean create(Product product) {
        return executeUpdate(
                "INSERT INTO product (schema) VALUES (?::jsonb)",
                preparedStatement -> preparedStatement.setString(1, product.getSchema()),
                "Error creating product"
        );
    }

    public boolean update(Product product) {
        return executeUpdate(
                "UPDATE product SET schema = ?::jsonb WHERE id = ?",
                preparedStatement -> {
                    preparedStatement.setString(1, product.getSchema());
                    preparedStatement.setInt(2, product.getId());
                },
                "Error updating product"
        );
    }

    public boolean delete(int id) {
        return executeUpdate(
                "DELETE FROM product WHERE id = ?",
                preparedStatement -> preparedStatement.setInt(1, id),
                "Error deleting product"
        );
    }
}
