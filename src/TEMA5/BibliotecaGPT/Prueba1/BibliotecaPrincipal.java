package TEMA5.BibliotecaGPT.Prueba1;

import java.util.Scanner;

public class BibliotecaPrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {

            System.out.println("Elige una opcion: ");
            System.out.println("1. Agregar un nuevo documento");
            System.out.println("2. Consultar documentos mas populares:");
            System.out.println("3. Salir");
            int op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.println("Elige el tipo: ");
                    System.out.println("1. Libro");
                    System.out.println("2. Articulo");
                    int tipo = sc.nextInt();

                    switch (tipo){

                        case 1:
                            System.out.println("Elige su funcionalidad");
                            System.out.println("1. Descargable");
                            System.out.println("2. Leible");
                            int funcionalidad = sc.nextInt();

                            System.out.println("Introduce los datos: ");
                    }
            }
        }
    }
}
