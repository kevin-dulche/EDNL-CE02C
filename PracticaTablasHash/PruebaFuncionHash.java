import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PruebaFuncionHash {
    public static void main(String[] args) {
        // Generar un conjunto de cadenas de entrada
        List<String> cadenas = generarCadenas(1000, 1000);
    
        // Calcular la distribución de valores hash
        Map<Integer, Integer> distribucionHash = new HashMap<>();
        for (String cadena : cadenas) {
            int valorHash = FuncionHash.generarHash(cadena);
            distribucionHash.put(valorHash, distribucionHash.getOrDefault(valorHash, 0) + 1);
        }

        // Analizar la distribución de valores hash
        System.out.println("Distribución de valores hash:");
        for (Map.Entry<Integer, Integer> entrada : distribucionHash.entrySet()) {
            System.out.println("Valor hash: " + entrada.getKey() + ", Frecuencia: " + entrada.getValue());
        }
    }

    private static List<String> generarCadenas(int cantidad, int longitud) {
        List<String> cadenas = new ArrayList<>();
        Random random = new Random();
        String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Caracteres permitidos
        
        for (int i = 0; i < cantidad; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < longitud; j++) {
                int indice = random.nextInt(alfabeto.length());
                sb.append(alfabeto.charAt(indice));
            }
            cadenas.add(sb.toString());
        }
        
        return cadenas;
    }
}