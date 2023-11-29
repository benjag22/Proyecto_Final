package org.example;
import java.awt.GraphicsEnvironment;

public class ListaFuentesFONT {
    public static void main(String[] args) {
        String[] nombresFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        System.out.println("Fuentes disponibles en el sistema:");
        for (String nombreFuente : nombresFuentes) {
            System.out.println(nombreFuente);
        }
    }
}