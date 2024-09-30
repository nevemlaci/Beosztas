package org.nevemlaci.schedule;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

        List<String> employees = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            employees.add("Employee " + i);
        }
        model = new EmployeeTableModel(employees, this);
        setModel(model);

        getColumnModel().getColumn(0).setResizable(true);
        for (int i = 1; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setResizable(false);
        }


        String[] options = {"", "6-18", "18-6", "SZ", "P"};
        for (int i = 1; i < getColumnCount(); i++) {
            DefaultCellEditor editor = new EmployeeTableComboBoxCellEditor(options, this);
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
