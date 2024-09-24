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
        setLayout(new BorderLayout());

        table = new EmployeeTable();
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.BLACK);
        scroll_pane = new JScrollPane(table);
        add(scroll_pane, BorderLayout.CENTER);
        setBackground(Color.DARK_GRAY);
        scroll_pane.setBackground(Color.DARK_GRAY);

    }


}
