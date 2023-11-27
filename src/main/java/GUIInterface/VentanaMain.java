package GUIInterface;

import GUIInterface.PanelPrincipal;

import javax.swing.*;

public class VentanaMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            PanelPrincipal panelPrincipal = new PanelPrincipal();
            frame.add(panelPrincipal);
            frame.setTitle("Venta de pasajes");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(1500, 1020);
            frame.setVisible(true);
        });
    }
}