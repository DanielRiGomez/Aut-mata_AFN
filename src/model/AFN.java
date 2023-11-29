package model;

import java.util.ArrayList;

public class AFN {
	
	private String [] states;
	private char [] alphabet;
	private String [][] transitions;
	private String initState;
	private String [] finalStates;
	
	public AFN(String[] states, char[] alphabet, String[][] transitions, String initState, String[] finalStates) {
		this.states = states;
		this.alphabet = alphabet;
		this.transitions = transitions;
		this.initState = initState;
		this.finalStates = finalStates;
	}
	
	public ArrayList<String []> registerChain(String chain) {
		ArrayList<String []> setRute = new ArrayList<>();
		String [] rute1 = new String[chain.length()+1];
		rute1[0] = initState;
		int count = 1;
		int value = 1;
		setRute.add(rute1);
		for(int i=1; i <= chain.length(); i++) {
			value = count;
			for(int j=0; j < value; j++ ) {
					if(setRute.get(j)[i-1] != null) {
						String[] nodes = moviment(setRute.get(j)[i-1], chain.charAt(i-1)).split(","); 
						setRute.get(j)[i] = nodes[0];
						if(nodes.length > 1) {
							for(int k=1; k < nodes.length; k++){
								count++;
								String [] newRute = new String[chain.length()+1];
								for(int z = 0; z<i; z++) {
									newRute[z] = setRute.get(j)[z];
								}
								newRute[i] = nodes[k];
								setRute.add(newRute);
							}
						}
						setRute.get(j)[i] = nodes[0];
				   }	 
			}
		}
		return setRute;
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
		while(newState.equals("") && i < transitions.length) {
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
