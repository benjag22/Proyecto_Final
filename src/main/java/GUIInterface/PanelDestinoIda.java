package GUIInterface;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class PanelDestinoIda extends JPanel {
    private JTextField Origen_Destino;
    private JLabel Introducir;
    private BufferedImage imagen;
    private String origendestino;
    private Clip clipMouseOver;
    private Clip clipClick;
    public PanelDestinoIda(){
        cargarSonidos();
        this.setLayout(null);
        setPreferredSize(new Dimension(1920,1080));
        this.imagen = cargarImagen("C:\\Users\\Asus\\OneDrive\\Desktop\\Sukuna y fushiguro.PNG");

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