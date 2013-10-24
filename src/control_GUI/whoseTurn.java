package control_GUI;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class whoseTurn extends JPanel{
	
	private String name;
	private JTextArea display;
	
	public whoseTurn(){
		
		
		
		
	JLabel label = new JLabel("Whose Turn");
	add(label);
	
	String person = "todd";
	name = person;
	
	display = new JTextArea(1,10);
	display.setLineWrap(true);
	updateDisplay();
	add(display);
	
	}
	
	private void updateDisplay	(){
		display.setText(name);
	}
}
