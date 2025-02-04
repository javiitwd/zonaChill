package TEMA6.Boletín1.Ejercicio3;

public class Main {
    public static void main(String[] args) {

        Persona alumno1 = new Alumno("Antoñito", 15);
        Persona alumno2 = new Alumno("Antonio", 35);

        Persona maestro1 = new Profesor("Juan", 80);
        Persona maestro2 = new Profesor("Villaba", 80);

        try {

            System.out.println("Un metodo para poder enviar un mensaje a otra persona");
           // alumno1.enviarMensaje(alumno2, "Illo fornike o klk");
            maestro1.enviarMensaje(maestro2, "Illo un Vonneuman o klk");
            alumno1.enviarMensaje(maestro2, "Voy a por ti");

            System.out.println("Un metodo para poder leer los mensajes del buzón");
            System.out.println(maestro2.leerMensajes());

            System.out.println("mensajes del buzón pero ordenado por el nombre del remitente alfabéticamente");
            System.out.println(maestro2.ordenarMensajes());
            System.out.println(maestro2.leerMensajes());

            System.out.println("Un metodo para poder borrar un mensaje del buzón");
            maestro2.borrarMensaje(1);
            System.out.println(maestro2.leerMensajes());

            System.out.println("Un metodo que realice una búsqueda para poder encontrar los mensajes de su buzón que contienen una frase");
            System.out.println(maestro2.buscarMensajes("Voy"));

        } catch (MensajeriaException e) {
            System.out.println(e.getMessage());
        }
    }
}
