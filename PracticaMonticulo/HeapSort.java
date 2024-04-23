public class HeapSort {
    public static void ordenar(int[] datos) {
        MonticuloMaximo monticulo = new MonticuloMaximo(datos);
    
        while (!monticulo.estaVacio()) {
            int maximo = monticulo.eliminarMaximo();
            datos[monticulo.getTamanio()] = maximo;
        }
    }
    
}
