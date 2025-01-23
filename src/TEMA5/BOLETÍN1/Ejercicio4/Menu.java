package TEMA5.BOLETÍN1.Ejercicio4;

import Comun.MiEntradaSalida;

public class Menu {

    private static JuegoRolApp2 juego = new JuegoRolApp2();

    public static void main(String[] args) {

        String[] opciones = {
                "Alta de personaje",
                "Mago aprende hechizo",
                "Mago lanza hechizo",
                "Clérigo cura mago",
                "Mostrar lista de personajes",
                "Mostrar el listado de personajes ordenados por puntos actuales de mayor a menor",
                "Salir"
        };

        int opcion = 0;
        do {
            opcion = MiEntradaSalida.seleccionaOPcion("Menú", opciones);

            switch (opcion) {

                case 0:
                    altaDePersonaje();
                    break;
                case 1:
                    aprenderHechizo();
                    break;
            }

        } while (opcion != 7);
    }

    public static void altaDePersonaje() {
        Personaje personaje;

        int opcion = MiEntradaSalida.seleccionaOPcion("Tipo de personaje", new String[]{"Mago", "Clérigo"});

        String nombre = MiEntradaSalida.solicitarCadena("Pon el nombre: ");
        String[] convertirAString = new String[Traza.values().length];
        for (int i = 0; i < convertirAString.length; i++) {

            //Convertimos los valores de la raza a String
            convertirAString[i] = String.valueOf(Traza.values()[i]);
        }

        //Recogemos el numero correspondiente a la raza que ha seleccionado el cliente
        int opRaza = MiEntradaSalida.seleccionaOPcion("Raza", convertirAString);

        //Guardamos la raza seleccionada
        Traza raza = Traza.values()[opRaza];

        int vida = MiEntradaSalida.solicitarEnteroEnRango("Ponga la vida", Personaje.MIN_PUNTOS_VIDA, Personaje.MAX_PUNTOS_VIDA);

        try {
            if (opcion == 0) {
                int fuerza = MiEntradaSalida.solicitarEnteroEnRango("Ponga la fuerza", Personaje.MIN_PUNTOS_APLICABLES, Mago.MAX_FUERZA_MAGO);
                int inteligencia = MiEntradaSalida.solicitarEnteroEnRango("Ponga la inteligencia", Mago.MIN_INTELIGENCIA_MAGO, Personaje.MAX_PUNTOS_APLICABLES);
                personaje = new Mago(vida, inteligencia, fuerza, raza, nombre);
            } else {
                int fuerza = MiEntradaSalida.solicitarEnteroEnRango("Ponga la fuerza", Clerigo.MIN_FUERZA_CLERIGO, Personaje.MAX_PUNTOS_APLICABLES);
                int inteligencia = MiEntradaSalida.solicitarEnteroEnRango("Ponga la inteligencia", Clerigo.MIN_INTELIGENCIA_CLERIGO, Clerigo.MAX_INTELIGENCIA_CLERIGO);
                String dios = MiEntradaSalida.solicitarCadena("Ponga el nombre del Dios");
                personaje = new Clerigo(vida, inteligencia, fuerza, raza, nombre, dios);
            }
            juego.anadirPersonaje(personaje);
        } catch (JuegoRolException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void aprenderHechizo() {

        Mago[] magos = juego.devolverMagos();

        String[] nombreMagos = new String[magos.length];

        for (int i = 0; i < magos.length; i++) {

            nombreMagos[i] = magos[i].getNombre();
        }

        int posicionMagoElegido = MiEntradaSalida.seleccionaOPcion("Elige un mago", nombreMagos);

        String nombreHechizo = MiEntradaSalida.solicitarCadena("Escribe el hechizo");

        try {
            magos[posicionMagoElegido].aprendeHehizo(nombreHechizo);
        } catch (JuegoRolException e) {
            System.out.println(e.getMessage());
        }
    }
}
