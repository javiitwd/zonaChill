package TEMA4.EXAMENES_TEMA4.Examen2021;

import java.util.Scanner;

public class PrincipalParking {
    public static void main(String[] args) throws ParkingException {
        Scanner sc = new Scanner(System.in);

        Coche coche = null;
        Parking parking = new Parking();

        boolean salir = false;

        while (!salir) {

            System.out.println("Seleccione una opcion");
            System.out.println("1.- Aparcar coche");
            System.out.println("2.- Ver coche aparcado");
            System.out.println("3.- Buscar coche por matrícula");
            System.out.println("4.- Calcular tarifa");
            System.out.println("5.- Salir");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("Ponga los siguientes datos:");
                        System.out.println("Nombre del propietario: ");
                        String nombrePropietario = sc.nextLine();
                        sc.nextLine();
                        System.out.println("Matrícula vehículo: ");
                        String matriculaVehiculo = sc.next();
                        System.out.println("Número de kilómetros: ");
                        double numeroKilometros = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Marca: ");
                        String marca = sc.next();

                        //Creamos un objeto tipo coche con los datos recogidos
                        coche = new Coche(nombrePropietario, matriculaVehiculo, numeroKilometros, marca);
                        //Aparcamos el coche creado
                        parking.aparcarCoche(coche);
                    } catch (ParkingException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Ponga su número de plaza");
                        int numPlaza = sc.nextInt();
                        //Guardamos el coche como cocheAMostrar
                        Coche cocheAMostrar = parking.mostrarDatosDelCoche(numPlaza);
                        System.out.println("Nombre del propietario: ");
                        System.out.println(cocheAMostrar.getNombrePropietario());
                        System.out.println("Matrícula vehículo: ");
                        System.out.println(cocheAMostrar.getMatriculaVehiculo());
                        System.out.println("Número de kilómetros: ");
                        System.out.println(cocheAMostrar.getNumeroKilometros());
                        System.out.println("Número de kilómetros: ");
                        System.out.println(cocheAMostrar.getMarca());
                        System.out.println("Fecha de aparcamiento: ");
                        System.out.println(cocheAMostrar.getFechaAparcamiento());
                    } catch (ParkingException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Ponga la matrícula");
                        String matriculaABuscar = sc.next();
                        if (!Coche.matriculaValida(matriculaABuscar)) {
                            System.out.println("Matrícula no válida");
                        }
                        //Guardamos la plaza del coche que tiene la matricula solicitada
                        int plazaDelCoche = parking.buscarCochePorMatricula(matriculaABuscar);

                        //Guardamos el coche como cocheAMostrar
                        Coche cocheAMostrar = parking.mostrarDatosDelCoche(plazaDelCoche);

                        //Hacemos lo mismo que en la opcion 2
                        System.out.println("Nombre del propietario: ");
                        System.out.println(cocheAMostrar.getNombrePropietario());
                        System.out.println("Matrícula vehículo: ");
                        System.out.println(cocheAMostrar.getMatriculaVehiculo());
                        System.out.println("Número de kilómetros: ");
                        System.out.println(cocheAMostrar.getNumeroKilometros());
                        System.out.println("Número de kilómetros: ");
                        System.out.println(cocheAMostrar.getMarca());
                        System.out.println("Fecha de aparcamiento: ");
                        System.out.println(cocheAMostrar.getFechaAparcamiento());

                    } catch (ParkingException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.println("Ponga la matrícula");
                        String matricula = sc.next();

                        System.out.printf("Debe pagar %s \n", parking.calcularTarifa(matricula));

                    } catch (ParkingException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Ponga una opcion valida");
            }
        }
    }
}
