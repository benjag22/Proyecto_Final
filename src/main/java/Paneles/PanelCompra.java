package Paneles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/**
 * Panel que da inicio y bienvenida al programa.
 */

public class PanelCompra extends JPanel implements MouseListener {
    private JButton ComprarAsiento;
    private BufferedImage imagen;
    private Clip clipMouseOver;
    private Clip clipClick;
    private PanelDestinoIda panelDestinoIda;

    /**
     * Constructor de la clase PanelCompra.
     */

    public PanelCompra(){
        cargarSonidos();
        panelDestinoIda = new PanelDestinoIda();
        this.setLayout(null);
        this.imagen = cargarImagen("src/main/java/Recursos/Fondo1.png");
        setPreferredSize(new Dimension(imagen.getWidth(),imagen.getHeight()));


        ComprarAsiento = new JButton("Comprar asiento");
        ComprarAsiento.addMouseListener(this);
        ComprarAsiento.setBounds(550, 300,500,200);
        ComprarAsiento.setFont(new Font("Mongolian Baiti",Font.PLAIN,50));
        add(ComprarAsiento);

    }

    /**
     * cargarImagen: Carga una imagen.
     * @param ruta Ruta del archivo.
     * @return La imagen cargada.
     */

    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * paintComponent: Sobrescribe el método paintComponent de JPanel para personalizar la apariencia del panel.
     * @param g El contexto gráfico en el que se va a pintar.
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagen !=null) {
                g.drawImage(imagen, 0, 0, 1920, 1080, this);
        }
    }

    /**
     * getComprarAsiento: Obtiene el botón de compra.
     * @return El botón de compra.
     */

    public JButton getComprarAsiento() {
        return ComprarAsiento;
    }

    /**
     * mouseClicked: Maneja el evento de clic del mouse.
     * @param e Evento de mouse.
     */

    @Override
    public void mouseClicked(MouseEvent e) {
        reproducirSonido(clipClick);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        reproducirSonido(clipMouseOver);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * cargarSonidos: Carga los sonidos utilizados para los eventos del mouse.
     */

    private void cargarSonidos() {
        try {
            String audioFileMouseOverPath = "src/main/java/Recursos/Sobre.wav";
            String audioFileClickPath ="src/main/java/Recursos/Click.wav";

            AudioInputStream audioStreamMouseOver = AudioSystem.getAudioInputStream(new File(audioFileMouseOverPath));
            clipMouseOver = AudioSystem.getClip();
            clipMouseOver.open(audioStreamMouseOver);

            AudioInputStream audioStreamClick = AudioSystem.getAudioInputStream(new File(audioFileClickPath));
            clipClick = AudioSystem.getClip();
            clipClick.open(audioStreamClick);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * reproducirSonido: Reproduce un sonido específico.
     * @param clip Clip a reproducir.
     */

    private void reproducirSonido(Clip clip) {
        if (clip != null) {
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }

    /**
     * getPanelDestinoIda: Obtiene el panel de destino ida asociado.
     * @return El panel de destino ida.
     */

    public PanelDestinoIda getPanelDestinoIda() {
        return panelDestinoIda;
    }
}
