package org.example;

public class AsientoSemiCama extends Asiento{
    private Boolean habilitado;
    public AsientoSemiCama(String fila, int columna){
        super(fila, columna);
    }
    @Override
    public void setHabilitado(boolean habilitado) {
        this.habilitado=habilitado;
    }
    @Override
    public String toString() {
        return super.getFila()+super.getColumna();
    }
}
