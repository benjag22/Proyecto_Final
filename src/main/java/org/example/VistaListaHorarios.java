package org.example;

import org.example.Ciudades;
import org.example.Horario;
import org.example.VistaHorario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VistaListaHorarios extends JPanel {
    private List<VistaHorario> listaHorarios;
    private int elementosPorPagina = 5;
    private int paginaActual = 1;
    private JButton btnPaginaAnterior;
    private JButton btnPaginaSiguiente;

    public VistaListaHorarios(int cantidad) {
        listaHorarios = new ArrayList<>();

        btnPaginaAnterior = new JButton("<< Anterior");
        btnPaginaSiguiente = new JButton("Siguiente >>");

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnPaginaAnterior);
        panelBotones.add(btnPaginaSiguiente);

        setLayout(new BorderLayout());
        cargarHorarios(cantidad);
        actualizarInterfaz();

        btnPaginaAnterior.addActionListener(e -> cambiarPagina(-1));
        btnPaginaSiguiente.addActionListener(e -> cambiarPagina(1));

        add(panelBotones, BorderLayout.SOUTH);
    }
    private void cargarHorarios(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Horario horarioRandom = Horario.generarHorarioAleatorio();
            VistaHorario vistaHorario = new VistaHorario(horarioRandom, Ciudades.CONCEPCION.getNombre(), Ciudades.SANTIAGO.getNombre());
            listaHorarios.add(vistaHorario);
        }
    }

    private void actualizarInterfaz() {
        removeAll();
        int inicio = (paginaActual - 1) * elementosPorPagina;
        int fin = Math.min(inicio + elementosPorPagina, listaHorarios.size());
        setLayout(new GridLayout(0, 1));
        for (VistaHorario vistaHorario : listaHorarios.subList(inicio, fin)) {
            add(vistaHorario);
        }
        revalidate();
        repaint();
    }

    private void cambiarPagina(int cambio) {
        int totalPaginas = (int) Math.ceil((double) listaHorarios.size() / elementosPorPagina);
        paginaActual = Math.min(Math.max(1, paginaActual + cambio), totalPaginas);
        actualizarInterfaz();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Título del Marco Principal");
            VistaListaHorarios vistaListaHorarios = new VistaListaHorarios(25);
            frame.add(vistaListaHorarios);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}