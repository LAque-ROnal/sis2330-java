package com.tareas.views;

import com.tareas.Tarea;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route(value = "tareas", layout = MainLayout.class)
public class TareaDetalleView extends VerticalLayout implements HasUrlParameter<Long> {

    private final Paragraph contenido = new Paragraph();

    public TareaDetalleView() {
        add(contenido);
    }

    @Override
    public void setParameter(BeforeEvent evento, Long id) {
        Tarea tarea = TareasView.buscarPorId(id);
        if (tarea == null) {
            contenido.setText("No existe una tarea con id " + id);
            return;
        }
        String estado = tarea.completada() ? "completada" : "pendiente";
        contenido.setText("Tarea #" + tarea.id() + ": " + tarea.descripcion()
                + " (" + estado + ")");
    }
}