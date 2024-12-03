package ALEJANDRO_Tema1y2;

/*
Ejercicio 11(Alejandro): Diseñar un programa
que muestre el producto de los 10 primeros
números impares
 */
public class ejercicio11alejandro {
    public static void main(String[] args) {
        int i, mult;
        mult=1;
        for(i=1; i<=20; i+=2){
            mult = i*mult;
        }
        System.out.println("El producto es " +mult);
    }
}
