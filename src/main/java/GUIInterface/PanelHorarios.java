package GUIInterface;

import org.example.Bus;
import org.example.BusDosPisos;
import org.example.BusUnPiso;
import org.example.Horario;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import javax.sound.sampled.*;

public class PanelHorarios extends JPanel implements ItemListener {
    private BufferedImage imagen;
    private JLabel Seleccionar;
    private String seleccion;
    private Clip clipMouseOver;
    private Clip clipClick;
    private JComboBox horarios;
    private Bus bus1;
    private Bus bus2;
    private Bus bus3;
    private Bus bus4;
    private Bus bus5;
    private Bus bus6;
    private Bus bus7;
    private Bus bus8;


public PanelHorarios(){
    this.setLayout(null);
    setPreferredSize(new Dimension(1920,1080));
    this.imagen =cargarImagen("");
    bus1= new BusUnPiso();
    bus2= new BusUnPiso();
    bus3= new BusUnPiso();
    bus4= new BusUnPiso();

    bus5= new BusDosPisos();
    bus6= new BusDosPisos();
    bus7= new BusDosPisos();
    bus8= new BusDosPisos();

    bus1.setHorario(new Horario(LocalTime.of(9,0),LocalTime.of(10,45)));
    bus1.setOrigen_Destino("CONC/LA");
    bus2.setHorario(new Horario(LocalTime.of(11,0),LocalTime.of(12,45)));
    bus2.setOrigen_Destino("LA/CONC");
    bus3.setHorario(new Horario(LocalTime.of(13,0),LocalTime.of(14,45)));
    bus3.setOrigen_Destino("CONC/LA");
    bus4.setHorario(new Horario(LocalTime.of(15,0),LocalTime.of(16,45)));
    bus4.setOrigen_Destino("LA/CONC");
    bus5.setHorario(new Horario(LocalTime.of(17,0),LocalTime.of(18,45)));
    bus5.setOrigen_Destino("CONC/LA");
    bus6.setHorario(new Horario(LocalTime.of(19,0),LocalTime.of(20,45)));
    bus6.setOrigen_Destino("LA/CONC");
    bus7.setHorario(new Horario(LocalTime.of(21,0),LocalTime.of(22,45)));
    bus7.setOrigen_Destino("CONC/LA");
    bus8.setHorario(new Horario(LocalTime.of(23,0),LocalTime.of(0,45)));
    bus8.setOrigen_Destino("LA/CONC");



    Font font = new Font("Arial",Font.PLAIN,30);
    Seleccionar = new JLabel("Seleccionar Horario");
    Seleccionar.setFont(font);
    Seleccionar.setBounds(400,150,1000,50);
    Seleccionar.setForeground(Color.BLACK);
    add(Seleccionar);

    horarios = new JComboBox();
    horarios.addItemListener(this);
    horarios.addItem("Eliga su horario");
    horarios.addItem(bus1.getHorario());
    horarios.addItem(bus2.getHorario());
    horarios.addItem(bus3.getHorario());
    horarios.addItem(bus4.getHorario());
    horarios.addItem(bus5.getHorario());
    horarios.addItem(bus6.getHorario());
    horarios.addItem(bus7.getHorario());
    horarios.addItem(bus8.getHorario());

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

    public Bus getBus1() {
        return bus1;
    }

    public Bus getBus2() {
        return bus2;
    }

    public Bus getBus3() {
        return bus3;
    }

    public Bus getBus4() {
        return bus4;
    }

    public Bus getBus5() {
        return bus5;
    }

    public Bus getBus6() {
        return bus6;
    }

    public Bus getBus7() {
        return bus7;
    }

    public Bus getBus8() {
        return bus8;
    }
}
