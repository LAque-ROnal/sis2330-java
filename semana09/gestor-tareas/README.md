# Gestor de Tareas - Navegacion Multi-Vista

## Descripcion

Aplicacion web Vaadin con navegacion entre pantallas: listado con Grid
y vista de detalle, envueltas en un layout con menu lateral.

## Como ejecutar

Ubicarse en la carpeta del proyecto, la que contiene el pom.xml:

    cd sis2330-java/semana09/gestor-tareas
    mvn spring-boot:run
    # Abrir http://localhost:8080

Si Maven no esta instalado (por ejemplo en Windows), usar el wrapper incluido:

    .\mvnw spring-boot:run

La primera ejecucion tarda varios minutos mientras Vaadin prepara el proyecto.
Para detener el servidor, pulsar Ctrl+C.

## Rutas

- /            -> Lista de tareas (TareasView)
- /tareas/{id} -> Detalle de una tarea (TareaDetalleView)
- /acerca      -> Informacion (AcercaDeView)

## Estructura

- com.tareas.Tarea: record inmutable
- com.tareas.views.MainLayout: AppLayout con menu lateral
- com.tareas.views.TareasView: Grid con alta de tareas y enlace al detalle
- com.tareas.views.TareaDetalleView: detalle por ID (HasUrlParameter)
- com.tareas.views.AcercaDeView: vista informativa

## Nota

Los datos viven en una lista estatica en memoria y se pierden al reiniciar.