class Nodo {
    int id;
    String nombre;
    String puesto;
    double salario;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public String toString() {
        return String.format("ID: %-4d | Nombre: %-15s | Puesto: %-12s | Salario: $%,.2f", 
                           id, nombre, puesto, salario);
    }
}
