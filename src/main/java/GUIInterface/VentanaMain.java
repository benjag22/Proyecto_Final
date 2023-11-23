package GUIInterface;

import javax.swing.*;

public class VentanaMain extends JFrame {
    public static void main (String[] args){
        JFrame frame = new JFrame();
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        frame.setTitle("Venta de pasajes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
}
