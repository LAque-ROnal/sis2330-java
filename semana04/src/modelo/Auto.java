package modelo;

public class Auto extends Vehiculo {
    protected int numPuertas;

    public Auto(String marca, String modelo, double velocidadMax, int numPuertas) {
        super(marca, modelo, velocidadMax);
        this.numPuertas = numPuertas;
    }

    @Override
    public String describir() {
        return "Auto " + marca + " " + modelo + ", " + numPuertas + " puertas, max "
                + velocidadMax + " km/h";
    }
}