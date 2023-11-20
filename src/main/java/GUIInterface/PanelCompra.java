package GUIInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelCompra extends JPanel implements MouseListener {
    private JButton ComprarAsiento;
    private BufferedImage imagen;
    private boolean botoncomprar;
    public PanelCompra(){
        this.setLayout(null);
        setPreferredSize(new Dimension(1920,1080));
        this.imagen = cargarImagen("C:\\Users\\Asus\\OneDrive\\Desktop\\Itadori durmiendo.jpg");


        ComprarAsiento = new JButton("Comprar asiento");
        ComprarAsiento.addMouseListener(this);
        ComprarAsiento.setBounds(775, 400,200,25);
        ComprarAsiento.setFont(new Font("Arial",Font.PLAIN,20));
        add(ComprarAsiento);

        botoncomprar = true;
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
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagen !=null) {
                g.drawImage(imagen, 0, 0, 1920, 1080, this);
        }
    }
    public JButton getComprarAsiento() {
        return ComprarAsiento;
    }

    public Boolean getBotoncomprar() {
        return botoncomprar;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
            botoncomprar = false;
        System.out.println(botoncomprar);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main (String[] args){
        JFrame frame = new JFrame();
        frame.add(new PanelCompra());
        frame.setTitle("Venta de pasajes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
}
