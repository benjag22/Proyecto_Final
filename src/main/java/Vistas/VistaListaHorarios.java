package Vistas;
import ClasesLogicas.Horario;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Vista lista de horarios en interfaz gráfica.
 */

public class VistaListaHorarios extends JPanel {
    private ArrayList<VistaHorario> listaHorarios;

    /**
     * Constructor de la clase VistaListaHorarios.
     *
     * @param cantidad Cantidad de horarios a mostrar en la lista.
     * @param origen Ciudad de origen.
     * @param destino Ciudad de destino.
     * @param fecha Fecha de los horarios.
     */

    public VistaListaHorarios(int cantidad, String origen, String destino, LocalDate fecha) {
        listaHorarios = new ArrayList<>();
        setLayout(new GridLayout(cantidad, 1));
        cargarHorarios(cantidad,origen, destino, fecha);
        setPreferredSize(new Dimension(1000, cantidad * 150));
    }

    /**
     * cargarHorarios: Carga los horarios aleatorios en la lista de horarios.
     *
     * @param cantidad Cantidad de horarios a cargar.
     * @param origen Ciudad de origen.
     * @param destino Ciudad de destino.
     * @param fecha Fecha de los horarios.
     */

    private void cargarHorarios(int cantidad,String origen, String destino, LocalDate fecha) {
        for (int i = 0; i < cantidad; i++) {
            Horario horarioRandom = Horario.generarHorarioAleatorio();
            VistaHorario vistaHorario = new VistaHorario(horarioRandom, origen, destino,fecha);
            listaHorarios.add(vistaHorario);
            add(vistaHorario);
        }
    }

    /**
     * getListaHorarios: Obtiene la lista de horarios.
     *
     * @return Lista de horarios.
     */

    public ArrayList<VistaHorario> getListaHorarios() {
        return listaHorarios;
    }
}