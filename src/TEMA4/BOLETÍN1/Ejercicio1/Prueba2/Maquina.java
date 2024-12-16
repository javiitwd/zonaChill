package TEMA4.BOLETÍN1.Ejercicio1.Prueba2;

public class Maquina {

    //Atributos
    private static final int MAX_DEPOSITO_CAFE = 50;
    private static final int MAX_DEPOSITO_LECHE = 50;
    private static final int MAX_DEPOSITO_VASOS = 80;

    private float monedero;
    private int depositoCafe;
    private int depositoLeche;
    private int depositoVasos;

    //Constructor
    public Maquina(float monedero) throws MaquinaException {

        if (monedero < 0) {
            throw new MaquinaException("Introduzca un importe válido");
        }
        this.monedero = monedero;
        this.depositoCafe = MAX_DEPOSITO_CAFE;
        this.depositoLeche = MAX_DEPOSITO_LECHE;
        this.depositoVasos = MAX_DEPOSITO_VASOS;

        }

    public float servirCafeSolo (float dinero) throws MaquinaException{

        if (dinero < 1){
            throw new MaquinaException("Necesita más dinero, lo sentimos");
        }
        if (depositoCafe <= 0){
            throw new MaquinaException("Lo sentimos, pero no tenemos café");
        }
        if (depositoVasos <= 0){
            throw new MaquinaException("Lo sentimos, pero no tenemos vasos");
        }

        monedero += 1;
        depositoCafe--;
        depositoVasos--;
        return dinero-1;
    }

    public float servirLeche (float dinero) throws MaquinaException{

        if (dinero < 0.80){
            throw new MaquinaException("Necesita más dinero, lo sentimos");
        }
        if (depositoLeche <= 0){
            throw new MaquinaException("Lo sentimos, pero no tenemos leche");
        }
        if (depositoVasos <= 0){
            throw new MaquinaException("Lo sentimos, pero no tenemos vasos");
        }

        monedero = (float) +0.80;
        depositoLeche--;
        depositoVasos--;
        return (float)(dinero-0.80);
    }

    public float servirCafeLeche (float dinero) throws MaquinaException{

        if (dinero < 1){
            throw new MaquinaException("Necesita más dinero, lo sentimos");
        }
        if (depositoCafe <= 0){
            throw new MaquinaException("Lo sentimos, pero no tenemos café");
        }
        if (depositoVasos <= 0){
            throw new MaquinaException("Lo sentimos, pero no tenemos vasos");
        }
        if (depositoLeche <= 0){
            throw new MaquinaException("Lo sentimos, pero no tenemos leche");
        }

        monedero = (float) +1.50;
        depositoCafe--;
        depositoVasos--;
        depositoLeche--;
        return (float) (dinero-1.50);
    }

    public void rellenarDepositos(){
        depositoCafe = MAX_DEPOSITO_CAFE;
        depositoLeche = MAX_DEPOSITO_LECHE;
        depositoVasos = MAX_DEPOSITO_VASOS;
    }

    public int estadoCafe (){
        return depositoCafe;
    }
    public int estadoLeche (){
        return depositoLeche;
    }
    public int estadoVasos (){
        return depositoVasos;
    }
    public float estadoMonedero (){
        return monedero;
    }
}
