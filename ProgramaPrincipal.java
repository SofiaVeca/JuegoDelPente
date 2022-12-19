package JuegoDelPente;

import java.util.Scanner;

public class ProgramaPrincipal {

    public static final int CASILLA_VACIA = 0;

    public static final int FICHA_CIRCULO = 1; //ficha_circulo=1&&1='O'; trabajo con 1 pero muestro O

    public static final int FICHA_EQUIS = 2;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < 1000; i++) {

            final String cyan = "\u001B[36m";
            final String rojo = "\u001B[31m";
            final String rosa = "\u001B[35m";
            final String reset = "\u001B[0m";

            System.out.println(" ");
            System.out.println(cyan + "Bienvenido al juego del pente." + reset);
            System.out.println(" ");

            System.out.println("Vamos a comenzar por definir el tamaño del tablero en el que vamos a jugar.");
            System.out.println("Recuerda que debe ser entre 10 y 19: ");
            int filasYcolumnas = teclado.nextInt();
            while (filasYcolumnas < 10 || filasYcolumnas > 19) {
                System.out.println(rojo + "¡El tamaño debe estar comprendido entre 10 y 19!" + reset);
                System.out.println("Indique el número de filas y columnas de forma correcta: ");
                filasYcolumnas = teclado.nextInt();
            }
            int tablero[][] = new int[filasYcolumnas][filasYcolumnas];
            Funciones.mostrarTablero(tablero);

            System.out.println(" ");
            System.out.println("Ahora, introduce el número de fichas capturadas para ganar.");
            System.out.println("Recuerda que debe ser entre 5 y 10: ");
            int fichas = teclado.nextInt();
            while (fichas < 5 || fichas > 10) {
                System.out.println(rojo + "!Entre 5 y 10!" + reset);
                System.out.println("Introduce el número de fichas de forma correcta: ");
                fichas = teclado.nextInt();
            }
            System.out.println(" ");

            String jugador1, jugador2;
            System.out.println("Introduce el nombre del jugador 1: ");
            jugador1 = teclado.next();
            System.out.println(rosa + jugador1 + reset + " tu ficha será el circulo: " + rosa + "O" + reset);
            System.out.println(" ");
            System.out.println("Introduce el nombre del jugador 2: ");
            jugador2 = teclado.next();
            System.out.println(rosa + jugador2 + reset + " tu ficha será la equis: " + rosa + "X" + reset);
            System.out.println(" ");

            int contador1 = 0;
            int contador2 = 0;
            boolean juego = true;
            boolean turno = true;
            while (juego) {
                if (turno) {
                    boolean colocada = false;
                    int fila = 0;
                    int columna = 0;
                    while (!colocada) {
                        System.out.println(jugador1 + " escribe la posicion:");
                        System.out.println("Fila: ");
                        fila = teclado.nextInt();
                        fila = fila - 1;
                        System.out.println("Columna: ");
                        columna = teclado.nextInt();
                        columna = columna - 1;
                        colocada = Funciones.colocarFicha(tablero, FICHA_CIRCULO, fila, columna);
                    }
                    Funciones.mostrarTablero(tablero, fila, columna);
                    if (Funciones.comprobarLinea(tablero, fila, columna)) {
                        System.out.println(" ");
                        System.out.println(cyan + "¡VICTORIA!" + reset);
                        juego = false;
                    }
                    Funciones.capturarFichas(tablero, fila, columna, contador1);
                    if (contador1 >= fichas) {
                        System.out.println(" ");
                        System.out.println(cyan + "¡VICTORIA!" + reset);
                        juego = false;
                    }
                } else {
                    boolean colocada = false;
                    int fila = 0;
                    int columna = 0;
                    while (!colocada) {
                        System.out.println(" escribe la posición:");
                        System.out.println("Fila: ");
                        fila = teclado.nextInt();
                        fila = fila - 1;
                        System.out.println("Columna: ");
                        columna = teclado.nextInt();
                        columna = columna - 1;
                        colocada = Funciones.colocarFicha(tablero, FICHA_EQUIS, fila, columna);
                    }
                    Funciones.mostrarTablero(tablero, fila, columna);
                    if (Funciones.comprobarLinea(tablero, fila, columna)) {
                        System.out.println(" ");
                        System.out.println(cyan + "¡VICTORIA!" + reset);
                        juego = false;
                    }
                    Funciones.capturarFichas(tablero, fila, columna, contador2);
                    if (contador1 >= fichas) {
                        System.out.println(" ");
                        System.out.println(cyan + "¡VICTORIA!" + reset);
                        juego = false;
                    }
                }
                if(!Funciones.casillasLibres(tablero)){
                    juego=!juego;
                    System.out.println("No quedan casillas vacias.");
                }
                turno = !turno;
            }
        }
    }
}
