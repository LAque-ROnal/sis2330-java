package com.tareas.views;

import com.tareas.Tarea;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.util.ArrayList;
import java.util.List;

@Route(value = "", layout = MainLayout.class)
public class TareasView extends VerticalLayout {

    // Lista en memoria compartida por todas las vistas
    private static final List<Tarea> TAREAS = new ArrayList<>();
    private static long siguienteId = 1;

    private final Grid<Tarea> grid = new Grid<>(Tarea.class, false);
    private final TextField descripcion = new TextField("Descripcion");

    public TareasView() {
        grid.addColumn(Tarea::id).setHeader("ID");
        grid.addColumn(Tarea::descripcion).setHeader("Descripcion");
        grid.addColumn(t -> t.completada() ? "Si" : "No").setHeader("Completada");
        grid.addColumn(new ComponentRenderer<>(tarea ->
                new RouterLink("Ver detalle", TareaDetalleView.class, tarea.id())))
                .setHeader("Detalle");

        Button agregar = new Button("Agregar", evento -> agregar());
        add(new HorizontalLayout(descripcion, agregar), grid);
        refrescarGrid();
    }

    private void agregar() {
        String texto = descripcion.getValue().trim();
        if (texto.isEmpty()) {
            Notification.show("La descripcion es obligatoria");
            return;
        }
        TAREAS.add(new Tarea(siguienteId++, texto, false));
        descripcion.clear();
        refrescarGrid();
    }

    private void refrescarGrid() {
        grid.setItems(TAREAS);
    }

    public static Tarea buscarPorId(long id) {
        return TAREAS.stream()
                .filter(t -> t.id() == id)
                .findFirst()
                .orElse(null);
    }
}