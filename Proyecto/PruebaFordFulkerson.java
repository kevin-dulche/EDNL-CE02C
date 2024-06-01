import java.io.IOException;

public class PruebaFordFulkerson {
    public static void main(String[] args) {
        try {
            Grafo grafo = LectorDeArchivo.leerGrafoDesdeArchivo("grafo.txt");
            FordFulkerson ff = new FordFulkerson(grafo);
            VisualizadorDeGrafo visualizador = new VisualizadorDeGrafo(grafo);
            
            int flujoMaximo = ff.fordFulkerson(0, 5);
            System.out.println("El flujo máximo posible es " + flujoMaximo);
            
            visualizador.mostrar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
