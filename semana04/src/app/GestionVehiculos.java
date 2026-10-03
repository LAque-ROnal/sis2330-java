package app;

import modelo.*;
import java.util.ArrayList;

public class GestionVehiculos {
    public static void main(String[] args) {
        ArrayList<Vehiculo> flota = new ArrayList<>();
        flota.add(new Auto("Toyota", "Corolla", 180, 4));
        flota.add(new Moto("Honda", "CB500", 200, false));
        flota.add(new Camion("Volvo", "FH16", 130, 25.0));
        flota.add(new AutoElectrico("Tesla", "Model 3", 225, 4));

        for (Vehiculo v : flota) {
            System.out.println(v.describir());
            if (v instanceof Electrico e) {
                e.cargarBateria();
                System.out.println("-> bateria cargada");
            }
        }
    }
}