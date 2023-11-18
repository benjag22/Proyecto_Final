package org.example;

public abstract class Asiento {
private String fila;
private int columna;
public Asiento(String fila, int columna){
    this.fila=fila;
    this.columna=columna;
}
    public abstract void setHabilitado(boolean habilitado);

    public String getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
