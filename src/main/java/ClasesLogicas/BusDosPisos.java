package ClasesLogicas;

import java.util.ArrayList;
import java.util.List;

public class BusDosPisos extends Bus {
    private ArrayList<Asiento> listaAsientosPiso1;
    private ArrayList<Asiento> listaAsientosPiso2;
    private final int pisos=2;

    public BusDosPisos() {
        super();
        listaAsientosPiso1 = new ArrayList<>();
        listaAsientosPiso2 = new ArrayList<>();
    }

    @Override
    public int getPisos() {
        return pisos;
    }
}