package Vistas;
import org.example.Asiento;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


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

    public void paint(Graphics g, int x, int y, int ancho, int alto) {
        super.paint(g);
        if (presionada) {
            g.drawImage(imagenPresionada, x, y, ancho, alto, this);
        } else {
            g.drawImage(imagenOriginal, x, y, ancho, alto, this);
        }
    }
}

