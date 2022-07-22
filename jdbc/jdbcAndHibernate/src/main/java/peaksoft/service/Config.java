package peaksoft.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    public Connection getConnection() throws SQLException {
        return DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1234");


    }
    public static SessionFactory getSession() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}


