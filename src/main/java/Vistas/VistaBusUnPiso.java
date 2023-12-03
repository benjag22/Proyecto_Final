package Vistas;

import org.example.*;

import javax.swing.*;

public class VistaBusUnPiso extends JPanel {
    public VistaBusUnPiso(BusUnPiso bus){
super();
    }
    public void agregarTipoCorrida(Asiento asiento, int cual){

    }
    private int obtenerColumnas(Asiento asiento) {
        return (asiento instanceof AsientoCama) ? CantidadesAsientoPisos.PISONORMAL.getCOLUMNAS() : CantidadesAsientoPisos.PISOREDUCIDO.getCOLUMNAS();
    }

    private Asiento crearNuevoAsiento(Asiento asiento, char letra, int numero) {
        return (asiento instanceof AsientoCama) ? new AsientoCama(String.valueOf(letra), numero) : new AsientoSemiCama(String.valueOf(letra), numero);
    }
    private int obtenerXPosicion(Asiento asiento) {
        return (asiento instanceof AsientoCama) ? 90 : 60;
    }
    private int obtenerYPosicion(Asiento asiento) {
        return (asiento instanceof AsientoCama) ? 70 : 70;
    }
}
