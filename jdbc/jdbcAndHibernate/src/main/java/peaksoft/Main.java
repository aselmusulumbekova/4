package peaksoft;


import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        // реализуйте алгоритм здесь
       UserServiceImpl userService = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true){
            int commandNum = scanner.nextByte();
            if (commandNum ==1) {
                userService.createUsersTable();
            } else if (commandNum ==2) {
                userService.saveUser("Asel", "Musulumbekova",(byte) 33);
                userService.saveUser("Maryam", "Baktibekova",(byte) 3);
                userService.saveUser("Azamat", "Ajigylov",(byte) 35);
            } else if(commandNum == 3)  {
                System.out.println(userService.getAllUsers());
            } else if (commandNum == 4) {
                System.out.println("write id");
                userService.removeUserById(scanner.nextByte());
            }else if (commandNum==5){
                userService.cleanUsersTable();
            } else if (commandNum == 6) {
                userService.dropUsersTable();
            }else {
                System.out.println("Wrong enter you have  only 6 command!");

            }
             {
                System.out.println("======= Commads====");
                System.out.println("Press 1 to create table");
                System.out.println("Press 2 to add users to database");
                System.out.println("Press 3 to get all users ");
                System.out.println("Press 4 to delete value by id");
                System.out.println("Press  5 to delete values of table");
                System.out.println("Press 6 to drop the table");
                System.out.println("============================");
            }

        }


    }


}
