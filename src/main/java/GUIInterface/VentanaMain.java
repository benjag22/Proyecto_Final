package GUIInterface;

import javax.swing.*;
import java.io.File;

public class VentanaMain extends JFrame {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        frame.add(panelPrincipal);
        frame.setTitle("Venta de pasajes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        String basePath = new File("").getAbsolutePath();
        MusicaFondo.reproducirMusicaFondo(basePath + "/src/Main/java/resources/Fondo.wav");
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