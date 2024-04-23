import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {
        // Genera un arreglo de numeros aleatorios
        int[] datos = new int[10];
        datos[0] = 10;
        datos[1] = 33;
        datos[2] = 52;
        datos[3] = 71;
        datos[4] = 19;
        datos[5] = 22;
        datos[6] = 18;
        datos[7] = 35;
        datos[8] = 47;
        datos[9] = 66;

        // Imprime el arreglo original
        for (int i = 0; i < datos.length; i++) {
            System.out.print(datos[i] + " ");
        }

        // Construye un montículo máximo a partir del arreglo
        MonticuloMaximo monticulo = new MonticuloMaximo(datos);

        // Imprime el montículo
        System.out.println();
        imprimirMonticulo(monticulo);

        // Ordena el arreglo utilizando el metodo HeapSort.
        HeapSort.ordenar(datos);

        System.out.println();

        // Imprime el arreglo ordenado
        System.out.println(Arrays.toString(datos));
    }

    // Imprimir monticulo
    private static void imprimirMonticulo(MonticuloMaximo monticulo) {
        int[] datos = monticulo.getDatos();
        int tamanio = monticulo.getTamanio();
        for (int i = 0; i < tamanio; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
    }
}