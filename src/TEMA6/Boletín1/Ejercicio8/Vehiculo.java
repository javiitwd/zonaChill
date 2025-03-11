package TEMA6.Boletín1.Ejercicio8;

public abstract class Vehiculo {
	
	private String matricula; 
	private TipoGama gama;
	
	public static final double PRECIO_ALTA = 50;
	public static final double PRECIO_MEDIA = 40;
	public static final double PRECIO_BAJA = 30;

	public Vehiculo(String matricula, TipoGama gama)  {
		this.matricula = matricula;
		this.gama=gama;

	}

	// M�todos gets y sets
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public TipoGama getGama() {
		return gama;
	}

	public void setGama(TipoGama gama) {
		this.gama = gama;
	}	

	// m�todos alquiler
	public abstract double calcularAlquiler(int dias) throws VehiculoException;

	// M�todos calcular base	

	protected double calcularAlquilerBase(int dias) {
		double precio;

		precio=dias* gama.getPrecioBasePorGama();
		return precio;
	}

	@Override
	public String toString() {
		return " Matricula=" + matricula + ", gama=" + gama + "]";
	}
}
