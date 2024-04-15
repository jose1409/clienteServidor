/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import domain.Autor;

/**
 *
 * @author Usuario
 */
public class Libro {

    private int id;
    private String autor;
    private String estudiante;
    private String nombre;
    private String fechaLanzamiento;
    private boolean disponibilidad;

    public Libro() {
        this.id = 0;
        this.nombre = "";
        this.fechaLanzamiento = "";
        this.disponibilidad = true;
    }

    public Libro(int id, String autor, String estudiante, String nombre, String fechaLanzamiento, boolean disponibilidad) {
        this.id = id;
        this.autor = autor;
        this.estudiante = null;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

}
