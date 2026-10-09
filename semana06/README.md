# Semana 06 - Sistema de Estudiantes (Maven + JUnit)

## Descripcion

Sistema de estudiantes construido con Maven, con ranking por promedio y suite de pruebas JUnit 5. El proyecto esta en la carpeta `sistema-estudiantes`.

## Como ejecutar
    Desde la carpeta semana06, abre la terminal y ejecuta:
    
    cd sistema-estudiantes
    mvn test
    mvn package

Para ejecutar el programa generado:

    java -jar target/sistema-estudiantes-1.0.0.jar

## Tests incluidos

- registrarEstudianteNuevoDevuelveTrue: registrar un estudiante nuevo funciona.
- registrarCodigoDuplicadoDevuelveFalse: no permite repetir un codigo.
- buscarPorCodigoExistenteDevuelveEstudiante: encuentra a un estudiante registrado.
- buscarPorCodigoInexistenteDevuelveNull: un codigo que no existe devuelve null.
- actualizarPromedioDeEstudianteExistenteDevuelveTrue: cambia el promedio y se refleja al buscarlo.
- actualizarPromedioDeEstudianteInexistenteDevuelveFalse: actualizar un codigo inexistente devuelve false.
- eliminarEstudianteExistenteDevuelveTrueYLoQuitaDelRanking: elimina al estudiante de la busqueda y del ranking.
- listarRankingConColeccionVaciaDevuelveListaVacia: caso borde, sin estudiantes devuelve lista vacia.
- listarRankingOrdenaPorPromedioDescendente: el ranking sale de mayor a menor promedio.
- topNConNMayorAlTotalDevuelveTodosSinLanzarExcepcion: pedir mas que el total devuelve todos, sin error.

## Resultado

    Tests run: 10, Failures: 0, Errors: 0