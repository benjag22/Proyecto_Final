package GUIInterface;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class PanelPrincipal extends JPanel implements MouseListener {

    private PanelCompra compra;
    private Clip clipMouseOver;
    private Clip clipClick;
    private PanelHorarios horarios;
    private PanelDestinoIda destinoIda;

    public PanelPrincipal(){
        this.addMouseListener(this);
        compra = new PanelCompra();
        compra.setVisible(true);
        cargarSonidos();

        destinoIda = compra.getPanelDestinoIda();
        destinoIda.setVisible(false);

        horarios = destinoIda.getPanelHorarios();
        horarios.setVisible(false);
        ActionListener horaselec = e -> {
            if(destinoIda.aceptar()) {
                destinoIda.setVisible(false);
                horarios.setVisible(true);
            }
            else{
                System.out.println("No se puede viajar desde tu ciudad a tu misma ciudad tontito");
            }
        };
        destinoIda.getFecha().addActionListener(horaselec);

        compra.getComprarAsiento().addMouseListener(this);

        setPreferredSize(new Dimension(1920,1080));
        add(compra);
        add(destinoIda);
        add(horarios);

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        destinoIda.setLocation(0,0);
        compra.setLocation(0,0);
        horarios.setLocation(0,0);

        if(compra.isVisible()){
            compra.paintComponent(g);
        }

        else if(destinoIda.isVisible()){
            destinoIda.paintComponent(g);
        }

        else if(horarios.isVisible()){
            horarios.paintComponent(g);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent()==compra.getComprarAsiento()){
            compra.setVisible(false);
            destinoIda.setVisible(true);
            revalidate();
            repaint();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
/*
    public static void main (String[] args){
        MusicaFondo.reproducirMusicaFondo("main/java/resources/Fondo.wav");
        JFrame frame = new JFrame();
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        frame.add(panelPrincipal);
        frame.setTitle("Venta de pasajes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1500,1020);
        frame.setVisible(true);
    }

 */
    private void cargarSonidos() {
        try {
            String audioFileMouseOverPath = "src/main/java/resources/Sobre.wav";
            String audioFileClickPath = "src/main/java/resources/Click.wav";

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
