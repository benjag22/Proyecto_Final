package GUIInterface;

import org.example.Ciudades;
import org.example.VistaHorario;
import org.example.VistaListaHorarios;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelDestinoIda extends JPanel implements ItemListener {
    private BufferedImage imagen;
    private JLabel Seleccionar;
    private String seleccion_origen;
    private String seleccion_destino;
    private JTextField Fecha;
    private JLabel Introducir;
    private Clip clipMouseOver;
    private Clip clipClick;
    private JComboBox Origen;
    private JComboBox Destino;
    private PanelHorarios panelHorarios;
    private ArrayList<VistaHorario> lista;
    public PanelDestinoIda(){
        cargarSonidos();
        panelHorarios = new PanelHorarios();
        this.setLayout(null);
        setPreferredSize(new Dimension(1920,1080));
        String basePath = new File("").getAbsolutePath();
        this.imagen = cargarImagen(basePath + "/src/Main/java/resources/Fondo.jpg");

        Font font = new Font("Arial",Font.PLAIN,30);
        Seleccionar = new JLabel("Seleccionar Horario");
        Seleccionar.setFont(font);
        Seleccionar.setBounds(650,150,1000,50);
        Seleccionar.setForeground(Color.BLACK);
        add(Seleccionar);

        Origen = new JComboBox();
        Origen.addItemListener(this);
        Origen.addItem("Elija su Origen");
        for (Ciudades ciudad : Ciudades.values()) {
            Origen.addItem(ciudad.getNombre());
        }

        Origen.setBounds(430,300,300,50);
        add(Origen);

        Destino = new JComboBox();
        Destino.addItemListener(this);
        Destino.addItem("Elija su Destino");
        for (Ciudades ciudad : Ciudades.values()) {
            Destino.addItem(ciudad.getNombre());
        }

        Destino.setBounds(830,300,300,50);
        add(Destino);

        Fecha = new JTextField("Fecha");
        Fecha.setFont(font);
        Fecha.setBounds(670,450,250,50);
        add(Fecha);
        lista = panelHorarios.getListaHorariosdepanel().getListaHorarios();
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == Origen) {
            seleccion_origen = Origen.getSelectedItem().toString();
        } else if (e.getSource() == Destino) {
            seleccion_destino = Destino.getSelectedItem().toString();
        }
        for(int i=0;i<panelHorarios.getListaHorariosdepanel().getListaHorarios().size();i++){
            panelHorarios.getListaHorariosdepanel().getListaHorarios().get(i).setDestino(seleccion_destino);
            panelHorarios.getListaHorariosdepanel().getListaHorarios().get(i).setOrigen(seleccion_origen);
        }
    }
    public boolean aceptar(){
        if(!seleccion_origen.equals(seleccion_destino)){
            return true;
        }
        else{
            return false;
        }
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

    public String getSeleccion_origen() {
        return seleccion_origen;
    }

    public String getSeleccion_destino() {
        return seleccion_destino;
    }
    public JTextField getFecha() {
        return Fecha;
    }

    public PanelHorarios getPanelHorarios() {
        return panelHorarios;
    }
}
