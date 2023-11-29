package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class InitJPanel extends JPanel{

	private InputSetPanel statesPanel;
	private InputSetPanel alphabetPanel;
	private JComboBox<String> type;
	private JButton confirmBut;
	
	public InitJPanel() {
		super();
	}
	
	public InitJPanel(int width, int height) {
		super();
		statesPanel = new InputSetPanel("Estados",(int)(width*0.45), (int)(height*0.8));
		alphabetPanel = new InputSetPanel("Alfabeto",(int)(width*0.45), (int)(height*0.8));
		confirmBut = new JButton("Confirmar");
		type = new JComboBox<>();
		init();
	}
	
	private void init() {
		confirmBut.setPreferredSize(new Dimension(200, 50));
		type.addItem("AFD");
		type.addItem("AFN");
		type.setSize(new Dimension(150, 40));
		this.add(statesPanel);
		this.add(alphabetPanel);
		this.add(confirmBut);
		this.add(type);
	}
	
	public void addListener(ActionListener listener) {
		statesPanel.addListener(listener, "moreStates");
		alphabetPanel.addListener(listener, "moreCharacters");
		confirmBut.setActionCommand("initConfirm");
		confirmBut.addActionListener(listener);
	}

	
	public InputSetPanel getStatesPanel() {
		return statesPanel;
	}

	public InputSetPanel getAlphabetPanel() {
		return alphabetPanel;
	}

	public JComboBox<String> getType() {
		return type;
	}
	
	
}
