package org.example;

import Vistas.VistasAsientos;

import javax.swing.*;
import java.awt.*;

public class BuilderCorridasAsientos extends JFrame {
    public BuilderCorridasAsientos(){
        super();
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }
    public void dibujarCorridaAsientosNormal(Graphics g,Asiento asiento) {
        int filas = CantidadesAsientoPisos.PISONORMAL.getFILAS();
        int columnas = CantidadesAsientoPisos.PISONORMAL.getCOLUMNAS();

        int anchoAsiento = getWidth() / columnas;
        int altoAsiento = getHeight() / filas;

        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                char y = (char) ('A' + i - 1);
                int x = j;

                Asiento nuevoAsiento;
                if (asiento.getClass() == AsientoSemiCama.class) {
                    nuevoAsiento = new AsientoSemiCama(String.valueOf(y), x);
                } else {
                    nuevoAsiento = new AsientoCama(String.valueOf(y), x);
                }

                VistasAsientos vistaAsiento = new VistasAsientos(nuevoAsiento);
                vistaAsiento.setBounds((j - 1) * anchoAsiento, (i - 1) * altoAsiento, anchoAsiento, altoAsiento);
                add(vistaAsiento);
            }
        }
    }

    public void dibujarCorridaAsientosReducido(Graphics g, Asiento asiento){
        int filas = CantidadesAsientoPisos.PISOREDUCIDO.getFILAS();
        int columnas = CantidadesAsientoPisos.PISOREDUCIDO.getCOLUMNAS();

        int anchoAsiento = getWidth() / columnas;
        int altoAsiento = getHeight() / filas;

        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                char fila = (char) ('A' + i - 1);

                Asiento nuevoAsiento;
                if (asiento.getClass() == AsientoSemiCama.class) {
                    nuevoAsiento = new AsientoSemiCama(String.valueOf(fila), j);
                } else {
                    nuevoAsiento = new AsientoCama(String.valueOf(fila), j);
                }
                VistasAsientos vistaAsiento = new VistasAsientos(nuevoAsiento);
                vistaAsiento.setBounds((j - 1) * anchoAsiento, (i - 1) * altoAsiento, anchoAsiento, altoAsiento);
                add(vistaAsiento);
            }
        }
    }
    public static void main(String[] args) {
        BuilderCorridasAsientos builder = new BuilderCorridasAsientos();
        builder.setVisible(true);
    }

}
