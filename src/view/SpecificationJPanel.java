package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SpecificationJPanel extends JPanel{
	
	private JTable table;
	private JComboBox<String> comboBox;
	private JButton button;
	private String[] states;
	private String[] alphabet;
	private boolean isAFD;
	
	public SpecificationJPanel() {
		super();
		button = new JButton("Confirmar");
		init();
	}
	
	public void showNewAFD(String[] states, String[] alphabet) {
		DefaultTableModel tableModel = new DefaultTableModel();
		this.states = states;
		this.alphabet = alphabet;
		
		isAFD = true;
		tableModel.addColumn("Finales");
		tableModel.addColumn("Estados");
		
		JComboBox<String> combo = new JComboBox<>();
		comboBox = new JComboBox<>();
		for(int i=0; i<states.length; i++) {
			tableModel.addRow(new Object[] {false, states[i]});
			combo.addItem(states[i]);
			comboBox.addItem(states[i]);
		}
		
		table = new JTable(tableModel);

		for(int i=0; i< alphabet.length; i++) {
			tableModel.addColumn(alphabet[i]);
		}

		table.getColumn("Finales").setCellEditor(new DefaultCellEditor(new JCheckBox()));
		for(int i=0; i< alphabet.length; i++) {
			table.getColumn(alphabet[i]).setCellEditor(new DefaultCellEditor(combo));
		}
		
		 JScrollPane jsp = new JScrollPane(table);
		 this.add(jsp);
		 
		 comboBox.setMaximumSize(new Dimension(200, 50));
		 this.add(comboBox);
		 this.add(button);
		
	}
	
	public void showNewAFN(String[] states, String[] alphabet) {
		DefaultTableModel tableModel = new DefaultTableModel();
		
		isAFD = false;
		this.states = states;
		this.alphabet = alphabet;
		
		tableModel.addColumn("Finales");
		tableModel.addColumn("Estados");
		
		JComboBox<String> combo = new JComboBox<>();
		comboBox = new JComboBox<>();
		for(int i=0; i<states.length; i++) {
			tableModel.addRow(new Object[] {false, states[i]});
			combo.addItem(states[i]);
			comboBox.addItem(states[i]);
		}
		
		table = new JTable(tableModel);

		for(int i=0; i< alphabet.length; i++) {
			tableModel.addColumn(alphabet[i]);
		}

		table.getColumn("Finales").setCellEditor(new DefaultCellEditor(new JCheckBox()));
		for(int i=0; i< alphabet.length; i++) {
			table.getColumn(alphabet[i]).setCellEditor(new DefaultCellEditor(new JTextField()));
		}
		
		 JScrollPane jsp = new JScrollPane(table);
		 this.add(jsp);
		 
		 comboBox.setMaximumSize(new Dimension(200, 50));
		 this.add(comboBox);
		 this.add(button);
	}
	
	public String[][] getTransitions() {
		String [][] transitions = new String[states.length*alphabet.length][3];
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		for(int i=0; i< states.length; i++) {
			for(int j=0; j< alphabet.length; j++) {
				transitions[(i*alphabet.length)+j][0] = states[i];
				transitions[(i*alphabet.length)+j][1] = alphabet[j];
				transitions[(i*alphabet.length)+j][2] = String.valueOf(modelo.getValueAt(i, j+2));
			}
		}
		return transitions;
	} 

	public String getInitState() {
		return String.valueOf(comboBox.getSelectedItem());
	}
	
	private void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		button.setPreferredSize(new Dimension(200, 50));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	
	public void addListener(ActionListener listener) {
		button.setActionCommand("finalConfirm");
		button.addActionListener(listener);
	}
	
	
	public Object[][] getData(){
		Object[][] data = new Object[states.length][2+alphabet.length];
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		for(int i=0; i< states.length; i++) {
			for(int j=0; j< alphabet.length+2; j++) {
				data[i][j] = String.valueOf(modelo.getValueAt(i, j));
			}
		}
		return data;
	}
	
	public Object[] getColumNames() {
		Object[] names= new String[2+alphabet.length];
		names[0] = "Finales";
		names[1] = "Estados";
		for(int i=0; i < alphabet.length; i++) {
			names[i+2] = alphabet[i];
		}
		return names;
		
	}

	public boolean isAFD() {
		return isAFD;
	}

	public String[] getStates() {
		return states;
	}

	public char[] getAlphabet() {
		char[] list = new char[alphabet.length];
		for(int i=0; i<alphabet.length; i++)
			list[i] = alphabet[i].charAt(0);
		return list;
	}

	public String[] getFinalStates() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		ArrayList<String> finals = new ArrayList<>();
		for(int j=0; j< states.length; j++) {
			if(String.valueOf(modelo.getValueAt(j, 0)).equals("true")) {
				finals.add(String.valueOf(modelo.getValueAt(j, 1)));
			}
		}
		String[] list = new String[finals.size()];
		for(int i=0; i<finals.size(); i++) {
			list[i] = finals.get(i);
		}
		
		return list;
	}
	
	
}
