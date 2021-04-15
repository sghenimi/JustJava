package com.mycompany.exemples;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

public class MainApp {

    public static void main(String[] args) {
        //connecteDB();
        //reverseStr();
        //calculAge(1987, 11, 3);
        toBinary(7);
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

    private static void reverseStr(){
        String text = "Hello";
        char[] arr = text.toCharArray();
        System.out.println( "ntred : "+ text);
        String res = "";
        //your code goes here
        for(int i = arr.length-1; i >=0; i--){
            res = res + arr[i];
            System.out.println(arr[i]);
        }
        System.out.print(res);
    }

    private static void calculAge(int myYear, int myMonth, int myDay){
        LocalDate myBirth = LocalDate.of(myYear, myMonth, myDay);
        LocalDate today = LocalDate.now();
        long myYears = ChronoUnit.YEARS.between(myBirth, today);
        Period p = Period.between(myBirth, today);
        System.out.println(myYears);
        System.out.println("Year : " + p.getYears() + "  Months:" + p.getMonths() + " days: " + p.getDays());
    }

    private static void toBinary(int num){
        String binary="";
        while(num > 0) {
            binary = (num%2) + binary;
            num /= 2;
        }
        System.out.println("binary value : "+ binary);
    }
}
