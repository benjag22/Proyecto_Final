package org.example;

public class AsientoCama extends Asiento{
    private Boolean habilitado;
    public AsientoCama(String fila, int columna){
        super(fila,columna);
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
