package Semana3;

import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
        System.out.println("Programa para calcular la cantidad de disolvente necesaria para pintar una pared.");
        final double galonesPorM2 = 0.25;
        final double galonesCPP = 10;
        double alto;
        double ancho;
        double area;
        double galones;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el alto de la pared: ");
        alto = sc.nextDouble();
        System.out.println("Ingrese el ancho de la pared: ");
        ancho = sc.nextDouble();

        area = alto * ancho;
        galones = area * galonesPorM2;

        if (galones > galonesCPP) {
            System.out.println("Se necesita comprar CPP.");
        } else {
            System.out.println("Se necesita comprar disolvente LATEX PATO.");
        }

        System.out.println("Cantidad de disolvente necesaria: " + galones + " galones.");
    }
}
