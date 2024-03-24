/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import presentation.Gui;

/**
 *
 * @author Usuario
 */
public class Crud {
    
    public static final String url = "jdbc:mysql://localhost:3306/biblioteca";
    public static final String user = "root";
    public static final String pass = "";

    
    public Crud() {
        getConnection();
    }
    
    //método para conectar con la bd
    public static Connection getConnection() {
        Connection c = null;
        try {
            c = (Connection) DriverManager.getConnection(url, user, pass);
            Gui.print("Conexion con la base de datos exitosa");
        } catch (SQLException e) {
            Gui.print(e.getMessage());
        }
        return c;
    }
}
