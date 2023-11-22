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
    @Override
    public void añadirAsientosPiso1(int cantidadAsientosCama, int cantidadAsientosSemicama) {
        for(int i=1;i<=cantidadAsientosCama;i++){
            listaAsientosPiso1.add(new AsientoCama("A",i));
        }
        for(int i=1;i<=cantidadAsientosSemicama;i++){
            listaAsientosPiso1.add(new AsientoSemiCama("A",i));
        }
    }
    public void añadirAsientosPiso2(int cantidadAsientosCama, int cantidadAsientosSemicama) {
        for(int i=1;i<=cantidadAsientosCama;i++){
            listaAsientosPiso1.add(new AsientoCama("A",i));
        }
        for(int i=1;i<=cantidadAsientosSemicama;i++){
            listaAsientosPiso1.add(new AsientoSemiCama("A",i));
        }
    }
}