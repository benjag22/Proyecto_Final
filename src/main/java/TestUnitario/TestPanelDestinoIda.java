package TestUnitario;

import Paneles.PanelDestinoIda;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPanelDestinoIda {

    @Test
    public void testAceptar() {
        PanelDestinoIda panelDestinoIda = new PanelDestinoIda();
        panelDestinoIda.getOrigenComboBox().setSelectedItem("CiudadOrigen");
        panelDestinoIda.getDestinoComboBox().setSelectedItem("CiudadDestino");

        assertTrue(panelDestinoIda.aceptar());
    }
}