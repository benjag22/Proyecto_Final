import ClasesLogicas.Bus;
import ClasesLogicas.BusUnPiso;
import Vistas.VistaBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase Test para VistaBus
 */

class VistaBusTest {

    private VistaBus vistaBus;
    private Bus bus;

    @BeforeEach
    void setUp() {
        bus = new BusUnPiso();
        vistaBus = new VistaBus(bus);
    }

    /**
     * Prueba la funcionalidad de cambiar de página en VistaBus
     */

    @Test
    void testCambiarPagina() {
        JPanel seatingArea = vistaBus;
        JPanel pagina1 = new JPanel();
        JPanel pagina2 = new JPanel();
        seatingArea.add(pagina1);
        seatingArea.add(pagina2);

        JButton btnSiguiente = findButton(vistaBus, "Siguiente >>");
        System.out.println("btnSiguiente: " + btnSiguiente);

        if (btnSiguiente != null) {
            btnSiguiente.doClick();
            assertEquals(pagina2, seatingArea.getComponent(1));
        }

        JButton btnAnterior = findButton(vistaBus, "<< Anterior");
        if (btnAnterior != null) {
            btnAnterior.doClick();
            assertEquals(pagina1, seatingArea.getComponent(0));
        }
    }

    private JButton findButton(Container container, String buttonText) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof JButton && ((JButton) component).getText().equals(buttonText)) {
                return (JButton) component;
            } else if (component instanceof Container) {
                JButton button = findButton((Container) component, buttonText);
                if (button != null) {
                    return button;
                }
            }
        }
        return null;
    }
}