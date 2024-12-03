/*
 * 2. Realizar un programa que permita gestionar el saldo de una cuenta corriente. Una
 * vez introducido el saldo inicial, se mostrará un menú que permitirá efectuar las
 * siguientes operaciones:
 * 1. Hacer un reintegro, se pedirá la cantidad a retirar.
 * 2. Hacer un ingreso, se pedirá la cantidad a ingresar.
 * 3. Consultar el saldo y el número de reintegros e ingresos
 * realizados.
 * 4. Finalizar las operaciones. Debe confirmar si realmente desea
 * salir e informar del saldo al final de todas las operaciones.
 * Debe realizarse una clase Cuenta y la clase Principal.
 */

package TEMA4.BOLETÍN1.Ejercicio2;

public class Cuenta {
    private String numeroDeCuenta; //Almacena el numero de cuenta
    private String titular; //Almacena el nombre del titular de la cuenta
    private double saldo; // el saldo actual de la cuenta
    private int contadorRetirada; // contador que guarda el numero de veces que se ha retirado dinero
    private int contadorIngreso; // contador que guarda el numero de veces que se ha ingresado dinero.

    /*Constructor cuenta.
    Recibe el numero de cuenta, titulr y un saldo inicial.
    Si el saldo es negativo, lanza una excepcion (CuentaException) usando this.setSaldo(saldoInicial),
    que invoca el metodo setSaldo.
     */
    public Cuenta(String numeroDeCuenta, String titular, double saldoInicial) throws CuentaException {

        this.numeroDeCuenta = numeroDeCuenta;
        this.titular = titular;
        contadorRetirada =0;
        contadorIngreso =0;

        this.setSaldo(saldoInicial);
    }

    /*Metodo setSaldo.
    Este metodo se encarga de establecer el saldo de la cuenta. Si el saldo es negativo, lanza una excepción personalizada (CuentaException).
    Esto garantiza que no se pueda tener un saldo negativo en la cuenta, lo cual es una validación importante
     */
    public void setSaldo(double saldo) throws CuentaException {
        if (saldo < 0) {

            throw new CuentaException("El saldo no puede ser negativo");
        }
        this.saldo = saldo;
    }
    /*Metodo getSaldo.
    Devuelve el saldo actual de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }
    /*Metodo sacarDinero
    Permite retirar dinero de la cuenta. Si la cantidad a retirar es negativa o mayor que el saldo disponible, lanza una excepción.
    Si la retirada es válida, el saldo se reduce y se incrementa el contador de retiradas.
     */
    public void sacarDinero(double retirada) throws CuentaException {

        if (retirada <= 0) {
            throw new CuentaException("la retirada no puede ser negativa ");
        } else if (retirada > saldo) {
            throw new CuentaException("la retirada no puede ser mayor que el saldo ");
        }
        this.saldo -= retirada;
        contadorRetirada++;

    }

    /*Metodo meterDinero.
    Permite ingresar dinero en la cuenta. Si la cantidad ingresada es negativa, lanza una excepción.
    Si es válida, el saldo aumenta y se incrementa el contador de ingresos.
     */

    public void meterDinero(double ingreso) throws CuentaException {

        if (ingreso <= 0) {

            throw new CuentaException("el ingreso no puede ser menor que 0 ");
        }
        this.saldo += ingreso;
        contadorIngreso++;
    }

    /*Metodo consultarSaldo.
    Imprime en consola el saldo actual, el número de veces que se ha retirado dinero y el número de ingresos realizados.
     */

    public void consultarSaldo() {
        System.out.println(this.saldo);

        System.out.println("Has sacado dinero " + contadorRetirada + " veces");

        System.out.println("Has metido dinero " + contadorIngreso + " veces");
    }
    /*Metodo finalizar
    Simplemente imprime el saldo de la cuenta y un mensaje de despedida al finalizar la sesión.
     */
    public void finalizar (){

        System.out.println("has salido de la cuenta tu saldo es de " +saldo);
    }
    /*métodos getContadorRetirada y getContadorIngreso.
    Retornan los valores de los contadores de retiradas e ingresos respectivamente.
     */
    public int getContadorRetirada() {
        return contadorRetirada;
    }

    public int getContadorIngreso() {
        return contadorIngreso;
    }
}