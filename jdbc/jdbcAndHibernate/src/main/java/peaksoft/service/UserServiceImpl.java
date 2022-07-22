package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public  class UserServiceImpl implements UserService {

     UserDao userDao = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }

    @Override
    public void removeUserById(byte b) {

    }
}
