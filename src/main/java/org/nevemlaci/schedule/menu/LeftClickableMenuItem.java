package org.nevemlaci.schedule.menu;

import org.nevemlaci.schedule.util.LeftClickListener;

import javax.swing.*;

public class LeftClickableMenuItem extends JMenuItem {
    public LeftClickableMenuItem(String text, Runnable onClick) {
        super(text);
        addMouseListener(new LeftClickListener(onClick));
    }
}
