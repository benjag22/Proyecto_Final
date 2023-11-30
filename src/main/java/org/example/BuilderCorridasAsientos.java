package org.example;

import Vistas.VistaBus;
import Vistas.VistasAsientos;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BuilderCorridasAsientos extends JPanel {
    ArrayList<VistasAsientos> listaVistaAsientos;
    private int filas;
    private int columnas;
    public BuilderCorridasAsientos(){
        super();
        setSize(800, 1080);
        listaVistaAsientos = new ArrayList<>();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int anchoAsiento = getWidth() / columnas;
        int altoAsiento = getHeight() / filas;

        int index = 0;

        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                int x = (j - 1) * anchoAsiento;
                int y = (i - 1) * altoAsiento;
                listaVistaAsientos.get(index++).paint(g, x, y, anchoAsiento, altoAsiento);
            }
        }
    }
    public void dibujarCorridaAsientosNormal(Asiento asiento) {
        this.filas = CantidadesAsientoPisos.PISONORMAL.getFILAS();
        this.columnas = CantidadesAsientoPisos.PISONORMAL.getCOLUMNAS();
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                char y = (char) ('A' + i - 1);
                Asiento nuevoAsiento = null;
                if (asiento.getClass() == AsientoSemiCama.class) {
                    nuevoAsiento = new AsientoSemiCama(String.valueOf(y), j);
                    VistasAsientos vistaNuevoAsiento = new VistasAsientos(nuevoAsiento);
                    listaVistaAsientos.add(vistaNuevoAsiento);

                }else if(asiento.getClass() == AsientoCama.class)
                    nuevoAsiento = new AsientoCama(String.valueOf(y), j);
                    VistasAsientos vistaNuevoAsiento = new VistasAsientos(nuevoAsiento);
                    listaVistaAsientos.add(vistaNuevoAsiento);
            }
        }
    }

    public void dibujarCorridaAsientosReducido(Asiento asiento) {
        this.filas = CantidadesAsientoPisos.PISOREDUCIDO.getFILAS();
        this.columnas = CantidadesAsientoPisos.PISOREDUCIDO.getCOLUMNAS();
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                char y = (char) ('A' + i - 1);
                Asiento nuevoAsiento = null;
                if (asiento.getClass() == AsientoSemiCama.class) {
                    nuevoAsiento = new AsientoSemiCama(String.valueOf(y), j);
                    VistasAsientos vistaNuevoAsiento = new VistasAsientos(nuevoAsiento);
                    listaVistaAsientos.add(vistaNuevoAsiento);
                } else if (asiento.getClass() == AsientoCama.class) {
                    nuevoAsiento = new AsientoCama(String.valueOf(y), j);
                    VistasAsientos vistaNuevoAsiento = new VistasAsientos(nuevoAsiento);
                    listaVistaAsientos.add(vistaNuevoAsiento);
                }
            }
        }
    }
}
