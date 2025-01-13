package TEMA4.EXAMENES_TEMA4.Examen2021;

import java.time.LocalDate;

public class Parking {
    public static final double PRECIO_POR_DIA = 12.65;
    private Coche[] cochesAparcados;

    public Parking() {
        this.cochesAparcados = new Coche[30];
    }

    //Metodo que devuelve el numero de coches aparcados actualmente
    public int buscarPlazasDisponibles() {

        //Recorremos el parking, si la plaza actual esta vacia, devolvemos esa posicion
        for (int i = 0; i < cochesAparcados.length; i++) {
            if (cochesAparcados[i] == null) {
                return i;
            }
        }
        //Si no hay plazas libres devolvemos -1
        return -1;
    }

    public void aparcarCoche(Coche cocheAAparcar) throws ParkingException {

        if (buscarPlazasDisponibles() == -1) {
            throw new ParkingException("No hay plazas libre actualmente");
        }
        //Si hay plazas metemos el coche en el parking
        cochesAparcados[buscarPlazasDisponibles()] = cocheAAparcar;
    }

    //Este metodo devolverá el coche que está aparcado en la posicion indicada
    //Para que después, se puedan sacar sus datos con los getter necesarios.
    public Coche mostrarDatosDelCoche(int posicionDelCoche) throws ParkingException {

        //Sino hay coches en esa posicion lanzamos una excepcion
        if (cochesAparcados[posicionDelCoche] == null) {
            throw new ParkingException("No hay ningún coche en esa posición");
        }

        return cochesAparcados[posicionDelCoche];
    }

    public int buscarCochePorMatricula(String matricula) throws ParkingException {

        //Recorro todos los coches aparcados y voy sacando sus matriculas con los getter
        for (int i = 0; i < cochesAparcados.length; i++) {
            //Si la matricula del el coche que está en la plaza 'i' coincide con la matricula, returno su plaza
            if (cochesAparcados[i].getMatriculaVehiculo().equals(matricula)) {
                return i;
            }
        }
        //Si no se encontró la matricula una excepcion
        throw new ParkingException("No se ha encontrado la matrícula");
    }

    public double calcularTarifa(String matriculaCoche) throws ParkingException {

        //Usamos el metodo buscarCochePorMatricula para obtener su lugar de plaza
        int posicionDelCoche = buscarCochePorMatricula(matriculaCoche);

        //Guardamos el coche de la plaza obtenida
        Coche cocheACalcularTarifa = mostrarDatosDelCoche(posicionDelCoche);

        //Obtenemos la fecha en la que se introdujo el coche
        LocalDate fechaDeEntrada = cocheACalcularTarifa.getFechaAparcamiento();

        //Obtenemos la fecha de salida (ahora)
        LocalDate fechaDeSalida = LocalDate.now();

        //Guardamos lso dias que han pasado en una variable de tipo entero
        int diasTranscurridos = fechaDeEntrada.compareTo(fechaDeSalida);

        //Calculamos lo que debe pagar la persona
        double precioAPagar = diasTranscurridos * PRECIO_POR_DIA;

        return precioAPagar;
    }
}