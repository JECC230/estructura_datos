#Documentación Técnica

1. Estructuras de Datos Implementadas

## ListaLigada

Propósito: Implementación básica de una lista ligada que servirá como base para las estructuras de Pila y Cola.
Características:
Inserción al inicio y al final
Eliminación del inicio y del final
Obtención del primer y último elemento
Verificación de estado vacío
Método para mostrar contenido
Pila

Propósito: Gestionar el historial de comandos ejecutados en el sistema operativo simulado.
Implementación: Utiliza una ListaLigada para almacenar los elementos.
Operaciones:
push(int x): Agrega un comando al historial
pop(): Deshace el último comando ejecutado
peek(): Consulta el último comando sin eliminarlo
mostrar(): Muestra todo el historial de comandos
Cola

Propósito: Administrar los programas en ejecución, procesándolos en orden de llegada.
Implementación: Utiliza una ListaLigada para almacenar los elementos.
Operaciones:
enqueue(int x): Agrega un programa a la cola de ejecución
dequeue(): Procesa el siguiente programa en la cola
peek(): Consulta el siguiente programa sin procesarlo
mostrar(): Muestra todos los programas en la cola de ejecución
2. Flujo del Programa

El programa principal (Actividad2) ofrece un menú interactivo con las siguientes opciones:

Gestión de Historial de Comandos (Pila): Permite ejecutar comandos, deshacerlos, consultar el último comando y visualizar el historial completo.
Gestión de Programas en Ejecución (Cola): Permite agregar programas a la cola, procesarlos, consultar el siguiente programa y visualizar la cola completa.
Simular Sistema Operativo: Ejecuta una simulación predefinida que demuestra el funcionamiento de ambas estructuras.
3. Casos de Uso

Para Pilas (Historial de Comandos):

Ejecutar comando: Cuando el usuario ejecuta un comando, se agrega a la pila.
Deshacer comando: Permite revertir la última acción realizada.
Consultar último comando: Muestra cuál fue el último comando ejecutado sin afectar el historial.
Para Colas (Programas en Ejecución):

Agregar programa: Cuando se inicia un programa, se agrega al final de la cola.
Procesar programa: El sistema operativo toma el primer programa de la cola para ejecutarlo.
Consultar siguiente programa: Permite ver qué programa se ejecutará a continuación.
