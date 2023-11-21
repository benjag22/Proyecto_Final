package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AsientoCama extends Asiento{
    private Boolean habilitado;
    private BufferedImage imagen;
    public AsientoCama(String fila, int columna){
        super(fila,columna);
        imagen=cargarImagen("src/main/resources/asiento_cama");
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
    public BufferedImage getImagen() {
        return imagen;
    }
    @Override
    public String toString() {
        return super.getFila()+super.getColumna();
    }
}
