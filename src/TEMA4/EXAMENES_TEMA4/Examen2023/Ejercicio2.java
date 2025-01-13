package TEMA4.EXAMENES_TEMA4.Examen2023;

public class Ejercicio2 {
    public static void main(String[] args) {

        String estribillo = "Feliz Navidad, Feliz Navidad";
        StringBuilder cancion = new StringBuilder(estribillo);

        cancion.append("El módulo de programación quiero aprobar\n");
        cancion.append("A mi profesor favorito tendré que sobornar.\n");
        cancion.append("Jamón y gambas tendré que comprar.\n");
        cancion.append("Porque si no me tocará pringar.\n");
        cancion.append("Y el año que viene el doble tendré que pagar.\n");

        System.out.println();
        System.out.println(cancion.repeat(cancion,2));

        System.out.println(cancion);


    }
}
