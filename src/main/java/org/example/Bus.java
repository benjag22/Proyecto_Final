package org.example;

import java.time.LocalTime;
import java.util.List;


public abstract class Bus {
    private Horario horario;
    private String Origen_Destino;
    public Bus() {
    }

    public abstract List<Asiento> getListaAsientos();

    public void añadirAsientosPiso2() {

    }

    public void añadirAsientosPiso1() {

    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getOrigen_Destino() {
        return Origen_Destino;
    }

    public void setOrigen_Destino(String origen_Destino) {
        Origen_Destino = origen_Destino;
    }
}

