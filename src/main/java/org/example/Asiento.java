package org.example;

import java.awt.image.BufferedImage;


public abstract class Asiento {
private String fila;
private int columna;

public Asiento(){

}
    public abstract void setHabilitado(boolean habilitado);

    public String getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public abstract BufferedImage getImagenSeleccionada();
    public abstract BufferedImage getImagenDeseleccionada();
}
