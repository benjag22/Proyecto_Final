package GUIInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPrincipal extends JPanel implements MouseListener {
    private PanelDestinoIda destinoIda;
    private PanelCompra compra;
    private PanelHorarios horarios;

    public PanelPrincipal(){
        this.addMouseListener(this);
        compra = new PanelCompra();
        compra.setVisible(true);

        destinoIda = new PanelDestinoIda();
        destinoIda.setVisible(false);

        horarios = new PanelHorarios();
        horarios.setVisible(false);

        compra.getComprarAsiento().addMouseListener(this);

        setPreferredSize(new Dimension(1920,1080));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        add(compra);
        add(destinoIda);
        add(horarios);

        destinoIda.setLocation(0,0);
        compra.setLocation(0,0);
        if(compra.isVisible()){
            compra.paintComponent(g);
        }
        else if(destinoIda.isVisible()){
            destinoIda.paintComponent(g);
        }
        else if(horarios.isVisible()){
            horarios.paintComponents(g);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent()==compra.getComprarAsiento()){
            compra.setVisible(!compra.isVisible());
            destinoIda.setVisible(!destinoIda.isVisible());
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getComponent()==compra) {
            System.out.println("dentro");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent()==compra) {
            System.out.println("fuera");
        }
    }

    public static void main (String[] args){
        JFrame frame = new JFrame();
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        panelPrincipal.setBounds(0,0,1920,1080);
        frame.add(panelPrincipal);
        frame.setTitle("Venta de pasajes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }

}
