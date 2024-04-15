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
            ps.setInt(6, pro.getId());
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
                estudiante.setCarnet(rs.getString("id_estudiante"));
                pro.setId_estudiante(estudiante);
                Libro libro = new Libro();
                libro.setNombre(rs.getString("id_libro"));
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

    public int ultimoId() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        int ultimoId = 0;

        String sql = "SELECT MAX(id) FROM prestamo";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return ultimoId;
    }

    public boolean actualizarCodigo(Prestamo pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "UPDATE prestamo SET codigo=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setInt(2, pro.getId());
            int columnasPorActualizar = ps.executeUpdate();
            return columnasPorActualizar > 0;
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

    
    // estadisticas prestamos
        public int cuentaActivos() {
        return cuentaSegunEstado(true);
    }

    public int cuentaInactivos() {
        return cuentaSegunEstado(false);
    }

    public int cuentaPrestamo() {
        return cuentaSegunEstado(null);
    }
    
    // contar segun el estado del prestamo
    private int cuentaSegunEstado(Boolean estado) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cuenta = 0;
        String sql = "SELECT COUNT(*) FROM prestamo";
        if (estado != null) {
            sql += " WHERE estado=?";
        }
        try {
            ps = con.prepareStatement(sql);
            if (estado != null) {
                ps.setBoolean(1, estado);
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                cuenta = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error de conteo");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error");
            }
        }
        return cuenta;
    }
    
    
    
}




