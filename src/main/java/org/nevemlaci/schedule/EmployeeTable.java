package org.nevemlaci.schedule;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmployeeTable extends JTable {
    TableModel model;

    EmployeeTable(){
        super();

        getTableHeader().setReorderingAllowed(false);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        setGridColor(Color.BLACK);
        setShowGrid(true);
        setSelectionBackground(Color.GRAY);
        setSelectionForeground(Color.WHITE);

        model = new EmployeeTableModel(Settings.getEmployees());
        setModel(model);

        getColumnModel().getColumn(0).setResizable(true);
        for (int i = 1; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setResizable(false);
        }


        for (int i = 1; i < getColumnCount(); i++) {
            DefaultCellEditor editor = new EmployeeTableComboBoxCellEditor(Settings.getShifts(), this);
            getColumnModel().getColumn(i).setCellEditor(editor);
        }
        for(int i = 0; i < getRowCount(); i++){
            String value = (String) getValueAt(i, 1);

        }

        getColumnModel().getColumn(0).setPreferredWidth(200);
        for (int i = 1; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setPreferredWidth(60);
        }

        setRowHeight(35);
        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        setColumnSelectionAllowed(true);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setGridColor(Color.BLACK);
        setShowGrid(true);
        setSelectionBackground(Color.GRAY);
        setSelectionForeground(Color.WHITE);
    }


//    @Override
//    public void columnMarginChanged(ChangeEvent e) {
//        super.columnMarginChanged(e);
//        if(getAutoResizeMode() == AUTO_RESIZE_ALL_COLUMNS){
//            int sum_width = 0;
//            for (int i = 1; i < getColumnCount(); i++) {
//                sum_width += getColumnModel().getColumn(i).getWidth();
//            }
//            for (int i = 1; i < getColumnCount(); i++) {
//                getColumnModel().getColumn(i).setPreferredWidth(sum_width / getColumnCount());
//            }
//        }
//    }
    


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
