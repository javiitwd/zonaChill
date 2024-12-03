package ALEJANDRO_Tema1y2;/*
Ejercicio 15(Alejandro): Dadas las edades y alturas de 5 alumnos,
mostrar la edad y la estatura media, la cantidad de alumnos mayores
de 18 años, y la cantidad de alumnos mayores de 18 años, y la cantidad
de alumnos que miden más de 1,75.
 */
import java.util.Scanner;
public class Ejercicio15alejandro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int alumnos = 5, edad;
        float edadmedia=0, alturamedia=0;
        float altura;
        int mas18 = 0, mas175 = 0;
        do{
            alumnos--;
            System.out.println("Pon la edad del alumno");
            edad = entrada.nextInt();
            edadmedia = edad + edadmedia; //suma la edad
            if(edad>=18){
                mas18++; //Si la edad es maoyor a 18 es contador aumenta
            }

            System.out.println("Pon la altura");
            altura = entrada.nextFloat();
            alturamedia = altura + alturamedia; //suma la altura
            if(altura>1.75){
                mas175++; //si la altura es mayor a 1,75 el contador aumenta
            }
        }while (alumnos>0);
        System.out.println("La edad media es " +edadmedia/5);
        System.out.println("La altura media es " +alturamedia/5);
        System.out.println("La cantidad de alumnos con más de 18 es " +mas18);
        System.out.println("La cantidad de alumnos que miden más de 1,75 es " +mas175);
    }
}
