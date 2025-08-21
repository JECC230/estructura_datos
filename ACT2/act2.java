import java.util.Scanner;

// Clase Nodo para la lista ligada
class Nodo {
    String data;
    Nodo next;

    public Nodo(String data) {
        this.data = data;
        this.next = null;
    }
}

// Clase Pila para el historial de comandos
class Pila {
    private Nodo top;

    public Pila() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(String x) {
        Nodo newNode = new Nodo(x);
        newNode.next = top;
        top = newNode;
        System.out.println("Comando '" + x + "' agregado al historial de comandos.");
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Historial vacío. No hay comandos para deshacer.");
            return null;
        }
        String removedData = top.data;
        top = top.next;
        return removedData;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Historial vacío. No hay comandos recientes.");
            return null;
        }
        return top.data;
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("El historial de comandos está vacío.");
            return;
        }
        System.out.println("--- Historial de Comandos ---");
        Nodo current = top;
        while (current != null) {
            System.out.println("-> " + current.data);
            current = current.next;
        }
    }
}

// Clase Cola para el planificador de procesos
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

    public void enqueue(String x) {
        Nodo newNode = new Nodo(x);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Proceso '" + x + "' agregado a la cola de ejecución.");
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("La cola de procesos está vacía. No hay procesos pendientes.");
            return null;
        }
        String removedData = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return removedData;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("La cola de procesos está vacía. No hay un siguiente proceso a ejecutar.");
            return null;
        }
        return front.data;
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("La cola de procesos está vacía.");
            return;
        }
        System.out.println("--- Procesos en Espera ---");
        Nodo current = front;
        while (current != null) {
            System.out.println("-> " + current.data);
            current = current.next;
        }
    }
}

// Clase principal con el menú de opciones
public class Act2 {
    private static Scanner scanner = new Scanner(System.in);
    private static Pila historialComandos = new Pila();
    private static Cola planificadorProcesos = new Cola();

    public static void main(String[] args) {
        System.out.println("Iniciando simulador de sistema operativo...");
        System.out.println("Pila de comandos y Cola de procesos creadas.");
        mostrarMenu();
    }

    private static void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n=== SIMULADOR DE SISTEMA OPERATIVO ===");
            System.out.println("--- Historial de Comandos (Pila) ---");
            System.out.println("1. Ejecutar un comando (ej. ls, cd, mkdir)");
            System.out.println("2. Deshacer último comando (Pop)");
            System.out.println("3. Ver último comando ejecutado (Peek)");
            System.out.println("4. Mostrar historial de comandos");
            System.out.println("5. Verificar si el historial de comandos está vacío");
            System.out.println("--- Planificador de Procesos (Cola) ---");
            System.out.println("6. Enviar proceso a la cola (Enqueue)");
            System.out.println("7. Procesar siguiente aplicación (Dequeue)");
            System.out.println("8. Ver siguiente proceso a ejecutar (Peek)");
            System.out.println("9. Mostrar cola de procesos");
            System.out.println("10. Verificar si la cola de procesos está vacía");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        ejecutarComando();
                        break;
                    case 2:
                        deshacerComando();
                        break;
                    case 3:
                        verUltimoComando();
                        break;
                    case 4:
                        mostrarHistorial();
                        break;
                    case 5:
                        verificarVaciaPila();
                        break;
                    case 6:
                        enviarProceso();
                        break;
                    case 7:
                        procesarSiguiente();
                        break;
                    case 8:
                        verSiguienteProceso();
                        break;
                    case 9:
                        mostrarCola();
                        break;
                    case 10:
                        verificarVaciaCola();
                        break;
                    case 11:
                        System.out.println("Apagando el simulador de sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
                
                // Agregar pausa después de cada operación
                if (opcion != 11) {
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine();
                }
                
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine();
                opcion = 0;
            }

        } while (opcion != 11);
    }

    private static void ejecutarComando() {
        System.out.print("Ingrese el comando a ejecutar: ");
        String comando = scanner.nextLine().trim().toLowerCase();
        if (!comando.isEmpty()) {
            historialComandos.push(comando);
            System.out.println();
            switch (comando) {
                case "ls":
                    System.out.println("Simulando 'ls'...");
                    System.out.println("  Documentos/  Descargas/  Proyectos/  README.md  main.java");
                    break;
                case "cd":
                    System.out.println("Simulando 'cd'...");
                    System.out.println("Cambiando de directorio a '/home/user/Documentos'.");
                    break;
                case "pwd":
                    System.out.println("Simulando 'pwd'...");
                    System.out.println("/home/user/Desktop/Proyectos_Java");
                    break;
                case "mkdir":
                    System.out.println("Simulando 'mkdir'...");
                    System.out.println("Creando un nuevo directorio llamado 'Carpeta_Nueva'.");
                    break;
                case "touch":
                    System.out.println("Simulando 'touch'...");
                    System.out.println("Creando un nuevo archivo llamado 'nuevo_documento.txt'.");
                    break;
                case "rm":
                    System.out.println("Simulando 'rm'...");
                    System.out.println("Eliminando el archivo 'archivo_temporal.log'.");
                    break;
                default:
                    System.out.println("Comando no reconocido. Ejecutando comando genérico.");
                    System.out.println("Ejecutando comando: " + comando);
                    break;
            }
        } else {
            System.out.println("Comando inválido. No se agregó al historial.");
        }
    }

    private static void deshacerComando() {
        String comandoDeshecho = historialComandos.pop();
        if (comandoDeshecho != null) {
            System.out.println("Comando deshecho: '" + comandoDeshecho + "'.");
        }
    }

    private static void verUltimoComando() {
        String ultimoComando = historialComandos.peek();
        if (ultimoComando != null) {
            System.out.println("Último comando ejecutado: '" + ultimoComando + "'.");
        }
    }

    private static void mostrarHistorial() {
        historialComandos.mostrar();
    }

    private static void verificarVaciaPila() {
        if (historialComandos.isEmpty()) {
            System.out.println("El historial de comandos está vacío.");
        } else {
            System.out.println("El historial de comandos NO está vacío.");
        }
    }

    private static void enviarProceso() {
        System.out.print("Ingrese el nombre de la aplicación/proceso (ej. Chrome, Word, Spotify, VSCode): ");
        String proceso = scanner.nextLine().trim();
        if (!proceso.isEmpty()) {
            planificadorProcesos.enqueue(proceso);
            System.out.println("Proceso '" + proceso + "' agregado a la cola de ejecución.");
        } else {
            System.out.println("Nombre de proceso inválido.");
        }
    }

    private static void procesarSiguiente() {
        String procesoProcesado = planificadorProcesos.dequeue();
        if (procesoProcesado != null) {
            System.out.println("Iniciando la ejecución del proceso: '" + procesoProcesado + "'...");
            System.out.println("Proceso '" + procesoProcesado + "' completado exitosamente.");
        }
    }

    private static void verSiguienteProceso() {
        String siguienteProceso = planificadorProcesos.peek();
        if (siguienteProceso != null) {
            System.out.println("Siguiente proceso en la cola: '" + siguienteProceso + "'.");
        }
    }

    private static void mostrarCola() {
        planificadorProcesos.mostrar();
    }
    
    private static void verificarVaciaCola() {
        if (planificadorProcesos.isEmpty()) {
            System.out.println("La cola de procesos está vacía.");
        } else {
            System.out.println("La cola de procesos NO está vacía.");
        }
    }
}
