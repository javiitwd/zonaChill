package TEMA4.EXAMENES_TEMA4.GPT_Examen3;

public class Estudiante {

    private String nombreCompleto;
    private String dni;
    private Curso[] cursosInscritos;

    public Estudiante(String nombreCompleto, String dni) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.cursosInscritos = new Curso[2];
    }

    public Curso[] getCursosInscritos() {
        return cursosInscritos;
    }

    public void setCursosInscritos(Curso[] cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    private int contadorCursosInscritos() {
        int contadorCursos = 0;
        for (int i = 0; i < cursosInscritos.length; i++) {
            if (cursosInscritos[i] != null) {
                contadorCursos++;
            }
        }
        return contadorCursos;
    }

    public void inscribirseEnCurso(Curso cursoAInscribirse) throws EstudiantesException {

        if (contadorCursosInscritos() >= cursosInscritos.length) {
            throw new EstudiantesException("No puede apuntarse a más cursos");
        }
        cursosInscritos[contadorCursosInscritos()] = cursoAInscribirse;
    }

    public String cursosAlumno(){
        StringBuilder cursosTemporales = new StringBuilder();
        for (int i = 0; i < contadorCursosInscritos(); i++) {

            cursosTemporales.append(cursosInscritos[i]).append(System.lineSeparator());
        }
        return cursosTemporales.toString();
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", dni='" + dni + '\'' +
                ", cursosInscritos=" + cursosAlumno() +
                '}';
    }
}
