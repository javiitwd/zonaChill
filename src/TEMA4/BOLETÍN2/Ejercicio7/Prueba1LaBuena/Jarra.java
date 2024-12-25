package TEMA4.BOLETÍN2.Ejercicio7.Prueba1LaBuena;

public class Jarra {
    public static float aguaConsumida = 0;

    private float cantidad;
    private float capacidad;

    public Jarra(float capacidad) {
        cantidad = 0;
        this.capacidad = capacidad;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }

    //Opcion1
    public void llenarJarra() throws JarraException {
        if (this.cantidad == this.capacidad){
            throw new JarraException("La jarra ya está llena");
        }
        aguaConsumida += (capacidad - cantidad);
        cantidad = capacidad;
    }

    //Opcion2
    public void vaciarJarra() throws JarraException {
        if (this.cantidad == 0) {
            throw new JarraException("La jarra ya está vacía");
        }
        cantidad = 0;
    }

    /**
     * @param otraJarra es donde voy a volcar el Agua de la jarra
     *                  actual
     */

    //Opcion3
    public void volcarJarra(Jarra otraJarra) throws JarraException {
        //Si mi jarra no está vacía y la otra no está llena...
        if (this.cantidad > 0 && otraJarra.cantidad < otraJarra.capacidad) {
            //Si mi cantidad es menor que lo que aún puede aceptar la otra jarra
            float capacidadFaltanteOtraJarra = otraJarra.capacidad - otraJarra.cantidad;
            if (this.cantidad <= (capacidadFaltanteOtraJarra)) {
                //Le echo la cantidad de la jarra actual a la otra jarra
                otraJarra.cantidad += this.cantidad;
                this.cantidad = (capacidadFaltanteOtraJarra - this.cantidad); //La jarra actual se queda con el resultado de haberle echado su cantidad a lo faltante de la otra jarra
            } else {
                throw new JarraException("La jarra tiene demasiada cantidad como para volcarla");
            }
        } else {
            throw new JarraException("Opcion actual no disponible");
        }
    }

    public float consultarAguaConsumida(){
        return aguaConsumida;
    }
}
