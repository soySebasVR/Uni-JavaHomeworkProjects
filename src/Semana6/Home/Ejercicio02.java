package Semana6.Home;

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        double capInicial;
        double intInicial;
        String opcion;
        int meses;
        double resultado;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese su capital inicial: ");
            capInicial = sc.nextDouble();
            System.out.println("Ingrese su interes incial: ");
            intInicial = sc.nextDouble();

            System.out.println(
                    "Qué desea calcular:\n(a) última tasa que recibió al cabo de unos meses\n(b) el interés total que recibirá al cabo de unos meses\n(c) el importe total que recibirá al cabo de unos meses");
            opcion = sc.next();
            System.out.println("Ingrese los meses:");
            meses = sc.nextInt();

            if (opcion.equals("a")) {
                resultado = calcularUltimaTasa(meses, intInicial);
                System.out.println(resultado);
            } else if (opcion.equals("b")) {
                resultado = calcularInteresTotal(meses, capInicial, intInicial);
                System.out.println(resultado);
            } else if (opcion.equals("c")) {
                resultado = calcularImporteTotal(meses, capInicial, intInicial);
                System.out.println(resultado);
            }
        }
    }

    public static double calcularUltimaTasa(double meses, double intInicial) {
        double y = meses / 3;
        double x = Math.ceil(y / 3) - 1;
        return intInicial + x / 100;
    }

    public static double calcularInteresTotal(double meses, double capInicial, double intInicial) {
        double capital = capInicial;
        double tasInteres = intInicial;

        for (int i = 1; i < meses + 1; i++) {
            capital += capital * tasInteres;
            if (i % 3 == 0) {
                tasInteres += 0.01;
            }
        }

        return capital - capInicial;
    }

    public static double calcularImporteTotal(double meses, double capInicial, double intInicial) {
        double capital = capInicial;
        double interes = intInicial;

        for (int i = 1; i < meses + 1; i++) {
            capital += capital * interes;
            if (i % 3 == 0) {
                interes += 0.01;
            }
        }

        return capital;
    }
}
