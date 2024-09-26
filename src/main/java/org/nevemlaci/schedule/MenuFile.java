package org.nevemlaci.schedule;

import javax.swing.*;
import java.awt.event.*;

public class MenuFile extends JMenu {
    public MenuFile() {
        super("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addMouseListener(new MouseAdapter() {;
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.exit(0);
                } else {
                    return;
                }
            }
        });
        add(exit);
    }
}
