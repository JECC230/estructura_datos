import java.util.Scanner;

// Clase Nodo para la lista ligada
// Representa un elemento en la lista ligada.
class Nodo {
    int data;
    Nodo next;

    public Nodo(int data) {
        this.data = data;
        this.next = null;
    }
}


// Implementa una estructura de datos LIFO (Last-In, First-Out) utilizando una lista ligada.
class Pila {
    private Nodo top;

    public Pila() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Agrega un elemento a la cima de la pila (principio de la lista ligada).
    public void push(int x) {
        Nodo newNode = new Nodo(x);
        newNode.next = top;
        top = newNode;
        System.out.println("Elemento " + x + " agregado a la pila.");
    }

    // Elimina y devuelve el elemento de la cima de la pila.
    public int pop() {
        if (isEmpty()) {
            System.out.println("Pila vacía. No se puede eliminar un elemento.");
            return -1;
        }
        int removedData = top.data;
        top = top.next;
        return removedData;
    }

    // Devuelve el elemento de la cima de la pila sin eliminarlo.
    public int peek() {
        if (isEmpty()) {
            System.out.println("Pila vacía. No hay elemento superior.");
            return -1;
        }
        return top.data;
    }

    // Muestra todos los elementos de la pila.
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return;
        }
        System.out.println("Contenido de la pila (desde el tope): ");
        Nodo current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


// Implementa una estructura de datos FIFO (First-In, First-Out) utilizando una lista ligada.
class Cola {
    private Nodo front;
    private Nodo rear;

    public Cola() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Agrega un elemento al final de la cola.
    public void enqueue(int x) {
        Nodo newNode = new Nodo(x);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Elemento " + x + " agregado a la cola.");
    }

    // Elimina y devuelve el elemento del frente de la cola.
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía. No se puede eliminar un elemento.");
            return -1;
        }
        int removedData = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // La cola queda vacía.
        }
        return removedData;
    }

    // Devuelve el elemento del frente de la cola sin eliminarlo.
    public int peek() {
        if (isEmpty()) {
            System.out.println("Cola vacía. No hay elemento al frente.");
            return -1;
        }
        return front.data;
    }

    // Muestra todos los elementos de la cola.
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }
        System.out.println("Contenido de la cola (desde el frente): ");
        Nodo current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Menú de opciones
public class Act2 {
    private static Scanner scanner = new Scanner(System.in);
    private static Pila pila = new Pila();
    private static Cola cola = new Cola();

    public static void main(String[] args) {
        System.out.println("Estructuras de datos (Pila y Cola) creadas.");
        mostrarMenu();
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

            try {
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
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer de entrada
                opcion = 0;
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
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("La pila NO está vacía.");
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
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("La cola NO está vacía.");
        }
    }
}
