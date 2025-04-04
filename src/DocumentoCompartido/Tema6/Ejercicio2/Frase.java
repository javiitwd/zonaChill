package DocumentoCompartido.Tema6.Ejercicio2;

import java.time.LocalDate;
import java.util.Objects;

public class Frase {
    private static final int MIN_VALORACION = 1;
    private static final int MAX_VALORACION = 5;

    private String texto;
    private String peliculaEnLaQueSale;
    private String actorQueLaDice;
    private int valoracion;
    private LocalDate fechaEnLaQueSeAnnadio;

    public Frase(String texto, String peliculaEnLaQueSale, String actorQueLaDice) throws FraseCineException {
        this.texto = texto;
        this.peliculaEnLaQueSale = peliculaEnLaQueSale;
        this.actorQueLaDice = actorQueLaDice;
        valoracion = 0;
        this.fechaEnLaQueSeAnnadio = LocalDate.now();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getPeliculaEnLaQueSale() {
        return peliculaEnLaQueSale;
    }

    public void setPeliculaEnLaQueSale(String peliculaEnLaQueSale) {
        this.peliculaEnLaQueSale = peliculaEnLaQueSale;
    }

    public String getActorQueLaDice() {
        return actorQueLaDice;
    }

    public void setActorQueLaDice(String actorQueLaDice) {
        this.actorQueLaDice = actorQueLaDice;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void annadirValoracion(int valoracion) throws FraseCineException {

        if (valoracion < MIN_VALORACION || valoracion > MAX_VALORACION) {
            throw new FraseCineException("La valoración debe estar entre " + MIN_VALORACION + " Y " + MAX_VALORACION);
        }
        this.valoracion = valoracion;
    }

    public LocalDate getFechaEnLaQueSeAnnadio() {
        return fechaEnLaQueSeAnnadio;
    }

    public void setFechaEnLaQueSeAnnadio(LocalDate fechaEnLaQueSeAnnadio) {

        this.fechaEnLaQueSeAnnadio = fechaEnLaQueSeAnnadio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frase frase = (Frase) o;
        return Objects.equals(texto, frase.texto) && Objects.equals(peliculaEnLaQueSale, frase.peliculaEnLaQueSale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto, peliculaEnLaQueSale);
    }
}
