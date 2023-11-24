package GUIInterface;

import org.example.Bus;
import org.example.Horario;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import javax.sound.sampled.*;

public class PanelDestinoIda extends JPanel implements ActionListener{
    private JTextField Origen_Destino;
    private JLabel Introducir;
    private BufferedImage imagen;
    private Clip clipMouseOver;
    private Clip clipClick;
    private PanelHorarios panelHorarios;
    public PanelDestinoIda(){
        this.setLayout(null);
        setPreferredSize(new Dimension(1920,1080));
        this.imagen = cargarImagen("C:\\Users\\Asus\\OneDrive\\Desktop\\Sukuna y fushiguro.PNG");
        panelHorarios = new PanelHorarios();

        Font font1 = new Font("Arial",Font.PLAIN,30);
        Introducir = new JLabel("Ingresar origen y destino de la siguiente manera: CNCE/LOSA");
        Introducir.setFont(font1);
        Introducir.setBounds(400,150,1800,50);
        Introducir.setForeground(Color.WHITE);
        add(Introducir);



        Font font = new Font("Arial",Font.PLAIN,20);

        Origen_Destino = new JTextField("Origen/Destino");
        Origen_Destino.setFont(font);
        Origen_Destino.setBounds(700,300,250,50);
        add(Origen_Destino);
        Origen_Destino.addActionListener(this);

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

    public JTextField getOrigen_Destino() {
        return Origen_Destino;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<panelHorarios.getBusArrayList().size();i++){
            Bus bus = panelHorarios.getBusArrayList().get(i);
            if(Origen_Destino.getText().equals(bus.getOrigen_Destino())){
                panelHorarios.addItem(bus);
            }
        }
        this.setVisible(false);
        panelHorarios.setVisible(true);
    }

    public PanelHorarios getPanelHorarios() {
        return panelHorarios;
    }
    public static void main (String[] args){
        JFrame frame = new JFrame();
        PanelDestinoIda panelDestinoIda = new PanelDestinoIda();
        frame.add(panelDestinoIda);
        frame.setTitle("Venta de pasajes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
}
