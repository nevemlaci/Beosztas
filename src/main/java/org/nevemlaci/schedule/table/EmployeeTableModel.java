package org.nevemlaci.schedule.table;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
    private final String[] columnNames;
    private final List<String> employees;
    private final String[][] data;

    public EmployeeTableModel(List<String> employees) {
        this.employees = employees;
        this.columnNames = new String[32];
        this.columnNames[0] = "Name";
        for (int i = 1; i <= 31; i++) {
            this.columnNames[i] = String.valueOf(i);
        }
        this.data = new String[employees.size()][32];
        for (int i = 0; i < employees.size(); i++) {
            this.data[i][0] = employees.get(i);
            for (int j = 1; j <= 31; j++) {
                this.data[i][j] = "";
            }
        }
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue.toString();
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //Name column shouldn't be editable
        return columnIndex != 0;
    }
}
