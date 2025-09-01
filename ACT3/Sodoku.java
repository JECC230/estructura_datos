public class Sodoku {
    private static final int TAMANIO = 9;
    static boolean resolverSudoku(int[][] tablero) {
        for (int fila = 0; fila < TAMANIO; fila++) {
            for (int col = 0; col < TAMANIO; col++) {
                if (tablero[fila][col] == 0) { // Encontrar celda vacía
                    for (int num = 1; num <= 9; num++) { // Probar números del 1 al 9
                        if (esValido(tablero, fila, col, num)) {
                            tablero[fila][col] = num; // Asignar número
                            
                            if (resolverSudoku(tablero)) { // Llamada recursiva
                                return true; // Solución encontrada
                            }
                            
                            tablero[fila][col] = 0; // Backtracking: deshacer asignación
                        }
                    }
                    return false; // No se encontró solución para esta celda
                }
            }
        }
        return true; // Todas las celdas están llenas (solución encontrada)
    }
    
    // Verifica si es válido colocar un número en una posición específica
     
    private static boolean esValido(int[][] tablero, int fila, int col, int num) {
        // Verificar fila
        for (int c = 0; c < TAMANIO; c++) {
            if (tablero[fila][c] == num) {
                return false;
            }
        }
        
        // Verificar columna
        for (int f = 0; f < TAMANIO; f++) {
            if (tablero[f][col] == num) {
                return false;
            }
        }
        
        // Verificar subcuadrícula 3x3
        int inicioFila = 3 * (fila / 3);
        int inicioCol = 3 * (col / 3);
        for (int f = inicioFila; f < inicioFila + 3; f++) {
            for (int c = inicioCol; c < inicioCol + 3; c++) {
                if (tablero[f][c] == num) {
                    return false;
                }
            }
        }
        
        return true; // El número se puede colocar en esta posición
    }
    
    //Imprime el tablero de Sudoku
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < TAMANIO; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < TAMANIO; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(tablero[i][j] == 0 ? ". " : tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] tablero = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        
        System.out.println("Tablero inicial:");
        imprimirTablero(tablero);
        System.out.println();
        
        if (resolverSudoku(tablero)) {
            System.out.println("Solución encontrada:");
            imprimirTablero(tablero);
        } else {
            System.out.println("No existe solución para este tablero.");
        }
    }
}

