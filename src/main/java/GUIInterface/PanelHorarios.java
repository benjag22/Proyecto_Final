package GUIInterface;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class PanelHorarios extends JPanel implements ItemListener {
    private BufferedImage imagen;
    private JLabel Seleccionar;
    private String seleccion;
    private Clip clipMouseOver;
    private Clip clipClick;
    private JComboBox horarios;

public PanelHorarios(){
    cargarSonidos();
    this.setLayout(null);
    setPreferredSize(new Dimension(1920,1080));
    this.imagen =cargarImagen("");

    Font font = new Font("Arial",Font.PLAIN,30);
    Seleccionar = new JLabel("Seleccionar Horario");
    Seleccionar.setFont(font);
    Seleccionar.setBounds(400,150,1000,50);
    Seleccionar.setForeground(Color.BLACK);
    add(Seleccionar);

    horarios = new JComboBox();
    horarios.addItemListener(this);
    horarios.addItem("Elija su horario");
    horarios.addItem("10:00");
    horarios.addItem("11:00");
    horarios.addItem("12:00");
    horarios.addItem("13:00");
    horarios.addItem("14:00");
    horarios.addItem("15:00");
    horarios.addItem("16:00");
    horarios.addItem("17:00");

    horarios.setBounds(400,300,300,50);
    add(horarios);
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
        if(e.getSource() == horarios){
            seleccion = horarios.getSelectedItem().toString();
            System.out.println(seleccion);
        }
    }
    private void cargarSonidos() {
        try {
            File audioFileMouseOver = new File("recursos/Sobre.wav");
            AudioInputStream audioStreamMouseOver = AudioSystem.getAudioInputStream(audioFileMouseOver);
            clipMouseOver = AudioSystem.getClip();
            clipMouseOver.open(audioStreamMouseOver);

            File audioFileClick = new File("recursos/ClickExpendedor.wav");
            AudioInputStream audioStreamClick = AudioSystem.getAudioInputStream(audioFileClick);
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
