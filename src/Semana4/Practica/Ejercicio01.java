package Semana4.Practica;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ejercicio01 {
    public static int libros = 1258;
    public static int enciclopedias = 17;
    public static int periodicos = 964;
    public static int revistas = 1698;

    final static double MULTA_L_DIAS_1_3 = 0.9;
    final static double MULTA_L_DIAS_4_7 = 1.8;
    final static double MULTA_L_DIAS_8 = 3.5;
    final static double MULTA_R_DIAS_1_3 = 0.7;
    final static double MULTA_R_DIAS_4_7 = 1.5;
    final static double MULTA_R_DIAS_8 = 2.5;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Bienvenido al sistema de la biblioteca de la provincia de Acobamba en Huancavelica");
        String accion;
        String recurso;
        int cantidad;
        double dinero;

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println(
                        "\n¿Qué acción desea realizar? (c: cantidad de recurso, d: donación de recursos, m: cálculo multa, s: salir)");
                accion = sc.nextLine();
                if (accion.equals("s")) {
                    break;
                }
                switch (accion) {
                    case "c":
                        System.out.println(
                                "Ingrese el recurso a buscar (l: libros, e: enciclopedias, p: periodicos, r: revistas)");
                        recurso = sc.nextLine();
                        cantidad = getRecurso(recurso);
                        if (cantidad == -1) {
                            System.out.println("Recurso no válido");
                            break;
                        }
                        System.out.println("La cantidad de " + getNombreRecurso(recurso) + " es: " + cantidad);
                        TimeUnit.SECONDS.sleep(1);
                        break;
                    case "d":
                        System.out.println(
                                "Ingrese el recurso a donar (l: libros, e: enciclopedias, p: periodicos, r: revistas)");
                        recurso = sc.nextLine();
                        System.out.println("Ingrese la cantidad a donar");
                        if (!(recurso.equals("l") || recurso.equals("e") || recurso.equals("p")
                                || recurso.equals("r"))) {
                            System.out.println("Recurso no válido");
                            break;
                        }
                        cantidad = Integer.parseInt(sc.nextLine());
                        if (cantidad < 0) {
                            System.out.println("Cantidad no válida");
                            break;
                        }
                        donarRecurso(recurso, cantidad);
                        cantidad = getRecurso(recurso);
                        System.out.println(
                                "La colección de " + getNombreRecurso(recurso) + " se ha incrementado a " + cantidad);
                        TimeUnit.SECONDS.sleep(1);
                        break;
                    case "m":
                        System.out.println("Ingrese el recurso a calcular la multa (l: libros, r: revistas)");
                        recurso = sc.nextLine();
                        if (!(recurso.equals("l") || recurso.equals("r"))) {
                            System.out.println("Recurso no válido");
                            break;
                        }
                        System.out.println("Ingrese la cantidad de días de retraso");
                        cantidad = Integer.parseInt(sc.nextLine());
                        if (cantidad < 0) {
                            System.out.println("Cantidad no válida");
                            break;
                        }
                        dinero = calcularMulta(recurso, cantidad);
                        System.out.printf("La multa a pagar por los %d días de retraso es: S/. %.2f\n", cantidad,
                                dinero);
                        TimeUnit.SECONDS.sleep(1);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
        }
        System.out.println(
                "Gracias por usar el sistema de la biblioteca de la provincia de Acobamba en Huancavelica");
    }

    public static String getNombreRecurso(String recurso) {
        switch (recurso) {
            case "l":
                return "libros";
            case "e":
                return "enciclopedias";
            case "p":
                return "periodicos";
            case "r":
                return "revistas";
            default:
                return "Recurso no válido";
        }
    }

    public static int getRecurso(String recurso) {
        switch (recurso) {
            case "l":
                return libros;
            case "e":
                return enciclopedias;
            case "p":
                return periodicos;
            case "r":
                return revistas;
            default:
                return -1;
        }
    }

    public static void donarRecurso(String recurso, int cantidad) {
        switch (recurso) {
            case "l":
                libros += cantidad;
                break;
            case "e":
                enciclopedias += cantidad;
                break;
            case "p":
                periodicos += cantidad;
                break;
            case "r":
                revistas += cantidad;
                break;
        }
    }

    public static double calcularMulta(String recurso, int diasRetraso) {
        double multa = 0;
        int diasPago_1_3 = 0;
        int diasPago_4_7 = 0;
        int diasPago_8 = 0;

        if (diasRetraso < 1) {
            return 0;
        } else if (diasRetraso >= 1 && diasRetraso <= 3) {
            diasPago_1_3 = diasRetraso;
            diasPago_4_7 = 0;
            diasPago_8 = 0;
        } else if (diasRetraso >= 4 && diasRetraso <= 7) {
            diasPago_1_3 = 3;
            diasPago_4_7 = diasRetraso - 3;
            diasPago_8 = 0;
        } else if (diasRetraso >= 8) {
            diasPago_1_3 = 3;
            diasPago_4_7 = 4;
            diasPago_8 = diasRetraso - 7;
        }

        if (recurso.equals("l")) {
            multa = diasPago_1_3 * MULTA_L_DIAS_1_3 + diasPago_4_7 * MULTA_L_DIAS_4_7 + diasPago_8 * MULTA_L_DIAS_8;
        } else if (recurso.equals("r")) {
            multa = diasPago_1_3 * MULTA_R_DIAS_1_3 + diasPago_4_7 * MULTA_R_DIAS_4_7 + diasPago_8 * MULTA_R_DIAS_8;
        } else {
            System.out.println("Recurso no válido");
            return -1;
        }
        return multa;
    }
}
