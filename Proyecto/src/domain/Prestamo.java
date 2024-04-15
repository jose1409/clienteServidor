/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

//librerias
import java.time.LocalDate;

//clase
public class Prestamo {

    private int id;
    private String codigo;
    private LocalDate fechaRegistro;
    private boolean estado;
    private Estudiante id_estudiante;
    private Libro id_libro;

    public Prestamo() {
        this.id = 0;
        this.codigo = "P-" + id;
        this.fechaRegistro = LocalDate.now();
        this.estado = false;
        this.id_estudiante = null;
        this.id_libro = null;
    }

    //constructor
    public Prestamo(int id, String codigo, LocalDate fechaRegistro, boolean estado, Estudiante estudiante, Libro libro) {
        this.id = id;
        this.codigo = codigo;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.id_estudiante = id_estudiante;
        this.id_libro = id_libro;
    }

    // get y set
    public int getId() {
        return id;
    }
      
      public void setId(int id) {
        this.id = id;
        this.codigo = "P-" + id;
    }
      

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Estudiante getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Estudiante id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public Libro getId_libro() {
        return id_libro;
    }

    public void setId_libro(Libro id_libro) {
        this.id_libro = id_libro;
    }

}
