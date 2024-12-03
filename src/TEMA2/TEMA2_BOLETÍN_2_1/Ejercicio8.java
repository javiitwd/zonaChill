package TEMA2.TEMA2_BOLETÍN_2_1;/*
EJERCICICIO 8: Realizar un programa que calcule las soluciones de una ecuación de
segundo grado. Deben pedirse los tres coeficientes A, B, C e informar de si
la ecuación tiene dos soluciones, una solución, o ninguna solución.
A*x2+ B*x+C= 0
 */
import java.util.Scanner;
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double a, b, c;
        System.out.println("Pon 3 números");
        a = entrada.nextDouble();
        b = entrada.nextDouble();
        c = entrada.nextDouble();

        double discriminante = (b * b) - 4 * a * c;
        double raiz = Math.sqrt(discriminante);

        if (discriminante < 0) {
            System.out.println("No tiene solución");
        } else if (discriminante == 0) {
            double igualacero = -b / (2 * a);
            System.out.println("Tiene una solución real " +igualacero);
        } else if (discriminante > 0) {

            double x1 = (-b + raiz) / (2*a);
            double x2 = (-b - raiz) / (2*a);

            System.out.println("Tiene 2 soluciones: x1= " +x1+ " y x2= " +x2);

        }
    }
}
