package presentation;

import javax.swing.JOptionPane;

public class Gui {

    public static void print(String tex) {
        JOptionPane.showMessageDialog(null, tex);
    }

    public static String input(String tex) {
        return JOptionPane.showInputDialog(null, tex);
    }

    public static String edit(String tex, String tex2) {
        return JOptionPane.showInputDialog(null, tex, tex2);
    }

    public static void errorMesage(String tex) {
        JOptionPane.showMessageDialog(null, tex, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
