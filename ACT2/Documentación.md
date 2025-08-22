# Documentación Técnica: Actividad 2

Esta Actividad 2 implementa las estructuras de datos fundamentales, Pila y Cola, utilizando una Lista Ligada para simular funcionalidades clave de un sistema operativo. Esta implementación dinámica permite un uso eficiente de la memoria, ya que la capacidad no está predefinida, lo que evita desbordamientos y permite que las estructuras crezcan de manera ilimitada.

El código se divide en tres clases principales: Nodo, que es el bloque de construcción de la lista ligada; Pila y Cola, que son las estructuras de datos que manejan la lógica de comandos y procesos; y Act2, la clase principal que contiene el menú interactivo para simular la consola del sistema operativo.

## 1. Clase Nodo

La clase Nodo es la base de la implementación. Cada Nodo representa un elemento en la lista ligada y contiene dos atributos principales:

String data: Guarda el valor del elemento, que en este caso es el nombre de un comando o un proceso.

Nodo next: Un puntero que apunta al siguiente nodo en la secuencia, creando la conexión de la lista ligada.

El constructor de esta clase inicializa un nuevo nodo con los datos proporcionados y establece el puntero next como nulo.

## 2. Clase Pila

La clase Pila simula un historial de comandos de una terminal. Funciona bajo el principio LIFO (Last-In, First-Out), lo que significa que el último elemento que se agrega es el primero en ser eliminado. Esto es ideal para las funciones de "deshacer" o ver el último comando ejecutado. La pila se gestiona a través de un único puntero, top, que siempre apunta al nodo superior.

### Métodos de la Pila:

push(String x): Agrega un nuevo comando a la cima de la pila. Este método crea un nuevo nodo y lo coloca al frente de la lista ligada, actualizando el puntero top.

pop(): Elimina y devuelve el comando que se encuentra en la cima de la pila. Si la pila está vacía, muestra un mensaje de error.

peek(): Permite ver el comando más reciente sin eliminarlo de la pila.

isEmpty(): Devuelve true si la pila no contiene ningún comando; de lo contrario, false.

mostrar(): Recorre la pila desde el tope hasta el último nodo, imprimiendo el historial completo de comandos.

## 3. Clase Cola

La clase Cola simula un planificador de procesos de un sistema operativo. Opera bajo el principio FIFO (First-In, First-Out), donde el primer proceso que entra es el primero en ser ejecutado. La cola se gestiona a través de dos punteros: front, que apunta al primer proceso en la cola, y rear, que apunta al último.

### Métodos de la Cola:

enqueue(String x): Añade un nuevo proceso al final de la cola.

dequeue(): Elimina y devuelve el proceso que está en el frente de la cola, simulando su ejecución. Si la cola está vacía, muestra un mensaje de error.

peek(): Permite ver el siguiente proceso que se va a ejecutar sin sacarlo de la cola.

isEmpty(): Devuelve true si la cola no contiene ningún proceso en espera; de lo contrario, false.

mostrar(): Recorre la cola desde el frente hasta el último nodo, imprimiendo la lista de procesos en espera.

## 4. Clase Principal: Act2

La clase Act2 es el motor de la simulación. Contiene el método main y un menú interactivo que guía al usuario a través de las operaciones de la pila y la cola. Aquí es donde se crea una instancia de Pila para el historial de comandos y una instancia de Cola para el planificador de procesos.

### Funcionalidades Clave:

Menú Interactivo: El menú de consola presenta 11 opciones para que el usuario pueda interactuar con el historial de comandos y la cola de procesos.

Simulación de Comandos: Cuando el usuario elige la opción 1 y ejecuta un comando como ls, cd, pwd, mkdir, touch o rm, el programa no solo lo guarda en la pila, sino que también muestra una respuesta simulada que se asemeja a la salida real de una terminal.

Control de Errores: El programa maneja entradas no válidas y condiciones de error, como intentar realizar una operación en una pila o cola vacía, mostrando mensajes claros al usuario.

Pausa Interactiva: Se ha añadido una pausa (Presione Enter para continuar...) después de cada operación del menú para que el usuario pueda revisar el resultado antes de continuar.
