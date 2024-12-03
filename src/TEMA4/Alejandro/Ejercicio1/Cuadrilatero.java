/*
Construir un programa que calcule el area y el perimetro de un cuadrilatero
dada la longuitud de sus dos lados. Los valores de la longitud deberan introducirse
por lineas de ordenes. Si es un cuadrado, solo se proporcionara la longuitud de
uno de los lados al constructor
 */

package TEMA4.Alejandro.Ejercicio1;

public class Cuadrilatero {
    //Atributos
    private float ladoA;
    private float ladoB;

    //Constructor 1
    public Cuadrilatero (float ladoA, float ladoB){

        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    //Constructor 2 (funciona solo cuando sea un cuadrado)
    public Cuadrilatero (float ladoA){

        this.ladoA = this.ladoB = ladoA;
    }

    public float getPerimetro (){  //Los getter no llevan nada entre (), solo retornan valor

        float perimetro = 2 * (ladoA+ladoB);

        return perimetro;
    }

    public float getArea (){

        float area = (ladoA*ladoB);

        return area;
    }
}
