# Semana 05 - Sistema de Estudiantes Avanzado

## Descripcion

Sistema de consola que registra estudiantes y mantiene un ranking automatico por promedio.

## Por que estas estructuras

- `HashMap<String, Estudiante>`: busqueda O(1) por codigo. Sin el, buscar un estudiante obligaria a recorrer toda la lista.
- `TreeSet<Estudiante>`: el ranking siempre esta ordenado por promedio, sin volver a ordenar manualmente en cada consulta.
- `ArrayList<Estudiante>` en `topN` y `listarRanking`: nunca se expone el TreeSet interno, asi el que llama no puede modificarlo.

## Como ejecutar

    cd src
    javac modelo/Estudiante.java servicio/SistemaEstudiantes.java Principal.java
    java Principal

## Ejemplo de salida

    1.Registrar 2.Buscar 3.Actualizar 4.Ranking 5.Top N 6.Salir 7.Eliminar
    Opcion: 4
    #002 Luis (92,0)
    #001 Ana (85,5)
    #003 Marta (78,0)