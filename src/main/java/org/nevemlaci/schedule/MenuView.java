package org.nevemlaci.schedule;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuView extends JMenu {
    public MenuView(App app) {
        super("View");
        JMenu scrollmode = new JMenu("Scroll mode");
        JMenuItem scrollmode_fit = new LeftClickableMenuItem("Fit columns", () -> app.getMainPanel().getEmployee_panel().getTable().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS));
        JMenuItem scrollmode_overflow = new LeftClickableMenuItem("Overflow columns", () -> app.getMainPanel().getEmployee_panel().getTable().setAutoResizeMode(JTable.AUTO_RESIZE_OFF));

        scrollmode.add(scrollmode_fit);
        scrollmode.add(scrollmode_overflow);

        add(scrollmode);
    }
}
