import modelo.Estudiante;
import servicio.SistemaEstudiantes;

public class Principal {
    public static void main(String[] args) {
        SistemaEstudiantes sistema = new SistemaEstudiantes();
        sistema.registrar(new Estudiante("E1", "Ana", 70.0));
        sistema.registrar(new Estudiante("E2", "Luis", 95.0));
        sistema.registrar(new Estudiante("E3", "Zoe", 80.0));

        System.out.println("Ranking:");
        for (Estudiante e : sistema.listarRanking()) {
            System.out.println("  " + e);
        }
    }
}