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
    @Override
    public void añadirAsientosPiso1(int cantidadAsientosCama, int cantidadAsientosSemicama) {
        for(int i=1;i<=cantidadAsientosCama;i++){
            listaAsientosPiso1.add(new AsientoSemiCama("A",i));
        }
        for(int i=1;i<=cantidadAsientosCama;i++){
            listaAsientosPiso1.add(new AsientoSemiCama("A",i));
        }
    }
}
