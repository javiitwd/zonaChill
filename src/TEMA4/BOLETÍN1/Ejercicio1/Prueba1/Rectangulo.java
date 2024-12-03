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

package TEMA4.BOLETÍN1.Ejercicio1.Prueba1;

public class Rectangulo {

    //Atributos
    private float longitud;
    private float ancho;

    //Constructor
    public Rectangulo(){

        longitud = 1;
        ancho = 1;
    }

    //Get y Set de Longitud
    public float getLongitud(){

        return longitud;
    }

    public float setLongitud(float longitud) throws RectanguloException{

        if (longitud <= 0 || longitud > 20){
            throw new RectanguloException ("La longitud es incorrecta");
        }
        return this.longitud = longitud;
    }

    //Get y Set de Ancho
    public float getAncho(){

        return ancho;
    }

    public float setAncho(float ancho) throws RectanguloException{

        if (ancho <= 0 || ancho > 20){

            throw new RectanguloException ("El ancho es incorrecto");
        }
        return this.ancho = ancho;
    }

    public float calcularPerimetro(){

        return 2 * (ancho + longitud);
    }

    public float calcularLArea(){

        return (longitud*ancho);
    }
}
