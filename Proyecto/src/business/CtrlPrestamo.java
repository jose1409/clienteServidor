package business;

import data.Listas;
import data.Crud;
import presentation.soliPrestamo;
import domain.Prestamo;
import domain.Estudiante;
import domain.Libro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.time.format.*;
import java.time.LocalDate;

public class CtrlPrestamo implements ActionListener {

    private Prestamo modelo = new Prestamo();
    private ConsultasPrestamo consultas = new ConsultasPrestamo();
    private soliPrestamo vista = new soliPrestamo();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private ConsultasLibros consultasLibros = new ConsultasLibros();
    private Crud crud = new Crud();

    public CtrlPrestamo(Prestamo modelo, ConsultasPrestamo consultas, soliPrestamo vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEstadistica.addActionListener(this);
        this.vista.btnVerLibros.addActionListener(this);
        this.consultasLibros = consultasLibros;
        this.crud = crud;
        this.vista.btnVerEstudiantes.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Préstamos");
        vista.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //boton de guardar
        if (e.getSource() == vista.btnGuardar) {
            LocalDate fecha = LocalDate.parse(vista.txtFechaRegistro.getText(), formatter);
            modelo.setFechaRegistro(fecha);
            modelo.setEstado(Boolean.parseBoolean(vista.txtEstado.getText()));
            //estudiante
            Estudiante estudiante = new Estudiante();
            estudiante.setId(Integer.parseInt(vista.txtEstudiante.getText()));
            modelo.setId_estudiante(estudiante);
            //libro
            Libro libro = new Libro();
            libro.setId(Integer.parseInt(vista.txtLibro.getText()));
            modelo.setId_libro(libro);
            if (consultas.registrar(modelo)) {
                int ultimoId = consultas.ultimoId();
                modelo.setId(ultimoId);
                modelo.setCodigo("P-" + ultimoId);
                consultas.actualizarCodigo(modelo);
                JOptionPane.showMessageDialog(null, "¡Préstamo de libro guardado!");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al guardar!");
                limpiar();
            }
        }

        //boton de modificar
        if (e.getSource() == vista.btnModificar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            modelo.setCodigo(vista.txtCodigo.getText());
            LocalDate fecha = LocalDate.parse(vista.txtFechaRegistro.getText(), formatter);
            modelo.setFechaRegistro(fecha);
            modelo.setEstado(Boolean.parseBoolean(vista.txtEstado.getText()));
            //estudiante
            Estudiante estudiante = new Estudiante();
            estudiante.setId(Integer.parseInt(vista.txtEstudiante.getText()));
            modelo.setId_estudiante(estudiante);
            //libro
            Libro libro = new Libro();
            libro.setId(Integer.parseInt(vista.txtLibro.getText()));
            modelo.setId_libro(libro);
            if (consultas.modificar(modelo)) {
                JOptionPane.showMessageDialog(null, "¡Préstamo modificado!");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al modificar!");
                limpiar();
            }
        }
        if (e.getSource() == vista.btnEliminar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "¡Préstamo eliminado!");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar!");
                limpiar();
            }
        }

        //Buscar
        if (e.getSource() == vista.btnBuscar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            if (consultas.buscar(modelo)) {
                vista.txtId.setText(String.valueOf(modelo.getId()));
                vista.txtCodigo.setText(modelo.getCodigo());
                vista.txtFechaRegistro.setText(modelo.getFechaRegistro().format(formatter));
                vista.txtEstado.setText(String.valueOf(modelo.isEstado()));
                vista.txtEstudiante.setText(modelo.getId_estudiante().getCarnet());
                vista.txtLibro.setText(modelo.getId_libro().getNombre());

            } else {
                JOptionPane.showMessageDialog(null, "¡No se encontró ningún préstamo!");
                limpiar();
            }
        }
        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }

        //Boton de estadistica
        if (e.getSource() == vista.btnEstadistica) {
            int cantActivos = consultas.cuentaActivos();
            int cantInactivos = consultas.cuentaInactivos();
            int cantTotal = consultas.cuentaPrestamo();
            String texto = "---Estadística de Préstamos---\n"
                    + "Cantidad de préstamos activos: " + cantActivos + "\n"
                    + "Cantidad de préstamos inactivos: " + cantInactivos + "\n"
                    + "Total de préstamos: " + cantTotal;
            JOptionPane.showMessageDialog(null, texto);
            limpiar();
        }

        // boton Ver libros
        if (e.getSource() == vista.btnVerLibros) {
            consultasLibros.obtenerLibros();
            mostrarLibros();
        }

        // boton Ver Estudiantes
        if (e.getSource() == vista.btnVerEstudiantes) {
            crud.obtenerEstudiantes();
            crud.mostrarEstudiantes();
        }

    }

    //metodo de limpiar
    public void limpiar() {
        vista.txtId.setText(null);
        vista.txtCodigo.setText(null);
        vista.txtFechaRegistro.setText(null);
        vista.txtEstado.setText(null);
        vista.txtEstudiante.setText(null);
        vista.txtLibro.setText(null);
    }

    //metodo mostrar libros
    private void mostrarLibros() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Libros:\n");
        for (Libro libro : Listas.libro) {
            if (libro.getDisponibilidad()) {
                sb.append("Id: ").append(libro.getId())
                        .append(", Nombre: ").append(libro.getNombre())
                        .append(", Autor: ").append(libro.getAutor())
                        .append(", Fecha de lanzamiento: ").append(libro.getFechaLanzamiento())
                        .append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

}
