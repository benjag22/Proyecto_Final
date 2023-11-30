package org.example;

import org.example.Ciudades;
import org.example.Horario;
import org.example.VistaHorario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VistaListaHorarios extends JPanel {
    private ArrayList<VistaHorario> listaHorarios;

    public VistaListaHorarios(int cantidad) {
        listaHorarios = new ArrayList<>();
        Horario horarioRandom = Horario.generarHorarioAleatorio();
        for(int i=0;i<cantidad;i++){
            listaHorarios.add(new VistaHorario(horarioRandom, Ciudades.CONCEPCION.getNombre(), Ciudades.SANTIAGO.getNombre()));
        }
        setLayout(new BorderLayout());
        cargarHorarios(cantidad);

    }
    private void cargarHorarios(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Horario horarioRandom = Horario.generarHorarioAleatorio();
            VistaHorario vistaHorario = new VistaHorario(horarioRandom, Ciudades.CONCEPCION.getNombre(), Ciudades.SANTIAGO.getNombre());
            listaHorarios.add(vistaHorario);
            setLayout(new GridLayout(0,1));
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