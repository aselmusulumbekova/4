package peaksoft.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import peaksoft.model.User;
import peaksoft.util.Config;
import sun.security.krb5.Config;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            Session session= Config.getSession().openSession();
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users ").executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session=Config.getSession().openSession();
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE users").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Table drop");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try { Session session=Util.getSession().openSession();
            session.beginTransaction();
            User user=new User(name,lastName,age);
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session=Config.getSession().openSession();
            session.beginTransaction();
            User user = (User) session.get(User.class,id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("DELETE user с id: " + id);
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<User> getAllUsers() {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            List<User> users = session.createQuery("FROM User").list();
            session.getTransaction().commit();
            session.close();
            return users;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }
}
