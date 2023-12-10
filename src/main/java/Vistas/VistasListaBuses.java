package Vistas;

import ClasesLogicas.AsientoCama;
import ClasesLogicas.AsientoSemiCama;
import ClasesLogicas.BusDosPisos;
import ClasesLogicas.BusUnPiso;
import java.util.ArrayList;

/**
 * Clase que proporciona vista de buses para la interfaz gráfica.
 */

public class VistasListaBuses {
    ArrayList<VistaBus> listaVistaBuses;

    /**
     * Constructor de la clase VistasListaBuses.
     * Inicializa la lista de vistas de buses y crea instancias de VistaBus con diferentes
     * configuraciones, tipos de asientos, cantidades de asientos y pisos
     */

    public VistasListaBuses(){
        listaVistaBuses= new ArrayList<>();

        VistaBus busUnPiso1 = new VistaBus( new BusUnPiso());
        busUnPiso1.agregarAsientos(new AsientoCama(),1);

        VistaBus busUnPiso2 = new VistaBus( new BusUnPiso());
        busUnPiso2.agregarAsientos(new AsientoCama(),2);

        VistaBus busDosPisos1 = new VistaBus(new BusDosPisos());
        busDosPisos1.agregarAsientos(new AsientoSemiCama(),1);
        busDosPisos1.agregarAsientos(new AsientoCama(),2);

        VistaBus busDosPisos2 = new VistaBus(new BusDosPisos());
        busDosPisos2.agregarAsientos(new AsientoCama(),1);
        busDosPisos2.agregarAsientos(new AsientoCama(),2);

        VistaBus busDosPisos3 = new VistaBus(new BusDosPisos());
        busDosPisos3.agregarAsientos(new AsientoSemiCama(),2);
        busDosPisos3.agregarAsientos(new AsientoCama(),2);

        VistaBus busDosPisos4 = new VistaBus(new BusDosPisos());
        busDosPisos4.agregarAsientos(new AsientoCama(),2);
        busDosPisos4.agregarAsientos(new AsientoCama(),2);

        listaVistaBuses.add(busUnPiso1);
        listaVistaBuses.add(busUnPiso2);
        listaVistaBuses.add(busDosPisos1);
        listaVistaBuses.add(busDosPisos2);
        listaVistaBuses.add(busDosPisos3);
        listaVistaBuses.add(busDosPisos3);

    }

    /**
     * GetBus: Obtiene una vista de bus aleatoria de la lista
     * @param random Dato aleatorio para seleccionar vista bus.
     * @return VistaBus seleccionada aleatoriamente.
     */

    public VistaBus getBus(int random) {
        VistaBus busSeleccionado = listaVistaBuses.get(random);
        return busSeleccionado;
    }
}
