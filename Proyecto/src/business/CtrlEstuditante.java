/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;


import domain.Estudiante;
import business.ConsultaEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import presentation.soliEstudiantes;
import presentation.soliLibros;
/**
 *
 * @author braym
 */
public class CtrlEstuditante implements ActionListener{
    private Estudiante modelo = new Estudiante();
    private ConsultaEstudiante consultas = new ConsultaEstudiante();
    private soliEstudiantes vista = new soliEstudiantes();

    public CtrlEstuditante (Estudiante modelo, ConsultaEstudiante consultas, soliEstudiantes vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);

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
            modelo.setApellido(vista.txtApellido.getText());
            modelo.setTelefono(vista.txtTelefono.getText());
            modelo.setCarnet(vista.txtCarnet.getText());

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
            modelo.setApellido(vista.txtApellido.getText());
            modelo.setTelefono(vista.txtTelefono.getText());
            modelo.setCarnet(vista.txtCarnet.getText());
            
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
                vista.txtApellido.setText(modelo.getApellido());
                vista.txtTelefono.setText(modelo.getTelefono());
                vista.txtCarnet.setText( modelo.getCarnet());
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún registro");
                limpiar();
            }
        }
     if(e.getSource()==vista.btnLimpiar){
            limpiar();
        }
    }
        
        
        
        

    

    public void limpiar() {

        vista.txtNombre.setText(null);
        vista.txtApellido.setText(null);
        vista.txtTelefono.setText(null);
        vista.txtCarnet.setText(null);
        vista.txtId.setText(null);
    }

}
    
    

