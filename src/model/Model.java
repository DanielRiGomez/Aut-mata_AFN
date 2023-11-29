package model;

public class Model {
	
	private Automaton autom;
	private AFN afn;
	
	public Model() {
		
	}
	
	public void newAFD(String[] states, char[] alphabet, String[][] transitions, String initState, String[] finalStates) {
		autom = new Automaton(states, alphabet, transitions, initState, finalStates);
	}

	public void newAFN(String[] states, char[] alphabet, String[][] transitions, String initState, String[] finalStates) {
		afn = new AFN(states, alphabet, transitions, initState, finalStates);
	}
	
	public Automaton getAutom() {
		return autom;
	}

	public AFN getAfn() {
		return afn;
	}
	
	
}
