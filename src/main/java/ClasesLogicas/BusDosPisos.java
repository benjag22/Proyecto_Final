package ClasesLogicas;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un autobús de dos pisos.
 */

public class BusDosPisos extends Bus {
    private ArrayList<Asiento> listaAsientosPiso1;
    private ArrayList<Asiento> listaAsientosPiso2;
    private final int pisos=2;

    /**
     * Constructor de la clase BusDosPisos.
     */

    public BusDosPisos() {
        super();
        listaAsientosPiso1 = new ArrayList<>();
        listaAsientosPiso2 = new ArrayList<>();
    }

    /**
     * getPisos: Obtiene el número de pisos del autobús.
     *
     * @return El número de pisos del autobús.
     */

    @Override
    public int getPisos() {
        return pisos;
    }
}