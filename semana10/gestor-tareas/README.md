# Gestor de Tareas - Spring Boot + Vaadin + Persistencia

## Descripcion

Aplicacion web completa con Vaadin como interfaz, Spring Boot como backend,
un servicio de negocio inyectado (TareaService) y persistencia JSON en tareas.json.

## Como ejecutar

Ubicarse en la carpeta del proyecto, la que contiene el pom.xml:

    cd sis2330-java/semana10/gestor-tareas
    mvn spring-boot:run
    # Abrir http://localhost:8080

Si Maven no esta instalado (por ejemplo en Windows), usar el wrapper incluido:

    .\mvnw spring-boot:run

Para detener el servidor, pulsar Ctrl+C.

## Empaquetar

    mvn clean package
    java -jar target/gestor-tareas-0.0.1-SNAPSHOT.jar

Ejecutar siempre desde la carpeta gestor-tareas, porque tareas.json se
crea en el directorio desde donde se ejecuta el comando.

## Persistencia

Los datos se guardan en tareas.json (directorio de ejecucion).
Las tareas sobreviven a reinicios del servidor. El archivo esta en
.gitignore porque contiene datos de prueba.

## Estructura

- TareaService: logica de negocio + persistencia JSON (Gson)
- TareasView: Grid con CRUD
- TareaDetalleView: detalle por ID
- TareaEditable: clase mutable para el Binder
- MainLayout: AppLayout con menu lateral