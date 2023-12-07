package Vistas;

import org.example.Horario;
import javax.swing.*;
import java.awt.*;
public class vistaDatosBus extends JPanel {
    String origen;
    String destino;
    JButton comprar;
    Horario horarioAsociado;
    VistaBus busAsociado;
    private double precioTotal;

    public vistaDatosBus(VistaBus busAsociado, Horario horario, String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
        this.busAsociado = busAsociado;
        this.horarioAsociado = horario;
        this.precioTotal = 0.0;
        setLayout(new BorderLayout());

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        comprar = new JButton("Comprar");
        comprar.setPreferredSize(new Dimension(200, 80));

        panelBoton.add(comprar);
        panelBoton.setLocation(1600,250);
        add(panelBoton);
        setPreferredSize(new Dimension(1920, 300));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font fuente = new Font("Yu Gothic UI Semilight", Font.BOLD, 18);
        g.setFont(fuente);
        g.setColor(Color.BLACK);
        g.drawString("Hora de inicio: " + horarioAsociado.getHoraInicio(), 20, 50);
        g.drawString("Hora de llegada: " + horarioAsociado.getHoraFin(), 20, 120);
        g.drawString("Origen: "+ origen,400,50);
        g.drawString("Destino: "+destino,400,120);
        g.drawRect(360,0,0,300);
        g.drawRect(740,0,0,300);
        g.drawRect(1072,0,0,300);
    }

    public double contarTotal() {
        for (VistasAsientos vistasAsientoAsicoaida : busAsociado.getListaAsientos()) {
            if (vistasAsientoAsicoaida.isPresionada()) {
                this.precioTotal += vistasAsientoAsicoaida.getAsiento().getPrecio();
            }
        }
        return this.precioTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
