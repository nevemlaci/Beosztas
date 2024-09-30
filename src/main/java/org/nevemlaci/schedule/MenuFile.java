package org.nevemlaci.schedule;

import javax.swing.*;
import java.awt.event.*;

public class MenuFile extends JMenu {
    public MenuFile() {
        super("File");
        JMenuItem exit = new LeftClickableMenuItem("Exit", () -> System.exit(0));
        add(exit);
    }
}
