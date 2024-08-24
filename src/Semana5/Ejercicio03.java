package Semana5;

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        String passwd;
        byte passwd_pos3;
        byte passwd_pos4;
        System.out.println("Ingrese su clave secreta:");

        try (Scanner sc = new Scanner(System.in)) {
            passwd = sc.nextLine();

            try {
                Integer.parseInt(passwd);
            } catch (Exception e) {
                System.out.println("ERROR: La clave solo debe contener números");
                System.exit(1);
            }
            if (passwd.length() < 4) {
                System.out.println("ERROR: La clave debe de contener 4 dígitos o más");
                System.exit(1);
            }
            passwd_pos3 = (byte) passwd.charAt(2);
            passwd_pos4 = (byte) passwd.charAt(3);
            if (passwd_pos3 % 2 != 0 || passwd_pos4 % 2 != 0) {
                System.out.println("ERROR: La clave, en su posición 3 y 4, debe ser números par");
                System.exit(1);
            }
        }
        System.out.println("Clave ingresada pasa todas las condiciones");
    }
}
