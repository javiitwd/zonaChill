package TEMA3.Boletín_Matrices;

public class ComprobarMatrizCuadrada {
    public static void main(String[] args) {
        int [] [] matriz = {{1,2,3}, {4,5,6}};

        boolean esCuadrada = comprobarIguadad(matriz);

        if (esCuadrada){
            System.out.println("Son iguales");
        } else {
            System.out.println("Mo son iguales");
        }
    }
    private static boolean comprobarIguadad(int[] [] matriz){
        boolean cuadrada = false;
        if (matriz.length == matriz[0].length){
            cuadrada = true;
        }
        return cuadrada;
    }
}