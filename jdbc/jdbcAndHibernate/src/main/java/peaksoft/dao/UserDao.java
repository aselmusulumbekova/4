package peaksoft.dao;

import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    

    void createUsersTable();


    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    void removeUserById(int id) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable();

    void removeUserById();
}
