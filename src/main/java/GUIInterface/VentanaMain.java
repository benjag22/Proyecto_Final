package GUIInterface;

import javax.swing.*;
import java.io.File;
public class VentanaMain {
    public static void main(String[] args) {
        MusicaFondo.reproducirMusicaFondo("src/main/java/resources/Fondo.wav");
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            PanelPrincipal panelPrincipal = new PanelPrincipal();
            frame.add(panelPrincipal);
            frame.setTitle("Venta de pasajes");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(1920, 1080);
            frame.setResizable(false);
            frame.setVisible(true);

        });
    }
}