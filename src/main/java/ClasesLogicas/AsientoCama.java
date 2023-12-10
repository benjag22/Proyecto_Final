package ClasesLogicas;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Clase que representa un asiento de tipo cama.
 */

public class AsientoCama extends Asiento{
    private BufferedImage imagenDeseleccionada;
    private BufferedImage imagenSeleccionada;
    private BufferedImage imagenOcupada;
    private final double precio=20000.0;

    /**
     * Constructor de la clase AsientoCama.
     */

    public AsientoCama(){
        super();
        this.imagenDeseleccionada = cargarImagen("src/main/java/Recursos/asiento_cama.png");
        this.imagenSeleccionada = cargarImagen("src/main/java/Recursos/asiento_cama_elegido.png");
        this.imagenOcupada = cargarImagen("src/main/java/Recursos/asiento_cama_ocupado.png");
    }

    /**
     * getPrecio: Obtiene el precio del asiento.
     *
     * @return El precio del asiento.
     */

    @Override
    public double getPrecio() {
        return precio;
    }

    /**
     * cargarImagen: Carga una imagen.
     *
     * @param ruta La ruta de la imagen.
     * @return La imagen cargada.
     */

    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * getImagenDeseleccionada: Obtiene la imagen asiento cama no seleccionado.
     *
     * @return La imagen asiento cama no seleccionado.
     */

    @Override
    public BufferedImage getImagenDeseleccionada() {
        return imagenDeseleccionada;
    }

    /**
     * getImagenSeleccionada Obtiene la imagen asiento cama seleccionado.
     *
     * @return La imagen asiento cama seleccionado.
     */

    @Override
    public BufferedImage getImagenSeleccionada() {
        return imagenSeleccionada;
    }


    /**
     * getImagenOcupado: Obtiene la imagen asiento cama ocupado.
     *
     * @return La imagen asiento cama ocupado.
     */

    @Override
    public BufferedImage getImagenOcupado() {
        return imagenOcupada;
    }


    /**
     * toStrin: String asiento cama.
     *
     * @return String del asiento cama.
     */

    @Override
    public String toString() {
        return super.getFila()+super.getColumna();
    }

    /**
     * setColumna: Establece la columna del asiento cama.
     *
     * @param columna La nueva columna del asiento cama.
     */

    @Override
    public void setColumna(int columna) {
        super.setColumna(columna);
    }

    /**
     * setFila: Establece la fila del asiento cama.
     *
     * @param fila La nueva fila del asiento cama.
     */

    @Override
    public void setFila(String fila) {
        super.setFila(fila);
    }
}
