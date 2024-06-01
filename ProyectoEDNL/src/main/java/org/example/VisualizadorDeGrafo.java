import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class VisualizadorDeGrafo {
    private Graph graph;

    public VisualizadorDeGrafo(Grafo grafo) {
        graph = new SingleGraph("Flujo Máximo");

        for (int i = 0; i < grafo.getV(); i++) {
            graph.addNode(String.valueOf(i));
        }

        int[][] capacidad = grafo.getCapacidad();
        for (int i = 0; i < grafo.getV(); i++) {
            for (int j = 0; j < grafo.getV(); j++) {
                if (capacidad[i][j] > 0) {
                    String id = i + "->" + j;
                    Edge edge = graph.addEdge(id, String.valueOf(i), String.valueOf(j), true);
                    edge.setAttribute("capacidad", capacidad[i][j]);
                    edge.setAttribute("flujoresidual", capacidad[i][j]);
                }
            }
        }
    }

    public void mostrar() {
        graph.display();
    }

    public void actualizarFlujo(int origen, int destino, int flujo) {
        Edge edge = graph.getEdge(origen + "->" + destino);
        if (edge != null) {
            int capacidad = (Integer)edge.getAttribute("capacidad");
            edge.setAttribute("flujoresidual", capacidad - flujo);
        }
    }

    public void setFlujo(int origen, int destino, int flujo) {
        Edge edge = graph.getEdge(origen + "->" + destino);
        if (edge != null) {
            edge.setAttribute("flujoresidual", flujo);
        }
    }
}
