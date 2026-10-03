import servicio.SistemaEstudiantes;
import modelo.Estudiante;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        SistemaEstudiantes sistema = new SistemaEstudiantes();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1.Registrar 2.Buscar 3.Actualizar 4.Ranking 5.Top N 6.Salir 7.Eliminar");
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Codigo: ");
                    String cod = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Promedio: ");
                    double prom = Double.parseDouble(sc.nextLine());
                    boolean ok = sistema.registrar(new Estudiante(cod, nom, prom));
                    System.out.println(ok ? "Registrado" : "Codigo duplicado");
                    break;
                case 2:
                    System.out.print("Codigo a buscar: ");
                    Estudiante e = sistema.buscarPorCodigo(sc.nextLine());
                    System.out.println(e != null ? e : "No encontrado");
                    break;
                case 3:
                    System.out.print("Codigo: ");
                    String c2 = sc.nextLine();
                    System.out.print("Nuevo promedio: ");
                    double np = Double.parseDouble(sc.nextLine());
                    System.out.println(sistema.actualizarPromedio(c2, np) ? "OK" : "No encontrado");
                    break;
                case 4:
                    for (Estudiante r : sistema.listarRanking()) {
                        System.out.println(r);
                    }
                    break;
                case 5:
                    System.out.print("N: ");
                    int n = Integer.parseInt(sc.nextLine());
                    System.out.println(sistema.topN(n));
                    break;
                case 6:
                    System.out.println("Adios.");
                    break;
                case 7:
                    System.out.print("Codigo a eliminar: ");
                    System.out.println(sistema.eliminar(sc.nextLine()) ? "Eliminado" : "No encontrado");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 6);
        sc.close();
    }
}