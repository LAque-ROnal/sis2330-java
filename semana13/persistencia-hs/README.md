# persistencia-hs

Programa en Haskell (Stack) que guarda una lista de estudiantes en un
archivo CSV y la vuelve a cargar al iniciar. Las lineas mal formadas se
reportan como avisos sin detener el programa.

## Como compilar y ejecutar

Ubicarse en la carpeta del proyecto, la que contiene package.yaml:

    cd sis2330-java/semana13/persistencia-hs
    stack build
    stack run

Al iniciar carga estudiantes.csv (si existe), pide cuantos estudiantes
nuevos agregar, los guarda y muestra el total, el promedio y los aprobados.

## Formato del archivo estudiantes.csv

Una linea por estudiante, con el formato nombre,nota:

    Ana,90.0
    Luis,45.0

El archivo esta en .gitignore porque contiene datos locales de prueba.

## Manejo de errores con Either String Estudiante

parsearLinea :: String -> Either String Estudiante es una funcion pura:
devuelve Right (nombre, nota) si la linea es valida, o Left "mensaje" si
no lo es (sin coma, nombre vacio o nota que no es un numero). Asi cada
linea mala es un dato y no una excepcion: cargarEstudiantes devuelve una
lista de Either, Main muestra un aviso por cada Left y sigue con las
lineas validas. Si el archivo no existe (primer arranque), se usa
doesFileExist y se empieza con una lista vacia.

## Modulos

- src/Modelo.hs: tipo Estudiante y calculos puros (promedio, aprobados).
- src/Persistencia.hs: parsearLinea (pura), guardarEstudiantes y
  cargarEstudiantes (IO).
- app/Main.hs: carga al iniciar, agrega estudiantes y guarda.