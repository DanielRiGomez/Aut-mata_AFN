package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AutomatonJPanel extends JPanel{

	private ResultsPanel resultsPanel;
	private RecordsPanel recordsPanel;
	
	public AutomatonJPanel() {
		super();
		resultsPanel = new ResultsPanel();
		recordsPanel = new RecordsPanel();
	}
	
	public void createAutomatonJPanel(int width, int height, Object[][] data, Object[] names) {
		this.resultsPanel.setSize((int)(width*0.9), (int)(height*0.4));
		this.recordsPanel.createRecordsPanel((int)(width*0.9), (int)(height*0.4), data, names);
		init();
	}
	
	private void init() {
		this.setLayout(new GridLayout(2, 1));
		this.add(recordsPanel);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(resultsPanel);
		this.add(scroll);
	}
	
	public void showResults(String chain, boolean accepted, String[] rute) {
		resultsPanel.showResults(chain, accepted, rute);
	}
	
	public void showResults(String chain, boolean accepted, ArrayList<String[]> rute) {
		resultsPanel.showResults(chain, accepted, rute);
	}
	
	public void addListener(ActionListener listener) {
		recordsPanel.addListener(listener);
	}

	public ResultsPanel getResultsPanel() {
		return resultsPanel;
	}

	public RecordsPanel getRecordsPanel() {
		return recordsPanel;
	}
	
	
}
