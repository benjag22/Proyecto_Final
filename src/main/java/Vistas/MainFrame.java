package Vistas;

import org.example.AsientoCama;
import org.example.AsientoSemiCama;
import org.example.BuilderCorridasAsientos;
import org.example.BusDosPisos;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private BuilderCorridasAsientos builder;
    private VistaBus vistaBus;

    public MainFrame() {
        super("Main Frame");

        builder = new BuilderCorridasAsientos();
        vistaBus = new VistaBus(new BusDosPisos(), builder);
        vistaBus.agregarAsientos(new AsientoCama("A", 1), 1);
        repaint();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(builder, BorderLayout.CENTER);
        mainPanel.add(vistaBus, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
