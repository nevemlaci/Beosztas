package org.nevemlaci.schedule.menu;

import org.nevemlaci.schedule.app.App;
import org.nevemlaci.schedule.settings.FileSettings;
import org.nevemlaci.schedule.settings.Settings;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MenuFile extends JMenu {
    public MenuFile() {
        super("File");
        JMenuItem exit = new LeftClickableMenuItem("Exit", () -> System.exit(0));
        JMenuItem loadEmployeesFromCSV = new LeftClickableMenuItem("Load employees from CSV...",
                this::importEmployeesFromCSVButtonBehavior);

        JMenuItem loadShiftsFromCSV = new LeftClickableMenuItem("Load shifts from CSV...",
                this::importShiftsFromCSVButtonBehavior);

        JMenuItem importFromJSON = new LeftClickableMenuItem("Import from JSON...", this::importFromJSONButtonBehavior);
        JMenuItem exportToJSON = new LeftClickableMenuItem("Export to JSON...", this::exportToJSONButtonBehavior);
        add(loadEmployeesFromCSV);
        add(loadShiftsFromCSV);
        add(importFromJSON);
        add(exportToJSON);
        add(exit);
    }

    private void importEmployeesFromCSVButtonBehavior () {
        JFileChooser fileChooser = new JFileChooser(FileSettings.getLastOpenDir());
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                Settings.importEmployeesFromCSV(file.toString());
                FileSettings.setLastOpenDir(file.getParentFile());
                App.Instance().getMainPanel().getEmployee_panel().getTable().getModel().updateEmployeeNames(Settings.getEmployees());
                App.Instance().getMainPanel().getEmployee_panel().getTable().refreshCellEditor(Settings.getShifts());
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(2);
            }
        }
    }

    private void importShiftsFromCSVButtonBehavior() {
        JFileChooser fileChooser = new JFileChooser(FileSettings.getLastOpenDir());
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                Settings.importShiftsFromCSV(file.toString());
                FileSettings.setLastOpenDir(file.getParentFile());
                App.Instance().getMainPanel().getEmployee_panel().getTable().refreshCellEditor(Settings.getShifts());
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(2);
            }
        }
    }

    private void importFromJSONButtonBehavior(){
        JFileChooser fileChooser = new JFileChooser(FileSettings.getLastOpenDir());
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                Settings.importSettingsFromJSON(file.toString());
                FileSettings.setLastOpenDir(file.getParentFile());
                App.Instance().getMainPanel().getEmployee_panel().getTable().getModel().updateEmployeeNames(Settings.getEmployees());
                App.Instance().getMainPanel().getEmployee_panel().getTable().refreshCellEditor(Settings.getShifts());
            }catch (IOException e){
                e.printStackTrace();
                System.exit(2);
            }
        }
    }

    private void exportToJSONButtonBehavior(){
        JFileChooser fileChooser = new JFileChooser(FileSettings.getLastOpenDir());
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                Settings.exportSettingsToJSON(file.toString());
                FileSettings.setLastOpenDir(file.getParentFile());
            }catch (IOException e){
                e.printStackTrace();
                System.exit(2);
            }
        }
    }
}
