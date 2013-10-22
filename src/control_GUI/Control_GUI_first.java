package control_GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Control_GUI_first extends JFrame {

	private JTextField Whose_Turn;
	
	private Control_GUI_first(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		setSize(600, 200);	
		createLayout();	
	}
	

	private void createLayout(){
		JLabel nameLabel = new JLabel("Whose Turn?");
		Whose_Turn = new JTextField(20);
	add(nameLabel, BorderLayout.NORTH);
	add(Whose_Turn, BorderLayout.CENTER);
	JButton nameButton = new JButton("OK");
	add(nameButton, BorderLayout.SOUTH);
	//nameButton.addActionListener(new ButtonListener());
	}


	public static void main(String[] args){

	Control_GUI_first controler = new Control_GUI_first();
	controler.setVisible(true);
			
			
	}
}