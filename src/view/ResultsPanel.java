package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultsPanel extends JPanel {
	
	private JLabel chainJL;
	private JLabel acceptedJL;
	private JLabel ruteJL;
	
	public ResultsPanel() {
		super();
	}

	public ResultsPanel(int width, int height) {
		super();
		this.setPreferredSize(new Dimension(width, height)); 
	}
	
	public void showResults(String chain, boolean accepted, String[] rute) {
		this.removeAll();
		this.repaint();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		chainJL = new JLabel("Cadena: "+chain);
		chainJL.setAlignmentX(Component.CENTER_ALIGNMENT);
		chainJL.setFont(new Font("Arial", Font.PLAIN, 50));
		
		acceptedJL = new JLabel();
		acceptedJL.setAlignmentX(Component.CENTER_ALIGNMENT);
		acceptedJL.setFont(new Font("Algerian", Font.PLAIN, 40));
		if(accepted) {
			acceptedJL.setText("Aceptado");
			acceptedJL.setForeground(Color.GREEN);
		}else {
			acceptedJL.setText("Rechazado");
			acceptedJL.setForeground(Color.RED);
		}
		
		
		this.add(chainJL);
		this.add(acceptedJL);
		
		String ruteStates = "Ruta: ";
		for(int i=0; i<rute.length; i++) {
			ruteStates = ruteStates + rute[i]+" - ";
		}
		
		ruteJL = new JLabel(ruteStates);
		ruteJL.setAlignmentX(Component.CENTER_ALIGNMENT);
		ruteJL.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		this.add(ruteJL);
	}
	
	public void showResults(String chain, boolean accepted, ArrayList<String[]> rute) {
		this.removeAll();
		this.repaint();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		chainJL = new JLabel("Cadena: "+chain);
		chainJL.setAlignmentX(Component.CENTER_ALIGNMENT);
		chainJL.setFont(new Font("Arial", Font.PLAIN, 50));
		
		acceptedJL = new JLabel();
		acceptedJL.setAlignmentX(Component.CENTER_ALIGNMENT);
		acceptedJL.setFont(new Font("Algerian", Font.PLAIN, 40));
		if(accepted) {
			acceptedJL.setText("Aceptado");
			acceptedJL.setForeground(Color.GREEN);
		}else {
			acceptedJL.setText("Rechazado");
			acceptedJL.setForeground(Color.RED);
		}
		
		
		this.add(chainJL);
		this.add(acceptedJL);
		
		for(int i=0; i<rute.size(); i++) {
			String ruteStates = "Ruta "+i+" : ";
			for(int j=0; j<rute.get(0).length; j++) {
				ruteStates = ruteStates + rute.get(i)[j]+" - ";
			}
			JLabel rut = new JLabel(ruteStates);
			rut.setAlignmentX(Component.CENTER_ALIGNMENT);
			rut.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
			this.add(rut);
		}
		
	}
	
	
}
