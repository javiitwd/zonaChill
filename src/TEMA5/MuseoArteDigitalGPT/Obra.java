package TEMA5.MuseoArteDigitalGPT;

import java.util.Arrays;

public class Obra {

    private String titulo;
    private String autor;
    private int anoCreacion;
    private int codigoInventario;
    private double valor;
    private Restauracion[] restauraciones;

    public Obra(String titulo, String autor, int anoCreacion, int codigoInventario, double valor) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoCreacion = anoCreacion;
        this.codigoInventario = codigoInventario;
        this.valor = valor;
        restauraciones = new Restauracion[5];
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoCreacion() {
        return anoCreacion;
    }

    public int getCodigoInventario() {
        return codigoInventario;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Obra{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoCreacion=" + anoCreacion +
                ", codigoInventario=" + codigoInventario +
                ", valor=" + valor +
                ", restauraciones=" + Arrays.toString(restauraciones) +
                '}';
    }
}
