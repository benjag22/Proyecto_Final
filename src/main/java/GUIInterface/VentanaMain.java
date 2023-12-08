package GUIInterface;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author Gabriel Huerta, Martin Rubilar y Benjmaín González
 *
 */

public class VentanaMain {
    public static void main(String[] args) {
        MusicaFondo.reproducirMusicaFondo("src/main/java/resources/Fondo.wav");
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setSize(new Dimension(1920,1080));
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            PanelPrincipal panelPrincipal = new PanelPrincipal();
            frame.add(panelPrincipal);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }
}