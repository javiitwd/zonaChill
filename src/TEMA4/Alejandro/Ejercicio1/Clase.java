/*
Construir un programa que calcule el area y el perimetro de un cuadrilatero
dada la longuitud de sus dos lados. Los valores de la longitud deberan introducirse
por lineas de ordenes. Si es un cuadrado, solo se proporcionara la longuitud de
uno de los lados al constructor
 */

package TEMA4.Alejandro.Ejercicio1;

public class Clase {

    private float lado1;
    private float lado2;

    //FALLE EN SOLO PONER EL 2º CONSTRUCTOR Y NO TENER EN CUNTA EL PRIMERO

    //Constructor 1
    public Clase (float lado1){

        this.lado1 = this.lado2 = lado1;
    }
    //Constructor 2
    public Clase(float lado1, float lado2) {

        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    //FALLE EN NO PONER LOS GETTER Y SETTER
    public float getPerimetro() {
        float perimetro = 2*(lado1 +lado2);

        return perimetro;
    }

    public float getArea(){
        float area = (lado1 * lado2);

        return area;
    }
}
