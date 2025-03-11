package TEMA6.Examenes.ExamenColecciones2022;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear algunos cromos
            Cromo cromo1 = new CromoDeJugadores(23342, "Messi", "Fútbol", 95);
            Cromo cromo2 = new CromoDeJugadores(23546, "Jordan", "Baloncesto", 98);
            Cromo cromo3 = new CromoDeJugadores(32546, "Serena", "Tenis", 96);
            Cromo cromo4 = new CromoDeEscudos(12345, "Barcelona", 2000, 8);
            Cromo cromo5 = new CromoDeEscudos(67890, "Chicago Bulls", 2005, 9);

            // Crear una colección de cromos
            CromoApp coleccion = new CromoApp();

            // Agregar cromos a la colección
            System.out.println(coleccion.annadirCromo(cromo1));
            System.out.println(coleccion.annadirCromo(cromo2));
            System.out.println(coleccion.annadirCromo(cromo3));
            System.out.println(coleccion.annadirCromo(cromo4));
            System.out.println(coleccion.annadirCromo(cromo5));

            // Mostrar la colección
            System.out.println("\nColección de Cromos:");
            System.out.println(coleccion.devolverListaDeCromos());

            // Ordenar cromos por nombre
            System.out.println("\nColección ordenada por nombre:");
            System.out.println(coleccion.devolverListaDeCromosOrdenados());

            // Contar cromos diferentes
            System.out.println("\nCantidad de cromos diferentes:");
            System.out.println(coleccion.contarCantidadDeCromosDiferentes());

            // Devolver cromos de un equipo específico
            System.out.println("\nCromos del equipo 'Barcelona':");
            System.out.println(coleccion.devolverCromosDeUnEquipo("Barcelona"));

            // Calcular la altura media de un equipo (asumiendo que solo aplica a jugadores)
            System.out.println("\nAltura media de los jugadores del equipo 'Barcelona':");
            System.out.println(coleccion.calcularAlturaMedia("Barcelona"));

            // Intercambiar cromos
            Cromo cromoNuevo = new CromoDeJugadores(44444, "Ronaldo", "Fútbol", 92);
            System.out.println("\nIntercambiando cromo 'Messi' por 'Ronaldo'...");
            coleccion.intercambiarCromoPorOtro(cromo1, cromoNuevo);
            System.out.println("Colección después del intercambio:");
            System.out.println(coleccion.devolverListaDeCromos());

            // Mezclar mazo con otro
            Map<Cromo, Integer> nuevoMazo = new HashMap<>();
            nuevoMazo.put(new CromoDeJugadores(55555, "Nadal", "Tenis", 94), 1);
            nuevoMazo.put(new CromoDeJugadores(66666, "Kobe", "Baloncesto", 97), 1);
            System.out.println("\nMezclando con otro mazo...");
            System.out.println(coleccion.mezclarMazoConOtro(nuevoMazo));

        } catch (CromoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


