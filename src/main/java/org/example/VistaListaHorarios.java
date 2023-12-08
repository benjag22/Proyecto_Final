package org.example;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class VistaListaHorarios extends JPanel {
    private ArrayList<VistaHorario> listaHorarios;

    public VistaListaHorarios(int cantidad) {
        listaHorarios = new ArrayList<>();
        setLayout(new GridLayout(cantidad, 1));
        cargarHorarios(cantidad);
        setPreferredSize(new Dimension(1000, cantidad * 150));
    }

    private void cargarHorarios(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Horario horarioRandom = Horario.generarHorarioAleatorio();
            VistaHorario vistaHorario = new VistaHorario(horarioRandom, Ciudades.CONCEPCION.getNombre(), Ciudades.SANTIAGO.getNombre(),horarioRandom.getLocalDate());
            listaHorarios.add(vistaHorario);
            add(vistaHorario);
        }
    }

    public ArrayList<VistaHorario> getListaHorarios() {
        return listaHorarios;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Título del Marco Principal");
            VistaListaHorarios vistaListaHorarios = new VistaListaHorarios(10);
            frame.add(vistaListaHorarios);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}