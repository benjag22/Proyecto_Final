package Vistas;
import javax.swing.*;

import GUIInterface.PanelCompra;
import org.example.Asiento;
import org.example.Bus;
import org.example.BusUnPiso;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VistaBus extends JFrame {
    private Bus bus;
    private List<VistasAsientos>listaAsientos;
    public VistaBus(Bus bus, int cantidad){
        super();
        this.bus=bus;
        listaAsientos = new ArrayList<>();
        bus.añadirAsientosPiso1();
        setLayout(new FlowLayout());

        Asiento asiento=bus.getListaAsientos().remove(0);
        while (asiento!=null){
            listaAsientos.add(new VistasAsientos(asiento));
            asiento=bus.getListaAsientos().remove(0);
        }

        for (VistasAsientos vistaAsiento : listaAsientos) {
            add(vistaAsiento);
        }
    }
}
