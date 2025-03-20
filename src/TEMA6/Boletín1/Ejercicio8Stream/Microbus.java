package TEMA6.Boletín1.Ejercicio8Stream;

public class Microbus extends Vehiculo {
	private int numPlazas;
	private final double CANTIDADXPLAZA=5;
	
	public Microbus(String matricula, TipoGama gama, int numPlaza) throws VehiculoException {
		super(matricula, gama);
		this.setNumPlazas(numPlaza);		
	}
	
	//M�todos gets y sets
	
	public int getNumPlazas() {
		return numPlazas;
	}	
	
	public void setNumPlazas(int numPlazas)throws VehiculoException {
		if(numPlazas<=0){
			throw new VehiculoException("No puede haber un n�mero de plazas negativo o cero");
		}
		this.numPlazas = numPlazas;
	}

	//Metodo calcular el alquiler
	public double calcularAlquiler(int dias) throws VehiculoException {
		double total;		
		if ( dias <=0)
			throw new VehiculoException("Dias de alquiler incorrecto");

		total=CANTIDADXPLAZA*numPlazas;
		return total+ calcularAlquilerBase(dias);
	}

	@Override
	public String toString() {
		return "Microbus  " + super.toString() + " plazas =" + numPlazas;
	}
}
