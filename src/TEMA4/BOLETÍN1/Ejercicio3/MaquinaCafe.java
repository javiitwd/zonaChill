/*
Tema 4 Boletin 1 Ejercicio 3 (miralo ahi)
que es pecha´ de largo xd
*/
package TEMA4.BOLETÍN1.Ejercicio3;

public class MaquinaCafe {

    private static final int DEPOSITO_CAFE = 50;
    private static final int DEPOSITO_LECHE = 50;
    private static final int DEPOSITO_VAS0S = 80;

    //Atributos
    private int depositoCafe;
    private int depositoLeche;
    private int depositoVasos;
    private float monedero;

    //Constructor maquina cafe con sus depositos
    public MaquinaCafe(float monedero) throws MaquinaCafeException {
        rellenarDeposito();
        if (monedero < 0) {
            throw new MaquinaCafeException("No te pases de listo conmigo muchacho");
        }
        this.monedero = monedero;
    }

    public void rellenarDeposito() {
        this.depositoCafe = DEPOSITO_CAFE;
        this.depositoLeche = DEPOSITO_LECHE;
        this.depositoVasos = DEPOSITO_VAS0S;
    }

    public float servirCafeSolo(float dineroCliente) throws MaquinaCafeException {
        if (depositoVasos < 0) {
            throw new MaquinaCafeException("No hay vasos, nenaza");
        }
        if (depositoCafe < 0) {
            throw new MaquinaCafeException("No hay café trapito");
        }

        if (dineroCliente > monedero) {
            throw new MaquinaCafeException("No tenemos cambio, largese");
        }
        depositoCafe--;
        depositoVasos--;
        monedero += 1;
        return dineroCliente - 1;
    }

    //Metodo si el usuario elije leche
    public float servirLeche(float dineroCliente) throws MaquinaCafeException {
        if (depositoVasos < 0) {
            throw new MaquinaCafeException("No hay vasos, nenaza");
        }
        if (depositoLeche < 0) {
            throw new MaquinaCafeException("Ya te gustaria que hubiera leche, poco hombre");
        }
        if (dineroCliente > monedero) {
            throw new MaquinaCafeException("No tenemos cambio, largese");
        }
        depositoVasos--;
        depositoLeche--;
        monedero += (float) 0.8;
        return ((float) (dineroCliente - 0.8));
    }

    //Metodo si el usuario elije Cafe con leche
    public float servirCafeLeche(float dineroCliente) throws MaquinaCafeException {
        if (depositoVasos < 0) {
            throw new MaquinaCafeException("No hay vasos, nenaza");
        }
        if (depositoLeche < 0) {
            throw new MaquinaCafeException("Ya te gustaria que hubiera leche, poco hombre");
        }
        if (depositoCafe < 0) {
            throw new MaquinaCafeException("No hay café trapito");
        }
        depositoLeche--;
        depositoCafe--;
        depositoVasos--;

        if (dineroCliente > monedero) {
            throw new MaquinaCafeException("No tenemos cambio, largese");
        }
        monedero += (float) 1.5;
        return ((float) (dineroCliente - 1.5));
    }

    //Metodos para comprobar el estado de la maquina
    public int consultarEstadoLeche() {
        return depositoLeche;
    }

    public int consultarEstadoCafe() {
        return depositoCafe;
    }

    public int consultarEstadoVasos() {
        return depositoVasos;
    }

    public float consultarMonedero() {
        return monedero;
    }
}
