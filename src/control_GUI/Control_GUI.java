package control_GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



public class Control_GUI extends JFrame {
	
		public Control_GUI(){
			
			JFrame frame = new JFrame("test");
			JPanel panel = new JPanel(new GridLayout(4,4,4,4));
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			
			
			setSize(new Dimension(600,200));
			setTitle("test title");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
			
			
			whoseTurn whoseTurn = new whoseTurn();
			add(whoseTurn, BorderLayout.NORTH);
			
			button button = new button();
			button.setSize(new Dimension(50,50));
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