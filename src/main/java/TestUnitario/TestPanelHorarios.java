package TestUnitario;

import GUIInterface.PanelHorarios;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestPanelHorarios {

    @Test
    public void testCargarNuevosHorarios() {
        PanelHorarios panelHorarios = new PanelHorarios();
        panelHorarios.cargarNuevosHorarios("CiudadOrigen", "CiudadDestino", LocalDate.now());

        assertNotNull(panelHorarios.getListaHorariosdepanel());
        assertNotNull(panelHorarios.getListaBotonesAsociado());
        assertFalse(panelHorarios.getListaHorariosdepanel().getListaHorarios().isEmpty());
        assertFalse(panelHorarios.getListaBotonesAsociado().isEmpty());
    }
}