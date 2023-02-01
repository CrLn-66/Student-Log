package gui;

import javax.swing.table.DefaultTableModel;

public class Model extends DefaultTableModel {
    public Model(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
    public Model() {
    	super(0, 0);
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
