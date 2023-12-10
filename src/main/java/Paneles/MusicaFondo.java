package Paneles;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/**
 * La clase MusicaFondo proporciona métodos para reproducir música de fondo en bucle continuo.
 */
public class MusicaFondo {

    /**
     * Reproduce música de fondo en bucle continuo.
     *
     * @param filepath La ruta del archivo de audio.
     * @throws UnsupportedAudioFileException Si el formato del acrhivo de audio no es compatible.
     * @throws LineUnavailableException Si no se puede acceder a la línea de audio para reproducir el sonido.
     * @throws IOException Si ocurre un error de entrada/salida durante la lectura del archivo de audio.
     */
    public static void reproducirMusicaFondo(String filepath) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        try {
            File audioFile = new File(filepath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);

            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw e;
        }
    }
}