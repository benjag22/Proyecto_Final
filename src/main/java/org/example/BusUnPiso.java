package org.example;

import java.util.ArrayList;
import java.util.List;

public class BusUnPiso extends Bus {
    private List<Asiento> listaAsientosPiso1;

    public BusUnPiso() {
        super();
        listaAsientosPiso1 = new ArrayList<>();
    }

    @Override
    public List<Asiento> getListaAsientos() {
        return new ArrayList<>(listaAsientosPiso1);
    }
}
