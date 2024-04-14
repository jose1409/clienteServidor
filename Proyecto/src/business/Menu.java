/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package business;

import CrudLibros.ConsultasLibros;
import CrudLibros.CtrlLibros;
import CrudLibros.Libro;
import CrudLibros.soliLibros;
import javax.swing.JOptionPane;
import presentation.*;
/**
 *
 * @author Usuario
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mitOpciones = new javax.swing.JMenu();
        mitLibros = new javax.swing.JMenuItem();
        mitPrestamo = new javax.swing.JMenuItem();
        mitAutores = new javax.swing.JMenuItem();
        mitEstudiantes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mitSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Proyecto");
        setBackground(new java.awt.Color(153, 255, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusableWindowState(false);
        setForeground(new java.awt.Color(102, 255, 0));
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/library_1233814.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setBackground(new java.awt.Color(255, 255, 153));
        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fidelitas");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 38)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Biblioteca");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel3.setOpaque(true);

        mitOpciones.setText("Opciones");
        mitOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/books_12958774.png"))); // NOI18N
        mitLibros.setText("Libros");
        mitLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitLibrosActionPerformed(evt);
            }
        });
        mitOpciones.add(mitLibros);

        mitPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/payment_3532267.png"))); // NOI18N
        mitPrestamo.setText("Prestamo");
        mitPrestamo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitPrestamoActionPerformed(evt);
            }
        });
        mitOpciones.add(mitPrestamo);

        mitAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/literature_6409763.png"))); // NOI18N
        mitAutores.setText("Autores");
        mitAutores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAutoresActionPerformed(evt);
            }
        });
        mitOpciones.add(mitAutores);

        mitEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reader_10985366.png"))); // NOI18N
        mitEstudiantes.setText("Estudiantes");
        mitEstudiantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitEstudiantesActionPerformed(evt);
            }
        });
        mitOpciones.add(mitEstudiantes);

        jMenuBar1.add(mitOpciones);

        jMenu2.setText("Salida");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit_1286853.png"))); // NOI18N
        mitSalir.setText("Salir");
        mitSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitSalirActionPerformed(evt);
            }
        });
        jMenu2.add(mitSalir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAutoresActionPerformed
        //Pestaña de ingreso de clientes
        new soliAutor();
        setVisible(false);
    }//GEN-LAST:event_mitAutoresActionPerformed

    private void mitLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitLibrosActionPerformed
        // TODO add your handling code here:
        
        //new soliLibros();
        //(false);
        
         Libro mod = new Libro();
        ConsultasLibros modC= new ConsultasLibros();
        soliLibros frm = new soliLibros();
        
        
        CtrlLibros ctrl = new CtrlLibros(mod,modC,frm);
        ctrl.iniciar();
        frm.setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_mitLibrosActionPerformed

    private void mitPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mitPrestamoActionPerformed

    private void mitEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitEstudiantesActionPerformed
        new soliEstudiantes();
        setVisible(false);
    }//GEN-LAST:event_mitEstudiantesActionPerformed

    private void mitSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSalirActionPerformed
        int opcion = JOptionPane.showOptionDialog(null, "¿Desea salir?", "Salir",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[]{"Salir", "Cancelar"}, "Salir");

        if (opcion == JOptionPane.YES_OPTION) {
            // Si el usuario elige "Salir"
            System.out.println("Saliendo...");
            System.exit(0);
        } else {
            // Si elige "Cancelar" o cierra el diálogo
            System.out.println("Operacion cancelada.");
            setVisible(true);
        }
    }//GEN-LAST:event_mitSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mitAutores;
    private javax.swing.JMenuItem mitEstudiantes;
    private javax.swing.JMenuItem mitLibros;
    private javax.swing.JMenu mitOpciones;
    private javax.swing.JMenuItem mitPrestamo;
    private javax.swing.JMenuItem mitSalir;
    // End of variables declaration//GEN-END:variables
}
