package Vistas;
import javax.swing.*;

import GUIInterface.PanelCompra;
import org.example.Bus;

import java.awt.*;

public class VistaBus extends JFrame {
    private Bus bus;
    public VistaBus(Bus bus){
        super();
        this.bus=bus;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
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
