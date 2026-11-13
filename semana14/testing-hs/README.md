# testing-hs

Proyecto en Haskell (Stack) con funciones puras sobre notas de estudiantes,
una suite de tests automatizados (HUnit y QuickCheck) y un modulo basado
en State para contar consultas sin variables mutables.

## Estructura

- src/Notas.hs: funciones puras (promedio, masAlto, ordenarPorNota,
  aprobados) y parsearLinea, que devuelve Either String Estudiante.
- src/Historial.hs: contador de consultas por nombre con State (Map String Int).
- test/Spec.hs: 6 tests HUnit y 1 propiedad QuickCheck sobre Notas.
- app/Main.hs: procesa lineas "nombre,nota", muestra el reporte y usa
  Historial para contar consultas.

## Como correr

    cd sis2330-java/semana14/testing-hs
    stack build && stack test && stack run

(En Windows PowerShell antiguo, ejecutar los tres comandos por separado.)

## Que aprendi

- Las funciones puras se prueban sin preparar nada: entrada conocida,
  salida esperada.
- HUnit prueba casos concretos y QuickCheck prueba propiedades con
  entradas aleatorias; se complementan.
- State permite llevar un contador sin mutar variables: cada paso recibe
  un estado y devuelve uno nuevo, y se ejecuta con execState.