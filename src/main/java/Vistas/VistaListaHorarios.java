package Vistas;
import ClasesLogicas.Horario;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class VistaListaHorarios extends JPanel {
    private ArrayList<VistaHorario> listaHorarios;

    public VistaListaHorarios(int cantidad, String origen, String destino, LocalDate fecha) {
        listaHorarios = new ArrayList<>();
        setLayout(new GridLayout(cantidad, 1));
        cargarHorarios(cantidad,origen, destino, fecha);
        setPreferredSize(new Dimension(1000, cantidad * 150));
    }
    private void cargarHorarios(int cantidad,String origen, String destino, LocalDate fecha) {
        for (int i = 0; i < cantidad; i++) {
            Horario horarioRandom = Horario.generarHorarioAleatorio();
            VistaHorario vistaHorario = new VistaHorario(horarioRandom, origen, destino,fecha);
            listaHorarios.add(vistaHorario);
            add(vistaHorario);
        }
    }
    public ArrayList<VistaHorario> getListaHorarios() {
        return listaHorarios;
    }
}