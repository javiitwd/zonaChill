package TEMA5.VideoJuegoGPT;

public class EmpresaJuegos {


    public static void main(String[] args) {

        Juego juego1 = new JuegoDeDeporte("FIFA", "Game freak", 20, "Futbol", true);
        Juego juego2 = new JuegoDeEstrategia("Ajedrez", "Enigma", 10, "Estrategia Online", 2);
        Juego juego3 = new JuegoDeRol("Blood Soup", "IndieGames", 10, Tcomplejidad.FACIL);
        Personaje personaje = new Personaje("Prota", 34);
        Personaje personaje2 = new Personaje("Prota 2", 30);
        Personaje[] personajes = new Personaje[]{personaje, personaje2};
        Juego juego4 = new JuegoDeAccion("Call of Duty", "Raven", 30, 10, personajes);

        Juego[] juegos = new Juego[]{juego1, juego2, juego3, juego4};
        costeJuegos(juegos);

    }

    public static void costeJuegos(Juego[] juegos) {

        for (int i = 0; i < juegos.length; i++) {
            double precioFinalJuego = juegos[i].getCosteBase();

            if (juegos[i] instanceof Actualizable) {

                Actualizable actualizable = (Actualizable) juegos[i];
                actualizable.actualizar();
                System.out.println("Se ha actualizado el juego " + juegos[i].getTitulo());
                precioFinalJuego += Actualizable.PRECIO_POR_ACTUALIZAR;
            }

            if (juegos[i] instanceof Multijugable juegoMultijugable) {

                juegoMultijugable.mantener();
                System.out.println("Se requieres servidores para el juego " + juegos[i].getTitulo());
                precioFinalJuego += Multijugable.PRECIO_POR_MANTENIMIENTO;
            }
            System.out.printf("El precio final para el juego %s es de: %.2f \n", juegos[i].getTitulo(), precioFinalJuego);
        }
    }
}
