package GUIInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        ActionListener horaselec = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destinoIda.setVisible(false);
                horarios.setVisible(true);
            }
        };
        destinoIda.getOrigen_Destino().addActionListener(horaselec);

        compra.getComprarAsiento().addMouseListener(this);

        setPreferredSize(new Dimension(1920,1080));
        add(compra);
        add(destinoIda);
        add(horarios);

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        destinoIda.setLocation(0,0);
        compra.setLocation(0,0);
        horarios.setLocation(0,0);

        if(compra.isVisible()){
            compra.paintComponent(g);
        }

        else if(destinoIda.isVisible()){
            destinoIda.paintComponent(g);
        }

        else if(horarios.isVisible()){
            horarios.paintComponent(g);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent()==compra.getComprarAsiento()){
            compra.setVisible(false);
            destinoIda.setVisible(true);
            revalidate();
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static void main (String[] args){
        JFrame frame = new JFrame();
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        frame.add(panelPrincipal);
        frame.setTitle("Venta de pasajes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1500,1020);
        frame.setVisible(true);
    }
}
