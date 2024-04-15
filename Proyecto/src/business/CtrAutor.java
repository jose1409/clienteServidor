/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;


import presentation.soliAutor;
import domain.Autor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class CtrAutor implements ActionListener {

    private Autor modelo = new Autor();
    private consultaAutor consultas = new consultaAutor();
    private soliAutor vista = new soliAutor();
    
public CtrAutor(Autor modelo, consultaAutor consultas, soliAutor vista) {
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
        vista.setTitle("Autor");
        vista.setLocationRelativeTo(null);

    }
    
    
     @Override
    public void actionPerformed(ActionEvent e) {
        //boton de guardar
        if (e.getSource() == vista.btnGuardar) {
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setApellido(vista.txtApellido.getText());
            modelo.setTelefono(vista.txtTelefono.getText());
            modelo.setNacionalidad(vista.cmbNacionalidad.getSelectedItem().toString());

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
            modelo.setNacionalidad(vista.cmbNacionalidad.getSelectedItem().toString());
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
                vista.cmbNacionalidad.setSelectedItem (modelo.getNacionalidad());
                
                  
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
        vista.cmbNacionalidad.setSelectedIndex(0);
        vista.txtId.setText(null);
}

}
    
    
