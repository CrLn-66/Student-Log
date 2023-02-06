package gui;

import javax.swing.table.DefaultTableModel;

public class Model extends DefaultTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8321653798459095649L;
	public Model(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
    public Model() {
    	super(0, 0);
    }
    @Override
    public boolean isCellEditable(int row, int column) {
    	if(column == 0) {
    		System.out.println(String.format("(%d, %d) True", row, column));
    		return true;
    		}
    	System.out.println(String.format("(%d, %d) False", row, column));
    	return false;
    }
    
}
