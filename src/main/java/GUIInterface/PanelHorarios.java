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
import java.util.ArrayList;
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
    private Bus bus9;
    private Bus bus10;
    private Bus bus11;
    private Bus bus12;
    private Bus bus13;
    private Bus bus14;
    private Bus bus15;
    private Bus bus16;
    private Bus bus17;
    private Bus bus18;
    private Bus bus19;
    private Bus bus20;
    private Bus bus21;
    private Bus bus22;
    private Bus bus23;
    private Bus bus24;
    private ArrayList<Bus> busArrayList;


public PanelHorarios(){
    cargarSonidos();
    this.setLayout(null);
    setPreferredSize(new Dimension(1920,1080));
    this.imagen =cargarImagen("");
    busArrayList = new ArrayList<>();
    bus1= new BusUnPiso();
    bus2= new BusUnPiso();
    bus3= new BusUnPiso();
    bus4= new BusUnPiso();
    bus5= new BusUnPiso();
    bus6= new BusUnPiso();
    bus7= new BusUnPiso();
    bus8= new BusUnPiso();
    bus9= new BusUnPiso();
    bus10= new BusUnPiso();
    bus11= new BusUnPiso();
    bus12= new BusUnPiso();

    bus13 = new BusDosPisos();
    bus14 = new BusDosPisos();
    bus15 = new BusDosPisos();
    bus16 = new BusDosPisos();
    bus17 = new BusDosPisos();
    bus18 = new BusDosPisos();
    bus19 = new BusDosPisos();
    bus20 = new BusDosPisos();
    bus21 = new BusDosPisos();
    bus22 = new BusDosPisos();
    bus23 = new BusDosPisos();
    bus24 = new BusDosPisos();



    busArrayList.add(bus1);
    busArrayList.add(bus2);
    busArrayList.add(bus3);
    busArrayList.add(bus4);
    busArrayList.add(bus5);
    busArrayList.add(bus6);
    busArrayList.add(bus7);
    busArrayList.add(bus8);
    busArrayList.add(bus9);
    busArrayList.add(bus10);
    busArrayList.add(bus11);
    busArrayList.add(bus12);
    busArrayList.add(bus13);
    busArrayList.add(bus14);
    busArrayList.add(bus15);
    busArrayList.add(bus16);
    busArrayList.add(bus17);
    busArrayList.add(bus18);
    busArrayList.add(bus19);
    busArrayList.add(bus20);
    busArrayList.add(bus21);
    busArrayList.add(bus22);
    busArrayList.add(bus23);
    busArrayList.add(bus24);



    bus1.setHorario(new Horario(LocalTime.of(9,0),LocalTime.of(10,45)));
    bus1.setOrigen_Destino("CONC/LA");
    bus2.setHorario(new Horario(LocalTime.of(9,30),LocalTime.of(12,15)));
    bus2.setOrigen_Destino("CONC/LA");
    bus3.setHorario(new Horario(LocalTime.of(10,0),LocalTime.of(11,45)));
    bus3.setOrigen_Destino("CONC/LA");
    bus4.setHorario(new Horario(LocalTime.of(10,30),LocalTime.of(16,45)));
    bus4.setOrigen_Destino("CONC/LA");
    bus5.setHorario(new Horario(LocalTime.of(11,0),LocalTime.of(12,45)));
    bus5.setOrigen_Destino("CONC/LA");
    bus6.setHorario(new Horario(LocalTime.of(11,30),LocalTime.of(20,45)));
    bus6.setOrigen_Destino("CONC/LA");
    bus7.setHorario(new Horario(LocalTime.of(12,0),LocalTime.of(13,45)));
    bus7.setOrigen_Destino("CONC/LA");
    bus8.setHorario(new Horario(LocalTime.of(12,30),LocalTime.of(14,45)));
    bus8.setOrigen_Destino("CONC/LA");
    bus9.setHorario(new Horario(LocalTime.of(9,0),LocalTime.of(12,0)));
    bus9.setOrigen_Destino("LA/TEM");
    bus10.setHorario(new Horario(LocalTime.of(10,0),LocalTime.of(13,0)));
    bus10.setOrigen_Destino("LA/TEM");
    bus11.setHorario(new Horario(LocalTime.of(11,0),LocalTime.of(14,0)));
    bus11.setOrigen_Destino("LA/TEM");
    bus12.setHorario(new Horario(LocalTime.of(12,0),LocalTime.of(15,0)));
    bus12.setOrigen_Destino("LA/TEM");
    bus13.setHorario(new Horario(LocalTime.of(13,0),LocalTime.of(16,0)));
    bus13.setOrigen_Destino("LA/TEM");
    bus14.setHorario(new Horario(LocalTime.of(14,0),LocalTime.of(17,0)));
    bus14.setOrigen_Destino("LA/TEM");
    bus15.setHorario(new Horario(LocalTime.of(15,0),LocalTime.of(18,0)));
    bus15.setOrigen_Destino("LA/TEM");
    bus16.setHorario(new Horario(LocalTime.of(16,0),LocalTime.of(19,0)));
    bus16.setOrigen_Destino("LA/TEM");
    bus17.setHorario(new Horario(LocalTime.of(17,0),LocalTime.of(20,0)));
    bus17.setOrigen_Destino("LA/TEM");
    bus18.setHorario(new Horario(LocalTime.of(4,0),LocalTime.of(10,30)));
    bus18.setOrigen_Destino("SGTO/CONC");
    bus19.setHorario(new Horario(LocalTime.of(5,0),LocalTime.of(20,0)));
    bus19.setOrigen_Destino("SGTO/CONC");
    bus20.setHorario(new Horario(LocalTime.of(6,0),LocalTime.of(20,0)));
    bus20.setOrigen_Destino("SGTO/CONC");
    bus21.setHorario(new Horario(LocalTime.of(7,0),LocalTime.of(20,0)));
    bus21.setOrigen_Destino("SGTO/CONC");
    bus22.setHorario(new Horario(LocalTime.of(12,0),LocalTime.of(18,30)));
    bus22.setOrigen_Destino("CONC/STGO");
    bus23.setHorario(new Horario(LocalTime.of(13,0),LocalTime.of(19,30)));
    bus23.setOrigen_Destino("CONC/STGO");
    bus24.setHorario(new Horario(LocalTime.of(14,0),LocalTime.of(20,30)));
    bus24.setOrigen_Destino("CONC/STGO");









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
    

    public ArrayList<Bus> getBusArrayList() {
        return busArrayList;
    }

    public void addItem(Bus bus) {
    horarios.addItem(bus.getHorario());
    }
}
