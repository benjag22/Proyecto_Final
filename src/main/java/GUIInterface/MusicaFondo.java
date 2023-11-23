package GUIInterface;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
public class MusicaFondo {
    public static void main(String[] args) {
        reproducirMusicaFondo("main/java/resources/Fondo.wav");
    }

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