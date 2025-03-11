package TEMA5.LuchadoresGPT;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        try {
            List<Luchador> luchadores = new ArrayList<Luchador>();
            luchadores.add(new Luchador(100, "Guts", 90, 80, 70));
            luchadores.add(new Luchador(100, "Griffith", 85, 75, 80));
            luchadores.add(new Luchador(100, "Zodd", 70, 90, 60));
            luchadores.add(new Luchador(100, "Skull Knight", 80, 85, 85));

            Torneo torneo = new Torneo(luchadores);
            torneo.iniciarTorneo();

        } catch (TorneoException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
