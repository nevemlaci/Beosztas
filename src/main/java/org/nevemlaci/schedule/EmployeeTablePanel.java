package org.nevemlaci.schedule;

import javax.swing.*;
import java.awt.*;

public class EmployeeTablePanel extends JPanel{
    public EmployeeTable getTable() {
        return table;
    }

    private final EmployeeTable table;
    private final JScrollPane scroll_pane;

    EmployeeTablePanel() {
        super();
        setLayout(new BorderLayout());

        table = new EmployeeTable();
        scroll_pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll_pane, BorderLayout.CENTER);
    }


}
