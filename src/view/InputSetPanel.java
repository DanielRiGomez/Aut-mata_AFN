package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputSetPanel extends JPanel {
	
	private JLabel title;
	private ArrayList<JTextField> states;
	private JButton newBut;
	
	public InputSetPanel(String title, int width, int height) {
		super();
		this.setPreferredSize(new Dimension(width, height));
		this.title =new JLabel(title);
		newBut = new JButton("+");
		states = new ArrayList<>();
		init();
	}
	
	private void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		newBut.setPreferredSize(new Dimension(50, 20));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		newBut.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(title);
		this.add(newBut);
		newState();
	}
	
	public void newState() {
		JTextField newState = new JTextField();
		newState.setMaximumSize(new Dimension(200, 40));
		newState.setAlignmentX(Component.CENTER_ALIGNMENT);
		states.add(newState);
		this.add(newState);
	}
	
	public String[] getList() {
		String[] List = new String[states.size()];
		for(int i=0; i< states.size(); i++) {
			List[i] = states.get(i).getText();
		}
		return List;
	}
	
	public void addListener(ActionListener listener, String comand) {
		newBut.setActionCommand(comand);
		newBut.addActionListener(listener);
	}

}
