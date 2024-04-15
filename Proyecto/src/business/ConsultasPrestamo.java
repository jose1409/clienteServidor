package business;

import domain.Prestamo;
import domain.Estudiante;
import domain.Libro;
import data.Crud;
import static data.Crud.getConnection;
import domain.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasPrestamo extends Crud {

    public boolean registrar(Prestamo pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "INSERT INTO prestamo(codigo, fecha_registro, estado, id_estudiante, id_libro) VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setDate(2, java.sql.Date.valueOf(pro.getFechaRegistro()));
            ps.setBoolean(3, pro.isEstado());
            ps.setInt(4, pro.getId_estudiante().getId());
            ps.setInt(5, pro.getId_libro().getId());
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

public boolean modificar(Prestamo pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "UPDATE prestamo SET codigo=?, fecha_registro=?, estado=?, id_estudiante=?,id_libro=?    WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
 ps.setString(1, pro.getCodigo());
            ps.setDate(2, java.sql.Date.valueOf(pro.getFechaRegistro()));
            ps.setBoolean(3, pro.isEstado());
            ps.setInt(4, pro.getId_estudiante().getId());
            ps.setInt(5, pro.getId_libro().getId());
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

    public boolean eliminar(Prestamo pro) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "DELETE FROM prestamo WHERE id=?";
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

    public boolean buscar(Prestamo pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT * FROM prestamo WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
                pro.setEstado(rs.getBoolean("estado"));
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id_estudiante"));
                pro.setId_estudiante(estudiante);
                Libro libro = new Libro();
                libro.setId(rs.getInt("id_libro"));
                pro.setId_libro(libro);
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
