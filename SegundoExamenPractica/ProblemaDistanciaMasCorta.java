/*
 * Sección 4: Problemas de distancias más cortas
 * Pregunta b (25 puntos):

 * Un trágico accidente ocurrió en el Segundo Piso del Periférico, por lo que una ambulancia llegó de inmediato y el paciente debe ser internado en algún hospital lo antes posible. Hay N ciudades numeradas del 1, 2,3... N en la ubicación cercana y al paciente le quedan M minutos antes de morir, y solo hay un hospital que está situado en Y y ahora usted está en X, por lo que hay que acudir al hospital lo antes posible. Debe determinar si el paciente puede salvarse en M minutos o no.
 * 10 7 19 5 7
 * 3 10 8
 * 1 2 9
 * 2 3 3
 * 5 10 3
 * 1 3 7
 * 1 7 1
 * 3 6 2
 * 2 5 6
 * 2 4 8
 * 7 8 1
 * 1 10 6
 * 2 7 1
 * 2 8 2
 * 3 5 2
 * 2 6 5
 * 4 7 4
 * 6 9 9
 * 8 10 8
 * 7 10 2
 * 
 *  La primera línea contiene cinco números enteros separados por espacios N, M, R, X e Y que indican el número de ciudades, al paciente le quedan minutos antes de morir, el número de ruta para llegar al hospital, la posición en la que se encuentra y la ubicación del hospital.
 */

public class ProblemaDistanciaMasCorta {
    public static void main(String[] args) {

        /*
         * Leer N, M, R, X, Y
            Crear grafo con N nodos y sin conexiones inicialmente

            Para cada ruta (A, B, T) en las R rutas:
                Añadir conexión desde A hasta B con peso T al grafo
                Añadir conexión desde B hasta A con peso T al grafo

            Aplicar algoritmo de Dijkstra al grafo desde nodo X teniendo en cuenta el tiempo M

            Si la distancia desde X hasta Y es menor o igual que M:
                El paciente puede salvarse
            Sino:
                El paciente no puede salvarse
         */

        // * Leer N, M, R, X, Y
        int NumeroDeCiudades = 10;
        int MinutosAntesDeMorir = 7;
        int RutaHospital = 19;
        int X_posicionInicial = 5;
        int Y_posicionFinal = 7;

        // * Crear grafo con N nodos y sin conexiones inicialmente
        
        int[][] grafo = new int[NumeroDeCiudades][NumeroDeCiudades];
        for (int i = 0; i < NumeroDeCiudades; i++) {
            for (int j = 0; j < NumeroDeCiudades; j++) {
                grafo[i][j] = 0;
            }
        }

        // * Para cada ruta (A, B, T) en las R rutas:
        int[][] rutas = {
            {3, 10, 8},
            {1, 2, 9},
            {2, 3, 3},
            {5, 10, 3},
            {1, 3, 7},
            {1, 7, 1},
            {3, 6, 2},
            {2, 5, 6},
            {2, 4, 8},
            {7, 8, 1},
            {1, 10, 6},
            {2, 7, 1},
            {2, 8, 2},
            {3, 5, 2},
            {2, 6, 5},
            {4, 7, 4},
            {6, 9, 9},
            {8, 10, 8},
            {7, 10, 2}
        };

        for (int i = 0; i < RutaHospital; i++) {
            int A = rutas[i][0] - 1;
            int B = rutas[i][1] - 1;
            int T = rutas[i][2];

            // * Añadir conexión desde A hasta B con peso T al grafo
            grafo[A][B] = T;
            // * Añadir conexión desde B hasta A con peso T al grafo
            grafo[B][A] = T;
        }

        // * Aplicar algoritmo de Dijkstra al grafo desde nodo X teniendo en cuenta el tiempo M
        int[] distancias = new int[NumeroDeCiudades];
        for (int i = 0; i < NumeroDeCiudades; i++) {
            distancias[i] = Integer.MAX_VALUE;
        }
        distancias[X_posicionInicial - 1] = 0;

        boolean[] visitados = new boolean[NumeroDeCiudades];
        for (int i = 0; i < NumeroDeCiudades; i++) {
            int nodo = -1;
            for (int j = 0; j < NumeroDeCiudades; j++) {
                if (!visitados[j] && (nodo == -1 || distancias[j] < distancias[nodo])) {
                    nodo = j;
                }
            }

            visitados[nodo] = true;

            for (int j = 0; j < NumeroDeCiudades; j++) {
                if (grafo[nodo][j] > 0) {
                    distancias[j] = Math.min(distancias[j], distancias[nodo] + grafo[nodo][j]);
                }
            }
        }

        // * Si la distancia desde X hasta Y es menor o igual que M:
        //     El paciente puede salvarse
        // Sino:
        //     El paciente no puede salvarse

        if (distancias[Y_posicionFinal - 1] <= MinutosAntesDeMorir) {
            System.out.println("El paciente puede salvarse");
        } else {
            System.out.println("El paciente no puede salvarse");
        }
        
    
    }
}