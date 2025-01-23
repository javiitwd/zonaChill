package TEMA5.BOLETÍN1.Ejercicio4;

import java.util.Arrays;

public class JuegoRolApp2 {

    private static final int MAX_PERSONAJES_JUEGO = 200;
    Personaje[] personajes;

    public JuegoRolApp2() {
        personajes = new Personaje[MAX_PERSONAJES_JUEGO];
    }

    public Personaje[] getPersonajes() {
        return personajes;
    }

    private int posicionLibre() throws JuegoRolException {
        for (int i = 0; i < personajes.length; i++) {

            if (personajes[i] == null) {
                return i;
            }
        }
        throw new JuegoRolException("No hay posiciones libres");
    }

    public void anadirPersonaje(Personaje personajeAAnadir) throws JuegoRolException {

        personajes[posicionLibre()] = personajeAAnadir;
    }

    public Mago[] devolverMagos() {

        int contadorDeMagos = 0;
        Mago[] magos = new Mago[MAX_PERSONAJES_JUEGO];
        for (int i = 0; i < personajes.length; i++) {

            if (personajes[i] instanceof Mago) {
                magos[contadorDeMagos++] = (Mago) personajes[i];
            }
        }
        return Arrays.copyOfRange(magos, 0, contadorDeMagos);
    }

    public Personaje buscarPersonajePorNombre(String nombre) throws JuegoRolException {

        for (int i = 0; i < personajes.length; i++) {

            if (personajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return personajes[i];
            }
        }
        throw new JuegoRolException("Personaje no encontrado");
    }

    public Clerigo[] devolverClerigos() {

        int contadorDeClerigos = 0;
        Clerigo[] clerigos = new Clerigo[MAX_PERSONAJES_JUEGO];
        for (int i = 0; i < personajes.length; i++) {

            if (personajes[i] instanceof Clerigo) {
                clerigos[contadorDeClerigos++] = (Clerigo) personajes[i];
            }
        }
        return Arrays.copyOfRange(clerigos, 0, contadorDeClerigos);
    }

    public Personaje[] personajesOrdenadosPorVidaActual() {

        Arrays.sort(personajes);
        return personajes;
    }
}
