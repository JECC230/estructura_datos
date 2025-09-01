import java.util.Arrays;

public class SubsetSum {
  
    public static boolean existeSubconjuntoSuma(int[] conjunto, int n, int sumaObjetivo) {
        // Casos base
        if (sumaObjetivo == 0) return true; // Subconjunto vacío suma 0
        if (n == 0 && sumaObjetivo != 0) return false; // Sin elementos y suma no cero
        
        // Si el último elemento es mayor que la suma objetivo, ignorarlo
        if (conjunto[n-1] > sumaObjetivo) {
            return existeSubconjuntoSuma(conjunto, n-1, sumaObjetivo);
        }
        
        // Probar incluyendo o excluyendo el último elemento
        return existeSubconjuntoSuma(conjunto, n-1, sumaObjetivo) || 
               existeSubconjuntoSuma(conjunto, n-1, sumaObjetivo - conjunto[n-1]);
    }
    
    public static void main(String[] args) {
        int[] conjunto = {3, 34, 4, 12, 5, 2};
        int sumaObjetivo = 9;
        
        System.out.println("Conjunto: " + Arrays.toString(conjunto));
        System.out.println("¿Existe subconjunto que sume " + sumaObjetivo + "? " + 
                          existeSubconjuntoSuma(conjunto, conjunto.length, sumaObjetivo));
        
        sumaObjetivo = 30;
        System.out.println("¿Existe subconjunto que sume " + sumaObjetivo + "? " + 
                          existeSubconjuntoSuma(conjunto, conjunto.length, sumaObjetivo));
    }
}
