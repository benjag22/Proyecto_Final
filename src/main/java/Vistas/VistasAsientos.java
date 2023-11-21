package Vistas;

import org.example.Asiento;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class VistasAsientos extends JFrame {
    private Asiento asiento;

    public VistasAsientos(Asiento asiento) {
        this.asiento = asiento;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        BufferedImage imagenAsiento = asiento.getImagen();
        g.drawImage(imagenAsiento, 0, 0, this);
    }
}

