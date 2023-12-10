package ClasesLogicas;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un autobús de un piso.
 */

public class BusUnPiso extends Bus {
    private List<Asiento> listaAsientosPiso1;
    private final int pisos=1;

    /**
     * Constructor de la clase BusUnPiso.
     */

    public BusUnPiso() {
        super();
        listaAsientosPiso1 = new ArrayList<>();

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
