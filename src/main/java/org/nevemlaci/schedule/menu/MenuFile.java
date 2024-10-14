package org.nevemlaci.schedule.menu;

import javax.swing.*;

public class MenuFile extends JMenu {
    public MenuFile() {
        super("File");
        JMenuItem exit = new LeftClickableMenuItem("Exit", () -> System.exit(0));
        add(exit);
    }
}
