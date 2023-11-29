package modelTest;

import javax.swing.JButton;

import view.MyJFrame;

public class ViewTest {
	
	public static void main(String[] args) {
		
		System.out.println("ya");
		
		Object[][] data = {{"p1", "p1", "p1", "p1", "p1", "p1", "p1"},{"p2", "p2", "p2", "p1", "p1", "p1", "p1"},{"p3", "p3", "p3", "p1", "p1", "p1", "p1"}};
		Object[] names = {"Estados","a", "b", "c", "d", "e", "f"};
		
		MyJFrame frame = new MyJFrame();
		frame.setVisible(true);
		
		frame.getMainPanel().showAutomatonPanel(data, names);
		
		String chain = "ababab";
		boolean accepted = false;
		String[] rute = {"b0", "b1", "b2", "b0"};
		frame.getMainPanel().showResults(chain, accepted, rute);
		
		//frame.getMainPanel().showInit();
		
		frame.revalidate();
		
	}

}
