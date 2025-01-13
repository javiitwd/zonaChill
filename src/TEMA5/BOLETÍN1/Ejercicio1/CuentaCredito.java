package TEMA5.BOLETÍN1.Ejercicio1;

import TEMA4.BOLETÍN1.Ejercicio2.Cuenta;
import TEMA4.BOLETÍN1.Ejercicio2.CuentaException;

public class CuentaCredito extends Cuenta {
    public static final double MAX_CREDITO = 300; // Máximo crédito permitido
    private double credito; // Crédito disponible

    // Constructor sin parámetros, asigna un saldo inicial de 0 y crédito de 100
    public CuentaCredito() throws CuentaException {
        super("0000", "Titular por defecto", 0); // Llamamos al constructor de la clase base
        this.credito = 100; // Crédito por defecto
    }

    // Constructor con un crédito específico
    public CuentaCredito(double credito) throws CuentaException {
        super("0000", "Titular por defecto", 0); // Llamamos al constructor de la clase base
        if (credito > MAX_CREDITO) {
            throw new CuentaException("El crédito no puede superar los 300€.");
        }
        this.credito = credito;
    }

    // Metodo para obtener el crédito disponible
    public double getCredito() {
        return credito;
    }

    // Metodo para establecer el crédito disponible (validando el límite)
    public void setCredito(double credito) throws CuentaException {
        if (credito > MAX_CREDITO) {
            throw new CuentaException("El crédito no puede superar los 300€.");
        }
        this.credito = credito;
    }

    // Modificar el metodo para sacar dinero teniendo en cuenta el crédito
    @Override
    public void sacarDinero(double retirada) throws CuentaException {
        if (retirada <= 0) {
            throw new CuentaException("La cantidad a retirar no puede ser negativa o cero.");
        }
        // Si el dinero a retirar supera el saldo + crédito, no es posible
        if (retirada > (this.saldo + this.credito)) {
            throw new CuentaException("No puedes retirar más de lo que tienes (saldo + crédito).");
        }
        // Si es válida, restamos la cantidad del saldo
        this.saldo -= retirada;
        contadorRetirada++;
    }

    // Modificar el metodo para ingresar dinero, no afecta al crédito
    @Override
    public void meterDinero(double ingreso) throws CuentaException {
        if (ingreso <= 0) {
            throw new CuentaException("El ingreso no puede ser menor que 0.");
        }
        // Solo afecta al saldo
        this.saldo += ingreso;
        contadorIngreso++;
    }

    // Metodo para mostrar saldo y crédito disponible
    public void consultarSaldoYCredito() {
        System.out.println("Saldo actual: " + this.saldo);
        System.out.println("Crédito disponible: " + this.credito);
    }
}

