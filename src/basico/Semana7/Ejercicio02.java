package Semana7;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio02 {
    public static void main(String[] args) {

        // Arreglos
        int[] puntajesAgente = {5,4,3,4,5,2};
        String[] agentes = {"Juan", "Ana", "Luis", "Maria","Jose","David"};

        // Operación - promedio
        double promedio = calcularpuntajePromedio(puntajesAgente);
        System.out.printf("El puntaje promedio de atención es: %.2f%n", promedio);

        // Operación - agentes
        List<String> destacados = buscarAgentesDestacados(agentes, puntajesAgente);
        System.out.println("Colaboradores con nivel de satisfacción Excelente o Muy Bueno:");
        for (String agente : destacados) {
            System.out.println(agente);
        }

    }
    public static double calcularpuntajePromedio(int [] puntajesAgente){
        int sumaPuntajes = 0;
        for (int puntaje : puntajesAgente) {
            sumaPuntajes += puntaje;
        }
        double puntajePromedio = (double) sumaPuntajes / puntajesAgente.length;

        return puntajePromedio;
    }
    public static List<String> buscarAgentesDestacados(String[] agentes, int[] puntajesAgente){
        List<String> destacados = new ArrayList<>();
        for (int i = 0; i < agentes.length; i++) {
            if (puntajesAgente[i] == 5 || puntajesAgente[i] == 4) {
                destacados.add(agentes[i]);
            }
        }
        return destacados;
    }
}
