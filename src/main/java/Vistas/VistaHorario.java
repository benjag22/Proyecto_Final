package Vistas;
import ClasesLogicas.Horario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import javax.imageio.ImageIO;
public class VistaHorario extends JPanel {
    private Horario horario;
    private BufferedImage imagenComprar;
    private BufferedImage imagenComprarPresionada;
    private boolean presionado = false;
    private String origen;
    private String destino;
    private JButton botonCompra;
    private LocalDate fecha;
    public VistaHorario(Horario horario, String origen, String destino, LocalDate fecha) {
        this.horario = horario;
        this.origen = origen;
        this.destino = destino;
        this.fecha=fecha;

        this.imagenComprar = cargarImagen("src/main/java/Recursos/botonCompra2.png");
        this.imagenComprarPresionada = cargarImagen("src/main/java/Recursos/botonCompraPresionado2.png");
        int ancho = 180;
        int alto = 70;
        setPreferredSize(new Dimension(1000, 150));
        setMinimumSize(new Dimension(1000, 150));
        setMaximumSize(new Dimension(1000, 150));
        ImageIcon iconoOriginal = new ImageIcon(imagenComprar);
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon iconoPersonalizado = new ImageIcon(imagenEscalada);

        botonCompra = new JButton(iconoPersonalizado);
        botonCompra.setPreferredSize(new Dimension(ancho, alto));
        botonCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presionado = !presionado;
                actualizarImagen();
            }
        });
        add(botonCompra);
    }
    private void actualizarImagen() {
        if (presionado) {
            botonCompra.setIcon(new ImageIcon(imagenComprarPresionada.getScaledInstance(botonCompra.getWidth(), botonCompra.getHeight(), Image.SCALE_SMOOTH)));
        } else {
            botonCompra.setIcon(new ImageIcon(imagenComprar.getScaledInstance(botonCompra.getWidth(), botonCompra.getHeight(), Image.SCALE_SMOOTH)));
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage flecha = cargarImagen("src/main/java/Recursos/flecha.png");
        g.drawImage(flecha, 45, 30, flecha.getWidth(), flecha.getHeight(), this);
        Font fuente = new Font("Yu Gothic UI Semilight", Font.BOLD, 18);
        g.setFont(fuente);
        g.drawRect(690,0,0,105);
        g.drawString("Origen:  " + origen, 700, 45);
        g.drawString("Destino:  " + destino, 700, 105);
        g.drawString("Hora de inicio:  " + horario.getHoraInicio(), 80, 45);
        g.drawString("Hora de fin:  " + horario.getHoraFin(), 80, 105);
        g.drawString("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _  _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _", 80, 115);
        g.drawString("Descripción: " + horario + ", " + "Fecha: " + fecha, 150, 138);
        g.drawRect(0,0,this.getWidth(),this.getHeight());
    }
    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Horario getHorario() {
        return horario;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public JButton getBotonCompra() {
        return botonCompra;
    }
}