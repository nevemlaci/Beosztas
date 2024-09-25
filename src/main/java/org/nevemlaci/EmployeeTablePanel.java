package org.nevemlaci;

import javax.swing.*;
import java.awt.*;

public class EmployeeTablePanel extends JPanel{
    public EmployeeTable getTable() {
        return table;
    }

    private EmployeeTable table;
    private JScrollPane scroll_pane;

    EmployeeTablePanel() {
        super();
        setLayout(new BorderLayout());

        table = new EmployeeTable();
        scroll_pane = new JScrollPane(table);
        add(scroll_pane, BorderLayout.CENTER);
    }


}
