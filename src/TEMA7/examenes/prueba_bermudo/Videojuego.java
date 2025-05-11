package TEMA7.examenes.prueba_bermudo;

public class Videojuego {

    private String titulo;
    private String desarrolador;
    private int lanzamiento;
    private String plataforma;
    private String genero;
    private String descripcion;
    private String id;

    public Videojuego(String titulo, String desarrolador, int lanzamiento, String plataforma, String genero, String descripcion, String id) {
        this.titulo = titulo;
        this.desarrolador = desarrolador;
        this.lanzamiento = lanzamiento;
        this.plataforma = plataforma;
        this.genero = genero;
        this.descripcion = descripcion;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrolador() {
        return desarrolador;
    }

    public void setDesarrolador(String desarrolador) {
        this.desarrolador = desarrolador;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", desarrolador='" + desarrolador + '\'' +
                ", lanzamiento=" + lanzamiento +
                ", plataforma='" + plataforma + '\'' +
                ", genero='" + genero + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
