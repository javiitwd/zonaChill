package TEMA6.Boletín1.Ejercicio6.Prueba1;

public class GranAlmacen {

    private static final int MAXIMO_DE_CAJAS = 20;
    private static int numeroDeClientes = 0;
    private Caja cajas[];

    public GranAlmacen() {
        this.cajas = new Caja[MAXIMO_DE_CAJAS];
    }

    public void abrirCaja(int numCajaAAbrir) throws CajaException {

        //Comprobamos que esta en el limite
        if (numCajaAAbrir >= 20 || numCajaAAbrir < 0) {
            throw new CajaException("La caja supera nuestros limites de cajas");
        }
        //Si no existe, la creo
        if (cajas[numCajaAAbrir] == null) {
            cajas[numCajaAAbrir] = new Caja(numCajaAAbrir, true);
        }
        if (cajas[numCajaAAbrir].isEstaAbierta()) {
            throw new CajaException("La caja ya está abierta");
        }
        cajas[numCajaAAbrir].setEstaAbierta(true);
    }

    public void cerrarCaja(int numCajaAAbrir) throws CajaException {

        //Comprobamos que esta en el limite
        if (numCajaAAbrir >= 20 || numCajaAAbrir < 0) {
            throw new CajaException("La caja supera nuestros limites de cajas");
        }

        //Si no existe, lamzamos excepcion
        if (cajas[numCajaAAbrir] == null) {
            throw new CajaException("La caja no existe");
        }

        if (!cajas[numCajaAAbrir].isEstaAbierta()) {
            throw new CajaException("La caja ya está cerrada");
        }
        cajas[numCajaAAbrir].setEstaAbierta(false);
    }

    private Caja cajaConMenosClientes() throws CajaException {
        int numClientesDeLaMenorCaja = Integer.MAX_VALUE;
        Caja cajaConMenosClientes = null;

        for (Caja caja : cajas) {
            if (caja != null) {
                if (caja.getColaClientes().size() < numClientesDeLaMenorCaja && caja.isEstaAbierta()) {
                    cajaConMenosClientes = caja;
                    numClientesDeLaMenorCaja = caja.getColaClientes().size();
                }
            }
        }
        if (cajaConMenosClientes == null) {
            throw new CajaException("No hay cajas actualmente");
        }
        return cajaConMenosClientes;
    }

    public String nuevoCliente() throws CajaException {

        Caja cajaConMenosClientes = cajaConMenosClientes();
        if (cajaConMenosClientes.getColaClientes().size() >= MAXIMO_DE_CAJAS) {
            throw new CajaException("Todas las cajas estan llenas");
        }
        numeroDeClientes++;
        cajaConMenosClientes.getColaClientes().add(numeroDeClientes);
        return "Usted es el cliente " + numeroDeClientes + " y debe ir a la caja número: " + cajaConMenosClientes.getNumCaja();
    }

    public String atenderCliente(int cajaEnLaQueEstaElCliente) throws CajaException {

        if (cajaEnLaQueEstaElCliente < 1 || cajaEnLaQueEstaElCliente >= 20 || cajas[cajaEnLaQueEstaElCliente] == null){
            throw new CajaException("La caja no existe");
        }

        if (!cajas[cajaEnLaQueEstaElCliente].isEstaAbierta()){
            throw new CajaException("La caja está cerrada, no puede haber nadie ahí");
        }

        if (cajas[cajaEnLaQueEstaElCliente].getColaClientes().isEmpty()){
            throw new CajaException("No hay nadie en la caja");
        }

        //Sacamos el cliente que esta primero en la caja
        int numeroDelPrimerClienteDeLaCaja = cajas[cajaEnLaQueEstaElCliente].getColaClientes().getFirst();

        //Lo eliminamos
        cajas[cajaEnLaQueEstaElCliente].getColaClientes().removeFirst();

        return "Se ha atendido al cliente con número " +numeroDelPrimerClienteDeLaCaja+ ". ";
    }
}
