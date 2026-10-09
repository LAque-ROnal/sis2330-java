package servicio;

import modelo.Estudiante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class SistemaEstudiantes {
    private HashMap<String, Estudiante> porCodigo;
    private TreeSet<Estudiante> ranking;

    public SistemaEstudiantes() {
        this.porCodigo = new HashMap<>();
        this.ranking = new TreeSet<>();
    }

    public boolean registrar(Estudiante e) {
        if (porCodigo.containsKey(e.getCodigo())) return false;
        porCodigo.put(e.getCodigo(), e);
        ranking.add(e);
        return true;
    }

    public Estudiante buscarPorCodigo(String codigo) {
        return porCodigo.get(codigo);
    }

    public boolean actualizarPromedio(String codigo, double nuevoPromedio) {
        Estudiante e = porCodigo.get(codigo);
        if (e == null) return false;
        ranking.remove(e);
        e.setPromedio(nuevoPromedio);
        ranking.add(e);
        return true;
    }

    public ArrayList<Estudiante> listarRanking() {
        return new ArrayList<>(ranking);
    }

    public ArrayList<Estudiante> topN(int n) {
        ArrayList<Estudiante> top = new ArrayList<>();
        int i = 0;
        for (Estudiante e : ranking) {
            if (i >= n) break;
            top.add(e);
            i++;
        }
        return top;
    }

    public boolean eliminar(String codigo) {
        Estudiante e = porCodigo.remove(codigo);
        if (e == null) return false;
        ranking.remove(e);
        return true;
    }

    public int cantidad() {
        return porCodigo.size();
    }
}