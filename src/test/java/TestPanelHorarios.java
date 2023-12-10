import Paneles.PanelHorarios;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

/**
 * Clase Test para PanelHorarios.
 */

public class TestPanelHorarios {

    /**
     * Prueba el método "cargarNuevosHorarios" del PanelHorarios.
     * Verifica que las listas de horarios y botones asociados no sean nulas y
     * que no estén vacías después de cargar nuevos horarios.
     */

    @Test
    public void testCargarNuevosHorarios() {
        PanelHorarios panelHorarios = new PanelHorarios("CiudadOrigen","CiudadDestino",LocalDate.now());

        assertNotNull(panelHorarios.getListaHorariosdepanel());
        assertNotNull(panelHorarios.getListaBotonesAsociado());
        assertFalse(panelHorarios.getListaHorariosdepanel().getListaHorarios().isEmpty());
        assertFalse(panelHorarios.getListaBotonesAsociado().isEmpty());
    }
}