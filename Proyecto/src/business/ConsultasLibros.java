/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import domain.Libro;
import data.Crud;
import data.Listas;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

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
            ps.setString(3, pro.getFechaLanzamiento());
            ps.setBoolean(4, pro.getDisponibilidad());
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
            ps.setString(3, pro.getFechaLanzamiento());
            ps.setBoolean(4, pro.getDisponibilidad());
            //ps.setString(5,pro.getEstudiante());
            ps.setInt(5, pro.getId());
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

    // estadisticas libros
    public int cuentaDisponibles() {
        return cuentaPorDisponibilidad(true);
    }

    public int cuentaNoDisponibles() {
        return cuentaPorDisponibilidad(false);
    }

    public int cuentaDisponibilidad() {
        return cuentaPorDisponibilidad(null);
    }

    // contar segun el estado del prestamo
    private int cuentaPorDisponibilidad(Boolean disponibilidad) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cuenta = 0;
        String sql = "SELECT COUNT(*) FROM libro";
        if (disponibilidad != null) {
            sql += " WHERE disponibilidad=?";
        }
        try {
            ps = con.prepareStatement(sql);
            if (disponibilidad != null) {
                ps.setBoolean(1, disponibilidad);
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                cuenta = rs.getInt(1);
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
        return cuenta;
    }

    public void obtenerLibros() {
        Listas.libro = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM libro";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("idautor"));
                libro.setFechaLanzamiento(rs.getString("fechalanzamiento"));
                libro.setDisponibilidad(rs.getBoolean("disponibilidad"));
                Listas.libro.add(libro);
            }
        } catch (SQLException e) {
            System.err.println("Error para mostrar libros");
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

}
