package GUIInterface;

import Vistas.VistaBus;
import Vistas.VistasListaBuses;
import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import javax.swing.event.MenuEvent;

public class PanelEleccionAsientos extends JPanel{
    VistasListaBuses listaBuses = new VistasListaBuses();
    VistaBus busAsociado;
    /*De esta clase ira acompañada con un panel de detalles y total de compra que incluye vista bus
    * se inicializaran varias en panelHorarios*/

    public PanelEleccionAsientos(int randomBus){
        this.busAsociado=listaBuses.getBus(randomBus);

    }
}
