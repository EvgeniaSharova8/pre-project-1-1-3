package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    Connection connection = getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        String sql = "CREATE TABLE user(id MEDIUMINT NOT NULL AUTO_INCREMENT, name VARCHAR(225), lastName VARCHAR(225), age INT, PRIMARY KEY (id))";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Таблица успешно создана");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public void dropUsersTable() throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DROP TABLE user;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            System.err.println("Таблицы с таким именем не существует");
        } finally {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String sql = "INSERT INTO user(name, lastName, age) VALUES ( ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.out.println(e);
            connection.rollback();
        } finally {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
            connection.setAutoCommit(true);
        }
    }

    public void removeUserById(long id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement preparedStatement = null;
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
            connection.setAutoCommit(true);
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setAge(resultSet.getByte("AGE"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null) {
                statement.close();
            }
        }
        return userList;
    }

    public void cleanUsersTable() throws SQLException {
        String sql = "TRUNCATE TABLE user";
        PreparedStatement preparedStatement = null;
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
            connection.setAutoCommit(true);
        }
    }
}
