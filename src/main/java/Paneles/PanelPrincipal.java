package Paneles;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * PanelPrincipal es la clase principal que gestiona la interfaz gráfica.
 */

public class PanelPrincipal extends JPanel implements MouseListener {

    private PanelCompra compra;
    private Clip clipMouseOver;
    private Clip clipClick;
    private PanelHorarios horarios;
    private PanelDestinoIda destinoIda;
    private PanelEleccionAsientos eleccionAsientos;
    private JButton atras;
    private LocalDate fechalocal;
    private ArrayList<PanelHorarios> listapanelHorario;
    private JButton botonCompra;
    private PanelDatosBus datosBus;
    private String origen;
    private String destino;
    private Boolean horarioEncontrado = false;

    /**
     * Constructor de PanelPrincipal.
     */

    public PanelPrincipal() {
        listapanelHorario = new ArrayList<>();
        this.addMouseListener(this);
        atras = new JButton("Regresar");
        atras.addMouseListener(this);

        compra = new PanelCompra();
        compra.setVisible(true);

        cargarSonidos();

        destinoIda = compra.getPanelDestinoIda();
        destinoIda.setVisible(false);
        ActionListener horaselec = e -> {
            if (destinoIda.aceptar()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                origen = destinoIda.getSeleccion_origen();
                destino = destinoIda.getSeleccion_destino();
                try {
                    fechalocal = LocalDate.parse(destinoIda.getFecha().getText(), formatter);
                } catch (Exception f) {
                    fechalocal=null;
                }
                if (fechalocal != null && !origen.equals(destinoIda.getOrg()) && !destino.equals(destinoIda.getDest())) {
                    if (listapanelHorario.isEmpty()) {
                        horarios = new PanelHorarios(destinoIda.getSeleccion_origen(), destinoIda.getSeleccion_destino(), fechalocal);
                        horarios.setVisible(false);
                        for (int i = 0; i < horarios.getListaBotonesAsociado().size(); i++) {
                            horarios.getListaBotonesAsociado().get(i).addMouseListener(this);
                        }
                        destinoIda.setVisible(false);
                        horarios.setVisible(true);
                        add(horarios);
                        horarios.setLocation(0, 0);
                        listapanelHorario.add(horarios);
                    } else {
                        remove(horarios);
                        horarioEncontrado = false;

                        for (PanelHorarios panelHorarios : listapanelHorario) {
                            System.out.println(fechalocal);

                            if (fechalocal.equals(panelHorarios.getFecha()) &&
                                    origen.equals(panelHorarios.getOrigen()) &&
                                    destino.equals(panelHorarios.getDestino())) {

                                horarios = panelHorarios;
                                horarios.setVisible(true);

                                for (int z = 0; z < horarios.getListaBotonesAsociado().size(); z++) {
                                    horarios.getListaBotonesAsociado().get(z).addMouseListener(this);
                                }

                                add(horarios);
                                horarios.setLocation(0, 0);
                                destinoIda.setVisible(false);
                                horarioEncontrado = true;
                                break;
                            }
                        }

                        if (!horarioEncontrado) {

                            horarios = new PanelHorarios(destinoIda.getSeleccion_origen(), destinoIda.getSeleccion_destino(), fechalocal);
                            horarios.setVisible(false);

                            for (int z = 0; z < horarios.getListaBotonesAsociado().size(); z++) {
                                horarios.getListaBotonesAsociado().get(z).addMouseListener(this);
                            }

                            destinoIda.setVisible(false);
                            horarios.setVisible(true);
                            add(horarios);
                            horarios.setLocation(0, 0);
                            listapanelHorario.add(horarios);
                        }
                    }
                } else {
                    JOptionPane.showConfirmDialog(null,"Verifique que la seleccion de origen,destino o la fecha ingresada sean correctas","Error en alguna seleccion",JOptionPane.DEFAULT_OPTION);
                }
            }
        };

        destinoIda.getFecha().addActionListener(horaselec);
        compra.getComprarAsiento().addMouseListener(this);
        setPreferredSize(new Dimension(1920, 1080));
        add(compra);
        add(destinoIda);
    }

