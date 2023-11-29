package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Model;
import view.MyJFrame;

public class Controller implements ActionListener{
	
	private MyJFrame view;
	private Model model;
	
	public Controller() {
		view = new MyJFrame();
		model = new Model();
	}
	
	public void start() {
		view.addListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "moreStates":
			view.getMainPanel().getInitPanel().getStatesPanel().newState();
			break;
		case "moreCharacters":
			view.getMainPanel().getInitPanel().getAlphabetPanel().newState();
			break;
		case "initConfirm":
			String autom = String.valueOf(view.getMainPanel().getInitPanel().getType().getSelectedItem());
			if(autom.equals("AFD")){
				view.getMainPanel().showSpecificationPanelAFD(view.getMainPanel().getInitPanel().getStatesPanel().getList(), 
						view.getMainPanel().getInitPanel().getAlphabetPanel().getList());
			} else {
				view.getMainPanel().showSpecificationPanelAFN(view.getMainPanel().getInitPanel().getStatesPanel().getList(), 
						view.getMainPanel().getInitPanel().getAlphabetPanel().getList());
			}
			break;
		case "finalConfirm":
			view.getMainPanel().showAutomatonPanel(view.getMainPanel().getSpecPanel().getData(), view.getMainPanel().getSpecPanel().getColumNames());
			if(view.getMainPanel().getSpecPanel().isAFD()) {
				model.newAFD(view.getMainPanel().getSpecPanel().getStates(), view.getMainPanel().getSpecPanel().getAlphabet(), 
						view.getMainPanel().getSpecPanel().getTransitions(), view.getMainPanel().getSpecPanel().getInitState(), 
						 view.getMainPanel().getSpecPanel().getFinalStates());
			}else {
				model.newAFN(view.getMainPanel().getSpecPanel().getStates(), view.getMainPanel().getSpecPanel().getAlphabet(), 
						view.getMainPanel().getSpecPanel().getTransitions(), view.getMainPanel().getSpecPanel().getInitState(), 
						 view.getMainPanel().getSpecPanel().getFinalStates());
			}
			break;	
			
		case "evaluar":
			if(view.getMainPanel().getSpecPanel().isAFD()) {
				String[] rute = model.getAutom().registerChain(view.getMainPanel().getAutomPanel().getRecordsPanel().getInput().getText());
				view.getMainPanel().getAutomPanel().showResults(view.getMainPanel().getAutomPanel().getRecordsPanel().getInput().getText(), 
						model.getAutom().isFinal(rute[rute.length-1]), rute);
			}else {
				ArrayList<String[]> rute = model.getAfn().registerChain(view.getMainPanel().getAutomPanel().getRecordsPanel().getInput().getText());
				boolean accepted = false;
				for(int i=0; i<rute.size(); i++) {
					if(model.getAfn().isFinal(rute.get(i)[rute.get(i).length-1])){
						accepted = true;
					}
				}
				view.getMainPanel().getAutomPanel().showResults(view.getMainPanel().getAutomPanel().getRecordsPanel().getInput().getText(), 
						accepted, rute);
			}
			break;
			
		case "borrar":
			view = new MyJFrame();
			view.addListener(this);
			break;	
		default:
			break;
		}
		view.revalidate();
	}

}
