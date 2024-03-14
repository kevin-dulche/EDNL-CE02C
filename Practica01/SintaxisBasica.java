/**
 * SintaxisBasica
 */
public class SintaxisBasica {

    public static void main(String[] args) {
        SintaxisBasica sintaxisBasica = new SintaxisBasica();
        sintaxisBasica.arregloUnidimensionalBidimesionales();
        sintaxisBasica.clasePersona();
        sintaxisBasica.claseHerencia();
    }


    public void arregloUnidimensionalBidimesionales() {
        System.out.println("Arreglos unidimensionales y bidimensionales");
        System.out.println("===========================================");
        System.out.println("\nArreglo unidimensional:");

        // Areglo unidimensional
        int[] numeros = new int[10];
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;
        numeros[5] = 60;
        numeros[6] = 70;
        numeros[7] = 80;
        numeros[8] = 90;
        numeros[9] = 100;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        System.out.println();

        // Arreglo bidimensional
        int[][] matriz = new int[3][3];
        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[0][2] = 3;
        matriz[1][0] = 4;
        matriz[1][1] = 5;
        matriz[1][2] = 6;
        matriz[2][0] = 7;
        matriz[2][1] = 8;
        matriz[2][2] = 9;



        System.out.println("\nArreglo bidimensional:");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void clasePersona() {
        System.out.println("\nClase Persona");
        System.out.println("===========================================");
        Persona persona = new Persona("Juan", 25);
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());
    }

    public void claseHerencia() {
        System.out.println("\nClase Herencia");
        System.out.println("===========================================");
        Perro perro = new Perro("Firulais", "Perro", "Pastor Aleman", "Cafe");
        Gato gato = new Gato("Michi", "Gato", "Michi", "Blanco");

        System.out.println(perro);
        System.out.println(gato);
    }
}