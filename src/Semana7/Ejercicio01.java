package Semana7;

public class Ejercicio01 {

    public static void main(String[] args) {
        String[] partidos = {"Cooperación Nacional", "Justicia Popular", "Juntos Perú", "Arriba Perú", "Perú Siempre", "Futuro Perú", "Blancos", "Nulos"};
        int[] votos = {50000, 45000, 40000, 20000, 15000, 5000, 3000, 2000};

        double[] porcentajes = calcularPorcentajes(partidos, votos);
        Object[] resultadoCurules = calcularCurules(partidos, votos, porcentajes);

        System.out.println("Porcentajes:");
        for (int i = 0; i < porcentajes.length; i++) {
            System.out.println(partidos[i] + ": " + porcentajes[i] + "%");
        }

        System.out.println("\nCurules:");
        for (int i = 0; i < resultadoCurules.length; i += 2) {
            System.out.println(resultadoCurules[i] + ": " + resultadoCurules[i + 1] + " congresistas");
        }
    }

    public static double[] calcularPorcentajes(String[] partidos, int[] votos) {
        int totalVotosValidos = 0;

        for (int i = 0; i < votos.length - 2; i++) {
            totalVotosValidos += votos[i];
        }

        double[] porcentajes = new double[partidos.length];

        for (int i = 0; i < votos.length - 2; i++) {
            porcentajes[i] = (double) votos[i] / totalVotosValidos * 100;
        }

        return porcentajes;
    }

    public static Object[] calcularCurules(String[] partidos, int[] votos, double[] porcentajes) {
        int totalVotosValidos = 0;
        for (int i = 0; i < votos.length - 2; i++) {
            if (porcentajes[i] >= 2.0) {
                totalVotosValidos += votos[i];
            }
        }

        int totalCurules = 120;
        Object[] resultadoCurules = new Object[partidos.length * 2];
        int index = 0;

        for (int i = 0; i < votos.length - 2; i++) {
            if (porcentajes[i] >= 2.0) {
                int curules = (int) Math.round((double) votos[i] / totalVotosValidos * totalCurules);
                resultadoCurules[index] = partidos[i];
                resultadoCurules[index + 1] = curules;
                index += 2;
            }
        }

        Object[] resultadoFinal = new Object[index];
        System.arraycopy(resultadoCurules, 0, resultadoFinal, 0, index);

        return resultadoFinal;
    }
}
