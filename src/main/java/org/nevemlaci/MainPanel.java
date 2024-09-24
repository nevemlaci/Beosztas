package org.nevemlaci;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public EmployeeTablePanel getEmployee_panel() {
        return employee_panel;
    }

    EmployeeTablePanel employee_panel = new EmployeeTablePanel();
    public MainPanel(){
        super();
        setLayout(new BorderLayout());
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        add(employee_panel, BorderLayout.CENTER);
    }
}
