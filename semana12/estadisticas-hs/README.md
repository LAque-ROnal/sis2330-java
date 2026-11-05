# estadisticas-hs

Programa en Haskell (Stack) que calcula estadisticas de una lista de
estudiantes (nombre, nota): promedio, el mas alto, orden por nota y aprobados.
La logica pura esta en Estadisticas.hs y la lectura por consola en Main.hs.

## Como compilar y ejecutar

Ubicarse en la carpeta del proyecto, la que contiene package.yaml:

    cd sis2330-java/semana12/estadisticas-hs
    stack build
    stack run

Para probar las funciones puras de forma interactiva:

    stack ghci

## Modulos

- src/Estadisticas.hs: funciones puras sobre [Estudiante] (promedio, masAlto,
  ordenarPorNota, aprobados). Estudiante es (String, Double).
- app/Main.hs: lee N estudiantes por consola y muestra el reporte.

## Ejemplo de entrada y salida

Entrada (stack run): 3 estudiantes: Ana 90, Luis 45, Marta 70.

    Promedio del grupo: 68.33333333333333
    Mas alto: ("Ana",90.0)
    Ordenados por nota: [("Ana",90.0),("Marta",70.0),("Luis",45.0)]
    Aprobados: [("Ana",90.0),("Marta",70.0)]

Con 0 estudiantes muestra: No se ingresaron estudiantes.