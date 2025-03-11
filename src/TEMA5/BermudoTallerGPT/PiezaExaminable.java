package TEMA5.BermudoTallerGPT;

import java.util.Random;

public class PiezaExaminable extends Pieza implements Examinable {

    public static final double INCREMENTO_POR_EXAMINAR = 0.10;

    public PiezaExaminable(int codigo, String descripcion, double coste) {
        super(codigo, descripcion, coste);
    }

    @Override
    public boolean examinar() {

        //Incrementamos el coste por examinar la pieza
        setCoste(getCoste() * INCREMENTO_POR_EXAMINAR);
        Random random = new Random();
        return random.nextBoolean();
    }
}
