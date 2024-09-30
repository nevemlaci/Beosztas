package org.nevemlaci.schedule;

import java.awt.event.*;

public class LeftClickListener extends MouseAdapter {

    Runnable action;
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
