import java.util.Random;
import java.util.Scanner;

public class Juego {
    static Scanner entrada = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        inicioJuego();
        entrada.close();
    }

    public static void inicioJuego() {
        String[] arreglo = {"Dado1", "Azul", "Dado2", "Verde"};
        int objetivo = random.nextInt(5) + 7; // 7, 8, 9, 10 u 11 (oculto)
        int acumulador = 0;                   // puntos de los dados acumulados

        System.out.println("Se eligio un numero secreto entre 7 y 11.");
        System.out.println("Tire los dados hasta que sus puntos acumulados lo igualen.");

        while (true) {
            System.out.println("\nSe tiran los dados");
            int numDado1 = leerEntero("Ingrese el valor del primer dado (1-6): ", 1, 6);
            int numDado2 = leerEntero("Ingrese el valor del segundo dado (1-6): ", 1, 6);

            Dados dadoA = new Dados(arreglo[0], arreglo[1], numDado1);
            Dados dadoV = new Dados(arreglo[2], arreglo[3], numDado2);

            mostrarDado(dadoA);
            mostrarDado(dadoV);

            acumulador += sumaDados(dadoA.getPuntos(), dadoV.getPuntos());
            System.out.println("Los puntos acumulados son: " + acumulador);

            if (acumulador == objetivo) {
                System.out.println("Acerto el numero secreto: " + objetivo);
                System.out.println("Usted gana, se le otorga el premio mayor");
                System.out.println("Fin del juego");
                return;
            }

            // Faltante para llegar al objetivo; una tirada suma de 2 a 12
            int faltante = objetivo - acumulador;
            if (faltante < 2) {
                System.out.println("Ya no es posible llegar al numero secreto en la siguiente ronda.");
                System.out.println("El numero secreto era: " + objetivo);
                System.out.println("Usted pierde. Fin del juego");
                return;
            }

            System.out.println("Aun no llega al numero secreto, puede seguir jugando.");
            int decision = leerEntero("Desea seguir jugando? 1-si 2-no: ", 1, 2);
            if (decision == 2) {
                System.out.println("Juego finalizado.");
                System.out.println("El numero secreto era: " + objetivo);
                System.out.println("Gracias por jugar.");
                return;
            }
        }
    }

    // Lee un entero dentro de [min, max]; repite hasta que sea valido.
    public static int leerEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String linea = entrada.nextLine().trim();
            try {
                int valor = Integer.parseInt(linea);
                if (valor >= min && valor <= max) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                // cae al mensaje de error
            }
            System.out.println("Valor no valido, debe ser un numero entre " + min + " y " + max + ".");
        }
    }

    public static void mostrarDado(Dados dado) {
        System.out.println("El dado utilizado fue: " + dado.getNombre() + " " + dado.getColor()
                + " salio con la cantidad de " + dado.getPuntos());
    }

    public static int sumaDados(int noDado, int noDado2) {
        return noDado + noDado2;
    }
}