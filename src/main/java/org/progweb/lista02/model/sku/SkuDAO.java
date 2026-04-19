package org.progweb.lista02.model.sku;

import org.progweb.lista02.model.JdbcDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/*
    Classe concreta que implementa as operações de CRUD para a entidade SKU, utilizando os métodos genéricos definidos na classe abstrata.
    Ela mapeia os resultados do banco de dados para objetos SKUs e fornece métodos específicos para listar, obter por ID, criar, atualizar e deletar SKUs.
*/
public class SkuDAO extends JdbcDAO {

    private static final Logger logger = Logger.getLogger(SkuDAO.class.getName());

    @Override
    protected Logger logger() {
        return logger;
    }

    private Sku mapSku(ResultSet resultSet) throws SQLException {
        Sku sku = new Sku();
        sku.setId(resultSet.getInt("id"));
        sku.setProductId(resultSet.getInt("product_id"));
        sku.setName(resultSet.getString("name"));
        sku.setPrice(resultSet.getBigDecimal("price"));
        sku.setPhoto(resultSet.getString("photo"));
        sku.setStock(resultSet.getInt("stock"));
        sku.setDescription(resultSet.getString("description"));
        sku.setAttributes(resultSet.getString("attributes"));
        return sku;
    }

    public List<Sku> listAll() {
        return queryList(
                "SELECT id, product_id, name, price, photo, stock, description, attributes FROM sku",
                preparedStatement -> {
                },
                this::mapSku,
                "Error listing skus"
        );
    }

    public Sku getById(int id) {
        return queryOne(
                "SELECT id, product_id, name, price, photo, stock, description, attributes FROM sku WHERE id = ?",
                preparedStatement -> preparedStatement.setInt(1, id),
                this::mapSku,
                "Error getting sku by ID"
        );
    }

    public List<Sku> listByProductId(int productId) {
        return queryList(
                "SELECT id, product_id, name, price, photo, stock, description, attributes FROM sku WHERE product_id = ?",
                preparedStatement -> preparedStatement.setInt(1, productId),
                this::mapSku,
                "Error listing skus by product ID"
        );
    }

    public boolean create(Sku sku) {
        return executeUpdate(
                "INSERT INTO sku (product_id, name, price, photo, stock, description, attributes) VALUES (?, ?, ?, ?, ?, ?, ?::jsonb)",
                preparedStatement -> {
                    preparedStatement.setInt(1, sku.getProductId());
                    preparedStatement.setString(2, sku.getName());
                    preparedStatement.setBigDecimal(3, sku.getPrice());
                    preparedStatement.setString(4, sku.getPhoto());
                    preparedStatement.setInt(5, sku.getStock());
                    preparedStatement.setString(6, sku.getDescription());
                    preparedStatement.setString(7, sku.getAttributes());
                },
                "Error creating sku"
        );
    }

    public boolean update(Sku sku) {
        return executeUpdate(
                "UPDATE sku SET product_id = ?, name = ?, price = ?, photo = ?, stock = ?, description = ?, attributes = ?::jsonb WHERE id = ?",
                preparedStatement -> {
                    preparedStatement.setInt(1, sku.getProductId());
                    preparedStatement.setString(2, sku.getName());
                    preparedStatement.setBigDecimal(3, sku.getPrice());
                    preparedStatement.setString(4, sku.getPhoto());
                    preparedStatement.setInt(5, sku.getStock());
                    preparedStatement.setString(6, sku.getDescription());
                    preparedStatement.setString(7, sku.getAttributes());
                    preparedStatement.setInt(8, sku.getId());
                },
                "Error updating sku"
        );
    }

    public boolean delete(int id) {
        return executeUpdate(
                "DELETE FROM sku WHERE id = ?",
                preparedStatement -> preparedStatement.setInt(1, id),
                "Error deleting sku"
        );
    }
}
