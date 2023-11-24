package org.example;

import java.time.LocalTime;
import java.util.Random;
import java.time.LocalDate;
public class Horario {

    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate localDate;

    public Horario(LocalTime horaInicio, LocalTime horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.localDate=LocalDate.now();
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

        return new Horario(horarioInicio, horarioFin);
    }

    @Override
    public String toString() {
        return "Salida del bus: "+horaInicio.toString()+","+"Llegada del bus:"+horaFin.toString();
    }

    public static void main(String[] args) {
        Horario horarioAleatorio = Horario.generarHorarioAleatorio();
        System.out.println("Hora de inicio: " + horarioAleatorio.getHoraInicio());
        System.out.println("Hora de fin: " + horarioAleatorio.getHoraFin());
        System.out.println(horarioAleatorio.getLocalDate());
    }
}
