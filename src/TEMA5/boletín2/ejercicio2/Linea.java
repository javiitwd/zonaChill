package TEMA5.boletín2.ejercicio2;

public class Linea extends Forma implements Dibujable{

    private int longuitud;

    public Linea(int longuitud) {
        this.longuitud = longuitud;
    }



    @Override
    public double calcularArea() throws FiguraException {

        throw new FiguraException("La linea no puede calcular su área");
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando linea");
    }
}
