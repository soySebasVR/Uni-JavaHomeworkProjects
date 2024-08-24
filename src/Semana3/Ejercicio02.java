package Semana3;

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        final double desc = 0.20;
        double cant;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el importe: ");
        cant = scanner.nextDouble();

        if (cant > 1000) {
            double descTotal = cant * desc;
            double importeTotal = cant - descTotal;
            System.out.println("---Descuento aplicado --- S/." + descTotal);
            System.out.println("Importe total a pagar es: S/." + importeTotal);
        } else {
            System.out.println("--- No presenta descuento ---");
            System.out.println("Importe total a pagar : S/." + cant);
        }

    }
}
