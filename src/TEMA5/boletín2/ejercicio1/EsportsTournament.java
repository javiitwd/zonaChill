package TEMA5.boletín2.ejercicio1;

public class EsportsTournament {

    private Gamer[] players;

    public EsportsTournament() {
        players = new Gamer[]{new FPSGamer(), new MOBAGamer(), new SportsGamer()};
    }

    public static void main(String[] args) {

        EsportsTournament e = new EsportsTournament();
        startTournament(e.players);
    }

    private static void startTournament(Gamer[] players) {

        for (Gamer e : players){
            e.playGame();
        }
    }
}
