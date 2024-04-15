/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import domain.Estudiante;
import domain.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        infoEstudiantesLocal();
        infoAutorLocal();
    }

    //método para conectar con la bd
    public static Connection getConnection() {
        Connection c = null;
        try {
            c = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            Gui.print(e.getMessage());
        }
        return c;
    }

    //Metodo guardado de base de datos a arrayList los Autores
    public static void infoAutorLocal() {
        try {
            Connection con = Crud.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM autor");
            ResultSet res = ps.executeQuery();
            while (res.next()) {//mientras haya que mostrar apunta al siguiente
                Listas.autor.add(new Autor(
                        res.getInt("id"),
                        res.getString("nombre"),
                        res.getString("apellido"),
                        res.getString("telefono"),
                        res.getString("nacionalidad")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodo guardado de base de datos a arrayList los Autores
    public static void infoEstudiantesLocal() {
        try {
            Connection con = Crud.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM estudiante");
            ResultSet res = ps.executeQuery();
            while (res.next()) {//mientras haya que mostrar apunta al siguiente
                Listas.estudiante.add(new Estudiante(
                        res.getInt("id"),
                        res.getString("nombre"),
                        res.getString("apellido"),
                        res.getString("telefono"),
                        res.getString("carnet")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //método para insertar datos
    public static void InsertarInfoAutor(Autor autor) {
        try {
            Connection con = Crud.getConnection();

            // Verificar si el autor ya está en la base de datos
            if (autor.getId() == 0) {
                // Autor no está en la base de datos, insertarlo
                PreparedStatement ps = con.prepareStatement("INSERT INTO autor (nombre, apellido, telefono, nacionalidad) VALUES (?, ?, ?, ?)");
                ps.setString(1, autor.getNombre());
                ps.setString(2, autor.getApellido());
                ps.setString(3, autor.getTelefono());
                ps.setString(4, autor.getNacionalidad());
                
                int filasInsertadas = ps.executeUpdate();
                if (filasInsertadas > 0) {
                    System.out.println("Datos insertados correctamente");
                } else {
                    Gui.errorMesage("No se pudo insertar los datos");
                }
            } else {
                // Autor ya está en la base de datos, no es necesario insertarlo nuevamente
                Gui.errorMesage("El autor ya está en la base de datos, no es necesario insertarlo.");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Insertado de Estudiantes en la base de datos
    public static void InsertarInfoEstudiante(Estudiante estudiante) {
        try {
            Connection con = Crud.getConnection();

            // Verificar si el autor ya está en la base de datos
            if (estudiante.getId() == 0) {
                // Autor no está en la base de datos, insertarlo
                PreparedStatement ps = con.prepareStatement("INSERT INTO estudiante (nombre, apellido, telefono, carnet) VALUES (?, ?, ?, ?)");
                ps.setString(1, estudiante.getNombre());
                ps.setString(2, estudiante.getApellido());
                ps.setString(3, estudiante.getTelefono());
                ps.setString(4, estudiante.getCarnet());
                
                int filasInsertadas = ps.executeUpdate();
                if (filasInsertadas > 0) {
                    System.out.println("Datos insertados correctamente");
                } else {
                    Gui.errorMesage("No se pudo insertar los datos");
                }
            } else {
                // Autor ya está en la base de datos, no es necesario insertarlo nuevamente
                Gui.errorMesage("El autor ya está en la base de datos, no es necesario insertarlo.");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
