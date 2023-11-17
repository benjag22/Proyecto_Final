package GUIInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelDestinoIda extends JPanel {
    JTextField Origen_Destino;
    JLabel Introducir;
    private BufferedImage imagen;
    public PanelDestinoIda(){
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
/**
    public static void main (String[] args){
        JFrame frame = new JFrame();
        frame.add(new PanelDestinoIda());
        frame.setTitle("Venta de pasajes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }*/
}
