# Semana 07 - Gestor de Tareas (Vaadin)

## Descripcion

Aplicacion web hecha con Vaadin y Spring Boot. Permite escribir la descripcion
de una tarea, agregarla a una lista en memoria y verla como texto plano.
Si el campo esta vacio al pulsar "Agregar", muestra un aviso y no agrega nada.

## Requisitos

- Java (el proyecto compila con la version instalada)
- Conexion a Internet la primera vez, para descargar dependencias

## Como ejecutar

Ubicarse en la carpeta del proyecto, la que contiene el pom.xml:

    cd sis2330-java/semana07/gestor-tareas
    mvn spring-boot:run
    # Abrir http://localhost:8080

Si Maven no esta instalado (por ejemplo en Windows), usar el wrapper incluido:

    .\mvnw spring-boot:run

La primera ejecucion tarda varios minutos mientras Vaadin prepara el proyecto.
Para detener el servidor, pulsar Ctrl+C.

## Estructura

- com.tareas.Tarea: record con id, descripcion, completada
- com.tareas.views.TareasView: vista principal con @Route("")

## Que se aprendio

Vistas Vaadin con @Route, componentes (TextField, Button, Div, Notification),
manejo de eventos con lambdas y el uso de un record como modelo de datos.

## Nota

Las tareas se pierden al reiniciar (almacenamiento en memoria).