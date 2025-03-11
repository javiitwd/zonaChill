package TEMA6.Boletín1.Ejercicio6;

public class GranAlmacen {

    private static final int MAX_DE_CAJAS = 20;
    private static int numDeClientes = 0;
    private Caja[] cajas;

    public GranAlmacen() {
        this.cajas = new Caja[MAX_DE_CAJAS];
    }

    //Metodo para contar las cajas que hay en el almacen,
    //nos servira para asignarle un numero a la caja a la hora de su creacion
    //y para asegurarnos de que no superamos el maximo de cajas creadas
    private int numCajas() {
        int cajasEcontradas = 0;
        for (Caja caja : cajas) {
            if (caja != null) {
                cajasEcontradas++;
            }
        }
        return cajasEcontradas;
    }

    public void abrirCaja(int numCajaAAbrir) throws CajaException {

        //Me aseguro de que no se supera el numero de cajas que se pueden crear
        //y de que el numero de la caja que se quiere abrir es mayor que 0
        if (numCajas() >= MAX_DE_CAJAS || numCajaAAbrir < 0) {
            throw new CajaException("No es posible crear la caja");
        }

        /*Después, para asegurarme de que no me va a lanzar un nullPointException
        Miro si es null, es decir, si no existe esa caja, si no, creo una caja en esa posicion */
        if (cajas[numCajaAAbrir] == null) {
            cajas[numCajaAAbrir] = new Caja(numCajas(), true);
            return; //(terminamos el metodo aquí)
        }

        //Miro si la caja seleccionada esta abierta, si no lo esta con un set la abro
        if (!cajas[numCajaAAbrir].estaAbierta()) {
            cajas[numCajaAAbrir].setEstaAbierta(true);
        } else {
            throw new CajaException("La caja ya está abierta");
        }
    }

    public void cerrarCaja(int numCajaACerrar) throws CajaException {

        //Si la caja esta abierta y la cola de clientes esta vacia (no hay clientes) la cierro
        if (cajas[numCajaACerrar].estaAbierta() && cajas[numCajaACerrar].getColaDeClientes().isEmpty()) {
            cajas[numCajaACerrar].setEstaAbierta(false);
        } else {
            throw new CajaException("La caja no se puede cerrar");
        }
    }

    private Caja cajaConMenosClientes() {

        //Caja con menos clientes y su numero de clientes (seleccionamos el mayor numero posible)
        Caja cajaConMenosClientes = null;
        int menorNumClientes = Integer.MAX_VALUE;

        //Recorremos las cajas
        for (Caja caja : cajas) {
            //Nos aseguramos de que existe y esta abierta
            if (caja != null && caja.estaAbierta()) {
                //Si la caja actual tiene menos clientes que la actual la remplaza y el menor numero de clientes se actualiza
                if (caja.getColaDeClientes().size() < menorNumClientes) {
                    cajaConMenosClientes = caja;
                    menorNumClientes = caja.getColaDeClientes().size();
                }
            }
        }
        return cajaConMenosClientes;
    }

    public String nuevoCliente() throws CajaException {
        Caja cajaDelCliente = cajaConMenosClientes();
        if (cajaDelCliente == null) {
            throw new CajaException("No hya cajas abiertas");
        }
        //Incrementamos el numero de clientes (asi no le mostramos: "usted es el cliente 0")
        numDeClientes++;
        // Añadimos el cliente a la cola (SE ME OLVIDO HACERLO!!!)
        cajaDelCliente.getColaDeClientes().add(numDeClientes);
        return "Usted es el cliente " + numDeClientes + " y debe ir a la caja número " + cajaConMenosClientes().getNumCaja();
    }

    public int atenderCliente(int numCajaEnLaQueEstaElCliente) throws CajaException {

        //Comprobaciones basicas para ver uq ela caja indicada esta dentro del rango (>0 y <20) y que NO ES NULL
        if (numCajaEnLaQueEstaElCliente < 0 || numCajaEnLaQueEstaElCliente >= MAX_DE_CAJAS || cajas[numCajaEnLaQueEstaElCliente] == null) {
            throw new CajaException("La caja no existe");
        }
        //Si la caja en la que esta el cliente no esta abierta o no hay clientes lanzamos una excepcion
        if (!cajas[numCajaEnLaQueEstaElCliente].estaAbierta() || cajas[numCajaEnLaQueEstaElCliente].getColaDeClientes().isEmpty()) {
            throw new CajaException("La caja está cerrada o no hay nadie en ella");
        }
        //Si pasa los filtros, devolvemos el cliente que se va a eliminar y lo eliminamos
        //En este caso usamos el metodo removeFirst para elimar al primer cliente que entro (FIFO: primero en entrar, primero en salir)
        return cajas[numCajaEnLaQueEstaElCliente].getColaDeClientes().removeFirst();
    }
}

/*
El metodo .poll() pertenece a la interfaz Queue (que LinkedList implementa)
y se usa para obtener y eliminar el primer elemento de la cola.

📌 Diferencia entre .poll() y .removeFirst()
poll(): Si la lista está vacía, devuelve null (evita excepciones).
removeFirst(): Si la lista está vacía, lanza una NoSuchElementException.
*/
