package Semana2;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("El siguiente programa calcula la cantidad de billetes de 20 soles que se necesitan para entregar una determinada cantidad de dinero");
        int dinero;

        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("Ingrese la cantidad de dinero: ");
                dinero = sc.nextInt();
            } while (dinero < 0);
            int billetes = dinero / 20;

            System.out.println("\nLa cantidad de billetes de 20 soles es " + billetes);
        } catch (Exception e) {
            System.out.println("\nHa ingresado datos invalidos.\n");
        }
    }
}
