/*
Realizar un programa que permita gestionar el saldo de una cuenta corriente. Una
vez introducido el saldo inicial, se mostrará un menú que permitirá efectuar las
siguientes operaciones:
1. Hacer un reintegro, se pedirá la cantidad a retirar.
2. Hacer un ingreso, se pedirá la cantidad a ingresar.
3. Consultar el saldo y el número de reintegros e ingresos
realizados.
4. Finalizar las operaciones. Debe confirmar si realmente desea
salir e informar del saldo al final de todas las operaciones.
Debe realizarse una clase Cuenta y la clase Principal
*/

package TEMA4.BOLETÍN1.Ejercicio2.Prueba1;

public class Cuenta {

    private float saldo;
    private int contadorIngresos = 0;
    private int contadorRetiros = 0;

    public Cuenta (float saldo) throws CuentaException{
        if (saldo <= 0){
            throw new CuentaException ("No te pases de listo conmigo muñeca");
        }
        this.saldo = saldo;
    }

    public float setRetirar(float retirar) throws CuentaException{
        if (retirar > saldo || retirar <= 0){
            throw new CuentaException("Introduzca bien la cantidad");
        }
        //le quito al saldo lo que ha seleccionado este hombre
        this.saldo = this.saldo-retirar;
        contadorRetiros++;
        return retirar;
    }

    public float setIngreso(float ingreso){
        this.saldo += ingreso;
       contadorIngresos++;
        return ingreso;
    }

    public float consultarSaldo(){
        return saldo;
    }

    public int consultarVecesIngreso(){
        return contadorIngresos;
    }

    public int consultarVecesRetiro(){
        return  contadorRetiros;
    }

}
