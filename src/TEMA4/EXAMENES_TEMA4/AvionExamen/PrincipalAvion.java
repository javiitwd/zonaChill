package TEMA4.EXAMENES_TEMA4.AvionExamen;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class PrincipalAvion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LocalDate fechaRevision = LocalDate.of(2020, 12, 12);
        Period periodoDeValidez = Period.ofDays(120);
        Revision revision = new Revision(fechaRevision, true, periodoDeValidez);
        Deposito deposito = new Deposito();
        Avion avion = new Avion("Renault", "Magane", deposito);

        avion.anadirRevision(revision);

        System.out.println(avion.toString());

        System.out.println("Introduzca la distancia");
        double distancia = sc.nextDouble();

        try {
            if (avion.comprobarSiAvionPuedeRealizarRecorido(distancia)) {
                System.out.println("El avión puede llegar al destino");
            } else {
                System.out.println("El avión no puede llegar al destino");
            }
        } catch (AvionException e) {
            System.out.println(e.getMessage());
        }
    }
}
