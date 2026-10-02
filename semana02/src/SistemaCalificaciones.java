import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaCalificaciones {

    static double leerNotaValida(Scanner sc, String mensaje) {
        double nota = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                nota = sc.nextDouble();
                if (nota < 0 || nota > 100) {
                    System.out.println("Error: la nota debe estar entre 0 y 100.");
                    continue;
                }
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un numero valido.");
                sc.next();
            }
        }
        return nota;
    }
    
    static double promedio(double[] notas) {
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }

    static double maximo(double[] notas) {
        double max = notas[0];
        for (double n : notas) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    static double minimo(double[] notas) {
        double min = notas[0];
        for (double n : notas) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }

    static String estado(double promedio) {
        return promedio >= 51 ? "Aprobado" : "Reprobado";
    }
}
