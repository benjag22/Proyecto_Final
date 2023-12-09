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
    private ArrayList<PanelEleccionAsientos> listapanelEleccion;
    private boolean verdad=false;

    public PanelPrincipal(){
        listapanelHorario = new ArrayList<>();
        listapanelEleccion = new ArrayList<>();
        this.addMouseListener(this);
        atras = new JButton("Regresar");
        atras.addMouseListener(this);

        compra = new PanelCompra();
        compra.setVisible(true);


        cargarSonidos();

        destinoIda = compra.getPanelDestinoIda();
        destinoIda.setVisible(false);
        ActionListener horaselec = e -> {
            if(destinoIda.aceptar()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                try {
                    fechalocal = LocalDate.parse(destinoIda.getFecha().getText(), formatter);
                } catch (Exception f) {
                    System.out.println("Error");
                }
                if (listapanelHorario.isEmpty()) {
                    System.out.println("estas en listapanelHorario.isempty");
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
                    System.out.println("se removio el horario anterior(sigue en la lista de horarios)");
                    for (int i = 0; i < listapanelHorario.size(); i++) {
                        PanelHorarios panelHorarios = listapanelHorario.get(i);
                        System.out.println("buscamos por un panelhorario");
                        System.out.println(fechalocal);
                        if (fechalocal.equals(panelHorarios.getFecha())) {
                            System.out.println("encontramos el mismo panel horario de antes");
                            horarios = panelHorarios;
                            horarios.setVisible(true);
                            for (int z = 0; z < horarios.getListaBotonesAsociado().size(); z++) {
                                horarios.getListaBotonesAsociado().get(z).addMouseListener(this);
                            }
                            add(horarios);
                            horarios.setLocation(0, 0);
                            destinoIda.setVisible(false);
                            break;
                        }
                        else{
                            System.out.println("no encontramos ninguna fecha igual a alguna de la lista de paneles horarios, asi que crearemos un nuevo panelhorario");
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
                }
            }
            else{
                System.out.println("No se puede viajar desde tu ciudad a tu misma ciudad tontito");
            }
        };
        destinoIda.getFecha().addActionListener(horaselec);

        compra.getComprarAsiento().addMouseListener(this);
        setPreferredSize(new Dimension(1920,1080));
        add(compra);
        add(destinoIda);



    }

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
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getLocationOnScreen());
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
                    eleccionAsientos.getPanelDatos().setHoraInicioAsociada((horarios.getListaHorariosdepanel().getListaHorarios().get(i).getHorario().getHoraInicio()));
                    eleccionAsientos.getPanelDatos().setHoraFinAsociada(horarios.getListaHorariosdepanel().getListaHorarios().get(i).getHorario().getHoraFin());
                    revalidate();
                    repaint();
                    System.out.println("en que boton hize click ?:" + boton.getText());

                }
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
    /*
        public static void main (String[] args){
            MusicaFondo.reproducirMusicaFondo("main/java/resources/Fondo.wav");
            JFrame frame = new JFrame();
            PanelPrincipal panelPrincipal = new PanelPrincipal();
            frame.add(panelPrincipal);
            frame.setTitle("Venta de pasajes");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(1500,1020);
            frame.setVisible(true);
        }

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

    private void reproducirSonido(Clip clip) {
        if (clip != null) {
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }
}
