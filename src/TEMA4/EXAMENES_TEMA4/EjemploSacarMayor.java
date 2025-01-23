package TEMA4.EXAMENES_TEMA4;

public class EjemploSacarMayor {

    public class Vehiculo {
        private String nombre;
        private double precio;

        // Constructor
        public Vehiculo(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        // Getters
        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }
    }

    public class Main {

        public static void encontrarMasCaro(Vehiculo[] vehiculos) {
            if (vehiculos.length == 0) {
                System.out.println("No hay vehículos en el array.");
                return;
            }

            //Inicializar con el precio del primer vehículo
            double maxPrecio = vehiculos[0].getPrecio();

            //Contador para vehículos con el precio máximo
            int conteoMaximos = 0;

            //Primer bucle: encontrar el precio máximo
            for (int i = 1; i < vehiculos.length; i++) {
                Vehiculo v = vehiculos[i];
                //Si la posicion actual es mayor que el numero maximo lo sustituye
                if (v.getPrecio() > maxPrecio) {
                    maxPrecio = v.getPrecio();
                    conteoMaximos = 1; //Reiniciar el conteo
                } else if (v.getPrecio() == maxPrecio) {
                    conteoMaximos++; //Incrementar el conteo si el precio es igual al máximo
                }
            }

            //Segundo bucle: imprimir los vehículos con el precio máximo
            System.out.println("Vehículos más caros:");
            for (int i = 0; i < vehiculos.length; i++) {
                Vehiculo v = vehiculos[i];
                if (v.getPrecio() == maxPrecio) {
                    System.out.println("Nombre: " + v.getNombre() + ", Precio: " + v.getPrecio());
                }
            }
        }
    }
}