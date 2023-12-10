package ClasesLogicas;

import java.awt.image.BufferedImage;

/**
 * Clase abstracta que representa un asiento.
 */

public abstract class Asiento {
private String fila;
private int columna;
private double precio;

    /**
     * Constructor clase Asiento.
     */

public Asiento(){

}

    /**
     * getPrecio: Obtiene el precio del asiento.
     *
     * @return El precio del asiento.
     */

    public double getPrecio() {
        return precio;
    }

    /**
     * getFila: Obtiene la fila del asiento.
     *
     * @return La fila del asiento.
     */

    public String getFila() {
        return fila;
    }

    /**
     * getColumna: Obtiene la columna del asiento.
     *
     * @return La columna del asiento.
     */

    public int getColumna() {
        return columna;
    }

    /**
     * setColumna: Establece la columna del asiento.
     *
     * @param columna La nueva columna del asiento.
     */

    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * setFila: Establece la fila del asiento.
     *
     * @param fila La nueva fila del asiento.
     */

    public void setFila(String fila) {
        this.fila = fila;
    }

    /**
     * getImagenSeleccionad: Abstracto para obtener la imagen cuando el asiento es seleccionado.
     *
     * @return La imagen asiento seleccionado.
     */

    public abstract BufferedImage getImagenSeleccionada();

    /**
     * getImagenDeseleccionada: Abstracto para obtener la imagen cuando el asiento no está seleccionado.
     *
     * @return La imagen asiento no seleccionado.
     */

    public abstract BufferedImage getImagenDeseleccionada();

    /**
     * getImagenOcupado: Aabstracto para obtener la imagen cuando el asiento está ocupado.
     *
     * @return La imagen del asiento ocupado.
     */

    public abstract BufferedImage getImagenOcupado();
}
