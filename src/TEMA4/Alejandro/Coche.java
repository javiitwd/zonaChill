package TEMA4.Alejandro;

public class Coche { //Crear clase

    //Crear atributos
    String marca;
    String color;
    int km;

    public static void main(String[] args) {

        //Crear objeto
        Coche coche1 = new Coche(); //Crear objeto

        coche1.marca = "Seat"; //Darle a un objeto un atributo con un valor
        coche1.color = "Azul";
        coche1.km = 0;

        System.out.println("El marca del coche1 es:" +coche1.marca);
        System.out.println("El color del coche1 es:" +coche1.color);
        System.out.println("Los km del coche1 es:" +coche1.marca);

        //Crear objeto
        Coche coche2 = new Coche(); //Crear objeto

        coche1.marca = "Audi";
        coche1.color = "Rojo";
        coche1.km = 100;

        System.out.println("El marca del coche2 es:" +coche2.marca);
        System.out.println("El color del coche2 es:" +coche2.color);
        System.out.println("Los km del coche2 es:" +coche2.marca);

    }



}

