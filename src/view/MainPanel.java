package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private InitJPanel initPanel;
	private SpecificationJPanel specPanel;
	private AutomatonJPanel automPanel;
	
	private int height;
	private int width;
	
	public MainPanel(int width, int height){
		super();
		this.height = height;
		this.width = width;
		initPanel = new InitJPanel();
		specPanel = new SpecificationJPanel();
		automPanel = new AutomatonJPanel();
		init();
		showInit();
	}
	
	private void init() {
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(new BorderLayout());
	}
	
	public void showInit() {
		this.removeAll();
		initPanel = new InitJPanel(width, height);
		this.add(initPanel, BorderLayout.CENTER);
	}
	
	public void showSpecificationPanelAFD(String[] states, String[] alphabet) {
		this.removeAll();
		specPanel.showNewAFD(states, alphabet);
		this.add(specPanel, BorderLayout.CENTER);
	}
	
	public void showSpecificationPanelAFN(String[] states, String[] alphabet) {
		this.removeAll();
		specPanel.showNewAFN(states, alphabet);
		this.add(specPanel, BorderLayout.CENTER);
	}
	
	public void showAutomatonPanel(Object[][] data, Object[] names) {
		this.removeAll();
		automPanel.createAutomatonJPanel(width, height, data, names);
		this.add(automPanel);
	}
	
	public void showResults(String chain, boolean accepted, String[] rute) {
		automPanel.showResults(chain, accepted, rute);
	}
	
	public void addListener(ActionListener listener) {
		initPanel.addListener(listener);
		specPanel.addListener(listener);
		automPanel.addListener(listener);
	}

	public InitJPanel getInitPanel() {
		return initPanel;
	}

	public SpecificationJPanel getSpecPanel() {
		return specPanel;
	}

	public AutomatonJPanel getAutomPanel() {
		return automPanel;
	}
	
	
}
