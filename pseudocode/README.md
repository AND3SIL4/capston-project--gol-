# Algoritmo de Búsqueda Binaria

1. Inicio
2. Inicializar `low` a 0 y `high` a `n-1`
3. Mientras `low` sea menor o igual a `high`
    1. Calcular `mid` como `(low + high) / 2`
    2. Si `arr[mid]` es igual a `key`
        1. Retornar `mid`
    3. Si `arr[mid]` es menor que `key`
        1. Asignar `low` a `mid + 1`
    4. Si `arr[mid]` es mayor que `key`
        1. Asignar `high` a `mid - 1`
4. Retornar `-1`
5. Fin
