package Vistas;
import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaBus extends JPanel {

    private Bus bus;
    private JPanel seatingArea;
    private CardLayout cardLayout;
    private ArrayList<VistasAsientos> listaAsientos;
    private int paginaActual = 1;

    public VistaBus(Bus bus) {
        this.bus = bus;
        listaAsientos = new ArrayList<>();
        seatingArea = new JPanel();
        cardLayout = new CardLayout();
        seatingArea.setLayout(cardLayout);

        if (bus.getPisos() == 2) {
            agregarPagina(1);
            agregarPagina(2);
            cardLayout.show(seatingArea, "1");

            JButton btnPaginaAnterior = new JButton("<< Anterior");
            btnPaginaAnterior.addActionListener(e -> cambiarPagina(-1));

            JButton btnPaginaSiguiente = new JButton("Siguiente >>");
            btnPaginaSiguiente.addActionListener(e -> cambiarPagina(1));

            JPanel navigationPanel = new JPanel();
            navigationPanel.add(btnPaginaAnterior);
            navigationPanel.add(btnPaginaSiguiente);

            setLayout(new BorderLayout());
            add(seatingArea, BorderLayout.CENTER);
            add(navigationPanel, BorderLayout.SOUTH);
        }
    }

    private void cambiarPagina(int delta) {
        paginaActual += delta;
        if (paginaActual < 1) {
            paginaActual = 1;
        } else if (paginaActual > 2) {
            paginaActual = 2;
        }
        cardLayout.show(seatingArea, String.valueOf(paginaActual));
    }

    private void agregarPagina(int pagina) {
        JPanel paginaPanel = new JPanel(new BorderLayout());
        JPanel asientoPanel = new JPanel(new GridLayout());
        agregarAsientos(new AsientoCama("A", 1), pagina, asientoPanel);
        JScrollPane scrollPane = new JScrollPane(asientoPanel);
        paginaPanel.add(scrollPane, BorderLayout.CENTER);
        paginaPanel.setName(String.valueOf(pagina));
        seatingArea.add(paginaPanel, String.valueOf(pagina));
        cardLayout.show(seatingArea, String.valueOf(pagina));
    }

    private void agregarAsientos(Asiento asiento, int cualCorridaAsiento,JPanel pagina) {
        int filas = obtenerFilas(cualCorridaAsiento);
        int columnas = obtenerColumnas(cualCorridaAsiento);
        int xposicion = obtenerXPosicion(asiento);
        int yposicion = obtenerYPosicion(asiento);
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                char letra = (char) ('A' + i - 1);
                int x = xposicion * (j - 1);
                int y = yposicion * (i - 1);
                Asiento nuevoAsiento = crearNuevoAsiento(asiento, letra,j);
                VistasAsientos vistanuevoAsiento = new VistasAsientos(nuevoAsiento);
                vistanuevoAsiento.setLocation(x, y);
                pagina.add(vistanuevoAsiento);
                listaAsientos.add(vistanuevoAsiento);
            }
        }
    }


    private int obtenerFilas(int cualCorridaAsiento) {
        return (cualCorridaAsiento == 1) ? CantidadesAsientoPisos.PISONORMAL.getFILAS() : CantidadesAsientoPisos.PISOREDUCIDO.getFILAS();
    }

    private int obtenerColumnas(int cualCorridaAsiento) {
        return (cualCorridaAsiento == 1) ? CantidadesAsientoPisos.PISONORMAL.getCOLUMNAS() : CantidadesAsientoPisos.PISOREDUCIDO.getCOLUMNAS();
    }

    private int obtenerXPosicion(Asiento asiento) {
        return (asiento instanceof AsientoCama) ? 90 : 70;
    }

    private int obtenerYPosicion(Asiento asiento) {
        return (asiento instanceof AsientoCama) ? 70 : 70;
    }

    private Asiento crearNuevoAsiento(Asiento asiento, char letra, int numero) {
        return (asiento instanceof AsientoCama) ? new AsientoCama(String.valueOf(letra), numero) : new AsientoSemiCama(String.valueOf(letra), numero);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BusDosPisos bus = new BusDosPisos();
            JFrame frame = new JFrame("VistaBus Test");
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new VistaBus(bus));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}


