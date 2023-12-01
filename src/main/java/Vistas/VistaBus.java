package Vistas;
import javax.swing.*;
import org.example.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VistaBus extends JPanel {
    private Bus bus;
    private ArrayList<VistasAsientos>listaAsientos;
    private BuilderCorridasAsientos builder;
    public VistaBus(Bus bus,BuilderCorridasAsientos builder){
        super();
        this.bus=bus;
        listaAsientos = new ArrayList<>();
        this.builder = builder;
    }

   /* @Override
    public void paint(Graphics g) {
        super.paint(g);
        int index = 0;
        if(!listaAsientos.isEmpty() && listaAsientos.get(0).getAsiento() instanceof AsientoCama) {
            for(int i=1; i<=builder.getFilas()*builder.getColumnas();i++){
                listaAsientos.get(index++).paint(g);
            }
        }else if(!listaAsientos.isEmpty() && listaAsientos.get(0).getAsiento() instanceof AsientoSemiCama){
            for(int i=1; i<=builder.getFilas()*builder.getColumnas();i++){
                listaAsientos.get(index++).paint(g);
            }
        }
    }*/
   public void agregarAsientos(Asiento asiento, int cualCorridaAsiento) {
       if (bus.getPisos() == 1) {
           if (cualCorridaAsiento == 1) {
               builder.agregarCorridaAsientosNormal(asiento);
           } else if (cualCorridaAsiento == 2) {
               builder.agregarCorridaAsientosReducido(asiento);
           }
       } else if (bus.getPisos() == 2) {
           if (cualCorridaAsiento == 1) {
               builder.agregarCorridaAsientosNormal(asiento);
           } else if (cualCorridaAsiento == 2) {
               builder.agregarCorridaAsientosReducido(asiento);
           }
       }
       listaAsientos.clear();
       listaAsientos.addAll(builder.getListaVistaAsientos());
   }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BuilderCorridasAsientos builder = new BuilderCorridasAsientos();
            VistaBus vistaBus = new VistaBus(new BusDosPisos(), builder);
            vistaBus.agregarAsientos(new AsientoCama("A", 1), 1);
            JFrame frame = new JFrame("VistaBus Test");
            frame.setSize(1920, 1080);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(vistaBus);
            frame.setContentPane(mainPanel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

