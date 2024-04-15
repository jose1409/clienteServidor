/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.Crud;
import static data.Crud.getConnection;
import domain.Autor;
import domain.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



public class consultaAutor extends Crud {
     public boolean registrar(Autor pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "INSERT INTO autor(nombre,apellido,telefono, nacionalidad) VALUES(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getApellido());
            ps.setString(3,pro.getTelefono());
            ps.setString(4,pro.getNacionalidad());
           // ps.setInt(5,pro.getId());
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
     
public boolean modificar(Autor pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "UPDATE Autor SET nombre=?, apellido=?, telefono=?,nacionalidad=?    WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getApellido());
            ps.setString(3,pro.getTelefono());
            ps.setString(4,pro.getNacionalidad());
            //ps.setString(5,pro.getEstudiante());
            ps.setInt(5,pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
     }

public boolean eliminar(Autor pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "DELETE FROM Autor WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

public boolean buscar(Autor pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT * FROM Autor WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id")));
            pro.setNombre(rs.getString("nombre"));
            pro.setApellido(rs.getString("apellido"));
            pro.setTelefono(rs.getString("telefono"));
            pro.setNacionalidad(rs.getString("nacionalidad"));
           // pro.autor(rs.getString("autor"));
            
            
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
     
}

