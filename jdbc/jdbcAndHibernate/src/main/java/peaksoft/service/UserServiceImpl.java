package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public abstract class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoJdbcImpl() {
        @Override
        public void removeUserById(long id) {
            userDao.removeUserById();

        }

        @Override
        public void removeUserById(int id) throws SQLException {
            userDao.removeUserById();

        }

        @Override
        public void dropUsersTable() {
            userDao.dropUsersTable();
        }

        @Override
        public void createUsersTable() {
            userDao.createUsersTable();

        }

        @Override
        public void saveUser(String name, String lastName, byte age) {
            userDao.saveUser(name, lastName, age);


        }

        @Override
        public List<User> getAllUsers() throws SQLException {
            return null;
        }

        @Override
        public void cleanUsersTable() {
            userDao.cleanUsersTable();
        }

        @Override
        public String toString() {
            return "$classname{}";
        }
    };
}
