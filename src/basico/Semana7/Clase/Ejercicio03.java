package Semana7.Clase;

import java.util.Scanner;

public class Ejercicio03 {
    static String[] placas = { "AGX123", "BGX837", "IUR923", "YRS623", "PSO998", "MWR836" };
    static String[] modelos = { "Camion", "Auto", "Auto", "Bus", "Bus", "Auto" };

    public static void main(String[] args) {
        // System.out.println("Que desea hacer?");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingresar el dígito a buscar en placa: ");
            String digito = sc.nextLine();

            int cantVehiculos = cantidadVehiculos(digito);
            System.out.printf("La cantidad de vehiculos para el digito %s es %d\n", digito, cantVehiculos);
        }
    }

    private static int cantidadVehiculos(String digito) {
        int cantidad = 0;
        for (String placa : placas) {
            if (String.valueOf(placa.charAt(5)).equals(digito)) {
                cantidad++;
            }
        }
        return cantidad;
    }
}
