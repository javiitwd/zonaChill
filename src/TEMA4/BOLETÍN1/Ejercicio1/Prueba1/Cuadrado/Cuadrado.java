/*
Crear una clase Rectangulo con los atributos longitud y ancho, cada uno con un
valor predeterminado igual a 1. Proporcionar los métodos set y get para los
atributos longitud y ancho respectivamente. El metodo set debe verificar que
longitud y ancho contengan números reales mayores que cero y menores que
20. Además, proporcionar métodos que calculen el perímetro y el área del
rectángulo.
Escribir un metodo main que solicite los datos de un rectángulo y muestre cual es
su área y su perímetro. Probar a introducir un dato incorrecto (mayor o igual que
20).
*/
package TEMA4.BOLETÍN1.Ejercicio1.Prueba1.Cuadrado;

public class Cuadrado {

    private int longitud;
    private int ancho;

    public Cuadrado (){
        longitud = 1;
        ancho = 1;
    }

    public int getLongitud(){
        return longitud;
    }

    public int setLongitud(int longitud) throws CuadradoException{

        if (longitud <= 0 || longitud >20){
            throw new CuadradoException ("No esta en los limites");
        }
        return this.longitud = longitud;
    }

    public int getAncho() {
        return ancho;
    }

    public int setAncho (int ancho) throws CuadradoException{

        if (ancho <= 0 || ancho > 20){
            throw new CuadradoException("Se pasa de los limites");
        }

        return this.ancho = ancho;
    }

    public int calcularPerimetro(){

        return 2 * (ancho + longitud);
    }

    public int calculaArea(){

        return (ancho*longitud);
    }
}
