package org.nevemlaci.schedule;

import javax.swing.*;

public class Menu extends JMenuBar {
    public Menu() {
        super();
        MenuFile file = new MenuFile();
        MenuTheme theme = new MenuTheme();
        add(file);
        add(theme);
    }
}
