package Paneles;

import ClasesLogicas.Ciudades;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Panel que permite seleccionar el origen, destino y fecha.
 */

public class PanelDestinoIda extends JPanel implements ItemListener {
    private BufferedImage imagen;
    private JLabel Seleccionar;
    private String seleccion_origen;
    private String seleccion_destino;
    private JTextField Fecha;
    private Clip clipMouseOver;
    private Clip clipClick;
    private JComboBox Origen;
    private JComboBox Destino;
    private String Org;
    private String Dest;

    /**
     * Constructor del PanelDestinoIda.
     */

    public PanelDestinoIda(){
        cargarSonidos();
        this.setLayout(null);
        setPreferredSize(new Dimension(1920,1080));
        String basePath = new File("").getAbsolutePath();
        this.imagen = cargarImagen(basePath + "/src/Main/java/Recursos/Fondo2.png");

        Font font = new Font("Mongolian Baiti",Font.PLAIN,30);
        Seleccionar = new JLabel("Seleccionar Horario");
        Seleccionar.setFont(font);
        Seleccionar.setBounds(650,150,1000,50);
        Seleccionar.setForeground(Color.BLACK);
        add(Seleccionar);

        Origen = new JComboBox();
        Origen.addItemListener(this);
        Org = "Elija su Origen";
        Origen.addItem(Org);
        for (Ciudades ciudad : Ciudades.values()) {
            Origen.addItem(ciudad.getNombre());
        }

        Origen.setBounds(430,300,300,50);
        add(Origen);

        Destino = new JComboBox();
        Destino.addItemListener(this);
        Dest = "Elija su Destino";
        Destino.addItem(Dest);
        for (Ciudades ciudad : Ciudades.values()) {
            Destino.addItem(ciudad.getNombre());
        }
        Destino.setBounds(830,300,300,50);
        add(Destino);

        Fecha = new JTextField("dd-mm-yyyy");
        Fecha.setFont(font);
        Fecha.setBounds(670,450,250,50);
        add(Fecha);
    }

    /**
     * cargarImagen: Carga una imagen.
     *
     * @param ruta Ruta del archivo.
     * @return Imagen cargada.
     */

    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * paintComponent: Sobrescribe el método paintComponent de JPanel para personalizar la apariencia del panel.
     * @param g El contexto gráfico en el que se va a pintar.
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(imagen != null){
            g.drawImage(imagen, 0, 0, 1920, 1080, this);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == Origen) {
            seleccion_origen = Origen.getSelectedItem().toString();
        } else if (e.getSource() == Destino) {
            seleccion_destino = Destino.getSelectedItem().toString();
        }
    }

    /**
     * aceptar: Verifica si la selección de origen y destino es válida.
     *
     * @return True si la selección es válida, False sino.
     */

    public boolean aceptar(){
        return !seleccion_origen.equals(seleccion_destino);
    }

    /**
     * getSeleccion_origen: Obtiene la ciudad origen.
     *
     * @return Ciudad de origen seleccionada.
     */

    public String getSeleccion_origen() {
        return seleccion_origen;
    }

    /**
     * getSeleccion_destino: Obtiene la ciudad destino.
     *
     * @return Ciudad de destino seleccionada.
     */

    public String getSeleccion_destino() {
        return seleccion_destino;
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
     *
     * @param clip Sonido a reproducir.
     */

    private void reproducirSonido(Clip clip) {
        if (clip != null) {
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }

    /**
     * getFecha: Obtiene campo de texto de fecha.
     *
     * @return Campo de texto de fecha.
     */

    public JTextField getFecha() {
        return Fecha;
    }

    /**
     * getOrigenComboBox: Obtiene el JComboBox de origen.
     *
     * @return JComboBox de origen.
     */

    public JComboBox getOrigenComboBox() {
        return Origen;
    }

    /**
     * getDestinoComboBox: Obtiene el JComboBox de destino.
     *
     * @return JComboBox de destino.
     */

    public JComboBox getDestinoComboBox() {
        return Destino;
    }

    /**
     * getOrg: Obtiene el String de origen.
     *
     * @return String de origen.
     */

    public String getOrg() {
        return Org;
    }

    /**
     * getDest: Obtiene el String de destino.
     *
     * @return String de destino.
     */

    public String getDest() {
        return Dest;
    }
}
