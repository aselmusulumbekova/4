package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.service.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }
    User user=new User();

    public void createUsersTable() {


        String createTable = "CREATE TABLE IF NOT EXISTS users( " +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR, " +
                "last_name VARCHAR, " +
                "age int); ";
        try (Connection connection= Config.getConnection();
             Statement statement= connection.createStatement()){
            statement.executeUpdate(createTable);
            System.out.println("Благополучно создали таблицу ");
        }catch (SQLException e){
            e.getMessage();
        }
    }

    public void dropUsersTable() {
        String dropTable = "DROP TABLE IF EXISTS users";
        try (Connection connection= Config.getConnection();
             Statement statement= connection.createStatement()){
            statement.executeUpdate(dropTable);
            System.out.println("Благополучно удалили таблицу ");
        }catch (SQLException e){
            e.getMessage();
        }
    }

    public void saveUser(String name, String lastName, byte age) {


        String saveUserTable = "INSERT INTO users (name, last_name, age) values (?, ?, ?);";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(saveUserTable)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.executeUpdate();
            System.out.println("Успешно " + name+ " " +lastName+" " +" добавлен  в базу данных");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        String removeUserByIdTable = "DELETE FROM users WHERE id =(?)";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(removeUserByIdTable)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println(" Пользователь удален с id: " + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {

        String getAllTable = "SELECT * FROM users";
        try (Connection connection = Config.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(getAllTable);
            List<User>users=new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(resultSet.getLong("id" ),
                        resultSet.getString("name" ),
                        resultSet.getString("last_name" ),
                        resultSet.getByte("age" )));
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println( "Что то не то!!! " );
            return  null;
        }
    }

    public void cleanUsersTable() {

        String cleanTable = "CLEAN TABLE users";
        try (Connection connection= Config.getConnection();
             Statement statement= connection.createStatement()){
            statement.executeUpdate(cleanTable);
            System.out.println("Таблица успешно очишена");
        }catch (SQLException e){
            e.getMessage();
        }
    }
}


