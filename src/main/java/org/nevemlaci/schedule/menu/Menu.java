package org.nevemlaci.schedule.menu;

import org.nevemlaci.schedule.app.App;

import javax.swing.*;

public class Menu extends JMenuBar {
    public Menu(App app) {
        super();
        view = new MenuView(app);
        add(file);
        add(view);
        add(theme);
    }


    MenuFile file = new MenuFile();
    MenuTheme theme = new MenuTheme();
    MenuView view;

    public MenuFile getFile() {
        return file;
    }

    public MenuTheme getTheme() {
        return theme;
    }

    public MenuView getView() {
        return view;
    }
}
