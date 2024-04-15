/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import domain.Persona;

/**
 *
 * @author Usuario
 */
public class Estudiante extends Persona {

    private int id;
    private String carnet;

    public Estudiante() {
        this.id = 0;
        this.carnet = "";
    }

    public Estudiante(int id, String nombre, String apellido, String telefono, String carnet) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.carnet = carnet;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

}
