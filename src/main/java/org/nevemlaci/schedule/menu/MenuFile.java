package org.nevemlaci.schedule.menu;

import org.nevemlaci.schedule.settings.Settings;

import javax.swing.*;
import java.io.IOException;

public class MenuFile extends JMenu {
    public MenuFile() {
        super("File");
        JMenuItem exit = new LeftClickableMenuItem("Exit", () -> System.exit(0));
        JMenuItem loadEmployeesFromCSV = new LeftClickableMenuItem("Load employees from CSV",
                () -> {
                    JFileChooser fileChooser = new JFileChooser();
                    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        try {
                            Settings.ImportEmployeesFromCSV(fileChooser.getSelectedFile().toString());
                        }catch (IOException e){
                            e.printStackTrace();
                            System.exit(2);
                        }
                    }
                });
        add(exit);
        add(loadEmployeesFromCSV);
    }
}
