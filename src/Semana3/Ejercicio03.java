package Semana3;

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        System.out.println("Programa para evaluar tres números.");
        int num1;
        int num2;
        int num3;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el primer número: ");
        num1 = sc.nextInt();
        System.out.println("Ingrese el segundo número: ");
        num2 = sc.nextInt();
        System.out.println("Ingrese el tercer número: ");
        num3 = sc.nextInt();

        System.out.println("El número mayor es: " + mayor(num1, num2, num3));
        System.out.println("El número menor es: " + menor(num1, num2, num3));
        System.out.println("El número del medio es: " + medio(num1, num2, num3));
    }

    public static int mayor(int num1, int num2, int num3) {
        int mayor = num1;

        if (num2 > mayor) {
            mayor = num2;
        }

        if (num3 > mayor) {
            mayor = num3;
        }

        return mayor;
    }

    public static int menor(int num1, int num2, int num3) {
        int menor = num1;

        if (num2 < menor) {
            menor = num2;
        }

        if (num3 < menor) {
            menor = num3;
        }

        return menor;
    }

    public static int medio(int num1, int num2, int num3) {
        int mayor = mayor(num1, num2, num3);
        int menor = menor(num1, num2, num3);

        if (num1 != mayor && num1 != menor) {
            return num1;
        } else if (num2 != mayor && num2 != menor) {
            return num2;
        } else {
            return num3;
        }
    }
}
