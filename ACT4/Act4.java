import java.util.Scanner;

public class Act4 {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        System.out.println("🌳 SISTEMA DE GESTIÓN DE EMPLEADOS CON ÁRBOL BINARIO");
        System.out.println("===================================================");

        while (ejecutando) {
            mostrarMenu();
            int opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1:
                    arbol.insertarDesdeUsuario();
                    break;
                case 2:
                    arbol.buscarDesdeUsuario();
                    break;
                case 3:
                    arbol.eliminarDesdeUsuario();
                    break;
                case 4:
                    arbol.mostrarEmpleadosInorden();
                    break;
                case 5:
                    arbol.recorridoPreorden();
                    arbol.recorridoInorden();
                    arbol.recorridoPostorden();
                    break;
                case 6:
                    arbol.insertarDatosEjemplo();
                    break;
                case 7:
                    demostrarEficiencia();
                    break;
                case 8:
                    System.out.println("\n👋 ¡Hasta luego!");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("❌ Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n📋 MENÚ PRINCIPAL:");
        System.out.println("1. ➕ Insertar nuevo empleado");
        System.out.println("2. 🔍 Buscar empleado por ID");
        System.out.println("3. 🗑️ Eliminar empleado");
        System.out.println("4. 👥 Mostrar todos los empleados");
        System.out.println("5. 📊 Mostrar recorridos del árbol");
        System.out.println("6. 📋 Insertar datos de ejemplo");
        System.out.println("7. ⚡ Demostrar eficiencia vs búsqueda secuencial");
        System.out.println("8. ❌ Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void demostrarEficiencia() {
        System.out.println("\n⚡ DEMOSTRACIÓN DE EFICIENCIA");
        System.out.println("Creando árbol con 1000 empleados...");
        
        ArbolBinario arbolGrande = new ArbolBinario();
        int[] ids = new int[1000];
        java.util.Random random = new java.util.Random();
        
        for (int i = 0; i < 1000; i++) {
            int id = random.nextInt(10000);
            ids[i] = id;
            arbolGrande.insertar(id, "Empleado" + i, "Puesto" + i, 30000 + random.nextInt(50000));
        }

        // Medir tiempo de búsqueda en árbol
        long inicioArbol = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int idBuscado = ids[random.nextInt(1000)];
            arbolGrande.buscar(idBuscado);
        }
        long finArbol = System.nanoTime();

        // Medir tiempo de búsqueda secuencial
        long inicioSecuencial = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int idBuscado = ids[random.nextInt(1000)];
            for (int j = 0; j < 1000; j++) {
                if (ids[j] == idBuscado) {
                    break;
                }
            }
        }
        long finSecuencial = System.nanoTime();

        System.out.println("⏱️ Tiempo árbol binario: " + (finArbol - inicioArbol) / 1000000.0 + " ms");
        System.out.println("⏱️ Tiempo búsqueda secuencial: " + (finSecuencial - inicioSecuencial) / 1000000.0 + " ms");
        double ratio = (double)(finSecuencial - inicioSecuencial) / (finArbol - inicioArbol);
        System.out.printf("🚀 El árbol binario es %.1f veces más rápido!%n", ratio);
    }
}