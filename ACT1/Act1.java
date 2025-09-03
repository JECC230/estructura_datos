import java.util.Scanner;

// =================================================================================
// 1. CLASE CONTACT 
// =================================================================================
/**
 * Representa un contacto con nombre, teléfono y dirección.
 * Este es un ejemplo de un tipo de dato complejo y abstracto.
 */
class Contact {
    private String name;
    private String phone;
    private String address;

    public Contact(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    // Sobrescribimos el método toString para mostrar la información del contacto de forma clara.
    @Override
    public String toString() {
        return "Contacto{" +
               "Nombre='" + name + '\'' +
               ", Teléfono='" + phone + '\'' +
               ", Dirección='" + address + '\'' +
               '}';
    }
}

// =================================================================================
// 2. CLASE NODE Estructura base para los nodos
// =================================================================================
/**
 * Representa un nodo genérico en una lista enlazada.
 * Utilizamos genéricos (<T>) para que el nodo pueda almacenar cualquier tipo de dato.
 * El tipo de dato que almacenará el nodo.
 */
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Representa un nodo para una lista doblemente enlazada.
 * Hereda de Node y añade una referencia al nodo previo.
 * El tipo de dato que almacenará el nodo.
 */
class DoublyNode<T> extends Node<T> {
    DoublyNode<T> prev;

    public DoublyNode(T data) {
        super(data);
        this.prev = null;
    }
}


// =================================================================================
// 3. INTERFAZ LIST Define las operaciones comunes
// =================================================================================
/**
 * Interfaz que define las operaciones básicas para cualquier tipo de lista.
 * El tipo de dato que manejará la lista.
 */
interface List<T> {
    void insert(T data);
    boolean delete(T data);
    Node<T> find(T data);
    void display();
    boolean isEmpty();
}


// =================================================================================
// 4. CLASE LINKEDLIST (Implementaciones de las listas)
// =================================================================================

// ---------------------------
// 4.1. Lista Simplemente Enlazada
// ---------------------------
class SinglyLinkedList<T> implements List<T> {
    protected Node<T> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("✅ Elemento insertado: " + data);
    }

    @Override
    public boolean delete(T data) {
        if (isEmpty()) {
            System.out.println("⚠️ Error: La lista está vacía.");
            return false;
        }

        if (head.data.equals(data)) {
            head = head.next;
            System.out.println("🗑️ Elemento eliminado: " + data);
            return true;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("🗑️ Elemento eliminado: " + data);
            return true;
        }

        System.out.println("⚠️ Error: Elemento no encontrado para eliminar.");
        return false;
    }

    @Override
    public Node<T> find(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                System.out.println("🔍 Elemento encontrado: " + current.data);
                return current;
            }
            current = current.next;
        }
        System.out.println("⚠️ Elemento no encontrado.");
        return null;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("|| La lista está vacía. ||");
            return;
        }
        System.out.println("--- Lista Simplemente Enlazada ---");
        Node<T> current = head;
        while (current != null) {
            System.out.print("[ " + current.data + " ] -> ");
            current = current.next;
        }
        System.out.println("null");
        System.out.println("---------------------------------");
    }
}

// ---------------------------
// 4.2. Lista Doblemente Enlazada
// ---------------------------
class DoublyLinkedList<T> implements List<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void insert(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("✅ Elemento insertado: " + data);
    }

    @Override
    public boolean delete(T data) {
        if (isEmpty()) {
             System.out.println("⚠️ Error: La lista está vacía.");
            return false;
        }

        DoublyNode<T> current = head;
        while(current != null && !current.data.equals(data)) {
            current = (DoublyNode<T>) current.next;
        }

        if(current == null) {
            System.out.println("⚠️ Error: Elemento no encontrado para eliminar.");
            return false;
        }
        
        if(current == head) { // Eliminar la cabeza
            head = (DoublyNode<T>) head.next;
            if(head != null) head.prev = null;
            else tail = null; // La lista quedó vacía
        } else if (current == tail) { // Eliminar la cola
            tail = tail.prev;
            tail.next = null;
        } else { // Eliminar un nodo intermedio
            current.prev.next = current.next;
            ((DoublyNode<T>) current.next).prev = current.prev;
        }

        System.out.println("🗑️ Elemento eliminado: " + data);
        return true;
    }

    @Override
    public Node<T> find(T data) {
        DoublyNode<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                System.out.println("🔍 Elemento encontrado: " + current.data);
                return current;
            }
            current = (DoublyNode<T>) current.next;
        }
        System.out.println("⚠️ Elemento no encontrado.");
        return null;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("|| La lista está vacía. ||");
            return;
        }
        System.out.println("--- Lista Doblemente Enlazada ---");
        DoublyNode<T> current = head;
        System.out.print("null <-> ");
        while (current != null) {
            System.out.print("[ " + current.data + " ] <-> ");
            current = (DoublyNode<T>) current.next;
        }
        System.out.println("null");
        System.out.println("---------------------------------");
    }
}


