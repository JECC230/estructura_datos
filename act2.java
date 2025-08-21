import java.util.Scanner;


// Implementa una estructura de datos LIFO (Last-In, First-Out) usando un arreglo.
class Pila {
    private int[] data;
    private int top;
    private int capacity;

    public Pila(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        top = -1; // Pila vacia
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    // Agrega un elemento a la cima de la pila.
    public void push(int x) {
        if (isFull()) {
            System.out.println("Pila llena. No se puede agregar " + x);
            return;
        }
        data[++top] = x;
    }

    // Elimina y devuelve el elemento de la cima de la pila.
    public int pop() {
        if (isEmpty()) {
            System.out.println("Pila vacia. No se puede eliminar un elemento");
            return -1; // Indicador de error
        }
        return data[top--];
    }

    // Devuelve el elemento de la cima de la pila sin eliminarlo.
    public int peek() {
        if (isEmpty()) {
            System.out.println("Pila vacia. No hay elemento superior");
            return -1;
        }
        return data[top];
    }

    // Muestra todos los elementos de la pila desde el tope.
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


// Implementa una estructura de datos FIFO (First-In, First-Out) usando un arreglo circular.
class Cola {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Cola(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    // Agrega un elemento al final de la cola (rear).
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Cola llena. No se puede agregar " + x);
            return;
        }
        rear = (rear + 1) % capacity;
        data[rear] = x;
        size++;
    }

    // Elimina y devuelve el elemento del frente de la cola (front).
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacia. No se puede eliminar un elemento");
            return -1;
        }
        int removedElement = data[front];
        front = (front + 1) % capacity;
        size--;
        return removedElement;
    }

    // Devuelve el elemento del frente de la cola sin eliminarlo.
    public int peek() {
        if (isEmpty()) {
            System.out.println("Cola vacia. No hay elemento superior");
            return -1;
        }
        return data[front];
    }

    // Muestra todos los elementos de la cola desde el frente.
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return;
        }
        System.out.println("Contenido de la cola (desde el frente): ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
    
    public int getSize() {
        return size;
    }
    
    public int getCapacity() {
        return capacity;
    }
}

// Menú de opciones
public class Act2 {
    private static Scanner scanner = new Scanner(System.in);
    private static Pila pila;
    private static Cola cola;
    
    public static void main(String[] args) {
        inicializarEstructuras();
        mostrarMenu();
    }
    
    private static void inicializarEstructuras() {
        System.out.print("Ingrese la capacidad de las estructuras: ");
        int capacidad = scanner.nextInt();
        pila = new Pila(capacidad);
        cola = new Cola(capacidad);
        System.out.println("Pila y Cola creadas con capacidad: " + capacidad);
    }
    
    private static void mostrarMenu() {
        int opcion;
        
        do {
            System.out.println("\n=== MENÚ DE ESTRUCTURAS DE DATOS ===");
            System.out.println("--- Pila ---");
            System.out.println("1. Agregar elemento a la Pila (Push)");
            System.out.println("2. Eliminar elemento de la Pila (Pop)");
            System.out.println("3. Ver elemento superior de la Pila (Peek)");
            System.out.println("4. Mostrar pila completa");
            System.out.println("5. Verificar si la Pila está vacía");
            System.out.println("--- Cola ---");
            System.out.println("6. Agregar elemento a la Cola (Enqueue)");
            System.out.println("7. Eliminar elemento de la Cola (Dequeue)");
            System.out.println("8. Ver elemento del frente de la Cola (Peek)");
            System.out.println("9. Mostrar cola completa");
            System.out.println("10. Verificar si la Cola está vacía");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    agregarElementoPila();
                    break;
                case 2:
                    eliminarElementoPila();
                    break;
                case 3:
                    verElementoSuperiorPila();
                    break;
                case 4:
                    mostrarPila();
                    break;
                case 5:
                    verificarVaciaPila();
                    break;
                case 6:
                    agregarElementoCola();
                    break;
                case 7:
                    eliminarElementoCola();
                    break;
                case 8:
                    verElementoFrenteCola();
                    break;
                case 9:
                    mostrarCola();
                    break;
                case 10:
                    verificarVaciaCola();
                    break;
                case 11:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            
        } while (opcion != 11);
    }
    
    private static void agregarElementoPila() {
        System.out.print("Ingrese el número a agregar a la pila: ");
        int elemento = scanner.nextInt();
        pila.push(elemento);
    }
    
    private static void eliminarElementoPila() {
        int elementoEliminado = pila.pop();
        if (elementoEliminado != -1) {
            System.out.println("Elemento eliminado de la pila: " + elementoEliminado);
        }
    }
    
    private static void verElementoSuperiorPila() {
        int elementoSuperior = pila.peek();
        if (elementoSuperior != -1) {
            System.out.println("Elemento superior de la pila: " + elementoSuperior);
        }
    }
    
    private static void mostrarPila() {
        pila.mostrar();
    }
    
    private static void verificarVaciaPila() {
        if (pila.isEmpty()) {
            System.out.println("La pila está vacía");
        } else {
            System.out.println("La pila NO está vacía");
        }
    }

    private static void agregarElementoCola() {
        System.out.print("Ingrese el número a agregar a la cola: ");
        int elemento = scanner.nextInt();
        cola.enqueue(elemento);
    }

    private static void eliminarElementoCola() {
        int elementoEliminado = cola.dequeue();
        if (elementoEliminado != -1) {
            System.out.println("Elemento eliminado de la cola: " + elementoEliminado);
        }
    }

    private static void verElementoFrenteCola() {
        int elementoFrente = cola.peek();
        if (elementoFrente != -1) {
            System.out.println("Elemento del frente de la cola: " + elementoFrente);
        }
    }

    private static void mostrarCola() {
        cola.mostrar();
    }

    private static void verificarVaciaCola() {
        if (cola.isEmpty()) {
            System.out.println("La cola está vacía");
        } else {
            System.out.println("La cola NO está vacía");
        }
    }
}
