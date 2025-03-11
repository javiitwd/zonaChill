/* Estás diseñando el sistema informático de un taller mecánico y electrónico. En él se manejan diferentes tipos de piezas
que pueden requerir distintos cuidados y procesos antes de llegar al cliente:

Algunas piezas pueden ser sometidas a pruebas de calidad antes de su entrega.
Otras piezas no se prueban de la misma forma o, directamente, no se prueban.
Ciertas piezas se pueden reparar si presentan desperfectos, mientras que otras no admiten reparaciones o no las necesitan.
El coste total de cada pieza puede verse afectado tras la realización de pruebas o reparaciones (o ambas).
El sistema debe permitir:

Registrar información básica de cada pieza (por ejemplo, una descripción y su coste).
Aplicar el proceso de prueba de calidad a la pieza (si corresponde).
Reparar la pieza (si es posible).
Ajustar el coste final en caso de que se aplique alguna prueba y/o reparación.
Hacer todo lo anterior sin saber de antemano de que tipo de pieza se trata. El sistema deberia poder gestionar todas
las piezas por igual y, si la pieza tiene procesos específicos, aplicarlos adecuadamente.
Pista de implementación (sin mencionar aspectos concretos de herencia ni interfaces):

En el futuro, se podrían añadir nuevos tipos de piezas con comportamientos similares o distintos a las piezas actuales,
sin alterar demasiado el sistema. Algunas piezas tienen el mismo tipo de prueba o reparación, aunque difieran en su funcionamiento interno.
Requisitos:

Desarrolla las clases y métodos necesarios para que, al crear distintos tipos de piezas, el sistema:
Reconozca si cada pieza puede o no pasar una prueba de calidad y, en caso afirmativo, la ejecute.
Compruebe si se puede reparar, y si procede, aplique la reparación.
Calcule el coste final tras estos procesos.
Prepara un metodo que, al recibir una pieza (sin conocer su tipo real), intente pasar la prueba de calidad y/o repararla.
Objetivo:
La solución debe abstraer bien los diferentes tipos de piezas y sus características, permitiendo especializar
la lógica de prueba y de reparación donde sea necesario. Se evaluará la capacidad de reutilizar el mismo proceso
(prueba y/o reparación) para piezas distintas y de agregar piezas nuevas sin modificar drásticamente el resto del código. */

package TEMA5.BermudoTallerGPT;

public class Principal {

    public static void main(String[] args) {

        Taller taller = new Taller();

        PiezaExaminable piezaExaminable = new PiezaExaminable(2143, "efwr", 3);
        PiezaReparable piezaReparable = new PiezaReparable(3214, "ewqfds", 31, true);

        taller.annadirPieza(piezaExaminable);
        taller.annadirPieza(piezaReparable);

        System.out.println(taller.piezaPuedeExaminarse(piezaExaminable));
        System.out.println(taller.piezaPuedeRepararse(piezaReparable));
        System.out.println(taller.tratarDeExaminarYRepararPieza(piezaExaminable));
    }
}
