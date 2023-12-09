import ClasesLogicas.AsientoCama;
import ClasesLogicas.Bus;
import ClasesLogicas.BusUnPiso;
import Vistas.VistaBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VistaBusTest {

    private VistaBus vistaBus;
    private Bus bus;

    @BeforeEach
    void setUp() {
        BusUnPiso bus= new BusUnPiso();
        vistaBus = new VistaBus(bus);
    }

    @Test
    void testCambiarPagina() {
        JPanel seatingArea = vistaBus;
        JPanel pagina1 = new JPanel();
        JPanel pagina2 = new JPanel();
        seatingArea.add(pagina1, "1");
        seatingArea.add(pagina2, "2");
        assertEquals("1", ((CardLayout) seatingArea.getLayout()).getHgap());
        assertEquals("2", ((CardLayout) seatingArea.getLayout()).getHgap());
        assertEquals("2", ((CardLayout) seatingArea.getLayout()).getHgap());
    }
}
