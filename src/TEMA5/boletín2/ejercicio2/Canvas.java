package TEMA5.boletín2.ejercicio2;

public class Canvas {

    private Forma[] formas;

    public Canvas() {
        formas = new Forma[]{new Circulo(4), new Rectangulo(2, 3), new Linea(3),  new CirculoMovible()};
    }

    public static void main(String[] args) {

        Canvas canvas = new Canvas();

        try {
            dibujaYAnimaFormas(canvas.formas);
        } catch (FiguraException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void dibujaYAnimaFormas(Forma[] formas) throws FiguraException {

        for (Forma f : formas) {

            if (f instanceof Dibujable d) {
                d.dibujar();
            }

            if (f instanceof Animable) {
                Animable a = (Animable) f;
                a.animar();
            }

            System.out.println("Area: " + f.calcularArea());
        }
    }
}
