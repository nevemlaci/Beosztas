package org.nevemlaci;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTable extends JTable {
    TableModel model;

    EmployeeTable(){
        super();

        setGridColor(Color.BLACK);
        setShowGrid(true);


        List<String> employees = new ArrayList<String>();
        for(int i = 0; i < 50; i++){
            employees.add("Employee " + i);
        }
        model = new EmployeeTableModel(employees, this);
        setModel(model);


        String[] options = {"", "6-18", "18-6", "SZ", "P"};
        for (int i = 1; i < getColumnCount(); i++) {
            DefaultCellEditor editor = new EmployeeTableComboBoxCellEditor(options, this);
            getColumnModel().getColumn(i).setCellEditor(editor);
        }

        getColumnModel().getColumn(0).setPreferredWidth(200);

        setRowHeight(30);
        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        setColumnSelectionAllowed(true);
    }

    public void setSelectedCellsValue(Object value) {
        int[] selectedRows = getSelectedRows();
        int[] selectedColumns = getSelectedColumns();
        for (int row : selectedRows) {
            for (int column : selectedColumns) {
                if (isCellEditable(row, column)) {
                    setValueAt(value, row, column);
                }
            }
        }
    }

}
