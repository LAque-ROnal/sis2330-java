package com.tareas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class TareaService {

    private static final String ARCHIVO = "tareas.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final List<Tarea> tareas = new ArrayList<>();
    private long siguienteId = 1;

    public TareaService() {
        cargar();
    }

    public synchronized List<Tarea> listar() {
        return List.copyOf(tareas);
    }

    public synchronized Tarea agregar(String descripcion) {
        Tarea nueva = new Tarea(siguienteId++, descripcion, false);
        tareas.add(nueva);
        guardar();
        return nueva;
    }

    public synchronized void actualizar(Tarea actualizada) {
        tareas.removeIf(t -> t.id() == actualizada.id());
        tareas.add(actualizada);
        guardar();
    }

    public synchronized void eliminar(long id) {
        tareas.removeIf(t -> t.id() == id);
        guardar();
    }

    public synchronized Tarea buscarPorId(long id) {
        return tareas.stream().filter(t -> t.id() == id).findFirst().orElse(null);
    }

    private void cargar() {
        Path ruta = Path.of(ARCHIVO);
        if (!Files.exists(ruta)) {
            return;
        }
        try (FileReader lector = new FileReader(ARCHIVO)) {
            Type tipoLista = new TypeToken<List<Tarea>>() {}.getType();
            List<Tarea> guardadas = gson.fromJson(lector, tipoLista);
            if (guardadas != null) {
                tareas.addAll(guardadas);
                siguienteId = tareas.stream().mapToLong(Tarea::id).max().orElse(0) + 1;
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer " + ARCHIVO, e);
        }
    }

    private void guardar() {
        try (FileWriter escritor = new FileWriter(ARCHIVO)) {
            gson.toJson(tareas, escritor);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir " + ARCHIVO, e);
        }
    }
}