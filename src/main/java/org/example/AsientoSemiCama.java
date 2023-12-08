package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AsientoSemiCama extends Asiento{
    private Boolean habilitado;
    private BufferedImage imagenDeseleccionada;
    private BufferedImage imagenSeleccionada;
    private BufferedImage imagenOcupada;
    private final double precio=15000.0;
    public AsientoSemiCama(){
        super();
        this.imagenDeseleccionada=cargarImagen("src/main/java/resources/asiento_semicama.png");
        this.imagenSeleccionada=cargarImagen("src/main/java/resources/asiento_semicama_elegida.png");
        this.imagenOcupada=cargarImagen("src/main/java/resources/asiento_semicama_ocupado.png");
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void setHabilitado(boolean habilitado){
        this.habilitado=habilitado;
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
    public AsientoSemiCama getThis(){
        return this;
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
