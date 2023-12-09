package TestUnitario;

import Paneles.PanelHorarios;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class TestPanelHorarios {

    @Test
    public void testCargarNuevosHorarios() {
        PanelHorarios panelHorarios = new PanelHorarios("CiudadOrigen","CiudadDestino",LocalDate.now());

        assertNotNull(panelHorarios.getListaHorariosdepanel());
        assertNotNull(panelHorarios.getListaBotonesAsociado());
        assertFalse(panelHorarios.getListaHorariosdepanel().getListaHorarios().isEmpty());
        assertFalse(panelHorarios.getListaBotonesAsociado().isEmpty());
    }
}