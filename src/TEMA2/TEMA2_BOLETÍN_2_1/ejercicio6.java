package TEMA2.TEMA2_BOLETÍN_2_1;/*EJERCICIO 6, BOLETÍN 2.1
Realizar un programa que lea el número de alumnos que hay en una clase.
A continuación debe leer la nota de cada uno de ellos en un examen y nos
debe informar del número de suspensos y aprobados, así como los
porcentajes.
 */
import java.util.Scanner;
public class ejercicio6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Pon el numero de alumnos");
        int alumnos = entrada.nextInt();
        int i = alumnos;
        float nota;
        int aprobados, suspensos;
        aprobados = 0;
        suspensos = 0;
        do {
            System.out.println("Pon la nota del alumno");
            nota = entrada.nextFloat();
            i--;

             if (nota >= 5) {
                 aprobados++;
             } else {
                 suspensos++;
             }
        } while (i > 0);

        System.out.println("El numero de aprobados es " + aprobados);
        System.out.println("El numero de suspensos es " + suspensos);
        float porcentajeAprob = aprobados / alumnos * 100;
        float porcentajeSusp = porcentajeAprob-100;
        System.out.println("El porcentaje de aprobados es " +porcentajeAprob+ "% " + " y de suspensos " +porcentajeSusp+ "%");
    }
}