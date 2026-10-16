package com.tareas.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        DrawerToggle toggle = new DrawerToggle();
        H1 titulo = new H1("Gestor de Tareas");

        RouterLink linkLista = new RouterLink("Lista de Tareas", TareasView.class);
        RouterLink linkAcerca = new RouterLink("Acerca de", AcercaDeView.class);

        VerticalLayout menu = new VerticalLayout(linkLista, linkAcerca);

        addToNavbar(toggle, titulo);
        addToDrawer(menu);
    }
}