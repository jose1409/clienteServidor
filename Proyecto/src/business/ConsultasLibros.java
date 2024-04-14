/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import domain.Libro;
import data.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author braym
 */
public class ConsultasLibros extends Crud {
     public boolean registrar(Libro pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "INSERT INTO libro(nombre,idautor,fechalanzamiento, disponibilidad) VALUES(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getAutor());
            ps.setString(3,pro.getFechaLanzamiento());
            ps.setBoolean(4,pro.getDisponibilidad());
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
     
     public boolean modificar(Libro pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "UPDATE libro SET nombre=?, idautor=?, fechalanzamiento=?,disponibilidad=?    WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getAutor());
            ps.setString(3,pro.getFechaLanzamiento());
            ps.setBoolean(4,pro.getDisponibilidad());
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
     
     public boolean eliminar(Libro pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "DELETE FROM libro WHERE id=?";
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
     public boolean buscar(Libro pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT * FROM libro WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id")));
            pro.setNombre(rs.getString("nombre"));
            pro.setAutor(rs.getString("idautor"));
            pro.setFechaLanzamiento(rs.getString("fechalanzamiento"));
            pro.setDisponibilidad(Boolean.parseBoolean(rs.getString("disponibilidad")));
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
