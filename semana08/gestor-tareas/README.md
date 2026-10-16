# Gestor de Tareas - Grid y CRUD

## Descripcion

Aplicacion web Vaadin con tabla editable (Grid), formulario validado
(Binder) y operaciones CRUD completas sobre tareas.

## Como ejecutar

Ubicarse en la carpeta del proyecto, la que contiene el pom.xml:

    cd sis2330-java/semana08/gestor-tareas
    mvn spring-boot:run
    # Abrir http://localhost:8080

Si Maven no esta instalado (por ejemplo en Windows), usar el wrapper incluido:

    .\mvnw spring-boot:run

La primera ejecucion tarda varios minutos mientras Vaadin prepara el proyecto.
Para detener el servidor, pulsar Ctrl+C.

## Estructura

- com.tareas.Tarea: record inmutable (id, descripcion, completada)
- com.tareas.views.TareaEditable: clase mutable para el Binder
- com.tareas.views.TareasView: vista con Grid y formulario

## Nota

TareaEditable existe porque Binder necesita setters y Tarea es inmutable.
Los datos se pierden al reiniciar (almacenamiento en memoria).