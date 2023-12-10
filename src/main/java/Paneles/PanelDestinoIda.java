package Paneles;

import ClasesLogicas.Ciudades;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelDestinoIda extends JPanel implements ItemListener {
    private BufferedImage imagen;
    private JLabel Seleccionar;
    private String seleccion_origen;
    private String seleccion_destino;
    private JTextField Fecha;
    private Clip clipMouseOver;
    private Clip clipClick;
    private JComboBox Origen;
    private JComboBox Destino;
    private String Org;
    private String Dest;
    public PanelDestinoIda(){
        cargarSonidos();
        this.setLayout(null);
        setPreferredSize(new Dimension(1920,1080));
        String basePath = new File("").getAbsolutePath();
        this.imagen = cargarImagen(basePath + "/src/Main/java/Recursos/Fondo2.png");

        Font font = new Font("Mongolian Baiti",Font.PLAIN,30);
        Seleccionar = new JLabel("Seleccionar Horario");
        Seleccionar.setFont(font);
        Seleccionar.setBounds(650,150,1000,50);
        Seleccionar.setForeground(Color.BLACK);
        add(Seleccionar);

        Origen = new JComboBox();
        Origen.addItemListener(this);
        Org = "Elija su Origen";
        Origen.addItem(Org);
        for (Ciudades ciudad : Ciudades.values()) {
            Origen.addItem(ciudad.getNombre());
        }

        Origen.setBounds(430,300,300,50);
        add(Origen);

        Destino = new JComboBox();
        Destino.addItemListener(this);
        Dest = "Elija su Destino";
        Destino.addItem(Dest);
        for (Ciudades ciudad : Ciudades.values()) {
            Destino.addItem(ciudad.getNombre());
        }
        Destino.setBounds(830,300,300,50);
        add(Destino);

        Fecha = new JTextField("dd-mm-yyyy");
        Fecha.setFont(font);
        Fecha.setBounds(670,450,250,50);
        add(Fecha);
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
    }
    public boolean aceptar(){
        return !seleccion_origen.equals(seleccion_destino);
    }

    public String getSeleccion_origen() {
        return seleccion_origen;
    }

    public String getSeleccion_destino() {
        return seleccion_destino;
    }

    private void cargarSonidos() {
        try {
            String audioFileMouseOverPath = "src/main/java/Recursos/Sobre.wav";
            String audioFileClickPath = "src/main/java/Recursos/Click.wav";

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
    public JTextField getFecha() {
        return Fecha;
    }
    public JComboBox getOrigenComboBox() {
        return Origen;
    }
    public JComboBox getDestinoComboBox() {
        return Destino;
    }

    public String getOrg() {
        return Org;
    }

    public String getDest() {
        return Dest;
    }
}
