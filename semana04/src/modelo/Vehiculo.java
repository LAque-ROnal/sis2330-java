package modelo;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected double velocidadMax;

    public Vehiculo(String marca, String modelo, double velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMax = velocidadMax;
    }

    public abstract String describir();

    @Override
    public String toString() {
        return describir();
    }
}