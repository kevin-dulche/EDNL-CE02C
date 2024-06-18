import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorDeArchivo {
    public static Grafo leerGrafoDesdeArchivo(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        int V = Integer.parseInt(br.readLine().trim());
        Grafo grafo = new Grafo(V);

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(" ");
            int origen = Integer.parseInt(partes[0]);
            int destino = Integer.parseInt(partes[1]);
            int capacidad = Integer.parseInt(partes[2]);
            grafo.agregarArista(origen, destino, capacidad);
        }

        br.close();
        return grafo;
    }
}
