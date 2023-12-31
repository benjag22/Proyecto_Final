package Vistas;

import ClasesLogicas.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Vista bus en interfaz gráfica, representa en un panel el bus con asientos
 */

public class VistaBus extends JPanel{

    private Bus bus;
    private JPanel seatingArea;
    private CardLayout cardLayout;
    private ArrayList<VistasAsientos> listaAsientos;
    private int filas;
    private int columnas;
    private int paginaActual = 1;

    /**
     * Constructor de la clase VistaBus, dependiendo de que bus sea, inicializa paginas y los ordena mediante un cardlayout
     * @param bus Objeto Bus asociado.
     */

    public VistaBus(Bus bus) {
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

    /**
     * cambiarPagina: Cambia la página actual de asientos si es que el bus es de dos pisos sino no se genera
     * @param delta Para cambiar la página.
     */

    private void cambiarPagina(int delta) {
        paginaActual += delta;
        if (paginaActual < 1) {
            paginaActual = 1;
        } else if (paginaActual > seatingArea.getComponentCount()) {
            paginaActual = seatingArea.getComponentCount();
        }
        cardLayout.show(seatingArea, String.valueOf(paginaActual));
    }

    /**
     * agregarAsientos: Agrega corridas de asientos al bus, con un tipo de asientos y con entero
     * identifica que columnas y filas se crea en el piso del bus, en resumen cantidad y tipo de asiento
     * ademas se agregan la mitad de la corrida a un Gridlayout para que se vea un espacio que represente al pasillo del bus
     * @param asiento Tipo de asiento a agregar.
     * @param cual    Tipo específico de asiento.
     */

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

    /**
     * obtenerFilas: Obtiene el número de filas del enums "CantidadesAsientosPiso"
     * @param tipoAsiento Tipo de asiento.
     * @return Número de filas.
     */

    private int obtenerFilas(int tipoAsiento) {
        return (tipoAsiento == 1) ? CantidadesAsientoPisos.PISONORMAL.getFILAS() : CantidadesAsientoPisos.PISOREDUCIDO.getFILAS();
    }

    /**
     * obtenerColumnas: Obtiene el número de columnas del enums "CantidadesAsientosPiso"
     * @param tipoAsiento Tipo de asiento.
     * @return Número de columnas.
     */

    private int obtenerColumnas(int tipoAsiento) {
        return (tipoAsiento == 1) ? CantidadesAsientoPisos.PISONORMAL.getCOLUMNAS() : CantidadesAsientoPisos.PISOREDUCIDO.getCOLUMNAS();
    }

    /**
     * getListaAsientos: Obtiene la lista de VistaAsientos.
     * @return Lista de VistaAsientos.
     */

    public ArrayList<VistasAsientos> getListaAsientos() {
        return listaAsientos;
    }

    /**
     * crearNuevoAsiento: Crea un nuevo asiento según el tipo de asiento escogigo en agregarAsientos
     *
     * @param asiento Tipo de asiento.
     * @param letra   Letra de la fila.
     * @param numero  Número de la columna.
     * @return Nuevo objeto Asiento.
     */

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
}
