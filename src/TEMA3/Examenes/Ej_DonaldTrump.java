package TEMA3.Examenes;

public class Ej_DonaldTrump {
    public static void main(String[] args) {
        String[] estados = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Carolina del Norte", "Carolina del Sur", "Colorado", "Connecticut", "Dakota del Norte", "Dakota del Sur", "Delaware", "Distrito de Columbia", "Florida", "Georgia", "Hawái", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Luisiana", "Maine", "Maryland", "Massachusetts", "Míchigan", "Minnesota", "Mississippi", "Misuri", "Montana", "Nebraska", "Nevada", "Nueva Jersey", "Nueva York", "Nuevo Hampshire", "Nuevo México", "Ohio", "Oklahoma", "Oregón", "Pensilvania", "Rhode Island", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Virginia Occidental", "Washington", "Wisconsin", "Wyoming"};
        int[] electores = {9, 3, 11, 6, 55, 15, 9, 9, 7, 3, 3, 3, 3, 29, 16, 4, 4, 20, 11, 6, 6, 8, 8, 4, 10, 11, 16, 10, 6, 10, 3, 5, 6, 14, 29, 4, 5, 18, 7, 7, 20, 4, 11, 38, 6, 3, 13, 5, 12, 10, 3};
        int[] votosDemocratas = {729547, 116454, 1161167, 380494, 8753788, 1338870, 897572, 235603, 282830, 4504975, 1877963, 266891, 189765, 3090729, 1033126, 653669, 427005, 628854, 780154, 715326, 1677928, 1995196, 2268839, 1367716, 485131, 1071068, 177709, 568988, 539260, 348526, 2148278, 385234, 4556124, 2189316, 93758, 2394164, 420375, 1002106, 2926441, 252525, 855373, 117458, 870695, 3877868, 310676, 178573, 1981473, 1742718, 188794, 1382536, 55973};
        int[] votosRepublicanos = {1318255, 163387, 1252401, 684872, 4483810, 1202484, 673215, 185127, 12723, 4617886, 2089104, 128847, 409055, 2146015, 1557286, 800983, 671018, 1202971, 1178638, 671154, 943169, 1090893, 2279543, 1322951, 700714, 1594511, 279240, 991922, 512058, 345790, 1601933, 319667, 2819534, 2362631, 216794, 2841005, 949136, 782403, 2970733, 180543, 1155389, 227721, 1522925, 4685047, 515231, 95369, 1769443, 1221747, 489371, 1405284, 174419};

        calcularPresidente(electores,votosDemocratas, votosRepublicanos, estados);
    }

    public static void calcularPresidente (int[] electores, int[] votosDemocratas, int[] votosRepublicanos, String [] estados){
        //1
        int electoresDemocratas = 0;
        int electoresRepublicanos = 0;
        //2
        int votosTotalesDemocratas = 0;
        int votosTotalesRepublicanos = 0;
        //4
        int estadosApoyanDemocratas = 0;
        int estadosApoyanRepublicanos = 0;
        //5
        int masAporteRepublicanos = 0;
        int masAportaDemocratas = 0;
        int estadoMasAportaElectoresRepublicano = 0;
        int estadoMasAportaElectoresDemocrata = 0;

        for (int i = 0; i < electores.length; i++) {
            //1
            if (votosDemocratas[i] > votosRepublicanos[i]){
                electoresDemocratas += electores[i];
                estadosApoyanDemocratas++; //4
                //5
                if (electores[i] > masAportaDemocratas){
                    masAportaDemocratas = electores[i];
                    estadoMasAportaElectoresDemocrata = i;
                }
            } else {
                electoresRepublicanos += electores[i];
                estadosApoyanRepublicanos++; //4
                //5
                if (electores[i] > masAporteRepublicanos){
                    masAporteRepublicanos = electores[i];
                    estadoMasAportaElectoresRepublicano = i;
                }
            }
            //3
            votosTotalesDemocratas += votosDemocratas[i];
            votosTotalesRepublicanos += votosRepublicanos[i];
        }

        //1 y 2
        if (electoresDemocratas > electoresRepublicanos){
            System.out.println("El presidente es del partido democrata con " +electoresDemocratas+ " electores, mientras que el republicano obtuvo " +electoresRepublicanos);
        } else{
            System.out.println("El presidente es del partido republicano con " +electoresRepublicanos+ " electores, mientras que el democrata obtuvo " +electoresDemocratas);
        }

        //3
        if (votosTotalesDemocratas > votosTotalesRepublicanos){
            System.out.println("El partido más votado es el democrata con " +votosTotalesDemocratas+ " votos");
        }else {
            System.out.println("El partido más votado es el republicano con " +votosTotalesRepublicanos+ " votos");
        }

        //4
        System.out.println("Al partido republicano lo apoyan " +estadosApoyanRepublicanos+ " estados");
        System.out.println("Al partido democrata lo apoyan " +estadosApoyanDemocratas+ " estados");

        //5
        System.out.println("El estado que más aporta a los republicanos es " +estados[estadoMasAportaElectoresRepublicano]+ " aportandoles " +masAporteRepublicanos + " electores");
        System.out.println("El estado que más aporta a los democratas es " +estados[estadoMasAportaElectoresDemocrata]+ " aportandoles " +masAportaDemocratas + " electores");
    }
}