/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import domain.Estudiante;
import domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentation.Gui;

/**
 *
 * @author Usuario
 */
public class Crud {

    String base = "test"; //"biblioteca" o "test"
    public static final String url = "jdbc:mysql://localhost:3306/" + "test";//biblioteca
    public static final String user = "root";
    public static final String pass = "";

    public Crud() {
        //  infoEstudiantesLocal();
        //   infoAutorLocal();
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

    //metodo para contar total estudiantes
    public int conteoEstudiantes() {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int conteo = 0;
        String sql = "SELECT COUNT(*) FROM estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                conteo = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error de conteo");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Error");
            }
        }
        return conteo;
    }

    //metodo para contar total autores
    public int conteoAutores() {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int conteo = 0;
        String sql = "SELECT COUNT(*) FROM autor";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                conteo = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error de conteo");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Error");
            }
        }
        return conteo;
    }
    
    
    // metodo para obtener estudiantes
       public void obtenerEstudiantes() {
        Listas.estudiante = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM estudiante";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setCarnet(rs.getString("carnet"));
                Listas.estudiante.add(estudiante);
            }
        } catch (SQLException e) {
            System.err.println("Error para mostrar estudiantes");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Error");
            }
        }
    }
       
           //metodo mostrar estudiantes
    public void mostrarEstudiantes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Estudiantes:\n");
        for (Estudiante estudiante : Listas.estudiante) {
            if (estudiante.getId() != 0) {
                sb.append("Id: ").append(estudiante.getId())
                        .append(", Nombre: ").append(estudiante.getNombre())
                        .append(", Apellido: ").append(estudiante.getApellido())
                        .append(", Teléfono: ").append(estudiante.getTelefono())
                        .append(", Carnet: ").append(estudiante.getCarnet())
                        .append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    // metodo para obtener autores
       public void obtenerAutores() {
        Listas.autor = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM autor";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId(rs.getInt("id"));
                autor.setNombre(rs.getString("nombre"));
                autor.setApellido(rs.getString("apellido"));
                autor.setTelefono(rs.getString("telefono"));
                autor.setNacionalidad(rs.getString("nacionalidad"));
                Listas.autor.add(autor);
            }
        } catch (SQLException e) {
            System.err.println("Error para mostrar autores");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Error");
            }
        }
    }
       
           //metodo mostrar autores
    public void mostrarAutores() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Autores:\n");
        for (Autor autor : Listas.autor) {
            if (autor.getId() != 0) {
                sb.append("Id: ").append(autor.getId())
                        .append(", Nombre: ").append(autor.getNombre())
                        .append(", Apellido: ").append(autor.getApellido())
                        .append(", Teléfono: ").append(autor.getTelefono())
                        .append(", Nacionalidad: ").append(autor.getNacionalidad())
                        .append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
}
