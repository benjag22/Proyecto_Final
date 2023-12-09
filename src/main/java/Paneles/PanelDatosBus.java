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
                    }
                }
            }
        });
    }

    @Override
    public void onAsientoClick() {
        contarTotal();
        repaint();
    }
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
        int x=40;
        int y=50;
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
    private BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void setHoraInicioAsociada(LocalTime horaInicioAsociada) {
        this.horaInicioAsociada = horaInicioAsociada;
    }

    public void setHoraFinAsociada(LocalTime horaFinAsociada) {
        this.horaFinAsociada = horaFinAsociada;
    }
}
