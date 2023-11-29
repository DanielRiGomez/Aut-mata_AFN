package model;

public class Automaton {
	
	private String [] states;
	private char [] alphabet;
	private String [][] transitions;
	private String initState;
	private String [] finalStates;
	
	public Automaton(String[] states, char[] alphabet, String[][] transitions, String initState, String[] finalStates) {
		this.states = states;
		this.alphabet = alphabet;
		this.transitions = transitions;
		this.initState = initState;
		this.finalStates = finalStates;
	}
	
	public String [] registerChain(String chain) {
		String[] rute = new String[chain.length()+1];
		rute[0] = initState;
		for(int i=1; i<rute.length; i++) {
			rute[i] = moviment(rute[i-1], chain.charAt(i-1));
		}
		return rute;
	}
	
	public boolean isFinal(String state) {
		boolean isFinal = false;
		for(String i: finalStates) {
			if(i.equals(state))
				isFinal = true;
		}
		return isFinal;
	}
	
	private String moviment(String state, char character) {
		String newState = "";
		int i = 0;
		while(newState.equals("")) {
			if(transitions[i][0].equals(state) && transitions[i][1].equals(String.valueOf(character))) {
				newState = transitions[i][2];
			}
			i++;
		}
		return newState;
	}
	
	public String[][] getMatriz(){
		String[][] matriz = new String[states.length][alphabet.length+1];
		for(int i=0; i<states.length; i++) {
			matriz[i][0] =  states[i];
			for(int j=1; j<alphabet.length+1; j++) {
				matriz[i][j] = transitions[j+(i*alphabet.length)-1][2];
			}
		}
		return matriz;
	}
}
