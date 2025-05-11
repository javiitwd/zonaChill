package TEMA7.examenes.prueba_bermudo.prueba1;

public class Videojuego {

    private String id;
    private String titulo;
    private String desarrollador;
    private int lanzamiento;
    private String plataforma;
    private String genero;
    private String descripcion;

    public Videojuego(String id, String titulo, String desarrollador, int lanzamiento, String plataforma, String genero, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.desarrollador = desarrollador;
        this.lanzamiento = lanzamiento;
        this.plataforma = plataforma;
        this.genero = genero;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
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
}
