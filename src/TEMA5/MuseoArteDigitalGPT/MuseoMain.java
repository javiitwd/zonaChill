package TEMA5.MuseoArteDigitalGPT;

import Comun.MiEntradaSalida;

import java.time.LocalDate;
import java.util.Scanner;

public class MuseoMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {

            Museo museo = new Museo();

            System.out.println("OPCIONES");
            System.out.println("Agregar nuevas obras de arte digital");
            System.out.println("Mostrar todas las obras almacenadas");
            System.out.println("Consultar las obras más populares");
            System.out.println("Registrar una restauración en una obra");
            System.out.println("Extender la duración de una exhibición exclusiva");
            System.out.println("Actualizar el registro de interacciones de una obra interactiva");
            System.out.println("Consultar el historial de modificaciones de una obra restaurada");

            int op = sc.nextInt();

            switch (op) {

                case 1:
                    Obra obra = solicitarTipoDeObra();
                    museo.anadirObra(obra);
                    break;
                case 2:

            }
        }
    }

    public static Obra solicitarTipoDeObra() {

        Obra obra = null;

        String titulo = MiEntradaSalida.solicitarCadena("Pon el titulo");
        System.out.println("Ponga la fecha: ");
        int anoCreacion = MiEntradaSalida.solicitarEntero("Año: ");
        int codigoInventario = MiEntradaSalida.solicitarEntero("Codigo");
        String autor = MiEntradaSalida.solicitarCadena("Autor: ");
        double valor = MiEntradaSalida.solicitarEntero("Ponga el precio");

        System.out.println("Especifique su tipo de obra");
        int tipoObra = MiEntradaSalida.solicitarEnteroEnRango("1. Imagen digital 2. Modelo 3D", 1, 2);

        if (tipoObra == 1) {

            int resolucion = MiEntradaSalida.solicitarEntero("Ponga la resolucion");
            String formato = MiEntradaSalida.solicitarCadena("Ponga el formato");

            System.out.println("1. Interactiva / 2. Exclusiva");
            int funcionObra = MiEntradaSalida.solicitarEnteroEnRango("Seleccione la funcionalidad", 1, 2);

            if (funcionObra == 1) {
                String tipoInteraccion = MiEntradaSalida.solicitarCadena("Ponga el tipo de interaccion");

                return obra = new ImagenDigitalInteractiva(titulo, autor, anoCreacion, codigoInventario, valor, resolucion, formato, tipoInteraccion);

            } else {

                System.out.println("Ponga la fecha de finalizacion de la exhibicion: ");
                int anoExhibicion = MiEntradaSalida.solicitarEntero("Año: ");
                int mesExhibicion = MiEntradaSalida.solicitarEntero("Mes: ");
                int diaExhibicion = MiEntradaSalida.solicitarEntero("Dia: ");

                LocalDate fechaExhibicion = LocalDate.of(anoExhibicion, mesExhibicion, diaExhibicion);

                int numAcesosPermitidos = MiEntradaSalida.solicitarEntero("Num de acesos: ");

                return obra = new ImagenDigitalExclusiva(titulo, autor, anoCreacion, codigoInventario, valor, resolucion, formato, fechaExhibicion, numAcesosPermitidos);
            }
        }
        return null;
    }

}
