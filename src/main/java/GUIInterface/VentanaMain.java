package GUIInterface;

import javax.swing.*;

/*Nota: No funciona el programa si lo corres desde este main
*Hay que correrlo desde el main que se encuentra en PanelPrincipal.java
 */
public class VentanaMain extends JFrame {
    public static void main (String[] args){
        MusicaFondo.reproducirMusicaFondo("main/java/resources/Fondo.wav");
        JFrame frame = new JFrame();
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        frame.setTitle("Venta de pasajes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
}
