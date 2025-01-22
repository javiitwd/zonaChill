package TEMA5.BOLETÍN1.Ejercicio4;

public class JuegoRolApp {
    public static void main(String[] args) throws JuegoRolException {

        try {
            Traza razaMago1 = Traza.values()[0];
            Traza razaMago2 = Traza.values()[1];
            Traza razaClerigo1 = Traza.values()[2];

            Mago mago1 = new Mago(15, 18, 15, razaMago1, "Villalba");
            Mago mago2 = new Mago(15, 18, 15, razaMago2, "Villalba2");
            Clerigo clerigo1 = new Clerigo(15, 15, 19, razaClerigo1, "Villalba3", "juntaDeAndalucia");

            System.out.println("Magos aprendiendo hechizos...");
            mago1.aprendeHehizo("Vonneuman");
            mago1.aprendeHehizo("Vonneuman Plus!!!");
            mago2.aprendeHehizo("La vida es la vida y la vida fluye");

            System.out.println("Datos del mago 1: ");
            System.out.println("Datos del mago 1: " + mago1);

            System.out.println("Datos del mago 2: ");
            System.out.println("Datos del mago 2: " + mago2);

            System.out.println("Mago 1 lanza hechizo al mago 2!!!");
            mago1.lanzaHechizo(mago2, "Vonneuman");

            System.out.println("Mago 2 contraataca y le lanza hechizp al mago 1!!!");
            mago2.lanzaHechizo(mago1, "La vida es la vida y la vida fluye");

            System.out.println("No me lo creo! el clerigo llega para curar al mago 2!!!");
            clerigo1.curar(mago2);

            System.out.println("GUAU! EL MAGO 1 VUELVE A LANZAR UN HECHIZO A MAGO 2!!!");
            mago1.lanzaHechizo(mago2, "Vonneuman Plus!!!");

            System.out.println("La batalla... HA TERMIANDO, Estos son los resultados: ");

            System.out.println("Datos del mago 1: ");
            System.out.println("Datos del mago 1: " + mago1);

            System.out.println("Datos del mago 2: ");
            System.out.println("Datos del mago 2: " + mago2);

            System.out.println("Datos del clerigo 1: ");
            System.out.println("Datos del clérigo: " + clerigo1);

        } catch (JuegoRolException e) {
            System.out.println(e.getMessage());
        }
    }
}



/*
        EL TOSTRING SUSTITUYE A TODO ESTO
        System.out.println("Datos del mago 1: ");
        System.out.println("Nombre: " +mago1.getNombre());
        System.out.println("Puntos de vida actuales: " +mago1.getPuntoVidaActuales());
        System.out.println("Raza: " +mago1.getRaza());
        System.out.println("Fuerza: " +mago1.getFuerza());
        System.out.println("Inteligencia: " +mago1.getInteligencia());

        System.out.println("Datos del mago 2: ");
        System.out.println("Nombre: " +mago2.getNombre());
        System.out.println("Puntos de vida actuales: " +mago2.getPuntoVidaActuales());
        System.out.println("Raza: " +mago2.getRaza());
        System.out.println("Fuerza: " +mago2.getFuerza());
        System.out.println("Inteligencia: " +mago2.getInteligencia());
 */