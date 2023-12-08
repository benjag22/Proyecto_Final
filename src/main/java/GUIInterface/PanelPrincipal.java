package GUIInterface;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PanelPrincipal extends JPanel implements MouseListener {

    private PanelCompra compra;
    private Clip clipMouseOver;
    private Clip clipClick;
    private PanelHorarios horarios;
    private PanelDestinoIda destinoIda;
    private PanelEleccionAsientos eleccionAsientos;
    private JButton atras;
    private LocalDate fechalocal;

    public PanelPrincipal(){
        this.addMouseListener(this);
        atras = new JButton("Regresar");
        atras.addMouseListener(this);

        compra = new PanelCompra();
        compra.setVisible(true);
        cargarSonidos();

        destinoIda = compra.getPanelDestinoIda();
        destinoIda.setVisible(false);

        horarios = destinoIda.getPanelHorarios();
        horarios.setVisible(false);

        eleccionAsientos = horarios.getPanelEleccion();
        eleccionAsientos.setVisible(false);

        ActionListener horaselec = e -> {
            if(destinoIda.aceptar()) {
                for(int i=0;i<horarios.getListaHorariosdepanel().getListaHorarios().size();i++){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    try {
                        fechalocal = LocalDate.parse(destinoIda.getFecha().getText(), formatter);
                    }
                    catch(Exception f) {
                        System.out.println("Error");
                    }
                    horarios.getListaHorariosdepanel().getListaHorarios().get(i).setFecha(fechalocal);
                }
                destinoIda.setVisible(false);
                horarios.actualizarHorarios(destinoIda.getSeleccion_origen(),destinoIda.getSeleccion_destino(),fechalocal);
                horarios.setVisible(true);
            }
            else{
                System.out.println("No se puede viajar desde tu ciudad a tu misma ciudad tontito");
            }
        };
        destinoIda.getFecha().addActionListener(horaselec);

        compra.getComprarAsiento().addMouseListener(this);
        for(int i=0;i<horarios.getListaBotonesAsociado().size();i++) {
            horarios.getListaBotonesAsociado().get(i).addMouseListener(this);
        }
        setPreferredSize(new Dimension(1920,1080));
        add(compra);
        add(destinoIda);
        add(horarios);
        add(eleccionAsientos);


    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        destinoIda.setLocation(0,0);
        compra.setLocation(0,0);
        horarios.setLocation(0,0);
        eleccionAsientos.setLocation(0,0);


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
        for (JButton boton : horarios.getListaBotonesAsociado()) {
            if (e.getComponent() == boton) {
                horarios.setVisible(false);
                eleccionAsientos.setVisible(true);
                revalidate();
                repaint();
                System.out.println("en que boton hize click ?:"+boton.getText());
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
            String audioFileMouseOverPath = "src/main/java/resources/Sobre.wav";
            String audioFileClickPath = "src/main/java/resources/Click.wav";

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
