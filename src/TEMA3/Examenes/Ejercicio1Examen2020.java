/*
Ejercicio 1.

En EEUU, el sistema de voto es distinto al sistema de voto español. Cada uno de los 50 estados (más el Distrito de Columbia)
tienen un número predefinido de "electores". Son estos electores los que al final votan a un partido u otro.
Los electores son o republicanos, o demócratas (existen más partidos pero son tan minoritarios que no los tendremos en cuenta aquí).
Los ciudadanos de cada estado votan a uno de los dos partidos, y el que más votos obtenga se lleva la totalidad de los electores de dicho estado.
Por tanto, un candidato puede ser el más votado, pero no salir elegido presidente (de hecho, este fue el caso de las elecciones de 2016 con Hillary Clinton y Donald Trump).

Se pide que dado:
 - un array con el nombre de los estados
 - un array con el número de electores del mismo
 - un array con el número de personas que votaron al partido demócrata
 - un array con el número de personas que votaron al partido republicano

Determines:
 - 1.De qué partido es el presidente electo de los estados unidos
 - 2.Cuántos electores obtienen ambos partidos en total
 - 3.Cuál es el partido más votado con el nº de votos totales
 - 4.El número de estados que apoyan a cada partido
 - 5.Qué estado es el que más electores aporta a cada partido, y cuántos electores aporta

Teniendo en cuenta que el índice que ocupa un estado es el mismo en todos los arrays.
Considera que no es posible que en un estado, los dos partidos obtengan el mismo número de votos.
*/
package TEMA3.Examenes;

public class Ejercicio1Examen2020 {
    public static void main(String[] args) {

        String[] estados = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Carolina del Norte", "Carolina del Sur", "Colorado", "Connecticut", "Dakota del Norte", "Dakota del Sur", "Delaware", "Distrito de Columbia", "Florida", "Georgia", "Hawái", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Luisiana", "Maine", "Maryland", "Massachusetts", "Míchigan", "Minnesota", "Mississippi", "Misuri", "Montana", "Nebraska", "Nevada", "Nueva Jersey", "Nueva York", "Nuevo Hampshire", "Nuevo México", "Ohio", "Oklahoma", "Oregón", "Pensilvania", "Rhode Island", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Virginia Occidental", "Washington", "Wisconsin", "Wyoming"};
        int[] electoresEstado = {9, 3, 11, 6, 55, 15, 9, 9, 7, 3, 3, 3, 3, 29, 16, 4, 4, 20, 11, 6, 6, 8, 8, 4, 10, 11, 16, 10, 6, 10, 3, 5, 6, 14, 29, 4, 5, 18, 7, 7, 20, 4, 11, 38, 6, 3, 13, 5, 12, 10, 3};
        int[] votosDemocratas = {729547, 116454, 1161167, 380494, 8753788, 1338870, 897572, 235603, 282830, 4504975, 1877963, 266891, 189765, 3090729, 1033126, 653669, 427005, 628854, 780154, 715326, 1677928, 1995196, 2268839, 1367716, 485131, 1071068, 177709, 568988, 539260, 348526, 2148278, 385234, 4556124, 2189316, 93758, 2394164, 420375, 1002106, 2926441, 252525, 855373, 117458, 870695, 3877868, 310676, 178573, 1981473, 1742718, 188794, 1382536, 55973};
        int[] votosRepublicanos = {1318255, 163387, 1252401, 684872, 4483810, 1202484, 673215, 185127, 12723, 4617886, 2089104, 128847, 409055, 2146015, 1557286, 800983, 671018, 1202971, 1178638, 671154, 943169, 1090893, 2279543, 1322951, 700714, 1594511, 279240, 991922, 512058, 345790, 1601933, 319667, 2819534, 2362631, 216794, 2841005, 949136, 782403, 2970733, 180543, 1155389, 227721, 1522925, 4685047, 515231, 95369, 1769443, 1221747, 489371, 1405284, 174419};

        //1, 2 y 5
        partidoPresidenteElecto(electoresEstado, votosDemocratas, votosRepublicanos, estados);

        //3 y 4
        partidoMasVotado(electoresEstado, votosDemocratas, votosRepublicanos);
    }

    //----------------------------------------------------------------------------------------------------------------------
    //1 y 2
    private static void partidoPresidenteElecto(int[] electoresEstado, int[] votosDemocratas, int[] votosRepublicanos, String[] estados) {
        int votoElectoRepublicano = 0;
        int votoElectoDemocrata = 0;

        //5
        int estadoMasAportaDemocratas = 0;
        int estadoMasAportaRepublicanos = 0;

        int posicionEstadoRepublicano = 0;
        int posicionEstadoDemocrata = 0;

        for (int i = 0; i < votosDemocratas.length; i++) {
            if (votosRepublicanos[i] > votosDemocratas[i]) {
                votoElectoRepublicano += electoresEstado[i];

                if (electoresEstado[i] > estadoMasAportaRepublicanos) { //Esto es para el 5 -> comparo si la posición actual aporte más electores con estadoMasAportaRepublicanos y lo actualizo,
                    estadoMasAportaRepublicanos = electoresEstado[i];   //ademas pillo esla posición y la meto en otra variable, ya que me hará falta para saber qué país es.
                    posicionEstadoRepublicano = i;
                }

            } else {
                votoElectoDemocrata += electoresEstado[i];

                if (electoresEstado[i] > estadoMasAportaDemocratas) { //Esto es para el 5
                    estadoMasAportaDemocratas = electoresEstado[i];
                    posicionEstadoDemocrata = i;
                }
            }
        }

        //1 y 2
        if (votoElectoDemocrata > votoElectoRepublicano) {
            System.out.println("Los democratas ganan con " + votoElectoDemocrata + " electores, los respublicanos han conseguido " + votoElectoRepublicano);
        } else {
            System.out.println("Los republicanos ganan con " + votoElectoRepublicano + " electores, los democratas han conseguido " + votoElectoDemocrata);
        }

        //5

        System.out.println("El estado que más aporta al partido demócrata es " + estados[posicionEstadoDemocrata] + " aportando " + estadoMasAportaDemocratas + " electores y ");

        System.out.println("El estado que más aporta al partido republicano es " + estados[posicionEstadoRepublicano] + " aportando " + estadoMasAportaRepublicanos + " electores");


    }

    private static void partidoMasVotado(int[] electores, int[] votosDemocratas, int[] votosRepublicanos) {
        //3
        int votosTotalesDemocratas = 0;
        int votosTotalesRepublicanos = 0;

        //4
        int estadosQueApoyanDemocratas = 0;
        int estadosQueApoyanRepublicanos = 0;

        for (int i = 0; i < votosDemocratas.length; i++) {
            votosTotalesDemocratas += votosDemocratas[i];
            votosTotalesRepublicanos += votosRepublicanos[i];

            if (votosDemocratas[i] > votosRepublicanos[i]) { //esto es para el 4
                estadosQueApoyanDemocratas++;
            } else {
                estadosQueApoyanRepublicanos++;
            }
        }
        //3
        if (votosTotalesDemocratas > votosTotalesRepublicanos) {
            System.out.println("El partido más votado ha sido el demócrata con " + votosTotalesDemocratas + " votos");
        } else {
            System.out.println("El partido más votado ha sido el republicano con " + votosTotalesRepublicanos + " votos");
        }

        //4
        System.out.println("El partido demócrata es apoyado por " + estadosQueApoyanDemocratas + " estados y el republicano por " + estadosQueApoyanRepublicanos);

    }
}
