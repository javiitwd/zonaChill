package TEMA6.Boletín1.Ejercicio3.Prueba1;

public class Main {
    public static void main(String[] args) {

        Persona p1 = new Alumno("Carlitos", 12);
        Persona p2 = new Alumno("Carlos", 18);

        Persona p3 = new Profesor("Euyin", 24);
        Persona p4 = new Profesor("Uyine", 27);

        try {
            System.out.println("Enviar mensaje: ");
            //p1.enviarMensaje("Hola", p2);
            p3.enviarMensaje("Has aprobado", p1);
            p2.enviarMensaje("Hola", p1);
            p4.enviarMensaje("Andate", p1);

            System.out.println("Leer mensajes: ");
            System.out.println(p1.leerMensajesDelBuzon());

            System.out.println("Ordenar mensajes: ");
            System.out.println(p1.leerMnesajesDelBuzonAlfabeticamente());

            System.out.println("Eliminar mensaje: ");
            p1.borrarMensajeDelBuzon(2);

            System.out.println(p1.leerMensajesDelBuzon());

            System.out.println("Encontrar mensajes con X frase: ");
            System.out.println(p1.buscarMensajesQueContienenUnaFrase("Hola"));

        }catch (MensajesException e){
            System.out.println(e.getMessage());
        }
    }
}
