/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import presentation.soliLibros;
import domain.Libro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author braym
 */
public class CtrlLibros implements ActionListener {

    private Libro modelo = new Libro();
    private ConsultasLibros consultas = new ConsultasLibros();
    private soliLibros vista = new soliLibros();

    public CtrlLibros(Libro modelo, ConsultasLibros consultas, soliLibros vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEstadistica.addActionListener(this);

    }

    public void iniciar() {
        vista.setTitle("Libros");
        vista.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //boton de guardar
        if (e.getSource() == vista.btnGuardar) {
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setAutor(vista.txtAutor.getText());
            modelo.setFechaLanzamiento(vista.txtfechaLanzamiento.getText());
            modelo.setDisponibilidad(Boolean.parseBoolean(vista.txtDisponibilidad.getText()));

            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }

        //boton de modificar
        if (e.getSource() == vista.btnModificar) {

            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setAutor(vista.txtAutor.getText());
            modelo.setFechaLanzamiento(vista.txtfechaLanzamiento.getText());
            modelo.setDisponibilidad(Boolean.parseBoolean(vista.txtDisponibilidad.getText()));
            if (consultas.modificar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }
        if (e.getSource() == vista.btnEliminar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        
        //Buscar
        
        if (e.getSource() == vista.btnBuscar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            if (consultas.buscar(modelo)) {
                
                
                vista.txtId.setText(String.valueOf(modelo.getId()));
                vista.txtNombre.setText(modelo.getNombre());
                vista.txtAutor.setText(modelo.getAutor());
                vista.txtfechaLanzamiento.setText(modelo.getFechaLanzamiento());
                vista.txtDisponibilidad.setText(String.valueOf( modelo.getDisponibilidad()));
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún registro");
                limpiar();
            }
        }
     if(e.getSource()==vista.btnLimpiar){
            limpiar();
        }
                  //Boton de estadistica
        if (e.getSource() == vista.btnEstadistica) {
            int cantDisponibles = consultas.cuentaDisponibles();
            int cantNoDisponibles = consultas.cuentaNoDisponibles();
            int cantTotal = consultas.cuentaDisponibilidad();
            String texto = "---Estadística de Libros---\n"
                    + "Cantidad de libros disponibles: " + cantDisponibles + "\n"
                    + "Cantidad de libros no disponibles: " + cantNoDisponibles + "\n"
                    + "Total de libros: " + cantTotal;
            JOptionPane.showMessageDialog(null, texto);
            limpiar();
        }
    }
        
        
        
        

    

    public void limpiar() {

        vista.txtNombre.setText(null);
        vista.txtAutor.setText(null);
        vista.txtDisponibilidad.setText(null);
        vista.txtfechaLanzamiento.setText(null);
        vista.txtId.setText(null);
    }

}
