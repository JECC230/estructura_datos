public class Fibonacci {

    public static int fibonacci(int n) {
        // Casos base
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // Caso recursivo: F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        // Pruebas de la función Fibonacci
        System.out.println("Fibonacci de 0: " + fibonacci(0));
        System.out.println("Fibonacci de 1: " + fibonacci(1));
        System.out.println("Fibonacci de 5: " + fibonacci(5));
        System.out.println("Fibonacci de 10: " + fibonacci(10));
    }
}
