public class FuncionHash {

    public static int generarHash(String cadena) {
        int valorHash = 0;

        for (char caracter : cadena.toCharArray()) {
            valorHash = (valorHash * 31) + (int) caracter;
        }

        return valorHash;
    }
}
