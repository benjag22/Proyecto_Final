package Paneles;
import Vistas.VistaBus;
import Vistas.VistasListaBuses;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class PanelEleccionAsientos extends JPanel{
    private VistasListaBuses listaBuses = new VistasListaBuses();
    private VistaBus busAsociado;
    private PanelDatosBus panelDatos;
    private JLabel origenAsociado;
    private JLabel destinoAsociado;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private JButton comprar;


    public PanelEleccionAsientos(int randomBus, LocalTime horaInicio, LocalTime horaFinal, String origen, String destino) {
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.horaFinal=horaFinal;
        this.horaInicio=horaInicio;
        this.busAsociado = listaBuses.getBus(randomBus);
        origenAsociado= new JLabel(origen);
        destinoAsociado = new JLabel(destino);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // BoxLayout con eje Y para que se ordene

        JPanel panelInterno = new JPanel(new BorderLayout());
        panelDatos = new PanelDatosBus(busAsociado,horaInicio,horaFinal,origen,destino);

        panelInterno.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelDatos.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        panelInterno.add(busAsociado, BorderLayout.CENTER);
        panelInterno.add(panelDatos,BorderLayout.SOUTH);
        add(panelInterno);
        comprar = getPanelDatos().getBotonCompra();
    }
    public PanelDatosBus getPanelDatos() {
        return panelDatos;
    }

    public JButton getComprar() {
        return comprar;
    }
}

