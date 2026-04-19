package org.progweb.lista02.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/*
    Esta classe é uma implementação genérica reutilizável de DAO usando JDBC. Ela possui métodos genéricos para:
    - queryList: executar consultas que retornam múltiplos resultados.
    - queryOne: executar consultas que retornam um único resultado.
    - executeUpdate: executar operações de inserção, atualização ou exclusão.
    Além disso, ela também define interfaces funcionais para configurar PreparedStatements e mapear ResultSets, permitindo que as subclasses forneçam a lógica específica de mapeamento e configuração.
    A classe também lida com a conexão do banco de dados e o tratamento de exceções, registrando erros usando um logger específico para cada DAO.
*/
public abstract class JdbcDAO {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/ecommerce";
    private static final String JDBC_USER = "smd";
    private static final String JDBC_PWD = "ufc123";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Could not load JDBC driver", e);
        }
    }

    @FunctionalInterface
    protected interface PreparedStatementSetter {
        void accept(PreparedStatement preparedStatement) throws SQLException;
    }

    @FunctionalInterface
    protected interface ResultSetMapper<T> {
        T map(ResultSet resultSet) throws SQLException;
    }

    protected abstract Logger logger();

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PWD);
    }

    protected <T> List<T> queryList(
            String sql,
            PreparedStatementSetter setter,
            ResultSetMapper<T> mapper,
            String errorMessage
    ) {
        List<T> results = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setter.accept(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    results.add(mapper.map(resultSet));
                }
            }
            return results;
        } catch (SQLException e) {
            logger().severe(errorMessage + ": " + e.getMessage());
            return null;
        }
    }

    protected <T> T queryOne(
            String sql,
            PreparedStatementSetter setter,
            ResultSetMapper<T> mapper,
            String errorMessage
    ) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setter.accept(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapper.map(resultSet);
                }
            }
            return null;
        } catch (SQLException e) {
            logger().severe(errorMessage + ": " + e.getMessage());
            return null;
        }
    }

    protected boolean executeUpdate(
            String sql,
            PreparedStatementSetter setter,
            String errorMessage
    ) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setter.accept(preparedStatement);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger().severe(errorMessage + ": " + e.getMessage());
            return false;
        }
    }
}
