package ClasesLogicas;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Clase que representa un asiento de tipo semicama.
 */

public class AsientoSemiCama extends Asiento{
    private Boolean habilitado;
    private BufferedImage imagenDeseleccionada;
    private BufferedImage imagenSeleccionada;
    private BufferedImage imagenOcupada;
    private final double precio=15000.0;

    /**
     * Constructor de la clase AsientoSemiCama.
     */

    public AsientoSemiCama(){
        super();
        this.imagenDeseleccionada=cargarImagen("src/main/java/Recursos/asiento_semicama.png");
        this.imagenSeleccionada=cargarImagen("src/main/java/Recursos/asiento_semicama_elegida.png");
        this.imagenOcupada=cargarImagen("src/main/java/Recursos/asiento_semicama_ocupado.png");
    }

    /**
     * getPrecio: Obtiene el precio del asiento semicama.
     *
     * @return El precio del asiento semicama.
     */

    @Override
    public double getPrecio() {
        return precio;
    }

    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * getImagenDeseleccionada: Obtiene la imagen del asiento semicama deseleccionado.
     *
     * @return La imagen deseleccionada asiento semicama.
     */

    @Override
    public BufferedImage getImagenDeseleccionada() {
        return imagenDeseleccionada;
    }

    /**
     * getImagenSeleccionada: Obtiene la imagen del asiento semicama seleccionado.
     *
     * @return La imagen seleccionada asiento semicama.
     */

    @Override
    public BufferedImage getImagenSeleccionada() {
        return imagenSeleccionada;
    }


    /**
     * getImagenOcupado: Obtiene la imagen del asiento semicama ocupado.
     *
     * @return La imagen ocupada asiento semicama.
     */

    @Override
    public BufferedImage getImagenOcupado() {
        return imagenOcupada;
    }

    /**
     * toString: Devuelve String asiento semicama.
     *
     * @return String asiento semicama.
     */

    @Override
    public String toString() {
        return super.getFila()+super.getColumna();
    }

    /**
     * getThis: Obtiene la instancia asiento semicama.
     *
     * @return La instancia asiento semicama.
     */

    public AsientoSemiCama getThis(){
        return this;
    }

    /**
     * setColumna: Establece la columna del asiento semicama.
     *
     * @param columna La columna a establecer.
     */

    @Override
    public void setColumna(int columna) {
        super.setColumna(columna);
    }

    /**
     * setFila: Establece la fila del asiento semicama.
     *
     * @param fila La fila a establecer.
     */

    @Override
    public void setFila(String fila) {
        super.setFila(fila);
    }
}
