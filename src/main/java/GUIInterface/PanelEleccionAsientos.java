package GUIInterface;
import Vistas.VistaBus;
import Vistas.VistasListaBuses;
import Vistas.vistaDatosBus;
import org.example.Horario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class PanelEleccionAsientos extends JPanel implements MouseListener {
    VistasListaBuses listaBuses = new VistasListaBuses();
    VistaBus busAsociado;
    vistaDatosBus panelDatos;
    JLabel origenAsociado;
    JLabel destinoAsociado;

    /*De esta clase ira acompañada con un panel de detalles y total de compra que incluye vista bus
     * se inicializaran varias en panelHorariosr*/

    public PanelEleccionAsientos(int randomBus, Horario horario,String origen, String destino) {
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.busAsociado = listaBuses.getBus(randomBus);
        origenAsociado= new JLabel(origen);
        destinoAsociado = new JLabel(destino);
        this.addMouseListener(this);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // BoxLayout con eje Y para que se ordene

        JPanel panelInterno = new JPanel(new BorderLayout());
        panelDatos = new vistaDatosBus(busAsociado,horario.getHoraInicio(),horario.getHoraFin(),origen,destino);

        panelInterno.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelDatos.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        panelInterno.add(busAsociado, BorderLayout.CENTER);
        panelInterno.add(panelDatos,BorderLayout.SOUTH);
        add(panelInterno);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
}
