package ClasesLogicas;

/**
 * Interfaz para manejar eventos de click de Asiento para seleccionar,deseleccionar y al momento de comprar los asientos
 * sigue el principio del patron de diseño "Observer"
 */

public interface AsientoClickListener {

    /**
     * onAsientoClick: Cuando se hace clic en un asiento.
     */

    void onAsientoClick();

    /**
     * contarTotal: Contar el total de asientos seleccionados.
     */

    void contarTotal();
}
