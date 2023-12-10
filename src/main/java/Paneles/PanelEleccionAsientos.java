package Paneles;
import Vistas.VistaBus;
import Vistas.VistasListaBuses;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

/**
 * Panel para la elección de asientos en un bus.
 */

public class PanelEleccionAsientos extends JPanel{
    private VistasListaBuses listaBuses = new VistasListaBuses();
    private VistaBus busAsociado;
    private PanelDatosBus panelDatos;
    private JButton comprar;


    /**
     * Constructor del PanelEleccionAsientos, mas que nada ordena VistaBus elegido y lo asocia a un panelDatosBus
     * lo ordena mediante BoxLayout.Y_AXIS dentro del panel
     *
     * @param randomBus Índice del bus seleccionado aleatoriamente.
     * @param horaInicio Hora de inicio.
     * @param horaFinal  Hora de llegada.
     * @param origen     Ciudad de origen.
     * @param destino    Ciudad de destino.
     */

    public PanelEleccionAsientos(int randomBus, LocalTime horaInicio, LocalTime horaFinal, String origen, String destino) {
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.busAsociado = listaBuses.getBus(randomBus);
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

    /**
     * getPanelDatos: Obtiene el panel de datos asociado al PanelEleccionAsientos.
     *
     * @return Panel de datos.
     */

    public PanelDatosBus getPanelDatos() {
        return panelDatos;
    }

    /**
     * getComprar: Obtiene elección de asientos y sirve para devolver a panelCOmpra mediante eventos
     *
     * @return Elección Comprar.
     */

    public JButton getComprar() {
        return comprar;
    }
}

