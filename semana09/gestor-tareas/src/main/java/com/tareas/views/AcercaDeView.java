package com.tareas.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "acerca", layout = MainLayout.class)
public class AcercaDeView extends VerticalLayout {
    public AcercaDeView() {
        add(new Paragraph("Gestor de Tareas con navegacion multi-vista, construido con Vaadin."));
    }
}