// ---------------------------
// 4.3. Lista Circular
// ---------------------------
class CircularLinkedList<T> extends SinglyLinkedList<T> {
    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            head.next = head; // Apunta a sí mismo
        } else {
            Node<T> tail = head;
            while(tail.next != head) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.next = head;
        }
        System.out.println("✅ Elemento insertado: " + data);
    }

    @Override
    public boolean delete(T data) {
        if (isEmpty()) {
            System.out.println("⚠️ Error: La lista está vacía.");
            return false;
        }

        Node<T> current = head;
        Node<T> prev = null;

        // Buscar el nodo a eliminar
        do {
            if(current.data.equals(data)) break;
            prev = current;
            current = current.next;
        } while(current != head);

        // Si no se encuentra después de recorrer toda la lista
        if(!current.data.equals(data)) {
            System.out.println("⚠️ Error: Elemento no encontrado para eliminar.");
            return false;
        }

        // Caso 1: Es el único nodo
        if(current == head && current.next == head) {
            head = null;
        }
        // Caso 2: Es la cabeza de la lista
        else if (current == head) {
            prev = head;
            while(prev.next != head) prev = prev.next; // Encontrar el último nodo
            head = head.next;
            prev.next = head;
        }
        // Caso 3: Es un nodo intermedio o el último
        else {
             prev.next = current.next;
        }

        System.out.println("🗑️ Elemento eliminado: " + data);
        return true;
    }
    
    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("|| La lista está vacía. ||");
            return;
        }
        System.out.println("--- Lista Circular ---");
        Node<T> current = head;
        do {
            System.out.print("[ " + current.data + " ] -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(vuelve al inicio)");
        System.out.println("----------------------");
    }
}

// =================================================================================
// 5. CLASE DATATYPEEXAMPLES
// =================================================================================
/**
 * Clase con métodos estáticos para demostrar el uso de las listas
 * con diferentes tipos de datos.
 */
class DataTypeExamples {
    
    /**
     * Demuestra el uso de una lista con tipos de datos primitivos Integer.
     */
    public static void demonstratePrimitiveTypes() {
        System.out.println("\n--- 🌟 DEMOSTRACIÓN: Tipos de Datos Primitivos (Integer) 🌟 ---");
        List<Integer> numberList = new SinglyLinkedList<>();
        numberList.insert(10); // Autoboxing de int a Integer
        numberList.insert(20);
        numberList.insert(30);
        numberList.display();
        numberList.find(20);
        numberList.delete(20);
        numberList.display();
        System.out.println("--- FIN DEMOSTRACIÓN ---\n");
    }

    /**
     * Demuestra el uso de una lista con un tipo de dato complejo String..
     */
    public static void demonstrateComplexTypes() {
        System.out.println("\n--- 🌟 DEMOSTRACIÓN: Tipos de Datos Complejos (String) 🌟 ---");
        List<String> stringList = new DoublyLinkedList<>();
        stringList.insert("Hola");
        stringList.insert("Mundo");
        stringList.insert("Java");
        stringList.display();
        stringList.delete("Mundo");
        stringList.display();
        System.out.println("--- FIN DEMOSTRACIÓN ---\n");
    }
    
