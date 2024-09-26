package org.nevemlaci.schedule;

import javax.swing.*;
import java.awt.event.ItemEvent;

public class EmployeeTableComboBoxCellEditor extends DefaultCellEditor {
    public EmployeeTableComboBoxCellEditor(String[] options, EmployeeTable table) {
        super(new JComboBox<>(options));
        @SuppressWarnings (value="unchecked")
        JComboBox<String> comboBox = (JComboBox<String>) getComponent();
        comboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                table.setSelectedCellsValue(e.getItem());
            }
        });
    }

//    @Override
//    public boolean stopCellEditing() {
//        @SuppressWarnings (value="unchecked")
//        JComboBox<String> comboBox = (JComboBox<String>) getComponent();
//        if (comboBox.getSelectedItem() == null || comboBox.getSelectedItem().toString().isEmpty()) {
//            comboBox.setSelectedIndex(0);
//        }
//        return super.stopCellEditing();
//    }

    @Override
    public Object getCellEditorValue() {
        @SuppressWarnings (value="unchecked")
        JComboBox<String> comboBox = (JComboBox<String>) getComponent();
        return comboBox.getSelectedItem() != null ? comboBox.getSelectedItem() : "";
    }
}
