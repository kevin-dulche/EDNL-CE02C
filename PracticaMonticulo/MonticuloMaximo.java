public class MonticuloMaximo {

    private int[] datos;
    private int tamanio;

    public MonticuloMaximo(int[] datos) {
        this.datos = datos;
        this.tamanio = datos.length;
        // Completar: Construir el montículo máximo utilizando el método `heapify`.
        for (int i = tamanio / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int indice) {
        int hijoIzquierdo = 2 * indice + 1;
        int hijoDerecho = 2 * indice + 2;
        int mayor = indice;
    
        if (hijoIzquierdo < tamanio && datos[hijoIzquierdo] > datos[mayor]) {
            mayor = hijoIzquierdo;
        }
    
        if (hijoDerecho < tamanio && datos[hijoDerecho] > datos[mayor]) {
            mayor = hijoDerecho;
        }
    
        if (mayor != indice) {
            intercambiar(indice, mayor);
            heapify(mayor);
        }
    }
    

    private void intercambiar(int indice1, int indice2) {
        int temp = datos[indice1];
        datos[indice1] = datos[indice2];
        datos[indice2] = temp;
    }

    public int eliminarMaximo() {
        if (tamanio == 0) {
            throw new IllegalStateException("El montículo está vacío");
        }
        int maximo = datos[0];
        datos[0] = datos[tamanio - 1];
        tamanio--;
        // Reconstruir el montículo después de eliminar el máximo.
        heapify(0);
        return maximo;
    }

    public boolean estaVacio() {
        return tamanio == 0;
    }

    public int[] getDatos() {
        return datos;
    }

    public int getTamanio() {
        return tamanio;
    }
}
