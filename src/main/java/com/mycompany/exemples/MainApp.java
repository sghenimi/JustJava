package com.mycompany.exemples;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MainApp {

    public static void main(String[] args) {
        connecteDB();
    }

    private static void connecteDB() {
        Properties prop = new Properties();
        InputStream input = null;
        Connection conn = null;
        try{
            input = MainApp.class.getClassLoader().getResourceAsStream("config.properties");
            // load a properties file
            prop.load(input);
            printConfig(prop);
            conn = DriverManager.getConnection(
                    prop.getProperty("db.url"),
                    prop.getProperty("db.user"),
                    prop.getProperty("db.password"));

            if (conn != null) {
                System.out.println("==> Connected to the database!");
            } else {
                System.out.println("==> Failed to make connection!");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void printConfig(Properties prop) {
        // Java 8 , print key and values
        // Get all keys
        prop.keySet().forEach(x -> System.out.println(x));

        prop.forEach((key, value) -> System.out.println("Key : " + key + ", Value : " + value));


    }

}
