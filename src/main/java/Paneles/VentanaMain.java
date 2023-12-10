package Paneles;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Clase principal que inicia la aplicación.
 *
 * @author Gabriel Huerta, Martín Rubilar y Benjamín González
 */

public class VentanaMain {

    /**
     * Método principal "main": Inicia la aplicación, reproduce la música de fondo
     * y muestra la interfaz gráfica principal.
     *
     * @param args Los argumentos de la línea de comandos.
     * @throws UnsupportedAudioFileException Si ocurre un problema con el archivo de audio.
     * @throws LineUnavailableException Si no se puede acceder a la línea de audio.
     * @throws IOException Si ocurre un problema de entrada/salida.
     */

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MusicaFondo.reproducirMusicaFondo("src/main/java/Recursos/Fondo.wav");
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