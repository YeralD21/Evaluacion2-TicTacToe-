/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.coon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ACER ASPIRE
 */
public class ConnS {
    private static volatile ConnS instance;
    private static volatile Connection connection;

    private ConnS() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create ");
        }
        if (connection != null) {
            throw new RuntimeException("Use getConnection() method to create ");
        }
    }
    
    public static ConnS getInstance() {
        if (instance == null) {
            synchronized (ConnS.class) {
                if (instance == null) {
                    instance = new ConnS();
                    System.out.println("Se instancio ConnS");
                }
            }
        }
        return instance;
    }


public Connection getConnection() {
        if (connection == null) {
            synchronized (ConnS.class) {
                if (connection == null) {
                    try {
                        String dbUrl= "jdbc:sqlite:data/resultados.db?foreign_keys=on;";
                        connection = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}
