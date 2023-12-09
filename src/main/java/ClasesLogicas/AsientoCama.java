package ClasesLogicas;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AsientoCama extends Asiento{
    private BufferedImage imagenDeseleccionada;
    private BufferedImage imagenSeleccionada;
    private BufferedImage imagenOcupada;
    private final double precio=20000.0;
    public AsientoCama(){
        super();
        this.imagenDeseleccionada = cargarImagen("src/main/java/Recursos/asiento_cama.png");
        this.imagenSeleccionada = cargarImagen("src/main/java/Recursos/asiento_cama_elegido.png");
        this.imagenOcupada = cargarImagen("src/main/java/Recursos/asiento_cama_ocupado.png");
    }
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
    @Override
    public BufferedImage getImagenDeseleccionada() {
        return imagenDeseleccionada;
    }
    @Override
    public BufferedImage getImagenSeleccionada() {
        return imagenSeleccionada;
    }

    @Override
    public BufferedImage getImagenOcupado() {
        return imagenOcupada;
    }

    @Override
    public String toString() {
        return super.getFila()+super.getColumna();
    }

    @Override
    public void setColumna(int columna) {
        super.setColumna(columna);
    }

    @Override
    public void setFila(String fila) {
        super.setFila(fila);
    }
}
