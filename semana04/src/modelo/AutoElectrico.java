package modelo;

public class AutoElectrico extends Auto implements Electrico {
    private int nivelBateria;

    public AutoElectrico(String marca, String modelo, double velocidadMax, int numPuertas) {
        super(marca, modelo, velocidadMax, numPuertas);
        this.nivelBateria = 0;
    }

    @Override
    public void cargarBateria() {
        nivelBateria = 100;
    }

    @Override
    public String describir() {
        return super.describir() + " [electrico, bateria: " + nivelBateria + "%]";
    }
}