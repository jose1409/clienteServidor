/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import domain.Libro;
import static data.Listas.*;
import domain.*;
import presentation.Gui;

/**
 *
 * @author Usuario
 */
public class Logic {

    /*Ver Libros
    public static void insertarLibros() {
        String temp = "---Libros---\n";
        for (int i = 0; i < libro.size(); i++) {
            Libro libroActual = libro.get(i);
            String disponibilidad = (libroActual.isDisponibilidad()) ? "Disponible" : "No disponible";
            temp += "Nombre: " + libroActual.getNombre() + "\n"
                    + "Fecha de Lanzamiento: " + libroActual.getFechaLanzamiento() + "\n"
                    + "Disponibilidad: " + disponibilidad + "\n\n";
        }
        Gui.print(temp);
    }*/

    //Ver Autores
    public static void mostrarAutores() {
        String temp = "---Autores---\n";
        for (int i = 0; i < autor.size(); i++) {
            Autor autorActual = autor.get(i);
            temp += "Nombre: " + autorActual.getNombre() + "\n"
                    + "Apellidos: " + autorActual.getApellido() + "\n"
                    + "Telefono: " + autorActual.getTelefono() + "\n"
                    + "Nacionalidad: " + autorActual.getNacionalidad() + "\n\n";
        }
        Gui.print(temp);
    }

    public static void mostrarEstudiantes() {
        String temp = "---Autores---\n";
        for (int i = 0; i < estudiante.size(); i++) {
            Estudiante estudianteActual = estudiante.get(i);
            temp += "Nombre: " + estudianteActual.getNombre() + "\n"
                    + "Apellidos: " + estudianteActual.getApellido() + "\n"
                    + "Telefono: " + estudianteActual.getTelefono() + "\n"
                    + "Carnet: " + estudianteActual.getCarnet()+ "\n\n";
        }
        Gui.print(temp);
    }
}