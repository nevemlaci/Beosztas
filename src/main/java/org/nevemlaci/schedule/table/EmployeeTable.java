package org.nevemlaci.schedule.table;

import org.nevemlaci.schedule.settings.SettingsIO;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;


public class EmployeeTable extends JTable {
    final TableModel model;

    EmployeeTable(){
        super();

        getTableHeader().setReorderingAllowed(false);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        setGridColor(Color.BLACK);
        setShowGrid(true);
        setSelectionBackground(Color.GRAY);
        setSelectionForeground(Color.WHITE);

        model = new EmployeeTableModel(SettingsIO.getEmployees());
        setModel(model);

        getColumnModel().getColumn(0).setResizable(true);
        for (int i = 1; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setResizable(false);
        }

        refreshCellEditor(SettingsIO.getShifts());

        getColumnModel().getColumn(0).setPreferredWidth(200);
        for (int i = 1; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setPreferredWidth(60);
        }

        setRowHeight(35);
        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        setColumnSelectionAllowed(true);

    }

    @Override
    public EmployeeTableModel getModel() {
        return (EmployeeTableModel) model;
    }

    public void refreshCellEditor(List<String> options){
        for (int i = 1; i < getColumnCount(); i++) {
            DefaultCellEditor editor = new EmployeeTableComboBoxCellEditor(options, this);
            getColumnModel().getColumn(i).setCellEditor(editor);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setGridColor(Color.BLACK);
        setShowGrid(true);
        setSelectionBackground(Color.GRAY);
        setSelectionForeground(Color.WHITE);
    }

    /**
     * Set the value of all selected cells to the selected value
     * @param value the value to set the selected cells to
     */
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
