package JuegoDelPente;

import java.util.Arrays;

public class Funciones {

    public static final int CASILLA_VACIA = 0;

    public static final int FICHA_CIRCULO = 1; //ficha_circulo=1&&1='O'; trabajo con 1 pero muestro O

    public static final int FICHA_EQUIS = 2;

    public static void main(String[] args) {
    }

    public static void mostrarTablero(int[][] tablero) {

        for (int[] tablero1 : tablero) {
            for (int i = 0; i < 3 * tablero.length; i++) {
                System.out.print("=");
            }
            System.out.println(" ");
            for (int j = 0; j < tablero1.length; j++) {
                System.out.print("| ");
                if (tablero1[j] == CASILLA_VACIA) {
                    System.out.print(" ");
                } else if (tablero1[j] == FICHA_CIRCULO) {
                    System.out.print("O");
                } else if (tablero1[j] == FICHA_EQUIS) {
                    System.out.print("X");
                }
            }
            System.out.println("|");
        }
        for (int i = 0; i < 3 * tablero.length; i++) {
            System.out.print("=");
        }
    }

    /*
*Función mostrarTablero(int [][] tablero)
*Con esta función generamos un tablero con el diseño elegido
*
     */

    public static void mostrarTablero(int[][] tablero, int fila, int columna) {
        int contador = -1; //indice casero plus plus
        final String rosa = "\u001B[35m"; //para marcar la casilla recién puesta
        final String reset = "\u001B[0m";
        for (int[] tablero1 : tablero) {
            contador++;
            for (int i = 0; i < 3 * tablero.length; i++) {
                System.out.print("=");
            }
            System.out.println(" ");
            for (int j = 0; j < tablero1.length; j++) {
                System.out.print("| ");
                if (tablero1[j] == CASILLA_VACIA) {
                    System.out.print(" ");
                } else if (tablero1[j] == FICHA_CIRCULO) {
                    if (fila == contador && columna == tablero1[j]) {
                        System.out.print(rosa + "O" + reset);
                    } else {
                        System.out.print("O");
                    }
                } else if (tablero1[j] == FICHA_EQUIS) {
                    if (fila == contador && columna == tablero1[j]) {
                        System.out.print(rosa + "X" + reset);
                    } else {
                        System.out.print("X");
                    }
                }
            }
            System.out.println("|");
        }
        for (int i = 0; i < 3 * tablero.length; i++) {
            System.out.print("=");
        }
    }

    public static boolean colocarFicha(int[][] tablero, int ficha, int fila, int columna) {
        if (fila >= 0 && columna >= 0 && fila <= tablero.length && columna <= tablero.length) {
            if (tablero[fila][columna] == CASILLA_VACIA) {
                tablero[fila][columna] = ficha;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


public static int capturarFichas(int [][] tablero, int fila, int columna, int contador){
        int ficha=tablero[fila][columna];
        for(int i=1;i<4;i++){
            if(columna-i<0){
                i=69;
            }else if(tablero[fila][columna-i]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila][columna-i]){
                if(i==1||i==2){
                    i=69;
                }else{
                    tablero[fila][columna-1]=CASILLA_VACIA;
                    tablero[fila][columna-2]=CASILLA_VACIA;
                    contador++;        
                }
            }
        }
        
        for(int i=1;i<4;i++){
            if(columna+i>=tablero.length){
                i=69;
            }else if(tablero[fila][columna+i]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila][columna+i]){
                if(i==1||i==2){
                    i=69;
                }else{
                    tablero[fila][columna+1]=CASILLA_VACIA;
                    tablero[fila][columna+2]=CASILLA_VACIA;
                    contador++;
                }
            }
        }
        
        contador=0;
        for(int i=1;i<4;i++){
            if(fila-i<0){
                i=69;
            }else if(tablero[fila-i][columna]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila-i][columna]){
                if(i==1||i==2){
                    i=69;
                }else{
                    tablero[fila-1][columna]=CASILLA_VACIA;
                    tablero[fila-2][columna]=CASILLA_VACIA;
                    contador++;        
                }
            }
        }
        
        for(int i=1;i<4;i++){
            if(fila+i>=tablero.length){
                i=69;
            }else if(tablero[fila+i][columna]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila+i][columna]){
                if(i==1||i==2){
                    i=69;
                }else{
                    tablero[fila+1][columna]=CASILLA_VACIA;
                    tablero[fila+2][columna]=CASILLA_VACIA;
                    contador++;        
                }
            }
        }
        
