package org.example;

import java.time.LocalTime;
import java.util.List;


public abstract class Bus {
    public Bus() {
    }

    public abstract List<Asiento> getListaAsientos();

    public void añadirAsientosPiso2() {

    }

    public void añadirAsientosPiso1() {

    }
    public abstract int getPisos();
}

