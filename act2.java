import java.util.Scanner;

class Pila {
    private int[] data;
    private int top;
    private int capacity;

    public Pila(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        top = -1; // Pila vacia (corregí el valor inicial)
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Pila llena. No se puede agregar " + x);
            return;
        }
        data[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Pila vacia. No se puede eliminar un elemento");
            return -1; // Indicador de error
        }
        return data[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Pila vacia. No hay elemento superior");
            return -1;
        }
        return data[top];
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return;
        }
        
        System.out.println("Contenido de la pila (desde el tope): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    
    public int getSize() {
        return top + 1;
    }
    
    public int getCapacity() {
        return capacity;
    }
}

// menú de opciones
public class Act2 {
    private static Scanner scanner = new Scanner(System.in);
    private static Pila pila;
    
    public static void main(String[] args) {
        inicializarPila();
        mostrarMenu();
    }
    
    private static void inicializarPila() {
        System.out.print("Ingrese la capacidad de la pila: ");
        int capacidad = scanner.nextInt();
        pila = new Pila(capacidad);
        System.out.println("Pila creada con capacidad: " + capacidad);
    }
    
    private static void mostrarMenu() {
        int opcion;
        
        do {
            System.out.println("\n=== MENÚ DE PILA ===");
            System.out.println("1. Agregar elemento (Push)");
            System.out.println("2. Eliminar elemento (Pop)");
            System.out.println("3. Ver elemento superior (Peek)");
            System.out.println("4. Mostrar pila completa");
            System.out.println("5. Verificar si está vacía");
            System.out.println("6. Verificar si está llena");
            System.out.println("7. Mostrar tamaño actual");
            System.out.println("8. Mostrar capacidad máxima");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    agregarElemento();
                    break;
                case 2:
                    eliminarElemento();
                    break;
                case 3:
                    verElementoSuperior();
                    break;
                case 4:
                    mostrarPila();
                    break;
                case 5:
                    verificarVacia();
                    break;
                case 6:
                    verificarLlena();
                    break;
                case 7:
                    mostrarTamaño();
                    break;
                case 8:
                    mostrarCapacidad();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            
        } while (opcion != 9);
    }
    
    private static void agregarElemento() {
        System.out.print("Ingrese el número a agregar: ");
        int elemento = scanner.nextInt();
        pila.push(elemento);
    }
    
    private static void eliminarElemento() {
        int elementoEliminado = pila.pop();
        if (elementoEliminado != -1) {
            System.out.println("Elemento eliminado: " + elementoEliminado);
        }
    }
    
    private static void verElementoSuperior() {
        int elementoSuperior = pila.peek();
        if (elementoSuperior != -1) {
            System.out.println("Elemento superior: " + elementoSuperior);
        }
    }
    
    private static void mostrarPila() {
        pila.mostrar();
    }
    
    private static void verificarVacia() {
        if (pila.isEmpty()) {
            System.out.println("La pila está vacía");
        } else {
            System.out.println("La pila NO está vacía");
        }
    }
    
    private static void verificarLlena() {
        if (pila.isFull()) {
            System.out.println("La pila está llena");
        } else {
            System.out.println("La pila NO está llena");
        }
    }
    
    private static void mostrarTamaño() {
        System.out.println("Tamaño actual de la pila: " + pila.getSize());
    }
    
    private static void mostrarCapacidad() {
        System.out.println("Capacidad máxima de la pila: " + pila.getCapacity());
    }
}