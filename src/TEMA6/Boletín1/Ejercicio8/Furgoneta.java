package TEMA6.Boletín1.Ejercicio8;
public class Furgoneta extends Vehiculo {
	private int pma;
	private final double CANTIDAD=0.5;
	
	public Furgoneta(String matricula,TipoGama gama, int pma) throws VehiculoException {
		super(matricula, gama);
		this.setPma(pma);
	}

	//Metodo gets y sets

	public int getPma() {
		return pma;
	}

	public void setPma(int pma)throws VehiculoException {
		if(pma<0){
			throw new VehiculoException("No puede haber un peso m�nimo autorizado negativo");
		}
		this.pma = pma;
	}
	
	//M�todos calcular alquiler
	
	public double calcularAlquiler(int dias) throws VehiculoException {
		double total=0;						
		if ( dias <=0)
			throw new VehiculoException("Dias de alquiler incorrecto");
		
		total=CANTIDAD*pma*dias;
		return total+ calcularAlquilerBase(dias);
	}

	@Override
	public String toString() {
		return "Furgoneta " + super.toString() + " PMA =" + pma;
	}
}
