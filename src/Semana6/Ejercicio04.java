package Semana6;

import java.util.Scanner;

public class Ejercicio04 {
    static String[] nombres = { "El escondite", "Pintamar", "Fuerza Mancora", "Jorge 2", "Embarcadero" };
    static double[] calificaciones = { 3.6, 1.4, 4.5, 2.2, 5 };

    public static void main(String[] args) {
        String opcion;
        String nombreRestaurant = "";
        System.out.println("Ingrese accion:");
        System.out.println(
                "(a) Para el nombre de un restaurante determinado, cual fue el puntaje promedio de calificación que obtuvo");
        System.out.println("(b) Porcentaje de restaurantes que ha tenido una calificación que sea Excelente");
        System.out.println("(c) Restaurantes que han tenido una calificación Mala o Pésima.");
        try (Scanner sc = new Scanner(System.in)) {
            opcion = sc.nextLine();
            if (opcion.equals("a")) {
                System.out.println("Ingrese el nombre del restaurant");
                nombreRestaurant = sc.nextLine();
            }
        }
        switch (opcion) {
            case "a":
                System.out.println(
                        "El porcentaje promedio para " + nombreRestaurant + " es de " + getByNombre(nombreRestaurant));
                break;
            case "b":

                break;
            case "c":

                break;
            default:
                break;
        }
    }

    public static double getByNombre(String nombre) {
        int posicion = -1;

        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equals(nombre)) {
                posicion = i;
            }
        }
        if (posicion == -1) {
            System.err.println("No se encontró el restaurante");
            System.exit(1);
        }
        return calificaciones[posicion];
    }

    public double getPorcentajeExcelente() {
        int total = 0;
        int totalExcelentes = 0;

        for (double d : calificaciones) {
            total++;
            if (d >= 4.5) {
                totalExcelentes++;
            }
        }
        return totalExcelentes / total;
    }
}
