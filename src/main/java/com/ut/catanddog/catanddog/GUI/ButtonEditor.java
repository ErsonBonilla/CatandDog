package com.ut.catanddog.catanddog.GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ButtonEditor extends DefaultCellEditor {

    private String label;
    protected JButton button;
    private boolean isPushed;
    private JTable table;
    private Runnable onDelete;

    public ButtonEditor(JCheckBox checkBox, JTable table, Runnable onDelete) {
        super(checkBox);
        this.table = table;
        this.onDelete = onDelete;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        if (value == null) {
            label = "Eliminar";
        } else {
            label = value.toString();
        }
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            int row = table.convertRowIndexToModel(table.getEditingRow());
            ((DefaultTableModel) table.getModel()).removeRow(row);
            actualizarIDs();
            if (onDelete != null) {
                onDelete.run();
            }
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

    private void actualizarIDs() {
        DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloTabla.setValueAt(i + 1, i, 0);
        }
    }
}
