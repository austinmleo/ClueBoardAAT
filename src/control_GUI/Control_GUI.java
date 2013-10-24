package control_GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;



public class Control_GUI extends JFrame {
	
		public Control_GUI(){
			setSize(new Dimension(600,200));
			setTitle("test title");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			whoseTurn whoseTurn = new whoseTurn();
			add(whoseTurn, BorderLayout.NORTH);
			button button = new button();
			add(button,BorderLayout.EAST);
			
			Die dieRoll = new Die();
			add(dieRoll, BorderLayout.SOUTH);
			
			Guess guess = new Guess();
			add(guess, BorderLayout.CENTER);
			
			
			
		}

	
		public static void main(String[] args) {
			Control_GUI controler = new Control_GUI() ;
			controler.setVisible(true);
			
		}
	
}