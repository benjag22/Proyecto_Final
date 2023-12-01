package Vistas;
import Vistas.VistasAsientos;
import org.example.Asiento;
import org.example.AsientoCama;
import org.example.AsientoSemiCama;
import org.example.CantidadesAsientoPisos;

import javax.swing.*;
import java.util.ArrayList;

public class BuilderCorridasAsientos extends JPanel {
    ArrayList<VistasAsientos> listaVistaAsientos;
    private int filas;
    private int columnas;
    public BuilderCorridasAsientos(){
        super();
        listaVistaAsientos = new ArrayList<>();
    }
    public void agregarCorridaAsientosNormal(Asiento asiento) {
        this.filas = CantidadesAsientoPisos.PISONORMAL.getFILAS();
        this.columnas = CantidadesAsientoPisos.PISONORMAL.getCOLUMNAS();
        listaVistaAsientos.clear();
        int xposicion = 0;
        int yposicion = 0;
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                char letra = (char) ('A' + i - 1);
                if (asiento instanceof AsientoCama) {
                    xposicion = (i - 1) * 90;
                    yposicion = (j - 1) * 60;
                    Asiento nuevoAsiento = new AsientoCama(String.valueOf(letra), j);
                    VistasAsientos vistanuevoAsiento = new VistasAsientos(nuevoAsiento, xposicion, yposicion);
                    listaVistaAsientos.add(vistanuevoAsiento);
                } else if (asiento instanceof AsientoSemiCama) {
                    xposicion = (i - 1) * 70;
                    yposicion = (j - 1) * 70;
                    Asiento nuevoAsiento = new AsientoSemiCama(String.valueOf(letra), j);
                    VistasAsientos vistanuevoAsiento = new VistasAsientos(nuevoAsiento, xposicion, yposicion);
                    listaVistaAsientos.add(vistanuevoAsiento);
                }
            }
        }
    }

    public void agregarCorridaAsientosReducido(Asiento asiento) {
        this.filas = CantidadesAsientoPisos.PISOREDUCIDO.getFILAS();
        this.columnas = CantidadesAsientoPisos.PISOREDUCIDO.getCOLUMNAS();
        listaVistaAsientos.clear();
        int xposicion = 0;
        int yposicion = 0;
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                char letra = (char) ('A' + i - 1);
                if (asiento instanceof AsientoCama) {
                    xposicion = (i - 1) * 90;
                    yposicion = (j - 1) * 60;
                    Asiento nuevoAsiento = new AsientoCama(String.valueOf(letra), j);
                    VistasAsientos vistanuevoAsiento = new VistasAsientos(nuevoAsiento, xposicion, yposicion);
                    listaVistaAsientos.add(vistanuevoAsiento);
                } else if (asiento instanceof AsientoSemiCama) {
                    xposicion = (i - 1) * 70;
                    yposicion = (j - 1) * 70;
                    Asiento nuevoAsiento = new AsientoSemiCama(String.valueOf(letra), j);
                    VistasAsientos vistanuevoAsiento = new VistasAsientos(nuevoAsiento, xposicion, yposicion);
                    listaVistaAsientos.add(vistanuevoAsiento);
                }
            }
        }
    }
    public ArrayList<VistasAsientos> getListaVistaAsientos() {
        return listaVistaAsientos;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}