    /**
     * Demuestra la gestión de contactos .tipo abstracto/objeto. en una lista.
     */
    public static void demonstrateAbstractTypes() {
        System.out.println("\n--- 🌟 DEMOSTRACIÓN: Sistema de Gestión de Contactos (Objeto Contact) 🌟 ---");
        // Usamos una lista circular para la agenda de contactos.
        List<Contact> contactBook = new CircularLinkedList<>();
        
        Contact contact1 = new Contact("Ana", "555-1234", "Calle Falsa 123");
        Contact contact2 = new Contact("Luis", "555-5678", "Av. Siempre Viva 742");
        Contact contact3 = new Contact("Pedro", "555-8765", "Plaza Mayor 1");
        
        contactBook.insert(contact1);
        contactBook.insert(contact2);
        contactBook.insert(contact3);
        
        System.out.println("\nAgenda de contactos inicial:");
        contactBook.display();
        
        System.out.println("\nEliminando a Luis...");
        contactBook.delete(contact2); // Se elimina el objeto completo
        
        System.out.println("\nAgenda de contactos final:");
        contactBook.display();
        System.out.println("--- FIN DEMOSTRACIÓN ---\n");
    }
}


// =================================================================================
// 6. CLASE MAIN .Punto de entrada y menú interactivo
// =================================================================================
public class Act1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=============================================");
            System.out.println("  MENÚ PRINCIPAL - ESTRUCTURA DE DATOS");
            System.out.println("=============================================");
            System.out.println("1. Trabajar con Listas Enlazadas");
            System.out.println("2. Ver Demostraciones de Tipos de Datos");
            System.out.println("0. Salir del programa");
            System.out.print("Seleccione una opción: ");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    listMenu();
                    break;
                case 2:
                    demoMenu();
                    break;
                case 0:
                    System.out.println("👋 ¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠️ Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void listMenu() {
        System.out.println("\n--- Seleccionar Tipo de Lista ---");
        System.out.println("1. Lista Simplemente Enlazada");
        System.out.println("2. Lista Doblemente Enlazada");
        System.out.println("3. Lista Circular");
        System.out.print("Seleccione una opción: ");
        int typeChoice = getUserChoice();

        List<String> list; // Trabajaremos con Strings para el menú interactivo general

        switch (typeChoice) {
            case 1:
                list = new SinglyLinkedList<>();
                System.out.println("Ha seleccionado: Lista Simplemente Enlazada.");
                break;
            case 2:
                list = new DoublyLinkedList<>();
                System.out.println("Ha seleccionado: Lista Doblemente Enlazada.");
                break;
            case 3:
                list = new CircularLinkedList<>();
                System.out.println("Ha seleccionado: Lista Circular.");
                break;
            default:
                System.out.println("⚠️ Opción no válida. Regresando al menú principal.");
                return;
        }
        
        operationsMenu(list);
    }

    private static void operationsMenu(List<String> list) {
        while (true) {
            System.out.println("\n--- Operaciones de Lista ---");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Mostrar lista");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int choice = getUserChoice();
            scanner.nextLine(); // Consumir newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el elemento (String) a insertar: ");
                    String toInsert = scanner.nextLine();
                    list.insert(toInsert);
                    break;
                case 2:
                    System.out.print("Ingrese el elemento (String) a eliminar: ");
                    String toDelete = scanner.nextLine();
                    list.delete(toDelete);
                    break;
                case 3:
                    System.out.print("Ingrese el elemento (String) a buscar: ");
                    String toFind = scanner.nextLine();
                    list.find(toFind);
                    break;
                case 4:
                    list.display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        }
    }

    private static void demoMenu() {
        System.out.println("\n--- Menú de Demostraciones ---");
        System.out.println("1. Demo con Tipos Primitivos (Integer en Lista Simple)");
        System.out.println("2. Demo con Tipos Complejos (String en Lista Doble)");
        System.out.println("3. Demo con Sistema de Contactos (Objeto en Lista Circular)");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        
        int choice = getUserChoice();
        
        switch (choice) {
            case 1:
                DataTypeExamples.demonstratePrimitiveTypes();
                break;
            case 2:
                DataTypeExamples.demonstrateComplexTypes();
                break;
            case 3:
                DataTypeExamples.demonstrateAbstractTypes();
                break;
            case 0:
                return;
            default:
                System.out.println("⚠️ Opción no válida.");
        }
    }

    private static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar el buffer en caso de entrada no numérica
            return -1; // Retornar un valor inválido
        }
    }
}
