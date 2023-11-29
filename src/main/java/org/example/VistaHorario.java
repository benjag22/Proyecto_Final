package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class VistaHorario extends JPanel {  // Cambiado de JFrame a JPanel

    private Horario horario;
    private BufferedImage imagenComprar;
    private BufferedImage imagenComprarPresionada;
    private boolean presionado = false;
    private String origen;
    private String destino;
    private JButton botonCompra;

    // Constructor de la clase
    public VistaHorario(Horario horario, String origen, String destino) {
        this.horario = horario;
        this.origen = origen;
        this.destino = destino;

        // Cargar imágenes
        this.imagenComprar = cargarImagen("src/main/java/resources/botonCompra.png");
        this.imagenComprarPresionada = cargarImagen("src/main/java/resources/botonCompraPresionado.png");

        // Configuración de dimensiones
        int ancho = 180;
        int alto = 70;

        // Crear un botón con una imagen
        ImageIcon iconoOriginal = new ImageIcon(imagenComprar);
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon iconoPersonalizado = new ImageIcon(imagenEscalada);

        botonCompra = new JButton(iconoPersonalizado);
        botonCompra.setPreferredSize(new Dimension(ancho, alto));

        // Configurar el ActionListener para el botón
        botonCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presionado = !presionado;
                actualizarImagen();
            }
        });

        // Agregar el botón al panel
        add(botonCompra);
    }

    // Método para actualizar la imagen del botón
    private void actualizarImagen() {
        if (presionado) {
            botonCompra.setIcon(new ImageIcon(imagenComprarPresionada.getScaledInstance(botonCompra.getWidth(), botonCompra.getHeight(), Image.SCALE_SMOOTH)));
        } else {
            botonCompra.setIcon(new ImageIcon(imagenComprar.getScaledInstance(botonCompra.getWidth(), botonCompra.getHeight(), Image.SCALE_SMOOTH)));
        }
    }

    // Método para dibujar en el panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar una imagen
        BufferedImage flecha = cargarImagen("src/main/java/resources/flecha.png");
        g.drawImage(flecha, 10, 30, flecha.getWidth(), flecha.getHeight(), this);

        // Configurar la fuente
        Font fuente = new Font("Yu Gothic UI Semilight", Font.BOLD, 18);
        g.setFont(fuente);

        // Dibujar texto
        g.drawString("---" + "Origen: " + origen, 200, 45);
        g.drawString("---" + "Destino: " + destino, 180, 105);
        g.drawString("Hora de inicio: " + horario.getHoraInicio(), 35, 45);
        g.drawString("Hora de fin: " + horario.getHoraFin(), 35, 105);
        g.drawString("_____________________________________________________________________________", 35, 115);
        g.drawString("Descripción: " + horario + ", " + "Fecha: " + horario.getLocalDate(), 35, 135);
    }

    // Método para cargar una imagen desde un archivo
    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ejemplo VistaHorario");
            Horario horarioAleatorio = Horario.generarHorarioAleatorio();
            String origen = Ciudades.ANGOL.getNombre();
            String destino = Ciudades.ARAUCO.getNombre();
            VistaHorario horarioPanel = new VistaHorario(horarioAleatorio, origen, destino);

            frame.add(horarioPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}