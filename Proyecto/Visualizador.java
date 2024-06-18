import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Visualizador {
    public static void visualizarGrafo(FordFulkerson ff) {
        DirectedSparseGraph<Integer, String> grafo = new DirectedSparseGraph<>();

        for (int i = 0; i < ff.V; i++) {
            for (int j = 0; j < ff.V; j++) {
                if (ff.capacidad[i][j] > 0) {
                    grafo.addEdge("Arista " + i + "-" + j + " (" + ff.capacidad[i][j] + ")", i, j);
                }
            }
        }

        FRLayout<Integer, String> layout = new FRLayout<>(grafo);
        layout.setSize(new Dimension(600, 600));
        BasicVisualizationServer<Integer, String> vv = new BasicVisualizationServer<>(layout);
        vv.setPreferredSize(new Dimension(650, 650));
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<>());

        JFrame frame = new JFrame("Visualización del Grafo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }
}
