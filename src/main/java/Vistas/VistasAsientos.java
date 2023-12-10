package Vistas;
import ClasesLogicas.Asiento;
import ClasesLogicas.AsientoClickListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Vista de los asientos de la interfaz gráfica, representado solo con imagenes y seleccionado, deleseleccionado y ocupado
 */

public class VistasAsientos extends JPanel {
    private Asiento asiento;
    private BufferedImage imagenOriginal;
    private BufferedImage imagenPresionada;
    private BufferedImage imagenOcupado;
    private boolean presionada = false;
    private double precio;
    private AsientoClickListener listener;

    /**
     * Constructor inicializa las propiedades del asiento en la vista grafica
     * le establece la dimension de la imagen
     * y añade la logica del listener para seleccionar y deseleccionar
     * ademas notificar al observador si es seleccionado el asiento
     * @param asiento Asiento asociado a la vista.
     */

    public VistasAsientos(Asiento asiento) {
        this.asiento = asiento;
        this.precio=0.0;
        this.imagenOriginal = asiento.getImagenDeseleccionada();
        this.imagenPresionada = asiento.getImagenSeleccionada();
        this.imagenOcupado = asiento.getImagenOcupado();
        setPreferredSize(new Dimension(imagenOriginal.getWidth(), imagenOriginal.getHeight()));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                presionada = !presionada;
                repaint();

                if (listener != null) {
                    listener.onAsientoClick(); // Notificar al oyente(funciona como observador)
                }
            }
        });

    }

    /**
     * Paint: Pinta la imagen dependiendo de si es presionada o no el asiento grafico, ademas establece el precio
     * si es que es presionado o no, para representar el valor actual de la seleccion en PanelDatosBus
     * @param g Para pintar el componente.
     */

    public void paint(Graphics g) {
        super.paint(g);
        if (presionada) {
            g.drawImage(imagenPresionada,0,0, this);
            this.precio=asiento.getPrecio();
        } else {
            g.drawImage(imagenOriginal,0,0, this);
            this.precio=0;
        }
    }

    /**
     * getAsiento: Obtiene el asiento asociado a la vista.
     * @return Asiento asociado.
     */

    public Asiento getAsiento() {
        return asiento;
    }

    /**
     * isPresionada: Verifica si vista asiento está presionada.
     * mas que nada para ver todos los asientos presionados para volverlos ocupado al comprar
     * @return true si está presionada, false si no.
     */

    public boolean isPresionada() {
        return presionada;
    }

    /**
     * setAsientoCliclListener: Establece el oyente de clic asiento.
     *(principalmente para cuando el asiento es comprado)
     * @param listener Oyente evento clic.
     */

    public void setAsientoClickListener(AsientoClickListener listener) {
        this.listener = listener;
    }

    /**
     * cambiarAsientoOCupado: Cambia el estado del asiento a ocupado desde el observador
     *
     */

    public void cambiarAsientoOCupado() {
        this.imagenOriginal = this.imagenOcupado;
        this.imagenPresionada = this.imagenOcupado;
        this.precio = 0.0;
        this.presionada=false;
        setEnabled(false);
        repaint();
    }
}

