package TestUnitario;

import GUIInterface.PanelDestinoIda;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
public class TestPanelDestinoIda {

    @Test
    public void testAceptar() {
        PanelDestinoIda panelDestinoIda = new PanelDestinoIda();
        panelDestinoIda.getOrigenComboBox().setSelectedItem("CiudadOrigen");
        panelDestinoIda.getDestinoComboBox().setSelectedItem("CiudadDestino");

        assertTrue(panelDestinoIda.aceptar());
    }

    @Test
    public void testActualizarHorarios() {
        PanelDestinoIda panelDestinoIda = new PanelDestinoIda();
        panelDestinoIda.getOrigenComboBox().setSelectedItem("CiudadOrigen");
        panelDestinoIda.getDestinoComboBox().setSelectedItem("CiudadDestino");

        LocalDate fechaSeleccionada = LocalDate.now();
        panelDestinoIda.getFechaTextField().setText(fechaSeleccionada.toString());

        panelDestinoIda.actualizarHorarios();

        assertNotNull(panelDestinoIda.getPanelHorarios());
        assertNotNull(panelDestinoIda.getPanelHorarios().getListaHorariosdepanel());
        assertFalse(panelDestinoIda.getPanelHorarios().getListaHorariosdepanel().getListaHorarios().isEmpty());
    }
}