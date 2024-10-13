package org.nevemlaci.schedule;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public EmployeeTablePanel getEmployee_panel() {
        return employee_panel;
    }

    final EmployeeTablePanel employee_panel = new EmployeeTablePanel();
    public MainPanel(){
        super();
        setLayout(new BorderLayout());
        add(employee_panel);
    }
}
