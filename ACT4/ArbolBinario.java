import java.util.Scanner;

class ArbolBinario {
    private Nodo raiz;
    private Scanner scanner;

    public ArbolBinario() {
        this.raiz = null;
        this.scanner = new Scanner(System.in);
    }

    // Insertar empleado
    public void insertar(int id, String nombre, String puesto, double salario) {
        raiz = insertarRecursivo(raiz, id, nombre, puesto, salario);
    }

    private Nodo insertarRecursivo(Nodo actual, int id, String nombre, String puesto, double salario) {
        if (actual == null) {
            return new Nodo(id, nombre, puesto, salario);
        }

        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre, puesto, salario);
        } else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre, puesto, salario);
        } else {
            System.out.println("❌ ID " + id + " ya existe. No se insertó.");
            return actual;
        }

        return actual;
    }

  
    public void insertarDesdeUsuario() {
        System.out.println("\n➕ INSERTAR NUEVO EMPLEADO");
        
        int id = leerEntero("Ingrese ID del empleado: ");
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese puesto: ");
        String puesto = scanner.nextLine();
        double salario = leerDouble("Ingrese salario: ");

        insertar(id, nombre, puesto, salario);
        System.out.println("✅ Empleado agregado exitosamente!");
    }

    // Buscar empleado
    public Nodo buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Nodo buscarRecursivo(Nodo actual, int id) {
        if (actual == null || actual.id == id) {
            return actual;
        }

        if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        } else {
            return buscarRecursivo(actual.derecho, id);
        }
    }

    public void buscarDesdeUsuario() {
        System.out.println("\n🔍 BUSCAR EMPLEADO");
        int id = leerEntero("Ingrese ID a buscar: ");
        Nodo encontrado = buscar(id);
        
        if (encontrado != null) {
            System.out.println("✅ Empleado encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("❌ Empleado con ID " + id + " no encontrado.");
        }
    }

    // Eliminar empleado
    public void eliminar(int id) {
        raiz = eliminarRecursivo(raiz, id);
    }

    private Nodo eliminarRecursivo(Nodo actual, int id) {
        if (actual == null) {
            return null;
        }

        if (id == actual.id) {
            // Caso 1: Nodo sin hijos
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }
            
            // Caso 2: Nodo con un hijo
            if (actual.derecho == null) {
                return actual.izquierdo;
            }
            if (actual.izquierdo == null) {
                return actual.derecho;
            }
            
            // Caso 3: Nodo con dos hijos
            int valorMinimo = encontrarValorMinimo(actual.derecho);
            actual.id = valorMinimo;
            actual.derecho = eliminarRecursivo(actual.derecho, valorMinimo);
            return actual;
        }

        if (id < actual.id) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, id);
            return actual;
        }

        actual.derecho = eliminarRecursivo(actual.derecho, id);
        return actual;
    }

    public void eliminarDesdeUsuario() {
        System.out.println("\n🗑️ ELIMINAR EMPLEADO");
        int id = leerEntero("Ingrese ID a eliminar: ");
        Nodo encontrado = buscar(id);
        
        if (encontrado != null) {
            eliminar(id);
            System.out.println("✅ Empleado eliminado exitosamente!");
        } else {
            System.out.println("❌ Empleado con ID " + id + " no existe.");
        }
    }

    private int encontrarValorMinimo(Nodo raiz) {
        return raiz.izquierdo == null ? raiz.id : encontrarValorMinimo(raiz.izquierdo);
    }

    // Recorridos
    public void recorridoPreorden() {
        System.out.println("\n📊 RECORRIDO PREORDEN:");
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.id + " ");
            preordenRecursivo(nodo.izquierdo);
            preordenRecursivo(nodo.derecho);
        }
    }

    public void recorridoInorden() {
        System.out.println("\n📊 RECORRIDO INORDEN:");
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierdo);
            System.out.print(nodo.id + " ");
            inordenRecursivo(nodo.derecho);
        }
    }

    public void recorridoPostorden() {
        System.out.println("\n📊 RECORRIDO POSTORDEN:");
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.izquierdo);
            postordenRecursivo(nodo.derecho);
            System.out.print(nodo.id + " ");
        }
    }

    // Mostrar todos los empleados
    public void mostrarEmpleadosInorden() {
        System.out.println("\n👥 LISTA COMPLETA DE EMPLEADOS:");
        System.out.println("================================================");
        if (raiz == null) {
            System.out.println("No hay empleados registrados.");
        } else {
            mostrarEmpleadosRecursivo(raiz);
        }
        System.out.println("================================================");
    }

    private void mostrarEmpleadosRecursivo(Nodo nodo) {
        if (nodo != null) {
            mostrarEmpleadosRecursivo(nodo.izquierdo);
            System.out.println(nodo);
            mostrarEmpleadosRecursivo(nodo.derecho);
        }
    }

    // Métodos de utilidad para entrada de datos
    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Ingrese un número válido.");
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Ingrese un número válido.");
            }
        }
    }

    // Insertar datos de ejemplo
    public void insertarDatosEjemplo() {
        System.out.println("\n📋 INSERTANDO DATOS DE EJEMPLO...");
        insertar(50, "Ana García", "Gerente", 75000);
        insertar(30, "Carlos López", "Desarrollador", 55000);
        insertar(70, "María Rodríguez", "Diseñadora", 48000);
        insertar(20, "Juan Pérez", "Analista", 42000);
        insertar(40, "Laura Martínez", "QA", 45000);
        insertar(60, "Pedro Sánchez", "DevOps", 60000);
        insertar(80, "Sofía Hernández", "RH", 38000);
        insertar(10, "Miguel Castro", "Practicante", 25000);
        insertar(90, "Elena Ruiz", "Marketing", 52000);
        System.out.println("✅ Datos de ejemplo insertados correctamente!");
    }
}