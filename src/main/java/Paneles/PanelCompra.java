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

public class PanelCompra extends JPanel implements MouseListener {
    private JButton ComprarAsiento;
    private BufferedImage imagen;
    private boolean botoncomprar;
    private Clip clipMouseOver;
    private Clip clipClick;
    private PanelDestinoIda panelDestinoIda;
    public PanelCompra(){
        cargarSonidos();
        panelDestinoIda = new PanelDestinoIda();
        this.setLayout(null);
        this.imagen = cargarImagen("src/main/java/Recursos/Fondo1.png");
        setPreferredSize(new Dimension(imagen.getWidth(),imagen.getHeight()));


        ComprarAsiento = new JButton("Comprar asiento");
        ComprarAsiento.addMouseListener(this);
        ComprarAsiento.setBounds(550, 300,500,200);
        ComprarAsiento.setFont(new Font("Arial",Font.PLAIN,50));
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

    private void reproducirSonido(Clip clip) {
        if (clip != null) {
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }

    public PanelDestinoIda getPanelDestinoIda() {
        return panelDestinoIda;
    }
}
