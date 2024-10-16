package org.nevemlaci.schedule.table;

import org.nevemlaci.schedule.app.App;
import org.nevemlaci.schedule.util.Scaler;

import javax.swing.*;
import java.awt.*;

public class EmployeeTablePanel extends JPanel{
    public EmployeeTable getTable() {
        return table;
    }

    private final EmployeeTable table;
    private final JScrollPane scroll_pane;

    public EmployeeTablePanel() {
        super();
        setLayout(new BorderLayout());
        table = new EmployeeTable();
        scroll_pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll_pane, BorderLayout.CENTER);
    }


}
