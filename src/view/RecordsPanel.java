package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class RecordsPanel extends JPanel{
	
	private JTable automaton;
	private JLabel text;
	private JTextField input;
	private JButton delete;
	private JButton confirm;
	
	public RecordsPanel() {
		super();
		confirm = new JButton("Evaluar");
		delete = new JButton("Borrar");
	}
	
	public void createRecordsPanel(int width, int height, Object[][] data, Object[] names) {
		this.setPreferredSize(new Dimension(width, height)); 
		automaton = new JTable(data, names);
		text = new JLabel("Cadena");
		input = new JTextField();
		init();
	}
	
	private void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		automaton.setAlignmentX(Component.CENTER_ALIGNMENT);
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		input.setAlignmentX(Component.CENTER_ALIGNMENT);
		delete.setAlignmentX(Component.CENTER_ALIGNMENT);
		confirm.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		input.setMaximumSize(new Dimension(400, 20));
		
		JScrollPane jsp = new JScrollPane(automaton);
		this.add(jsp);
		this.add(text);
		this.add(input);
		this.add(delete);
		this.add(confirm);
	}
	
	public void addListener(ActionListener listener) {
		confirm.setActionCommand("evaluar");
		delete.setActionCommand("borrar");
		delete.addActionListener(listener);
		confirm.addActionListener(listener);
	}

	public JTextField getInput() {
		return input;
	}

	
}
