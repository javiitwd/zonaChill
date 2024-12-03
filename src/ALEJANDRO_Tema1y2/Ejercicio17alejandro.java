package ALEJANDRO_Tema1y2;/*
Ejercicio 17(Alejandro): Una empresa que se dedica a la venta de
desinfectantes necesita un programa para gestionar las facturas.
En cada factura figura: el código del artículo, la cantidad vendida
en lítros y el precio por litro. Se pide de 5 facturas introducidas:
Facturación total, cantidad en litros vendidos del artículo 1 y cuántas
facturas se emitieron de más de $600.
 */
import java.util.Scanner;

public class Ejercicio17alejandro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);

        int facturas = 5;
        int cantidadlitros, mas600=0, cantidad1=0;
        float preciolitro,  total, acumulador = 0;
        char codigo;

        do {
            facturas--;
            System.out.println("Pon el código");
            codigo = entrada.next().charAt(0);
            System.out.println("Pon la cantidad de litros");
            cantidadlitros = entrada.nextInt();
            System.out.println("Pon el precio por litros");
            preciolitro = entrada.nextFloat();

            if(codigo=='1'){
                cantidad1 = cantidad1+cantidadlitros;
            }

            total = (float) cantidadlitros*preciolitro;
            if(total>=600){
                mas600++;
            }
            acumulador = acumulador +(cantidadlitros*preciolitro);

        }while (facturas>0);
        System.out.println("La facturación total es " +acumulador);
        System.out.println("La cantidad de litros vendidos de artículo 1 es " +cantidad1);
        System.out.println("Se emitieron " +mas600+ " facturas de 600$");
    }
}
