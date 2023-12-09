package ClasesLogicas;
import java.time.LocalTime;
import java.util.Random;

public class Horario {
    private LocalTime horaInicio;
    private LocalTime horaFin;
    public Horario() {
        this.horaInicio = LocalTime.MIN;  // Inicializa con el valor mínimo de LocalTime
        this.horaFin = LocalTime.MIN;     // Inicializa con el valor mínimo de LocalTime
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
        Horario horarioGenerado = new Horario();
        horarioGenerado.horaInicio = horarioInicio;
        horarioGenerado.horaFin = horarioFin;

        return horarioGenerado;
    }
    @Override
    public String toString() {
        return "Salida del bus: " + horaInicio.toString() + ", " + "Llegada del bus:" + horaFin.toString();
    }
}
