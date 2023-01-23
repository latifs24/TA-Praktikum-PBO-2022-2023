package View;

import javax.swing.*;
import javax.swing.table.*;
public class TabelKamar extends JTable {

    public TabelKamar(TableModel model) {
        super(model);
        setDefaultRenderer(Object.class, new SquareCellRenderer());
    }

    private static class SquareCellRenderer extends DefaultTableCellRenderer {
        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setPreferredSize(new java.awt.Dimension(getWidth(), getWidth()));
            return this;
        }
    }
}