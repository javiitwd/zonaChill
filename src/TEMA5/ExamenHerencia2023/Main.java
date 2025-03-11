package TEMA5.ExamenHerencia2023;

public class Main {

    public static void main(String[] args) {

        Juguete[] juguetes = new Juguete[10];

        Juguete cuboMadera = new FiguraMadera(2, "Cubo", "Cubik", "España", 2024, "Rojo", 4);
        Juguete dodecaedro = new FiguraMadera(4, "Dodecaedro", "Si", "Marruecos", 2000, "Amarillo", 16);
    }
}
