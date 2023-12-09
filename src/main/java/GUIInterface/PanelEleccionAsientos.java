package GUIInterface;
import Vistas.VistaBus;
import Vistas.VistasListaBuses;
import Vistas.vistaDatosBus;
import org.example.Horario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;

public class PanelEleccionAsientos extends JPanel implements MouseListener {
    VistasListaBuses listaBuses = new VistasListaBuses();
    VistaBus busAsociado;
    vistaDatosBus panelDatos;
    JLabel origenAsociado;
    JLabel destinoAsociado;

    public PanelEleccionAsientos(int randomBus, LocalTime horaInicio, LocalTime horaFinal, String origen, String destino) {
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.busAsociado = listaBuses.getBus(randomBus);
        origenAsociado= new JLabel(origen);
        destinoAsociado = new JLabel(destino);
        this.addMouseListener(this);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // BoxLayout con eje Y para que se ordene

        JPanel panelInterno = new JPanel(new BorderLayout());
        panelDatos = new vistaDatosBus(busAsociado,horaInicio,horaFinal,origen,destino);

        panelInterno.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelDatos.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        panelInterno.add(busAsociado, BorderLayout.CENTER);
        panelInterno.add(panelDatos,BorderLayout.SOUTH);
        add(panelInterno);
    }
    public void actualizarDatos(VistaBus busAsociado, LocalTime horaInicio, LocalTime horaFinal, String origen, String destino) {
        this.origenAsociado.setText(origen);
        this.destinoAsociado.setText(destino);
        this.panelDatos.actualizarDatos(busAsociado, horaInicio, horaFinal, origen, destino);
        add(origenAsociado);
        add(destinoAsociado);
        add(panelDatos);
        revalidate();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
