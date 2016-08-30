# Variantes de Heapsort

#### Problema

Consideren las implementaciones de HeapSort estándar y las siguiente optimizaciones:

- HeapSort: Versión estándar, vale decir, que construye el heap a través de inserciones sucesivas y usa la extracción el mínimo en que se reemplaza el elemento al comienzo del heap por el último elemento del heap y luego lo hunde.

- Heapify de Floyd: Versión que construye el heap vía el uso de la función `PercolateDown`

- ExtractMin de Wegener: Cuando se extrae un elemento, se promueve al hijo con mejor prioridad, y luego se rellena el hueco en el nivel más bajo del heap con el último elemento del heap.

|   | Heapificación estándar | Heapificación de Floyd |
|---|---|---|
| Extracción estándar | HeapSortS | HeapSortF |
| Extracción de Wegener | HeapSortW | HeapSortFW |

Donde HeapSortS se refiere a la versión estándar, HeapSortF a la que heapifica con Floyd con extracción están0dar del mínimo, HeapSortW a la que usa la heapificación estándar y extrae mínimos con Wegener y HeapSortWF a la que heapifica con Floyd y extrae mínimos con Wegener.

#### Ejecución

Para compilar este programa, se debe hacer en la consola de Windows siguiendo la siguiente línea de comandos:

```
$ javac Tarea3.java
$ java Tarea 3 n --version x [-v] [-o filename] < entrada
```

Donde:

- `n` representa el tamaño del heap, y debe ser igual al numero de elementos en la entrada. 

  Ejemplo:

    n = 1 -> 1 kElementos = 1024 elementos
    
    n = 2 -> 2 kElementos = 2048 elementos
    
    n = 3 -> 3 kElementos = 3072 elementos
	
- `--version x` representa la version de heapsort a usar. Donde x puede vale:

    x = s -> HeapSort estándar 
    
    x = f -> HeapSort usando heapificacion de Floyd
    
    x = w -> HeapSort usando extractMin de Wegener
    
    x = wf o x = fw -> HeapSort usando heapificacion de Floyd y extractMin de Wegener
   
- `-v` es una entrada opcional e indica si quiere la compilación con depuración (paso a paso)

- `-o` filename también es opcional. filename indica el nombre del archivo a exportar la entrada ordenada. SE RECOMIENDA USARLO

- `entrada` archivo que contiene los elementos a ordenar. 



