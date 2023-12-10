import Paneles.PanelDestinoIda;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase Test para PanelDestinoIda.
 */

public class TestPanelDestinoIda {

    /**
     * Prueba el método "aceptar" del PanelDestinoIda.
     * Selecciona ciudades de origen y destino y verifica
     * que el método aceptar retorne "true".
     */

    @Test
    public void testAceptar() {
        PanelDestinoIda panelDestinoIda = new PanelDestinoIda();
        panelDestinoIda.getOrigenComboBox().setSelectedItem("CiudadOrigen");
        panelDestinoIda.getDestinoComboBox().setSelectedItem("CiudadDestino");

        assertTrue(panelDestinoIda.aceptar());
    }
}