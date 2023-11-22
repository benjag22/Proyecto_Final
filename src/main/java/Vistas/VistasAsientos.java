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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (presionada) {
            g.drawImage(imagenPresionada, 0, 0, this);
        } else {
            g.drawImage(imagenOriginal, 0, 0, this);
        }
    }
}

