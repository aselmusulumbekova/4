package peaksoft;


import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args)throws Exception {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
      User user = new User("1","Asel","Musulumbekova",33);
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.createUsersTable();
        userService.removeUserById(id);



    }
}
