package org.example;

import java.util.ArrayList;
import java.util.List;

public class BusDosPisos extends Bus {
    private ArrayList<Asiento> listaAsientosPiso1;
    private ArrayList<Asiento> listaAsientosPiso2;

    public BusDosPisos() {
        super();
        listaAsientosPiso1 = new ArrayList<>();
        listaAsientosPiso2 = new ArrayList<>();
    }

    @Override
    public List<Asiento> getListaAsientos() {
        List<Asiento> listaTotalAsientos = new ArrayList<>(listaAsientosPiso1);
        listaTotalAsientos.addAll(listaAsientosPiso2);
        return listaTotalAsientos;
    }
}
