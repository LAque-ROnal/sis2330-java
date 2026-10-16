package com.tareas.views;

import com.tareas.Tarea;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route("")
public class TareasView extends VerticalLayout {

    private final List<Tarea> tareas = new ArrayList<>();
    private long siguienteId = 1;

    private final Grid<Tarea> grid = new Grid<>(Tarea.class, false);
    private final TextField descripcion = new TextField("Descripcion");
    private final Checkbox completada = new Checkbox("Completada");
    private final Binder<TareaEditable> binder = new Binder<>(TareaEditable.class);

    private Tarea seleccionActual;

    public TareasView() {
        grid.addColumn(Tarea::id).setHeader("ID");
        grid.addColumn(Tarea::descripcion).setHeader("Descripcion");
        grid.addColumn(t -> t.completada() ? "Si" : "No").setHeader("Completada");
        grid.asSingleSelect().addValueChangeListener(evento ->
                cargarEnFormulario(evento.getValue()));

        binder.forField(descripcion)
                .asRequired("La descripcion es obligatoria")
                .bind(TareaEditable::getDescripcion, TareaEditable::setDescripcion);
        binder.forField(completada)
                .bind(TareaEditable::isCompletada, TareaEditable::setCompletada);

        Button guardar = new Button("Guardar", evento -> guardar());
        Button eliminar = new Button("Eliminar", evento -> eliminar());
        Button limpiar = new Button("Nuevo", evento -> cargarEnFormulario(null));

        VerticalLayout formulario = new VerticalLayout(descripcion, completada,
                new HorizontalLayout(guardar, eliminar, limpiar));

        add(new HorizontalLayout(grid, formulario));
        refrescarGrid();
        cargarEnFormulario(null);
    }

    private void cargarEnFormulario(Tarea tarea) {
        seleccionActual = tarea;
        TareaEditable editable = new TareaEditable();
        if (tarea != null) {
            editable.setId(tarea.id());
            editable.setDescripcion(tarea.descripcion());
            editable.setCompletada(tarea.completada());
        }
        binder.readBean(editable);
    }

    private void guardar() {
        TareaEditable editable = new TareaEditable();
        if (!binder.writeBeanIfValid(editable)) {
            Notification.show("Revisa los datos del formulario");
            return;
        }

        if (seleccionActual == null) {
            tareas.add(new Tarea(siguienteId++, editable.getDescripcion(),
                    editable.isCompletada()));
        } else {
            long id = seleccionActual.id();
            tareas.removeIf(t -> t.id() == id);
            tareas.add(new Tarea(id, editable.getDescripcion(), editable.isCompletada()));
        }
        refrescarGrid();
        cargarEnFormulario(null);
    }

    private void eliminar() {
        if (seleccionActual == null) {
            Notification.show("Selecciona una tarea para eliminar");
            return;
        }
        tareas.removeIf(t -> t.id() == seleccionActual.id());
        refrescarGrid();
        cargarEnFormulario(null);
    }

    private void refrescarGrid() {
        grid.setItems(tareas);
    }
}