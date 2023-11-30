package Vistas;
import javax.swing.*;
import org.example.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VistaBus extends JPanel {
    private Bus bus;
    private List<VistasAsientos>listaAsientos;
    private BuilderCorridasAsientos builder;
    public VistaBus(Bus bus,BuilderCorridasAsientos builder){
        super();
        this.bus=bus;
        listaAsientos = new ArrayList<>();
        this.builder = builder;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        builder.paint(g);
    }

    public void agregarAsientos(Asiento asiento, int cualCorridaAsiento){
        if(bus.getPisos()==1){
            bus=new BusUnPiso();
            if(cualCorridaAsiento==1){
              builder.dibujarCorridaAsientosNormal(asiento);
            }else if(cualCorridaAsiento==2){
              builder.dibujarCorridaAsientosReducido(asiento);
            }
        }else if(bus.getPisos()==2){
            bus=new BusDosPisos();
            if(cualCorridaAsiento==1){
                builder.dibujarCorridaAsientosNormal(asiento);
            }else if(cualCorridaAsiento==2){
                builder.dibujarCorridaAsientosReducido(asiento);
            }
        }
        repaint();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BuilderCorridasAsientos builder = new BuilderCorridasAsientos();
            BusDosPisos bus1 = new BusDosPisos();
            VistaBus bus1Vista = new VistaBus(bus1, builder);
            builder.add(bus1Vista);
            builder.setVisible(true);
            bus1Vista.agregarAsientos(new AsientoCama("A", 1), 1);
        });
    }
}
