package ClasesLogicas;

import java.util.ArrayList;
import java.util.List;

public class BusUnPiso extends Bus {
    private List<Asiento> listaAsientosPiso1;
    private final int pisos=1;
    public BusUnPiso() {
        super();
        listaAsientosPiso1 = new ArrayList<>();

    }
    @Override
    public int getPisos() {
        return pisos;
    }
}
