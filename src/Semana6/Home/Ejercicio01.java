package Semana6.Home;

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        System.out.println("Selecciona que desea calcular:");
        byte opcion = 0;
        double meses = 0;
        double pagoFinal = 0;
        double primeraCuota = 0;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese 1. calcular primera cuota o 2. calcular cantidad de meses: ");
            opcion = sc.nextByte();
            if (opcion == 1) {
                System.out.println("Ingrese el número de meses: ");
                meses = sc.nextInt();
                System.out.println("Ingrese el pago final: ");
                pagoFinal = sc.nextDouble();
                if (meses < 0 || pagoFinal < 0) {
                    System.out.println("Error en data ingresada");
                    System.exit(1);
                }

                System.out.printf("La primera cuota es de S/ %.2f\n", calcularPrimeraCuota(pagoFinal, meses));
            } else if (opcion == 2) {
                System.out.println("Ingrese la primera cuota: ");
                primeraCuota = sc.nextDouble();
                System.out.println("Ingrese el pago final: ");
                pagoFinal = sc.nextDouble();

                System.out.printf("La cantidad de meses a pagar aprox es %.1f meses\n",
                        calcularCantidadMeses(pagoFinal, primeraCuota));
            }

        }

    }

    public static double calcularPrimeraCuota(double pagoFinal, double meses) {
        return pagoFinal / (Math.pow(2, meses) - 1);
    }

    public static double calcularCantidadMeses(double pagoFinal, double primeraCuota) {
        return Math.log((pagoFinal / primeraCuota) + 1) / Math.log(2);
    }
}
