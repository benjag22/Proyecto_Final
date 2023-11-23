package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AsientoCama extends Asiento{
    private Boolean habilitado;
    private BufferedImage imagenDeseleccionada;
    private BufferedImage imagenSeleccionada;
    public AsientoCama(String fila, int columna){
        super(fila,columna);
        imagenDeseleccionada = cargarImagen("src/main/resources/asiento_cama.png");
        imagenSeleccionada = cargarImagen("src/main/resources/asiento_cama_elegido.png");
    }
    @Override
    public void setHabilitado(boolean habilitado) {
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
    public String toString() {
        return super.getFila()+super.getColumna();
    }
    public AsientoCama getThis(){
        return this;
    }
}
