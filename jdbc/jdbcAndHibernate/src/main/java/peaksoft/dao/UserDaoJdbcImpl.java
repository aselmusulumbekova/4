package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static peaksoft.util.Config.getConnection;

public  abstract class UserDaoJdbcImpl implements UserDao {

    public final Config config = new Config();

    public UserDaoJdbcImpl() {

    }

   @Override
   public void createUsersTable() {

        String createTable = "create table if not exists users( " +
                "id serial primary key," +
                "name varchar, " +
                "last_name varchar, " +
                "age int); ";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTable);
            System.out.println("table created!");
        } catch (SQLException e) {
            System.out.println("!!!");
        }
    }

    @Override
    public void dropUsersTable() {
        String dropTable = "drop table if exists user";
        try(Connection connection = config.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(dropTable);
            System.out.println("drop table");
        } catch (SQLException e) {
            System.out.println("!!!");
        }
    }

   @Override
   public void saveUser(String name, String lastName, byte age) {
       String saveUser = "save table if not exists user(" +
               "name varchar," +
               "last_name varchar," +
               "age int);";
       try(Connection connection = config.getConnection();
           Statement statement = connection.createStatement()) {
           statement.executeUpdate(saveUser);
           System.out.println("save User!");
       } catch (SQLException e) {
           System.out.println("!!!");
       }
   }


    @Override
    public void removeUserById(){
    String removeID = "Delete from products (" + " Where id =?);";
        try(Connection connection = config.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(removeID);
            System.out.println("removeId");
        } catch (SQLException e) {
            System.out.println("!!!");
        }
    }
    @Override
    public List<User> getAllUsers() throws SQLException{
        String alterTable = "select * from users";
        try(Connection connection = config.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(alterTable);
            List<User> users = new ArrayList<>();
            while (resultSet.next()){
                users.add(new User(resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("age")));
            }
            return users;
        } catch (SQLException e) {
            System.out.println("!!!");
            throw new SQLException();
        }
    }

    @Override
    public void cleanUsersTable() {
        String cleanTable = "clean table if exists user";
        try(Connection connection = config.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(cleanTable);
            System.out.println("clean table");
        } catch (SQLException e) {
            System.out.println("!!!");
        }
    }

    }
