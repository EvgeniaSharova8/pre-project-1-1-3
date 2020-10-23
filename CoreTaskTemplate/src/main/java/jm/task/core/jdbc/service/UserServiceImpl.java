package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends UserDaoJDBCImpl implements UserService {
    public UserServiceImpl() {

    }

    @Override
    public void createUsersTable() throws SQLException {
        super.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        super.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        super.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        super.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return super.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        super.cleanUsersTable();
    }

    @Override
    public void removeUserById(Long id) throws SQLException {
        super.removeUserById(id);
    }
}
