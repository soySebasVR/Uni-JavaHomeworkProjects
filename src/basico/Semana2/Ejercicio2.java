package Semana2;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("El siguiente programa calcula el cobro de horas de un estacionamiento, se considera la fracción de hora como hora completa.");
        double horas;
        double costo;

        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("Ingrese el costo por hora: ");
                costo = sc.nextDouble();
            } while (costo < 0);
            do {
                System.out.println("Ingrese la cantidad de horas: ");
                horas = sc.nextDouble();
            } while (horas < 0);
            int horas_por_pagar = (int) Math.ceil(horas);
            double total = horas_por_pagar * costo;

            System.out.printf("\nEl total a pagar es %.2f\n", total);
        } catch (Exception e) {
            System.out.println("\nHa ingresado datos invalidos.\n");
        }
    }
}
