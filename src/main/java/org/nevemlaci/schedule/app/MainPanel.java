package org.nevemlaci.schedule.app;

import org.nevemlaci.schedule.table.EmployeeTablePanel;
import org.nevemlaci.schedule.util.Scaler;
import org.nevemlaci.stat.StatPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public EmployeeTablePanel getEmployee_panel() {
        return employee_panel;
    }

    final EmployeeTablePanel employee_panel = new EmployeeTablePanel();

    public MainPanel() {
        super();
        setLayout(new BorderLayout());
        JSplitPane split_pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, employee_panel, new StatPanel());
        add(split_pane);
        split_pane.setDividerLocation((int)(Scaler.SCREEN_SIZE.width * 0.7));
        split_pane.setOneTouchExpandable(true);
    }
}
