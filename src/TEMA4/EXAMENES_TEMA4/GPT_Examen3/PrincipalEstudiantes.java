package TEMA4.EXAMENES_TEMA4.GPT_Examen3;

public class PrincipalEstudiantes {
    public static void main(String[] args) {
        // Crear cursos
        Curso cursoMatematicas = new Curso("Matemáticas", "MAT101", "Dr. Pérez", 2);
        Curso cursoInformatica = new Curso("Informática", "INF101", "Dra. García", 2);

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante("Ana Gómez", "12345678A");
        Estudiante estudiante2 = new Estudiante("Luis Pérez", "23456789B");
        Estudiante estudiante3 = new Estudiante("Carlos Sánchez", "34567890C");

        // Inscribir estudiantes en cursos
        try {
            estudiante1.inscribirseEnCurso(cursoMatematicas);
            estudiante2.inscribirseEnCurso(cursoMatematicas);
            estudiante3.inscribirseEnCurso(cursoMatematicas);  // Este debe lanzar una excepción

            estudiante1.inscribirseEnCurso(cursoInformatica);
            estudiante2.inscribirseEnCurso(cursoInformatica);
            estudiante3.inscribirseEnCurso(cursoInformatica);  // Este también debe lanzar una excepción
        } catch (EstudiantesException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar detalles de los cursos
        System.out.println(cursoMatematicas);
        System.out.println(cursoInformatica);

        // Mostrar detalles de los estudiantes
        System.out.println(estudiante1);
        System.out.println(estudiante2);
        System.out.println(estudiante3);
    }
}
