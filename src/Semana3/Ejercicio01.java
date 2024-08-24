package Semana3;

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número entero: ");
        int numero = sc.nextInt();
        String resultado = evaluarNumero(numero);
        System.out.println(resultado);
        sc.close();
    }

    public static String evaluarNumero(int numero) {
        if (numero > 0) {
            if (numero % 2 == 0) {
                return "El número " + numero + " par y mayor que cero.";
            } else {
                return "El número " + numero + " es impar y mayor que cero.";
            }
        } else {
            if (numero % 2 == 0) {
                return "El número " + numero + " es par y menor que cero.";
            } else {
                return "El número " + numero + " es impar y menor que cero.";
            }
        }
    }
}
