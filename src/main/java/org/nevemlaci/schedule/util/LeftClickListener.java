package org.nevemlaci.schedule.util;

import java.awt.event.*;

public class LeftClickListener extends MouseAdapter {

    final Runnable action;
    public LeftClickListener(Runnable action) {
        super();
        this.action = action;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            action.run();
        }
    }
}
