package GUIInterface;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
/**
 * Implementación Música Fondo que sonará en todo momento.
 * */
public class MusicaFondo {


    /**
     * Método comprarProducto: reproducirMusicaFondo Carga el archivo y lo reproduce en LOOP
     * continuamente mientras el programa se está ejecutando.
     **/
    public static void reproducirMusicaFondo(String filepath) {
        try {
            File audioFile = new File(filepath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);

            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}