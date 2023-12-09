package Paneles;
import Vistas.VistaBus;
import Vistas.VistasListaBuses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;

public class PanelEleccionAsientos extends JPanel implements MouseListener {
    private VistasListaBuses listaBuses = new VistasListaBuses();
    private VistaBus busAsociado;
    private PanelDatosBus panelDatos;
    private JLabel origenAsociado;
    private JLabel destinoAsociado;
    private LocalTime horaInicio;
    private LocalTime horaFinal;


    public PanelEleccionAsientos(int randomBus, LocalTime horaInicio, LocalTime horaFinal, String origen, String destino) {
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.horaFinal=horaFinal;
        this.horaInicio=horaInicio;
        this.busAsociado = listaBuses.getBus(randomBus);
        origenAsociado= new JLabel(origen);
        destinoAsociado = new JLabel(destino);
        this.addMouseListener(this);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // BoxLayout con eje Y para que se ordene

        JPanel panelInterno = new JPanel(new BorderLayout());
        panelDatos = new PanelDatosBus(busAsociado,horaInicio,horaFinal,origen,destino);

        panelInterno.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelDatos.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        panelInterno.add(busAsociado, BorderLayout.CENTER);
        panelInterno.add(panelDatos,BorderLayout.SOUTH);
        add(panelInterno);
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

    public PanelDatosBus getPanelDatos() {
        return panelDatos;
    }
}
