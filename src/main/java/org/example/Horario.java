package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class Horario {

    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate localDate;

    public Horario() {
        this.horaInicio = LocalTime.MIN;  // Inicializa con el valor mínimo de LocalTime
        this.horaFin = LocalTime.MIN;     // Inicializa con el valor mínimo de LocalTime
        this.localDate = LocalDate.now();
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public static Horario generarHorarioAleatorio() {
        Random random = new Random();

        int horaInicio = random.nextInt(24);
        int minutoInicio = random.nextInt(60);
        LocalTime horarioInicio = LocalTime.of(horaInicio, minutoInicio);

        int horaFin = horaInicio + random.nextInt(24 - horaInicio);
        int minutoFin = random.nextInt(60);
        LocalTime horarioFin = LocalTime.of(horaFin, minutoFin);

        // Crea un nuevo Horario con las horas aleatorias generadas
        Horario horarioGenerado = new Horario();
        horarioGenerado.horaInicio = horarioInicio;
        horarioGenerado.horaFin = horarioFin;

        return horarioGenerado;
    }

    @Override
    public String toString() {
        return "Salida del bus: " + horaInicio.toString() + ", " + "Llegada del bus:" + horaFin.toString();
    }

    public static void main(String[] args) {
        Horario horarioAleatorio = Horario.generarHorarioAleatorio();
        System.out.println("Hora de inicio: " + horarioAleatorio.getHoraInicio());
        System.out.println("Hora de fin: " + horarioAleatorio.getHoraFin());
        System.out.println(horarioAleatorio.getLocalDate());
    }
}
