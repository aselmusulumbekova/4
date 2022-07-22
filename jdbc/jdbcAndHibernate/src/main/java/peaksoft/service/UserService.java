package peaksoft.service;

import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void createUsersTable();


    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);


    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable();

    void removeUserById(byte b);


}

