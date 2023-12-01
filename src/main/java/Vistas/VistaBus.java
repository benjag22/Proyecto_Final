package Vistas;
import javax.swing.*;
import org.example.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaBus extends JPanel {
    private Bus bus;
    private JButton btnPaginaAnterior;
    private JButton btnPaginaSiguiente;
    private ArrayList<VistasAsientos> listaAsientos;
    private int paginaActual = 1;

    public VistaBus(Bus bus) {
        super();
        this.bus = bus;
        listaAsientos = new ArrayList<>();
        if (bus.getPisos() == 2) {
            btnPaginaAnterior = new JButton("<< Anterior");
            btnPaginaSiguiente = new JButton("Siguiente >>");
            btnPaginaAnterior.addActionListener(e -> cambiarPagina(-1));
            btnPaginaSiguiente.addActionListener(e -> cambiarPagina(1));
        }
    }
    private void cambiarPagina(int delta) {
        paginaActual += delta;
        if (paginaActual < 1) {
            paginaActual = 1;
        } else if (paginaActual > 2) {
            paginaActual = 2;
        }
        limpiarAsientos();
        agregarAsientos(new AsientoCama("A", 1), paginaActual);
    }

    private void limpiarAsientos() {
        removeAll();
        listaAsientos.clear();
    }

   @Override
    public void paint(Graphics g) {
        super.paint(g);

    }
   public void agregarAsientos(Asiento asiento, int cualCorridaAsiento) {
       int filas=0;
       int columnas=0;
       int xposicion;
       int yposicion;
           if (cualCorridaAsiento == 1) {
               filas = CantidadesAsientoPisos.PISONORMAL.getFILAS();
               columnas = CantidadesAsientoPisos.PISONORMAL.getCOLUMNAS();
           } else if (cualCorridaAsiento == 2) {
               filas = CantidadesAsientoPisos.PISOREDUCIDO.getFILAS();
               columnas = CantidadesAsientoPisos.PISOREDUCIDO.getCOLUMNAS();
           }
           if(asiento instanceof AsientoCama){
               xposicion=90;
               yposicion=60;
           }else{
               xposicion=70;
               yposicion=70;
           }
       for (int i = 1; i <= filas; i++) {
           for (int j = 1; j <= columnas; j++) {
               char letra = (char) ('A' + i - 1);
               int x= xposicion*(i - 1);
               int y= yposicion*(j - 1);
               Asiento nuevoAsiento;
               if (asiento instanceof AsientoCama) {
                   nuevoAsiento = new AsientoCama(String.valueOf(letra), j);
               } else {
                   nuevoAsiento = new AsientoSemiCama(String.valueOf(letra), j);
               }
               VistasAsientos vistanuevoAsiento = new VistasAsientos(nuevoAsiento);
               vistanuevoAsiento.setLocation(x, y);
               add(vistanuevoAsiento);
               listaAsientos.add(vistanuevoAsiento);
               }
           }
       }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BusDosPisos bus= new BusDosPisos();
            VistaBus vistaBus = new VistaBus(bus);
            vistaBus.agregarAsientos(new AsientoCama("A", 1), 2);
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

