package TEMA4.EXAMENES_TEMA4.GPT_Examen3;

public class Curso {

    private String asignatura;
    private String codigo;
    private String profesor;
    private int numEstudiantes;
    private Estudiante [] estudiantesInscritos;

    public Curso(String asignatura, String codigo, String profesor, int numEstudiantes) {
        this.asignatura = asignatura;
        this.codigo = codigo;
        this.profesor = profesor;
        this.numEstudiantes = numEstudiantes;
        estudiantesInscritos = new Estudiante[2];
    }

    @Override
    public String toString() {
        return "Curso{" +
                "asignatura='" + asignatura + '\'' +
                ", codigo='" + codigo + '\'' +
                ", profesor='" + profesor + '\'' +
                ", numEstudiantes=" + numEstudiantes +
                '}';
    }
}
