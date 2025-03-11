

package TEMA5.BermudoTallerGPT;

import java.util.ArrayList;
import java.util.List;

public class Taller {

    private List<Pieza> piezasDelTaller;

    public Taller() {
        this.piezasDelTaller = new ArrayList<>();
    }

    public void annadirPieza(Pieza pieza) {
        piezasDelTaller.add(pieza);
    }

    public double piezaPuedeExaminarse(Pieza pieza) {

        //Si es examinable le hacemos un casting y la examinamos
        if (pieza instanceof PiezaExaminable examinable) {

            examinable.examinar();

            //Modificamos su precio para añadirle el coste de reparacion
            examinable.setCoste(pieza.getCoste() - (examinable.getCoste() * PiezaExaminable.INCREMENTO_POR_EXAMINAR));

            return examinable.getCoste();
        }
        throw new TallerException("La pieza no se puede examinar");
    }

    public double piezaPuedeRepararse(Pieza pieza) {

        //Si es reparable le hacemos un casting y la reparamos
        if (pieza instanceof PiezaReparable) {

            PiezaReparable reparable = (PiezaReparable) pieza;
            reparable.reparar();

            //Modificamos su precio para añadirle el coste de reparacion
            reparable.setCoste(pieza.getCoste() - (reparable.getCoste() * PiezaReparable.INCREMENTO_POR_REPARACION));

            return reparable.getCoste();
        }
        throw new TallerException("La pieza no se puede reparar");
    }

    public String tratarDeExaminarYRepararPieza(Pieza pieza) {

        //String para mostrale al usuario los cambios que se han hecho a la pieza
        StringBuilder sb = new StringBuilder();

        //Si es examinable le hacemos un casting y la examinamos
        if (pieza instanceof PiezaExaminable examinable) {

            examinable.examinar();

            //Modificamos su precio para añadirle el coste de reparacion
            examinable.setCoste(pieza.getCoste() - (examinable.getCoste() * PiezaExaminable.INCREMENTO_POR_EXAMINAR));
            sb.append("La pieza es examinable. ");
        }

        //Si es reparable le hacemos un casting y la reparamos
        if (pieza instanceof PiezaReparable) {

            PiezaReparable reparable = (PiezaReparable) pieza;
            reparable.reparar();

            //Modificamos su precio para añadirle el coste de reparacion
            reparable.setCoste(pieza.getCoste() - (reparable.getCoste() * PiezaReparable.INCREMENTO_POR_REPARACION));
            sb.append("La pieza es reparable. ");
        }

        if (sb.isEmpty()) {
            throw new TallerException("La pieza no es ni examinable ni reparable");
        }

        //Le mostramos al usuario lo que le hemos hecho a su pieza y el coste total
        return sb.append("El coste total es de " + pieza.getCoste()).toString();
    }
}
