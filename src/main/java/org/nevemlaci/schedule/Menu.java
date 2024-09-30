package org.nevemlaci.schedule;

import javax.swing.*;

public class Menu extends JMenuBar {
    public Menu(App app) {
        super();
        MenuFile file = new MenuFile();
        MenuTheme theme = new MenuTheme();
        MenuView view = new MenuView(app);
        add(file);
        add(view);
        add(theme);
    }
}
