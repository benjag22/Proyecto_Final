package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HorarioPanel extends JFrame {

    private Horario horario;
    private BufferedImage imagenComprar;

    public HorarioPanel(Horario horario) {
        this.horario = horario;
        /*this.imagenComprar = cargarImagen("resources/botonComprar.png");*/
        setTitle("Horario Bus");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(4, 1));
        infoPanel.add(new JLabel("Hora de inicio: " + horario.getHoraInicio()));
        infoPanel.add(new JLabel("Hora de fin: " + horario.getHoraFin()));
        infoPanel.add(new JLabel("Fecha: " + horario.getLocalDate()));
        infoPanel.add(new JLabel("Descripción: " + horario));
        panel.add(infoPanel, BorderLayout.CENTER);
        JButton comprarButton = new JButton(new ImageIcon(imagenComprar));
        panel.add(comprarButton, BorderLayout.EAST);
        add(panel);
        setVisible(true);
    }

    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Horario horarioAleatorio = Horario.generarHorarioAleatorio();
        SwingUtilities.invokeLater(() -> new HorarioPanel(horarioAleatorio));
    }
}

