package modelo;

import java.util.Objects;

public class Estudiante implements Comparable<Estudiante> {
    private String codigo;
    private String nombre;
    private double promedio;

    public Estudiante(String codigo, String nombre, double promedio) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Codigo vacio");
        }
        if (promedio < 0.0 || promedio > 100.0) {
            throw new IllegalArgumentException("Promedio fuera de rango 0-100");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }

    @Override
    public int compareTo(Estudiante otro) {
        int porPromedio = Double.compare(otro.promedio, this.promedio);
        if (porPromedio != 0) return porPromedio;
        return this.codigo.compareTo(otro.codigo); // desempate estable
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        return codigo.equals(((Estudiante) o).codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return String.format("#%s %s (%.1f)", codigo, nombre, promedio);
    }
}