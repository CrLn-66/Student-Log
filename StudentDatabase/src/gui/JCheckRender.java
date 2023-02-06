package gui;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class JCheckRender extends DefaultTableCellRenderer  {
	public JCheckRender() {
	}
	 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	      JCheckBox checkBox = new JCheckBox();
	      checkBox.setSelected((Boolean) value);
	      return checkBox;
	    }
	 }