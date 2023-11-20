package GUIInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelHorarios extends JPanel implements ItemListener {
    private BufferedImage imagen;
    private JLabel Seleccionar;
    private String seleccion;
    private JComboBox horarios;

public PanelHorarios(){
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
    horarios.addItem("Eliga su horario");
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

     public static void main (String[] args){
     JFrame frame = new JFrame();
     frame.add(new PanelHorarios());
     frame.setTitle("Venta de pasajes");
     frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     frame.setSize(1000,1000);
     frame.setVisible(true);
     }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == horarios){
            seleccion = horarios.getSelectedItem().toString();
            System.out.println(seleccion);
        }
    }
}
