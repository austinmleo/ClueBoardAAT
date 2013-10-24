package control_GUI;


import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Board.Board;
import Board.Player;

public class whoseTurn extends JPanel{

	private String name;
	private JTextArea display;
	
	
	private JButton nextPlayerButton, accusationButton;
	

	public whoseTurn(){
		Board GUI_board = new Board("ClueLayout.csv", "ClueLegend.txt");
		ArrayList<Player> test = GUI_board.getPlayers();
		String player = test.get(0).getName();
		
		
	
			nextPlayerButton = new JButton("Next Player");
			accusationButton = new JButton("Make an accusation");
			
			
			add(nextPlayerButton);
			add(accusationButton);
		
		


		JLabel label = new JLabel("Whose Turn");

		String person = player;
		name = person;


		display = new JTextArea(1,10);
		display.setLineWrap(true);

		updateDisplay();

		add(label);
		add(display);
		
		add(nextPlayerButton);
		add(accusationButton);

	}

	private void updateDisplay	(){
		display.setText(name);
	}
}
