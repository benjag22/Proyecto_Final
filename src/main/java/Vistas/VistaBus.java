package Vistas;

import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class VistaBus extends JPanel{

    private Bus bus;
    private JPanel seatingArea;
    private CardLayout cardLayout;
    private ArrayList<VistasAsientos> listaAsientos;
    private int filas;
    private int columnas;
    private int paginaActual = 1;
    private double precioTotal;

    public VistaBus(Bus bus) {
        this.precioTotal=0.0;
        this.bus = bus;
        listaAsientos = new ArrayList<>();
        seatingArea = new JPanel();
        cardLayout = new CardLayout();
        seatingArea.setLayout(cardLayout);
        if(bus.getPisos()==2) {
            JButton btnPaginaAnterior = new JButton("<< Anterior");
            btnPaginaAnterior.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cambiarPagina(-1);
                }
            });

            JButton btnPaginaSiguiente = new JButton("Siguiente >>");
            btnPaginaSiguiente.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cambiarPagina(1);
                }
            });

            JPanel navigationPanel = new JPanel();
            navigationPanel.add(btnPaginaAnterior);
            navigationPanel.add(btnPaginaSiguiente);

            setLayout(new BorderLayout());
            add(seatingArea, BorderLayout.CENTER);
            add(navigationPanel, BorderLayout.SOUTH);
        } else {
            setLayout(new BorderLayout());
            add(seatingArea, BorderLayout.CENTER);
        }
    }
    private void cambiarPagina(int delta) {
        paginaActual += delta;
        if (paginaActual < 1) {
            paginaActual = 1;
        } else if (paginaActual > seatingArea.getComponentCount()) {
            paginaActual = seatingArea.getComponentCount();
        }
        cardLayout.show(seatingArea, String.valueOf(paginaActual));
    }
    public void agregarAsientos(Asiento asiento, int cual) {
        this.filas = obtenerFilas(cual);
        this.columnas = obtenerColumnas(cual);

        JPanel paginaPanel = new JPanel(new BorderLayout());
        JPanel asientoPanelSur = new JPanel(new GridLayout(columnas/2, filas));
        JPanel asientoPanelNorte = new JPanel(new GridLayout(columnas/2, filas));

        for (int i = 1; i <= columnas; i++) {
            for (int j = 1; j <= filas; j++) {
                char letra = (char) ('A' + i - 1);
                Asiento nuevoAsiento = crearNuevoAsiento(asiento, letra, j);
                VistasAsientos vistanuevoAsiento = new VistasAsientos(nuevoAsiento);
                listaAsientos.add(vistanuevoAsiento);
                if (i % 2 == 0) {
                    asientoPanelNorte.add(vistanuevoAsiento);
                } else {
                    asientoPanelSur.add(vistanuevoAsiento);
                }
            }
        }
        paginaPanel.add(asientoPanelSur, BorderLayout.NORTH);
        paginaPanel.add(asientoPanelNorte, BorderLayout.SOUTH);
        cardLayout.show(seatingArea, String.valueOf(seatingArea.getComponentCount()));
        if(bus.getPisos()==2){
          paginaActual++;
        }
        seatingArea.add(paginaPanel, String.valueOf(seatingArea.getComponentCount() + 1));
    }

    private int obtenerFilas(int tipoAsiento) {
        return (tipoAsiento == 1) ? CantidadesAsientoPisos.PISONORMAL.getFILAS() : CantidadesAsientoPisos.PISOREDUCIDO.getFILAS();
    }

    private int obtenerColumnas(int tipoAsiento) {
        return (tipoAsiento == 1) ? CantidadesAsientoPisos.PISONORMAL.getCOLUMNAS() : CantidadesAsientoPisos.PISOREDUCIDO.getCOLUMNAS();
    }

    public ArrayList<VistasAsientos> getListaAsientos() {
        return listaAsientos;
    }

    private Asiento crearNuevoAsiento(Asiento asiento, char letra, int numero) {
        Asiento nuevoAsiento;
        if (asiento instanceof AsientoCama) {
            nuevoAsiento = new AsientoCama();
        } else {
            nuevoAsiento = new AsientoSemiCama();
        }
        nuevoAsiento.setFila(String.valueOf(letra));
        nuevoAsiento.setColumna(numero);
        return nuevoAsiento;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BusDosPisos bus = new BusDosPisos();
            JFrame frame = new JFrame("VistaBus Test");
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            VistaBus vistaBusDosPisos = new VistaBus(bus);
            AsientoSemiCama asiento1= new AsientoSemiCama();
            AsientoCama asiento2 = new AsientoCama();
            vistaBusDosPisos.agregarAsientos(asiento2,2); /*Aqui agrego 4x14 asientos semicama*/
            vistaBusDosPisos.agregarAsientos(asiento1,1);
            frame.setContentPane(vistaBusDosPisos);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
