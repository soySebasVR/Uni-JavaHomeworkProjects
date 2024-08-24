package Semana5;

import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
        System.out.println("Tipos de contrato:");
        System.out.println("(r) Residencial");
        System.out.println("(c) Comercial");
        char contrato = '!';
        int m3 = 0;
        double totalPagar = 0;

        try (Scanner sc = new Scanner(System.in)) {
            try {
                System.out.println("Ingrese su contrato a consultar:");
                contrato = sc.nextLine().charAt(0);
                System.out.println("Ingrese los metros cúbicos gastados:");
                m3 = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.err.println("ERROR: Hubo un error al ingresar los datos");
                System.exit(1);
            }
            if (m3 <= 0) {
                System.err.println("ERROR: Los metros cúbicos ingresados deben ser superior a 0");
                System.exit(1);
            }
        }
        if (contrato != 'r' && contrato != 'c') {
            System.err.println("ERROR: Solo se puede seleccionar tipo de contrato (r) o (c)");
            System.exit(1);
        }

        totalPagar = calcularTotalPagar(contrato, m3);
    }

    public static double calcularTotalPagar(char contrato, int m3) {
        double totalPagar = 0;
        if (contrato == 'r') {
            totalPagar = calcularContratoResidencial(m3);
        } else {
            totalPagar = calcularContratoComercial(m3);
        }
        return totalPagar;
    }

    public static double calcularContratoResidencial(int m3) {
        double totalPagar = 0;

        for (int i = 0; i < m3 + 1; i++) {
            if (i > 28 && i <= 150) {
                totalPagar += 2.1;
            } else if (i > 150) {
                totalPagar += 1.8;
            }
        }

        return totalPagar;
    }

    public static double calcularContratoComercial(int m3) {
        double totalPagar = 0;

        for (int i = 0; i < m3 + 1; i++) {
            if (i <= 400) {
                totalPagar += 1.8;
            } else {
                totalPagar += 2.5;
            }
        }

        return totalPagar;
    }
}
