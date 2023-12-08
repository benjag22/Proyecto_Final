package GUIInterface;

import org.example.VistaListaHorarios;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import  java.util.Random;

public class PanelHorarios extends JPanel {
    private BufferedImage imagen;
    private JLabel Seleccionar;
    private Clip clipMouseOver;
    private Clip clipClick;
    private VistaListaHorarios listaHorarios;
    private PanelEleccionAsientos panelEleccion;
    private ArrayList<JButton> listaBotonesAsociado;

public PanelHorarios(){
    cargarSonidos();
    this.setLayout(null);
    setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    Random random = new Random();
    this.imagen = cargarImagen("src/main/java/resources/Fondo3.png");
    Font font = new Font("Arial",Font.PLAIN,30);

    Seleccionar = new JLabel("Seleccionar Horario");
    Seleccionar.setFont(font);
    Seleccionar.setBounds(650,120,1000,50);
    Seleccionar.setForeground(Color.BLACK);
    add(Seleccionar);
    int cantidad=random.nextInt(1,15);
    listaHorarios = new VistaListaHorarios(cantidad);
    listaBotonesAsociado = new ArrayList<>(cantidad);
    JScrollPane scrollPane = new JScrollPane(listaHorarios);
    scrollPane.setBounds(260,200,1000,480);
    add(scrollPane);
int index=0;
    JButton boton;
    for(int i=0;i<cantidad;i++) {
        panelEleccion = new PanelEleccionAsientos(random.nextInt(0,5), listaHorarios.getListaHorarios().get(i).getHorario(), listaHorarios.getListaHorarios().get(i).getOrigen(), listaHorarios.getListaHorarios().get(i).getDestino());
        boton = listaHorarios.getListaHorarios().get(index++).getBotonCompra();
        listaBotonesAsociado.add(boton);
    }
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(imagen != null){
            g.drawImage(imagen, 0, 0, 1920, 1080, this);
        }
    }
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

    public VistaListaHorarios getListaHorariosdepanel() {
        return listaHorarios;
    }
public ArrayList<JButton> getListaBotonesAsociado(){
    return listaBotonesAsociado;
}

    public PanelEleccionAsientos getPanelEleccion() {
        return panelEleccion;
    }
}
