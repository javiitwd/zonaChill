package TEMA5.BOLETÍN1.Ejercicio2;

import java.util.Scanner;

public class MenuVehiculos {

    public static void main(String[] args) throws VehiculosException {
        Scanner sc = new Scanner(System.in);

        empresaVehiculos empresaVehiculos = new empresaVehiculos();

        boolean salir = false;

        while (!salir) {
            System.out.println("Qué desea hacer?");
            System.out.println("1.- Alta de vehículo");
            System.out.println("2.- Cálculo de precio de alquiler");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    //PEDIR TIPO DE VEHICULO
                    System.out.println("Seleccione su tipo de vehículo");
                    System.out.println("1.- Coche");
                    System.out.println("2.- Furgoneta");
                    System.out.println("3.- Minibus");
                    int tipoVehiculo = sc.nextInt();

                    //PEDIR LA MATRICULA
                    System.out.println("Seleccione su matricula:");
                    String matricula = sc.next();

                    //PEDIR GAMA
                    System.out.println("Seleccione la gama:");
                    System.out.println("1.- Baja");
                    System.out.println("2.- Media");
                    System.out.println("3.- Alta");
                    int gamaSeleccionada = sc.nextInt();

                    //Guardamos la gama seleccionando su valor con el numero que nos ha dado el usuario
                    Tgama gama = Tgama.values()[gamaSeleccionada - 1];

                    // Alta de vehículo
                    Vehiculo nuevoVehiculo = null;
                    switch (tipoVehiculo) {
                        case 1:
                            System.out.println("Seleccione el combustible:");
                            System.out.println("1.- Gasolina");
                            System.out.println("2.- Diesel");
                            int combustibleSeleccionado = sc.nextInt();

                            //Guardamos el combustible seleccionando su valor con el numero que nos ha dado el usuario
                            Tcombustible combustible = Tcombustible.values()[combustibleSeleccionado - 1];

                            //Creamos un vehiculo con los datos que le hemos ido pidiendo al usuario
                            nuevoVehiculo = new Coche(matricula, gama, combustible);
                            break;
                        case 2:
                            //pedir pma
                            System.out.println("Introduzca el PMA de la furgoneta:");
                            double pma = sc.nextDouble();

                            //Creamos un vehiculo con los datos que le hemos ido pidiendo al usuario
                            nuevoVehiculo = new Furgoneta(matricula, gama, pma);
                            break;
                        case 3:
                            //pedir el numero de plazas para el microbus
                            System.out.println("Introduzca el número de plazas del microbús:");
                            int numPlazas = sc.nextInt();

                            //Creamos un vehiculo con los datos que le hemos ido pidiendo al usuario
                            nuevoVehiculo = new Microbus(matricula, gama, numPlazas);
                            break;
                    }

                    if (nuevoVehiculo != null) {

                        //Guardamos el total de vehiculos y nos aseguramos de que sea menor que el total
                        int totalVehiculos = empresaVehiculos.totalDeVehiculosActuales();
                        if (totalVehiculos < empresaVehiculos.MAX_VEHICULOS) {
                            //Si hay hueco, el la siguiente posicion al total meto el coche nuevo
                            empresaVehiculos.almacenDeVehiculos[totalVehiculos] = nuevoVehiculo;
                            System.out.println("Vehículo registrado con matrícula: " + matricula);
                        } else {
                            System.out.println("No se pueden registrar más vehículos. Capacidad máxima alcanzada.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ponga la matricula");
                    String matriculaABUscar = sc.next();
                    System.out.println("Ponga los dias que ha estado alquilado");
                    int diasAlquilados = sc.nextInt();

                    try {
                        double precioAlquiler = empresaVehiculos.calcularPrecioAlquiler(matriculaABUscar, diasAlquilados);
                        System.out.println("El precio de alquiler es: " + precioAlquiler + " euros.");

                    } catch (VehiculosException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
    }
}
