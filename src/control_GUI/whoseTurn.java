package control_GUI;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Board.Board;
import Board.Player;

public class whoseTurn extends JPanel{

	private String name;
	private JTextArea display;
	
	
	private JButton nextPlayerButton, accusationButton;
	

	public whoseTurn(){
		Board GUI_board = new Board("ClueLayout.csv", "ClueLegend.txt");
		ArrayList<Player> test = GUI_board.getPlayers();
		Random randomPlayer = new Random();
		int tempPlayer = (randomPlayer.nextInt(6));
		String player = test.get(tempPlayer).getName();
		
		
	
			nextPlayerButton = new JButton("Next Player");
			accusationButton = new JButton("Make an accusation");
			
			
			
		
		

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel label = new JLabel("Whose Turn");
		
		
		
		panel1.add(label);
	
		

		String person = player;
		name = person;


		display = new JTextArea(1,10);
		display.setEditable(false);
		display.setLineWrap(true);

		
		
		
		panel1.add(display);
		add(panel1);
		panel1.setBorder(new TitledBorder (new EtchedBorder(), "No where"));

		updateDisplay();
		
		
		
		panel2.add(nextPlayerButton);
		panel2.add(accusationButton);
		add(panel2);
		panel2.setBorder(new TitledBorder (new EtchedBorder(), "No one"));

	}

	private void updateDisplay	(){
		display.setText(name);
	}
}
