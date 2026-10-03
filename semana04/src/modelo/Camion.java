package modelo;

public class Camion extends Vehiculo {
    private double capacidadToneladas;

    public Camion(String marca, String modelo, double velocidadMax, double capacidadToneladas) {
        super(marca, modelo, velocidadMax);
        this.capacidadToneladas = capacidadToneladas;
    }

    @Override
    public String describir() {
        return "Camion " + marca + " " + modelo + ", capacidad " + capacidadToneladas
                + "t, max " + velocidadMax + " km/h";
    }
}