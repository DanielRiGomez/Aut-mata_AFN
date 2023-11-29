package view;

import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyJFrame extends JFrame {

	private MainPanel mainPanel;
	
	private final int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.8);
	private final int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.6);
	
	public MyJFrame() {
		super();
		init();
	}

	public void init() {
		this.mainPanel = new MainPanel(width, height);
	    this.setSize(width, height); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(mainPanel);
	}	
	
	public void addListener(ActionListener listener) {
		mainPanel.addListener(listener);
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}
}
