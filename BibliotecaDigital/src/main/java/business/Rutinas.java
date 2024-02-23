/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import javax.swing.JOptionPane;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author braym
 */
public class Rutinas {
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Implementar exepciones en busqueda de materiales
    
     public void Exepciones() {
    int total = 0, n1 = 0, n2 = 0;
    boolean esNum = false;

    while (!esNum) {
        try {
            n1 = Integer.parseInt(
                JOptionPane.showInputDialog("Digite un valor: "));
            n2 = Integer.parseInt(
                JOptionPane.showInputDialog("Digite otro valor: "));
            esNum=true; //si no lanza ninguna excepcion, hace que sea verdadero
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No se permiten letras",
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, palabra reservada",
                "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        } finally {
            total = n1 + n2;
        }
    }
    JOptionPane.showMessageDialog(null, "La sumatoria es: " + total);
    
    
    
}
     
     //Lectura y escritura de archivos (Guardar Informacion de usuarios y materiales bajo su nombre
     
     private static String cedula, nombre, email, telefono;

    private static int edad;

    public static boolean camposRequeridosIncompletos() {

        if ((cedula.equals(""))
                || (nombre.equals(""))
                || (email.equals(""))
                || (telefono.equals(""))
                || (edad == 0)) {

            return true;

        } else {

            return false;

        }

    }

