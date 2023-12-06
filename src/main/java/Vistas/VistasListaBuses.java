package Vistas;

import org.example.AsientoCama;
import org.example.AsientoSemiCama;
import org.example.BusDosPisos;
import org.example.BusUnPiso;

import java.util.ArrayList;
public class VistasListaBuses {
    ArrayList<VistaBus> listaVistaBuses;
    public VistasListaBuses(){
        listaVistaBuses= new ArrayList<>();
        VistaBus busUnPiso1 = new VistaBus( new BusUnPiso());
        busUnPiso1.agregarAsientos(new AsientoSemiCama(),1);

        VistaBus busUnPiso2 = new VistaBus( new BusUnPiso());
        busUnPiso2.agregarAsientos(new AsientoSemiCama(),2);

        VistaBus busUnPiso3 = new VistaBus( new BusUnPiso());
        busUnPiso3.agregarAsientos(new AsientoCama(),1);

        VistaBus busUnPiso4 = new VistaBus( new BusUnPiso());
        busUnPiso4.agregarAsientos(new AsientoCama(),2);

        VistaBus busDosPisos1 = new VistaBus(new BusDosPisos());
        busDosPisos1.agregarAsientos(new AsientoSemiCama(),1);
        busDosPisos1.agregarAsientos(new AsientoCama(),2);

        VistaBus busDosPisos2 = new VistaBus(new BusDosPisos());
        busDosPisos2.agregarAsientos(new AsientoCama(),1);
        busDosPisos2.agregarAsientos(new AsientoCama(),2);

        VistaBus busDosPisos3 = new VistaBus(new BusDosPisos());
        busDosPisos3.agregarAsientos(new AsientoSemiCama(),1);
        busDosPisos3.agregarAsientos(new AsientoSemiCama(),1);

        VistaBus busDosPisos4 = new VistaBus(new BusDosPisos());
        busDosPisos4.agregarAsientos(new AsientoCama(),2);
        busDosPisos4.agregarAsientos(new AsientoCama(),2);
        listaVistaBuses.add(busUnPiso1);
        listaVistaBuses.add(busUnPiso2);
        listaVistaBuses.add(busUnPiso3);
        listaVistaBuses.add(busUnPiso4);
        listaVistaBuses.add(busDosPisos1);
        listaVistaBuses.add(busDosPisos2);
        listaVistaBuses.add(busDosPisos3);
        listaVistaBuses.add(busDosPisos4);
    }
public VistaBus getBus(int random){
        return listaVistaBuses.get(random);
}
}