    /**
     * paintComponent: Sobrescribe el método paintComponent de JPanel para personalizar la apariencia del panel.
     * @param g El contexto gráfico en el que se va a pintar.
     */

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        destinoIda.setLocation(0,0);
        compra.setLocation(0,0);


        if(compra.isVisible()){
            compra.paintComponent(g);

        }

        else if(destinoIda.isVisible()){
            destinoIda.add(atras);
            atras.setBounds(1350,650,150,50);
            destinoIda.paintComponent(g);

        }

        else if(horarios.isVisible()){
            horarios.add(atras);
            atras.setBounds(1350,650,150,50);
            horarios.paintComponent(g);

        }
        else if(eleccionAsientos.isVisible()){
            eleccionAsientos.add(atras);
            atras.setBounds(1350,650,150,50);
            eleccionAsientos.paint(g);
            eleccionAsientos.setLocation(0,0);

        }
    }

    /**
     * mouseClicked: Maneja eventos de clic del ratón.
     * @param e Evento de ratón.
     */

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent() == atras){
            if(destinoIda.isVisible()){
                compra.setVisible(true);
                destinoIda.setVisible(false);
                revalidate();
                repaint();
            }
            else if(horarios.isVisible()){
                destinoIda.setVisible(true);
                horarios.setVisible(false);
                revalidate();
                repaint();
            }
            else if(eleccionAsientos.isVisible()){
                horarios.setVisible(true);
                eleccionAsientos.setVisible(false);
                revalidate();
                repaint();
            }
        }
        else if (e.getComponent() == compra.getComprarAsiento()) {
            compra.setVisible(false);
            destinoIda.setVisible(true);
            revalidate();
            repaint();
        }
        else if(horarios.isVisible()) {
            for (int i=0;i<horarios.getListaBotonesAsociado().size();i++) {
                JButton boton =horarios.getListaBotonesAsociado().get(i);
                if (e.getComponent() == boton) {
                    horarios.setVisible(false);
                    eleccionAsientos = horarios.getListaEleccionAsientos().get(i);
                    add(eleccionAsientos);
                    eleccionAsientos.setVisible(true);
                    datosBus = eleccionAsientos.getPanelDatos();
                    datosBus.setHoraInicioAsociada((horarios.getListaHorariosdepanel().getListaHorarios().get(i).getHorario().getHoraInicio()));
                    datosBus.setHoraFinAsociada(horarios.getListaHorariosdepanel().getListaHorarios().get(i).getHorario().getHoraFin());
                    botonCompra = eleccionAsientos.getComprar();
                    botonCompra.addMouseListener(this);
                    revalidate();
                    repaint();
                }
            }
        }else if (e.getComponent() == botonCompra) {
            if(datosBus.getPrecioTotal()!=0) {
                JOptionPane.showConfirmDialog(null, "Pasaje comprado exitosamente!", "Compra Exitosa", JOptionPane.DEFAULT_OPTION);
                eleccionAsientos.setVisible(false);
                compra.setVisible(true);
                datosBus.setPrecioTotal(0.0);
                revalidate();
                repaint();
            }
            else{
                JOptionPane.showConfirmDialog(null, "No has seleccionado ningun pasaje ", "Error de compra", JOptionPane.DEFAULT_OPTION);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
     * cargarSonidos: Carga los archivos de sonido para los eventos de mouse.
     */

    private void cargarSonidos() {
        try {
            String audioFileMouseOverPath = "src/main/java/Recursos/Sobre.wav";
            String audioFileClickPath = "src/main/java/Recursos/Click.wav";

            AudioInputStream audioStreamMouseOver = AudioSystem.getAudioInputStream(new File(audioFileMouseOverPath));
            clipMouseOver = AudioSystem.getClip();
            clipMouseOver.open(audioStreamMouseOver);

            AudioInputStream audioStreamClick = AudioSystem.getAudioInputStream(new File(audioFileClickPath));
            clipClick = AudioSystem.getClip();
            clipClick.open(audioStreamClick);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * reproducirSonido: Reproduce el sonido especificado.
     * @param clip Sonido a reproducir.
     */

    private void reproducirSonido(Clip clip) {
        if (clip != null) {
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }
}
