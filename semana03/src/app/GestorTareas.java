package app;

import modelo.Tarea;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorTareas {
    private static ArrayList<Tarea> tareas = new ArrayList<>();

    private static void agregar(String descripcion) {
        tareas.add(new Tarea(descripcion));
        System.out.println("Tarea agregada.");
    }

    private static void listar() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }
        for (Tarea t : tareas) {
            System.out.println(t);
        }
    }

    private static void completar(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                t.marcarCompletada();
                System.out.println("Tarea " + id + " marcada como completada.");
                return;
            }
        }
        System.out.println("No existe una tarea con ID " + id);
    }

    private static void eliminar(int id) {
        boolean eliminado = tareas.removeIf(t -> t.getId() == id);
        System.out.println(eliminado ? "Tarea eliminada." : "No existe una tarea con ID " + id);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("\n1) Agregar 2) Listar 3) Completar 4) Eliminar 5) Salir");
            System.out.print("Opcion: ");
            int opcion;
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un numero valido.");
                sc.next();
                continue;
            }
            sc.nextLine(); // consume el salto de linea pendiente

            switch (opcion) {
                case 1 -> {
                    System.out.print("Descripcion: ");
                    agregar(sc.nextLine());
                }
                case 2 -> listar();
                case 3 -> {
                    System.out.print("ID a completar: ");
                    completar(sc.nextInt());
                }
                case 4 -> {
                    System.out.print("ID a eliminar: ");
                    eliminar(sc.nextInt());
                }
                case 5 -> salir = true;
                default -> System.out.println("Opcion invalida.");
            }
        }
        sc.close();
    }
}