package com.intelliJoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        try {
            Driver driver = DriverManager.getDriver("jdbc:mysql://localhost:3306/");
            System.out.println("JDBC Driver Version: " + driver.getMajorVersion() + "." + driver.getMinorVersion());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SpringApplication.run(Application.class, args);
    }
}