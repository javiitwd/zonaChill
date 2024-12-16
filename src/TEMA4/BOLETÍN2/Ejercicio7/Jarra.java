package TEMA4.BOLETÍN2.Ejercicio7;

public class Jarra {
    private double capacidad;
    private double cantidad;
    private double cantidadConsumida;

    public Jarra(double capacidad) {
        this.capacidad = capacidad;
        this.cantidad = 0;
        this.cantidadConsumida = 0;
    }

    public void llenarJarra() {
        this.cantidadConsumida += this.capacidad - this.cantidad;
        this.cantidad = this.capacidad;
    }

    public void vaciarJarra() {
        this.cantidad = 0;
    }

    /**
     * @param otraJarra es la jarra en la que se volcará el agua de esta
     * @return la cantidad de agua transferida
     */
    public double volcar(Jarra otraJarra) {
        double cantidadTraspasada = 0;
        if (otraJarra.cantidad != otraJarra.capacidad && (this.cantidad != 0)) {
            double cantidadFaltante = otraJarra.capacidad - otraJarra.cantidad;
            if (this.cantidad >= cantidadFaltante) {
                otraJarra.cantidad = otraJarra.capacidad;
                cantidadTraspasada = cantidadFaltante;
                this.cantidad -= cantidadFaltante;
            } else {
                otraJarra.cantidad += this.cantidad;
                cantidadTraspasada = this.cantidad;
                this.cantidad = 0;
            }
        }
        return cantidadTraspasada;
    }

    @Override
    public String toString() {
        return String.format("La jarra tiene %.2f litros", cantidad);
    }

    public double getCantidadConsumida() {
        return cantidadConsumida;
    }
}