        contador=0;
        for(int i=1;i<4;i++){
            if(fila-i<0 || columna-i<0){
                i=69;
            }else if(tablero[fila-i][columna-i]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila-i][columna-i]){
                if(i==1||i==2){
                    i=69;
                }else{
                    tablero[fila-1][columna-1]=CASILLA_VACIA;
                    tablero[fila-2][columna-2]=CASILLA_VACIA;
                    contador++;        
                }
            }
        }
        
        for(int i=1;i<4;i++){
            if(fila+i>=tablero.length || columna+i>=tablero.length){
                i=69;
            }else if(tablero[fila+i][columna+i]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila+i][columna+i]){
                if(i==1||i==2){
                    i=69;
                }else{
                    tablero[fila+1][columna+1]=CASILLA_VACIA;
                    tablero[fila+2][columna+2]=CASILLA_VACIA;
                    contador++;        
                }
            }
        }
        
        contador=0;
        for(int i=1;i<4;i++){
            if(fila-i<0 || columna+i>=tablero.length){
                i=69;
            }else if(tablero[fila-i][columna+i]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila-i][columna+i]){
                if(i==1||i==2){
                    i=69;
                }else{
                    tablero[fila-1][columna+1]=CASILLA_VACIA;
                    tablero[fila-2][columna+2]=CASILLA_VACIA;
                    contador++;        
                }
            }
        }
        
        for(int i=1;i<4;i++){
            if(fila+i>=tablero.length || columna-i<0){
                i=69;
            }else if(tablero[fila+i][columna-i]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila+i][columna-i]){
                if(i==1||i==2){
                    i=69;
                }else{
                    tablero[fila+1][columna-1]=CASILLA_VACIA;
                    tablero[fila+2][columna-2]=CASILLA_VACIA;
                    contador++;        
                }
            }
        }
        System.out.println(" ");
        System.out.println("Has capturado: "+contador+"fichas");
        return contador;
    }
    
    
    public static boolean comprobarLinea(int [][] tablero, int fila, int columna){
        
        int ficha=tablero[fila][columna];
        int contador=0;
  
        for(int i=1;i<=4;i++){
            if(columna-i<0){
                i=69;
            }else if(tablero[fila][columna-i]==CASILLA_VACIA){
                i=69;
            }else if(tablero[fila][columna-i]==ficha){
                contador++;
            }
        }
        
        for(int i=1;i<=4;i++){
            if(columna+i>=tablero.length){
                i=69;
            }else if(tablero[fila][columna+i]==CASILLA_VACIA){
                i=69;
            }else if(tablero[fila][columna+i]==ficha){
                contador++;
            }
        }
        
        if (contador==4){
            return true;
        }
        
        contador=0;
        for(int i=1;i<=4;i++){
            if(fila-i<0){
                i=69;
            }else if(tablero[fila-i][columna]==CASILLA_VACIA){
                i=69;
            }else if(tablero[fila-i][columna]==ficha){
                contador++;
            }
        }
        
        for(int i=1;i<=4;i++){
            if(fila+i>=tablero.length){
                i=69;
            }else if(tablero[fila+i][columna]==CASILLA_VACIA){
                i=69;
            }else if(tablero[fila+i][columna]==ficha){
                contador++;
            }
        }
       
        if (contador==4){
            return true;
        }
        
        contador=0;
        for(int i=1;i<=4;i++){
            if(fila-i<0 || columna-i<0){
                i=69;
            }else if(tablero[fila-i][columna-i]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila-i][columna-i]){        
                contador++;
            }
        }
        
        for(int i=1;i<=4;i++){
            if(fila+i>=tablero.length || columna+i>=tablero.length){
                i=69;
            }else if(tablero[fila+i][columna+i]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila+i][columna+i]){      
                contador++;
            }
        }
        
        if (contador==4){
            return true;
        }
        
        contador=0;
        for(int i=1;i<=4;i++){
            if(fila-i<0 || columna+i>=tablero.length){
                i=69;
            }else if(tablero[fila-i][columna+i]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila-i][columna+i]){        
                contador++;
            }
        }
        
        for(int i=1;i<=4;i++){
            if(fila+i>=tablero.length || columna-i<0){
                i=69;
            }else if(tablero[fila+i][columna-i]==CASILLA_VACIA){
                i=69;
            }else if(ficha==tablero[fila+i][columna-i]){        
                contador++;
            }
        }
        
        if (contador==4){
            return true;
        }
        
        return false;
    }
    
    public static boolean casillasLibres(int [][] tablero){
        for (int j=0;j<tablero.length;j++){ //aquí recorremos la fila
            for(int i=0;i<tablero.length;i++) //aquí recorremos la columna
            if(tablero[j][i]==CASILLA_VACIA){
            return true;
            } 
        }
        return false;
    }
}
