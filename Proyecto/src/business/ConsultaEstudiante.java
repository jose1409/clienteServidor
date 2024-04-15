/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import domain.Estudiante;
import data.Crud;
import static data.Crud.getConnection;
import domain.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author braym
 */
public class ConsultaEstudiante extends Crud{
     public boolean registrar(Estudiante pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "INSERT INTO estudiante (nombre,apellido,telefono, carnet) VALUES(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getApellido());
            ps.setString(3,pro.getTelefono());
            ps.setString(4,pro.getCarnet());
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
     
     
     public boolean modificar(Estudiante pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "UPDATE estudiante SET nombre=?, apellido=?, telefono=?,carnet=?    WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getApellido());
            ps.setString(3,pro.getTelefono());
            ps.setString(4,pro.getCarnet());
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
     
     
      public boolean eliminar(Estudiante pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "DELETE FROM estudiante WHERE id=?";
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
     public boolean buscar(Estudiante pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT * FROM estudiante WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id")));
            pro.setNombre(rs.getString("nombre"));
            pro.setApellido(rs.getString("apellido"));
            pro.setTelefono(rs.getString("telefono"));
            pro.setCarnet(rs.getString("carnet"));
           // pro.setEstudiante(rs.getString("estudiante"));
            
            
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