    public static void agregar() {

        try {

            //creamos el archivo y entrada de datos
            DataOutputStream archivo = new DataOutputStream(new FileOutputStream("cliente.txt", true));

            //solicitamos los datos del usuario
            cedula = JOptionPane.showInputDialog("Digite su cedula: ");

            nombre = JOptionPane.showInputDialog("Digite su nombre: ");

            email = JOptionPane.showInputDialog("Digite su email: ");

            telefono = JOptionPane.showInputDialog("Digite su telefono: ");

            edad = Integer.parseInt(JOptionPane.showInputDialog("Digite su edad: "));

            //validamos que el usuario digitó toda la información
            if (camposRequeridosIncompletos()) {

                //si nos faltó ingresar algún dato, lazamos el error y esto lo captura el catch
                throw new Exception("Alguno de los campos requeridos no fueron completados");

            } else {

                //si los datos estan correctos escribimos en el archivo
                archivo.writeUTF(cedula);

                archivo.writeUTF(nombre);

                archivo.writeUTF(email);

                archivo.writeUTF(telefono);

                archivo.writeInt(edad);

                //notificamos al usuario que se guardaron los datos correctamente
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Agregar Datos",
                        JOptionPane.OK_OPTION);

                //debemos cerrar el archivo una vez que dejamos de usuarlo
                archivo.close();

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al agregar" + e.getMessage(), "Error al agregar datos",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void intercambiar() throws IOException {

        String ced, nom, correo, tel;

        int ed;

        try {

            DataInputStream archivoLectura = new DataInputStream(new FileInputStream("temporal.txt"));

            DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("cliente.txt"));

            try {

                while (true) {

                    ced = archivoLectura.readUTF();

                    nom = archivoLectura.readUTF();

                    correo = archivoLectura.readUTF();

                    tel = archivoLectura.readUTF();

                    ed = archivoLectura.readInt();

                    archivoEscritura.writeUTF(ced);

                    archivoEscritura.writeUTF(nom);

                    archivoEscritura.writeUTF(correo);

                    archivoEscritura.writeUTF(tel);

                    archivoEscritura.writeInt(ed);

                }

            } catch (EOFException e) {

                archivoEscritura.close();

                archivoLectura.close();

            }

        } catch (FileNotFoundException e) {

            JOptionPane.showMessageDialog(null, "Error al localizar el archivo" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Error los datos tiene error de lectura o escritura"
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void modificar() {

        String cedBuscar, ced, nom, correo, tel;

        int ed;

        cedBuscar = JOptionPane.showInputDialog("Digite la cédula de la persona a modificar: ");

        try {

            //todo lo que debe salir bien, va en este try
            //definimos el archivo que queremos leer
            DataInputStream archivoLectura = new DataInputStream(new FileInputStream("cliente.txt"));

            //creamos un arch temp, para almacenar los cambio del usuario 
            //y estos se registran en el arch original
            DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("temporal.txt"));

            //creamos el try adicional para buscar y recolectar la nueva info y modificar el original
            try {

                while (true) {

                    //descargamos el contenido del arch
                    ced = archivoLectura.readUTF();

                    nom = archivoLectura.readUTF();

                    correo = archivoLectura.readUTF();

                    tel = archivoLectura.readUTF();

                    ed = archivoLectura.readInt();

                    //si la cedula existe vamos a modificar el dato
                    if (cedBuscar.equals(ced)) {

                        //solictamos los nuevos datos del usuario
                        ced = JOptionPane.showInputDialog("Digite la nueva cedula: ");

                        nom = JOptionPane.showInputDialog("Digite el nuevo nombre: ");

                        correo = JOptionPane.showInputDialog("Digite el nuevo email: ");

                        tel = JOptionPane.showInputDialog("Digite el nuevo telefono: ");

                        ed = Integer.parseInt(JOptionPane.showInputDialog("Digite la nueva edad: "));

                    }

                    archivoEscritura.writeUTF(ced);

                    archivoEscritura.writeUTF(nom);

                    archivoEscritura.writeUTF(correo);

                    archivoEscritura.writeUTF(tel);

                    archivoEscritura.writeInt(ed);

                }

            } catch (EOFException e) {

                archivoEscritura.close();

                archivoLectura.close();

                intercambiar();

            }

        } catch (FileNotFoundException e) {

            JOptionPane.showMessageDialog(null, "Error al localizar el archivo" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Error los datos tiene error de lectura o escritura"
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void buscar() {

        String nomBuscar, ced, nom, correo, tel;

        int ed;

        boolean proximo = true;

        nomBuscar = JOptionPane.showInputDialog("Digite el nombre de la  persona a buscar: ");

        try {

            DataInputStream archivoLectura = new DataInputStream(new FileInputStream("cliente.txt"));

            try {

                while (proximo) {

                    ced = archivoLectura.readUTF();

                    nom = archivoLectura.readUTF();

                    correo = archivoLectura.readUTF();

                    tel = archivoLectura.readUTF();

                    ed = archivoLectura.readInt();

                    if (nomBuscar.equals(nom)) {

                        JOptionPane.showMessageDialog(null, "Se encontro a la persona: " + nom
                                + " , cuya cédula es " + ced + " , su correo es " + correo
                                + " , tiene " + ed + " años y su telefono es " + tel + ".");

                        proximo = false;

                    }

                }

            } catch (EOFException e) {

                archivoLectura.close();

            }

        } catch (FileNotFoundException e) {

            JOptionPane.showMessageDialog(null, "Error al localizar el archivo" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Error los datos tiene error de lectura o escritura"
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void eliminar() {

        String cedBuscar, ced, nom, correo, tel;

        int ed;

        cedBuscar = JOptionPane.showInputDialog("Digite la cédula de la persona a eliminar: ");

        try {

            DataInputStream archivoLectura = new DataInputStream(new FileInputStream("cliente.txt"));

            DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("temporal.txt"));

            try {

                while (true) {

                    ced = archivoLectura.readUTF();

                    nom = archivoLectura.readUTF();

                    correo = archivoLectura.readUTF();

                    tel = archivoLectura.readUTF();

                    ed = archivoLectura.readInt();

                    if (!cedBuscar.equalsIgnoreCase(ced)) {//buscarmos la cedula que digito el usuario

                        //si la cedula no es la que estamos buscando mantenemos los datos en el archivo
                        archivoEscritura.writeUTF(ced);

                        archivoEscritura.writeUTF(nom);

                        archivoEscritura.writeUTF(correo);

                        archivoEscritura.writeUTF(tel);

                        archivoEscritura.writeInt(ed);

                    }

                }

            } catch (EOFException e) {

                archivoEscritura.close();

                archivoLectura.close();

            }

        } catch (FileNotFoundException e) {

            JOptionPane.showMessageDialog(null, "Error al localizar el archivo" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Error los datos tiene error de lectura o escritura"
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

}

     
     
     
     

