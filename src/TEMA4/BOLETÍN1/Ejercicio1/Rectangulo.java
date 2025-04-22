/*
Crear una clase Rectangulo con los atributos longitud y ancho, cada uno con un
valor predeterminado igual a 1. Proporcionar los métodos set y get para los
atributos longitud y ancho respectivamente. El metodo set debe verificar que
longitud y ancho contengan números reales mayores que cero y menores que
20. Además, proporcionar métodos que calculen el perímetro y el área del
rectángulo.
Escribir un metodo Ejercicio4Pro que solicite los datos de un rectángulo y muestre cual es
su área y su perímetro. Probar a introducir un dato incorrecto (mayor o igual que
20).
*/

package TEMA4.BOLETÍN1.Ejercicio1;

//atributos
public class Rectangulo {
    private int longitud;
    private int ancho;

    //Constructor
    public Rectangulo() {
        longitud = 1;
        ancho = 1;
    }

    //METODOS
    public int getLongitud() {
        return longitud; //retorna el valor dado en el set
    }

    //(int longitud) ya que es otro valor que nos ha pasado el usuario en la clase principal
    public void setLongitud(int longitud) throws RectanguloException {
        if (longitud <= 0 || longitud > 20) {
            throw new RectanguloException("La longitud es incorrecta.");
        }
        this.longitud = longitud; //Paso el valor que dio el usuario en la clase principal al atribito longitud de esta clase

    }
    //.......................................................................................................................
    public int getAncho() {
        return ancho; //retorna el valor dado en el set
    }

    // (int ancho) ya que es otro valor que nos ha dado el usuario en la clase principal
    public void setAncho(int ancho) throws RectanguloException {
        if (ancho <= 0 || ancho > 20) {
            throw new RectanguloException("El ancho es incorrecto.");
        }
        this.ancho = ancho; //Pasa el valor que dio el usuario en la clase principal al atributo ancho de esta clase

    }

    //METODOS PARA CALCULAR PERIMETRO Y AREA (FÁCIL)
    public float calcularPerimetro() {
        return 2 * (longitud + ancho);
    }

    public float calcularArea() {
        return longitud * ancho;
    }
}
