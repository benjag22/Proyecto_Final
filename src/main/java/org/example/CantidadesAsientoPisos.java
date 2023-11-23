package org.example;

public enum CantidadesAsientoPisos {
    PISONORMAL(20, 4),
    PISOREDUCIDO(10, 4);
    private final int FILAS;
    private final int COLUMNAS;

    CantidadesAsientoPisos(int filas, int columnas) {
        this.FILAS = filas;
        this.COLUMNAS = columnas;
    }

    public int getFILAS() {
        return FILAS;
    }

    public int getCOLUMNAS() {
        return COLUMNAS;
    }
}

