public class Grafo {
    private int V; // Número de vértices
    private int[][] capacidad; // Matriz de capacidad

    public Grafo(int V) {
        this.V = V;
        capacidad = new int[V][V];
    }

    public void agregarArista(int origen, int destino, int capacidad) {
        this.capacidad[origen][destino] = capacidad;
    }

    public int getV() {
        return V;
    }

    public int[][] getCapacidad() {
        return capacidad;
    }
}
