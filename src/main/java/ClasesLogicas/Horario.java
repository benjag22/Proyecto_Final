package ClasesLogicas;
import java.time.LocalTime;
import java.util.Random;

/**
 * Clase que representa un horario de salida y llegada.
 */

public class Horario {
    private LocalTime horaInicio;
    private LocalTime horaFin;

    /**
     * Constructor de la clase Horario.
     * Inicializa las horas con el valor mínimo de LocalTime.
     */

    public Horario() {
        this.horaInicio = LocalTime.MIN;
        this.horaFin = LocalTime.MIN;
    }

    /**
     * getHoraInicio: Obtiene la hora de inicio.
     *
     * @return La hora de inicio.
     */

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * getHoraFin: Obtiene la hora de fin.
     *
     * @return La hora de fin.
     */

    public LocalTime getHoraFin() {
        return horaFin;
    }

    /**
     * generarHorarioAleatorio: Genera un horario aleatorio.
     *
     * @return Un objeto Horario con horas aleatorias.
     */

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

    /**
     * toString: String del objeto Horario.
     *
     * @return String del horario.
     */

    @Override
    public String toString() {
        return "Salida del bus: " + horaInicio.toString() + ", " + "Llegada del bus:" + horaFin.toString();
    }
}
