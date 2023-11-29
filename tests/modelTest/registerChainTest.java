package modelTest;

import java.util.ArrayList;

import model.Automaton;
import model.Model;

public class registerChainTest {
	
	public static void main(String[] args) {
		
		String [] states = {"q0", "q1"};
		char [] alphabet = {'a', 'b'};
		String [][] transitions = {{"q0", "a", "q0,q1"},{"q0", "b", "q0"},{"q1", "a", ""},{"q1", "b", "q0,q1"}};
	    String initState = "q0";
		String [] finalStates = {"q1"};

		Model model = new Model();
		model.newAFN(states, alphabet, transitions, initState, finalStates);
		
		ArrayList<String []> list = model.getAfn().registerChain("aabba");
				/*
		String[][] matriz = model.getAutom().getMatriz();
		*/
		System.out.println("ya");
	}
}
