package Final;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio01 {
    public static String[] Codigos = { "2023PERFUTF320169", "2023CHIVOLM280045", "2022PERFUTF300086",
            "2022BOLVOLM270127", "2022PERTENM280032", "2024BOLTENF200067" };

    public static void main(String[] args) {
        String pais = "PER";
        int ganadores = calcularCantidadGanadores(pais);
        System.out.printf("Ganadores de %s: %d\n", pais, ganadores);

        String paisMayor = paisMayorGanador();
        System.out.println("Pais con más ganadores: " + paisMayor);

        String anio = "2022";
        String[] deportistas = deportistasPorAnio(anio);
        System.out.println("Deportistas del año " + anio + " son: " + Arrays.toString(deportistas));
    }

    public static int calcularCantidadGanadores(String pais) {
        int ganadores = 0;
        for (String cod : Codigos) {
            if (cod.substring(4, 7).equals(pais)) {
                ganadores++;
            }
        }

        return ganadores;
    }

    public static String paisMayorGanador() {
        String ganador = "";
        int ganadoresChi = 0;
        int ganadoresPer = 0;
        int ganadoresBol = 0;
        for (String cod : Codigos) {
            if (cod.substring(4, 7).equals("PER")) {
                ganadoresPer++;
            } else if (cod.substring(4, 7).equals("CHI")) {
                ganadoresChi++;
            } else if (cod.substring(4, 7).equals("BOL")) {
                ganadoresBol++;
            }
        }
        if (ganadoresPer > ganadoresBol && ganadoresPer > ganadoresChi) {
            ganador = "PER";
        } else if (ganadoresBol > ganadoresChi) {
            ganador = "BOL";
        } else {
            ganador = "CHI";
        }
        return ganador;
    }

    public static String[] deportistasPorAnio(String anio) {
        ArrayList<String> deportistas = new ArrayList<String>();

        for (String cod : Codigos) {
            if (cod.substring(0, 4).equals(anio)) {
                deportistas.add(cod.substring(13, 17));
            }
        }
        String[] arr = new String[deportistas.size()];
        arr = deportistas.toArray(arr);
        return arr;
    }
}
