package org.nevemlaci.schedule;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.util.List;

public class EmployeeTableComboBoxCellEditor extends DefaultCellEditor {
    public EmployeeTableComboBoxCellEditor(List<String> options, EmployeeTable table) {
        super(new JComboBox<>(options.toArray()));
        @SuppressWarnings (value="unchecked")
        JComboBox<String> comboBox = (JComboBox<String>) getComponent();
        comboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                table.setSelectedCellsValue(e.getItem());
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        @SuppressWarnings (value="unchecked")
        JComboBox<String> comboBox = (JComboBox<String>) getComponent();
        return comboBox.getSelectedItem() != null ? comboBox.getSelectedItem() : "";
    }
}
