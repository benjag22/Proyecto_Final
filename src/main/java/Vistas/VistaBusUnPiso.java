package Vistas;

import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaBusUnPiso extends JPanel {

    private JPanel seatingArea;
    private CardLayout cardLayout;
    private ArrayList<VistasAsientos> listaAsientos;
    private int filas;
    private int columnas;

    public VistaBusUnPiso(BusUnPiso bus) {
        listaAsientos = new ArrayList<>();
        seatingArea = new JPanel();
        cardLayout = new CardLayout();
        seatingArea.setLayout(cardLayout);
        setLayout(new BorderLayout());
        add(seatingArea, BorderLayout.CENTER);
    }

    public void agregarTipoCorrida(Asiento asiento, int cual) {
        this.filas = obtenerFilas(cual);
        this.columnas = obtenerColumnas(asiento);

        JPanel paginaPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();

        JPanel asientoPanel = new JPanel(new GridLayout(columnas/2, filas));
        JPanel asientoPanel2 = new JPanel(new GridLayout(columnas/2, filas));

        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                char letra = (char) ('A' + i - 1);
                Asiento nuevoAsiento = crearNuevoAsiento(asiento, letra, j);
                VistasAsientos vistanuevoAsiento = new VistasAsientos(nuevoAsiento);
                listaAsientos.add(vistanuevoAsiento);

                // Alternar entre agregar a asientoPanel y asientoPanel2
                if (j % 2 == 0) {
                    asientoPanel.add(vistanuevoAsiento);
                } else {
                    asientoPanel2.add(vistanuevoAsiento);
                }
            }
        }
        paginaPanel.add(asientoPanel, BorderLayout.NORTH);
        paginaPanel.add(asientoPanel2, BorderLayout.SOUTH);
        scrollPane.setViewportView(paginaPanel);
        seatingArea.add(scrollPane, String.valueOf(seatingArea.getComponentCount() + 1));
        cardLayout.show(seatingArea, String.valueOf(seatingArea.getComponentCount()));
    }

    private int obtenerFilas(int tipoAsiento) {
        return (tipoAsiento == 1) ? CantidadesAsientoPisos.PISONORMAL.getFILAS() : CantidadesAsientoPisos.PISOREDUCIDO.getFILAS();
    }

    private int obtenerColumnas(Asiento asiento) {
        return (asiento instanceof AsientoCama) ? CantidadesAsientoPisos.PISONORMAL.getCOLUMNAS() : CantidadesAsientoPisos.PISOREDUCIDO.getCOLUMNAS();
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
            BusUnPiso bus = new BusUnPiso();
            JFrame frame = new JFrame("VistaBusUnPiso Test");
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            VistaBusUnPiso vistaBusUnPiso = new VistaBusUnPiso(bus);
            frame.setContentPane(vistaBusUnPiso);
            AsientoSemiCama asiento1 = new AsientoSemiCama();
            vistaBusUnPiso.agregarTipoCorrida(asiento1, 1); /* Aquí agrego asientos según el tipo y cantidad especificados */

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
