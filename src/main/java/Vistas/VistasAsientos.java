package Vistas;
import org.example.Asiento;
import org.example.AsientoCama;
import org.example.AsientoSemiCama;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


public class VistasAsientos extends JPanel {
    private Asiento asiento;
    private BufferedImage imagenOriginal;
    private BufferedImage imagenPresionada;
    private boolean presionada = false;
    private double precio;
    public VistasAsientos(Asiento asiento) {
        this.asiento = asiento;
        this.precio=0.0;
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

    public void paint(Graphics g) {
        super.paint(g);
        if (presionada) {
            g.drawImage(imagenPresionada,0,0, this);
            this.precio=asiento.getPrecio();
        } else {
            g.drawImage(imagenOriginal,0,0, this);
            this.precio=0;
        }
    }
    public Asiento getAsiento() {
        return asiento;
    }

    public boolean isPresionada() {
        return presionada;
    }
}

