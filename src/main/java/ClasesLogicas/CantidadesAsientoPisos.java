package ClasesLogicas;

/**
 * Enumeración que representa la cantidad de filas y columnas de asientos.
 */

public enum CantidadesAsientoPisos {

    PISONORMAL(14, 4),

    PISOREDUCIDO(10, 4);
    private final int FILAS;
    private final int COLUMNAS;

    /**
     * Constructor de la enumeración CantidadesAsientoPisos.
     *
     * @param filas    La cantidad de filas en el piso.
     * @param columnas La cantidad de columnas en el piso.
     */

    CantidadesAsientoPisos(int filas, int columnas) {
        this.FILAS = filas;
        this.COLUMNAS = columnas;
    }

    /**
     * getFILAS: Obtiene la cantidad de filas en el piso.
     *
     * @return La cantidad de filas.
     */

    public int getFILAS() {
        return FILAS;
    }

    /**
     * getCOLUMNAS: Obtiene la cantidad de columnas en el piso.
     *
     * @return La cantidad de columnas.
     */

    public int getCOLUMNAS() {
        return COLUMNAS;
    }
}

