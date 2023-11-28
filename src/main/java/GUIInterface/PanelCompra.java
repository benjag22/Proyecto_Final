package GUIInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class PanelCompra extends JPanel implements MouseListener {
    private JButton ComprarAsiento;
    private BufferedImage imagen;
    private boolean botoncomprar;
    private Clip clipMouseOver;
    private Clip clipClick;
    public PanelCompra(){
        cargarSonidos();
        this.setLayout(null);
        setPreferredSize(new Dimension(1920,1080));
        String basePath = new File("").getAbsolutePath();
        this.imagen = cargarImagen(basePath + "/src/Main/java/resources/Fondo.jpg");


        ComprarAsiento = new JButton("Comprar asiento");
        ComprarAsiento.addMouseListener(this);
        ComprarAsiento.setBounds(775, 400,200,25);
        ComprarAsiento.setFont(new Font("Arial",Font.PLAIN,20));
        add(ComprarAsiento);

        botoncomprar = true;
    }
    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagen !=null) {
                g.drawImage(imagen, 0, 0, 1920, 1080, this);
        }
    }
    public JButton getComprarAsiento() {
        return ComprarAsiento;
    }

    public Boolean getBotoncomprar() {
        return botoncomprar;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
            botoncomprar = false;
        reproducirSonido(clipClick);
        System.out.println(botoncomprar);
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
    private void cargarSonidos() {
        try {
            String basePath = new File("").getAbsolutePath();
            String audioFileMouseOverPath = basePath + "/src/Main/java/resources/Sobre.wav";
            String audioFileClickPath = basePath + "/src/Main/java/resources/ClickExpendedor.wav";

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

    private void reproducirSonido(Clip clip) {
        if (clip != null) {
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }
}
