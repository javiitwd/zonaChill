package TEMA5.MuseoArteDigitalGPT;

import Comun.MiEntradaSalida;

import java.time.LocalDate;
import java.util.Scanner;

public class Museo {

    private Obra[] obrasDelMuseo;

    public Museo() {
        this.obrasDelMuseo = new Obra[200];
    }

    public void anadirObra(Obra obra) {

        for (int i = 0; i < obrasDelMuseo.length; i++) {

            if (obrasDelMuseo[i] == null) {
                obrasDelMuseo[i] = obra;
                return;
            }
        }
    }

    public String mostrarObrasAlmacenadas() {

        for (int i = 0; i < obrasDelMuseo.length; i++) {
            if (obrasDelMuseo[i] != null) {
                System.out.println(obrasDelMuseo[i].toString());
            }
        }
        return "Obras mostradas";
    }

    /*public String mostrarObrasMasPopulares() {

        Obra[] obrasMasPopulares = new Obra[3];

        for (int i = 0; i < obrasDelMuseo.length; i++) {

            
        }
    }*/
}
