package TEMA6.Boletín1.Ejercicio8;

public enum TipoGama {
	
	ALTA(Vehiculo.PRECIO_ALTA),
	MEDIA(Vehiculo.PRECIO_MEDIA),
	BAJA(Vehiculo.PRECIO_BAJA);

	private double precioBasePorGama;
	
	private TipoGama ( double precioBasePorGama) {
		this.precioBasePorGama=precioBasePorGama;
	}
	
	public double getPrecioBasePorGama() {
		return precioBasePorGama;
	}
}
