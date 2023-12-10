package Paneles;

import ClasesLogicas.AsientoClickListener;
import Vistas.VistaBus;
import Vistas.VistasAsientos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

/**
 * Panel que muestra la información del bus.
 */

public class PanelDatosBus extends JPanel implements AsientoClickListener {
    private String origen;
    private String destino;
    private JButton comprar;
    private VistaBus busAsociado;
    private LocalTime horaInicioAsociada;
    private LocalTime horaFinAsociada;
    private double precioAsientos;
    private double precioIVA;
    private double precioTotal;

    /**
     * Constructor del PanelDatosBus, asocia el listener de cada VistaBus asociado, se encarga de anular o no el listener
     * de cada asiento seleccionado y comprado, implementa el observer
     *
     * @param busAsociado        Vista del bus al que está asociado.
     * @param horaInicioAsociada Hora de inicio asociada.
     * @param horaFinAsociada    Hora de llegada asociada.
     * @param origen             Ciudad de origen.
     * @param destino            Ciudad de destino.
     */

    public PanelDatosBus(VistaBus busAsociado, LocalTime horaInicioAsociada, LocalTime horaFinAsociada, String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
        this.busAsociado = busAsociado;
        this.horaInicioAsociada=horaInicioAsociada;
        this.horaFinAsociada=horaFinAsociada;
        this.precioAsientos = 0;
        this.precioTotal=0;
        this.precioIVA=0;
        setLayout(new BorderLayout());

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        comprar = new JButton("Comprar");
        comprar.setPreferredSize(new Dimension(200, 80));

        panelBoton.add(comprar);
        panelBoton.setLocation(1000,250);
        add(panelBoton);
        setPreferredSize(new Dimension(1920, 380));
        for (VistasAsientos asiento : busAsociado.getListaAsientos()) {
            asiento.setAsientoClickListener(this);
        }
        comprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (VistasAsientos asiento : busAsociado.getListaAsientos()) {
                    if (asiento.isPresionada()) {
                        asiento.cambiarAsientoOCupado();
                        asiento.setAsientoClickListener(null);
                        precioAsientos=0.0;
                        precioIVA=0.0;
                        repaint();
                    }
                }
            }
        });
    }

    /**
     * AsientoClickListener: Se llama cuando se hace clic en un asiento.
     * Actualiza el total y repinta la vista.
     */

    @Override
    public void onAsientoClick() {
        contarTotal();
        repaint();
    }

    /**
     * paint: Sobrescribe el método paint de la clase JPanel para personalizar la apariencia del panel de datos del bus.
     * ademas de mostrar el precio total con y sin iva durante la seleccion
     * @param g El contexto gráfico en el que se va a pintar.
     */

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        BufferedImage imagenAsientoNocupadoReferencial = cargarImagen("src/main/java/Recursos/asiento_semicama.png");
        BufferedImage imagenAsientoSeleccionadoReferencial = cargarImagen("src/main/java/Recursos/asiento_semicama_elegida.png");
        BufferedImage imagenAsientoOcupadoReferencial = cargarImagen("src/main/java/Recursos/asiento_semicama_ocupado.png");
        BufferedImage imagenAsiento2NocupadoReferencial = cargarImagen("src/main/java/Recursos/asiento_cama.png");
        BufferedImage imagenAsiento2SeleccionadoReferencial = cargarImagen("src/main/java/Recursos/asiento_cama_elegido.png");
        BufferedImage imagenAsientoOcupado2Referencial = cargarImagen("src/main/java/Recursos/asiento_cama_ocupado.png");
        Font fuente = new Font("Impact", Font.PLAIN , 20);
        g.setFont(fuente);
        g.setColor(Color.BLACK);
        g.drawString("Hora de inicio: " +horaInicioAsociada, 45, 65);
        g.drawString("Hora de llegada: " + horaFinAsociada, 45, 160);
        g.drawString("Origen: "+origen,380,65);
        g.drawString("Destino: "+destino,380,160);
        g.drawRect(360,0,0,400);
        g.drawRect(600,0,0,400);
        g.drawRect(950,0,0,400);
        g.drawString("Asiento Desocupado",1080,115);
        g.drawString("Asiento Seleccionado",1085,187);
        g.drawString("Asiento Ocupado",1088,257);
        g.drawImage(imagenAsientoNocupadoReferencial,1010,87,this);
        g.drawImage(imagenAsientoSeleccionadoReferencial,1010,159,this);
        g.drawImage(imagenAsientoOcupadoReferencial,1010,229,this);
        g.drawImage(imagenAsiento2NocupadoReferencial,1280,87,this);
        g.drawImage(imagenAsiento2SeleccionadoReferencial,1280,159,this);
        g.drawImage(imagenAsientoOcupado2Referencial,1280,229,this);
        g.drawString("Precio Asientos: "+precioAsientos,630,50);
        g.drawString("Precio IVA : "+precioIVA,630,100);
        g.drawString("Precio total con impuestos : "+precioTotal,630,150);

    }

    /**
     * contarTotal: Cuenta el total de los asientos seleccionados.
     */

    public void contarTotal() {
        this.precioAsientos = 0;
        this.precioIVA = 0;
        this.precioTotal = 0;
        for (VistasAsientos vistasAsientoAsicoaida : busAsociado.getListaAsientos()) {
            if (vistasAsientoAsicoaida.isPresionada()) {
                this.precioAsientos += vistasAsientoAsicoaida.getAsiento().getPrecio();
            }
        }
        this.precioIVA = this.precioAsientos * 0.19;
        this.precioTotal = this.precioAsientos + this.precioIVA;
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
     * setHoraInicioAsociada: Establece la hora de inicio asociada.
     *
     * @param horaInicioAsociada Nueva hora de inicio.
     */

    public void setHoraInicioAsociada(LocalTime horaInicioAsociada) {
        this.horaInicioAsociada = horaInicioAsociada;
    }

    /**
     * setHoraFinAsociada: Establece la hora de llegada asociada.
     *
     * @param horaFinAsociada Nueva hora de llegada.
     */

    public void setHoraFinAsociada(LocalTime horaFinAsociada) {
        this.horaFinAsociada = horaFinAsociada;
    }

    /**
     * getBotonCompra: Obtiene el botón de compra.
     *
     * @return Botón de compra.
     */

    public JButton getBotonCompra() {
        return comprar;
    }

    /**
     * getPrecioTotal: Obtiene el precio total de la compra.
     *
     * @return precio total.
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * setPrecioTotal: Establece el precio total.
     * @param precioTotal El precio total a establecer.
     */

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
