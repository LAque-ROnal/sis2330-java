package modelo;

public class Tarea {
    private static int siguienteId = 1;

    private final int id;
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.id = siguienteId++;
        setDescripcion(descripcion);
        this.completada = false;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("La descripcion no puede estar vacia");
        }
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void marcarCompletada() {
        this.completada = true;
    }

    @Override
    public String toString() {
        String estado = completada ? "[X]" : "[ ]";
        return estado + " (" + id + ") " + descripcion;
    }
}