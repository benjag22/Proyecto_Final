package Vistas;
import org.example.Asiento;
import org.example.AsientoCama;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VistasAsientos extends JFrame {
    private Asiento asiento;
    private BufferedImage imagenOriginal;
    private BufferedImage imagenPresionada;

    private boolean presionada = false;

    public VistasAsientos(Asiento asiento) {
        this.asiento = asiento;
        this.imagenOriginal = asiento.getImagenDeseleccionada();
        this.imagenPresionada = asiento.getImagenSeleccionada();

        setPreferredSize(new Dimension(imagenOriginal.getWidth(), imagenOriginal.getHeight()));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                presionada = !presionada;
                repaint();
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (presionada) {
            g.drawImage(imagenPresionada, 0, 0, this);
        } else {
            g.drawImage(imagenOriginal, 0, 0, this);
        }
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
        VistasAsientos vistasAsientos = new VistasAsientos(new AsientoCama("A", 2));
        vistasAsientos.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        vistasAsientos.setVisible(true);
    }
}

