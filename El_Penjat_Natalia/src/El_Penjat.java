import java.util.Scanner;
//Este es el juego del ahorcado.
//Hay un array de 30 palabras.
//El programa hace un cálculo para elegir una palabra random del array.
//Se enmascara la palabra con guioncitos y se muestra.
//El jugador tiene 6 intentos (6 vidas) para adivinarla.
//Si la letra introducida está en la palabra entonces se desenmascara todas las veces que aparezca en ella.
//Si la letra no está en la palabra, se resta una vida. Dependiendo del número de vidas se muestra una parte del ahorcado.
//El juego termina cuando la palabra ha sido totalmente desenmascarada o las vidas llegan a 0.

public class El_Penjat {
    static Scanner scan = new Scanner(System.in);

    //APUNTES:
    //Nunca poner código en el main.
    //Siempre poner primero las variables.
    //Construir el programa pensando en qué paso tiene que hacer la aplicación, en orden, y definir
    //cada paso como un método definido por un verbo
    //Los métodos que no tienen que devolver información son los que no necesitan guardar nada en una variable del main.
    //Las palabras que van entre los parentesis de los métodos son las variables que se cogen del main.
    //Las variables que se modifican en los métodos no cambian las del main, solo el return hace eso.

    public static void main(String[] args) {
        mostrarMensajeBienvenida();
        String[] palabras = arrayPalabras();
        String palabra = seleccionarPalabraRandom(palabras);
        char[] mascara = enmascararPalabra(palabra);
        int vidas = 6;

        //Empieza el loop del juego:
        boolean salir = false;
        do {
            System.out.println("\nLives: " + vidas);
            char letra = introducirLetra();
            boolean encontrada = comprobarLetra(letra, palabra, mascara);
            vidas = modificarVidas(vidas, encontrada, mascara);
            mostrarPenjat(vidas);
            salir = gestionarSalirJuego(vidas, mascara);
        } while (!salir);
    }
    private static void mostrarMensajeBienvenida() {
        System.out.print("GAME STARTS\n");
    }

    private static String[] arrayPalabras() {
        return new String[]{"party", "winter", "touch", "next", "coat", "love", "snail", "care", "brief", "guitar", "rhythm", "free", "prince", "princess", "king", "relation", "sword", "shield", "freezing", "mouth", "eye", "trick", "farm", "week", "weekend", "experience", "reflection", "factory", "pantry", "palace"};
    }

    private static String seleccionarPalabraRandom(String[] palabras) {
        String palabra = palabras[(int) (Math.random() * palabras.length)];
        return palabra;
    }

    private static char[] enmascararPalabra(String palabra) {
        char[] mascara = new char[palabra.length()];
        //Otra posibilidad es utilizar Array.fill etcetc
        for(int i = 0; i < mascara.length; i++) {
            mascara[i] = '_';
            System.out.print(mascara[i]);
        }
        return mascara;
    }

    private static char introducirLetra() {
        System.out.println("\nGuess a letter: ");
        return Character.toLowerCase(scan.next().charAt(0));
    }

    private static boolean comprobarLetra(char letra, String palabra, char[] mascara) {
        boolean encontrada = false;

        for(int i = 0; i < palabra.length(); i++) {

            char caracteres = palabra.charAt(i);

            if(caracteres == letra) {
                mascara[i] = caracteres;
                encontrada = true;
            }
        }

        return encontrada;
    }

    private static int modificarVidas(int vidas, boolean encontrada, char[] mascara) {

        if (!encontrada) {
            System.out.println("Wrong letter.");
            System.out.println(mascara);
            vidas--;
        } else {
            System.out.println(mascara);
        }
        return vidas;
    }

    private static void mostrarPenjat(int vidas) {
        switch (vidas) {
            case 0:
                System.out.println("..............");
                System.out.println("      |");
                System.out.println("      0");
                System.out.println("     /|\\");
                System.out.println("     / \\");
                break;

            case 1:
                System.out.println("..............");
                System.out.println("      |");
                System.out.println("      0");
                System.out.println("     /|\\");
                System.out.println("       \\");
                break;
            case 2:
                System.out.println("..............");
                System.out.println("      |");
                System.out.println("      0");
                System.out.println("     /|\\");
                break;
            case 3:
                System.out.println("..............");
                System.out.println("      |");
                System.out.println("      0");
                System.out.println("      |\\");
                break;
            case 4:
                System.out.println("..............");
                System.out.println("      |");
                System.out.println("      0");
                System.out.println("      |");
                break;
            case 5:
                System.out.println("..............");
                System.out.println("      |");
                System.out.println("      0");
                break;
        }
    }

    private static boolean gestionarSalirJuego(int vidas, char[] mascara) {

        boolean salir = false;

        if (vidas == 0) {
            System.out.println("GAME OVER!");
            return true;
        }

        salir = true;

        for (int i = 0; i < mascara.length; i++) {
            if (mascara[i] == '_')
                salir = false;
        }

        if (salir && vidas > 0) {
            System.out.println("YOU WIN!");
        }

        return salir;
    }

}
