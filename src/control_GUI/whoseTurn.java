package control_GUI;


import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Board.Board;
import Board.Player;

public class whoseTurn extends JPanel{

	private String name;
	private JTextArea display;

	public whoseTurn(){
		Board GUI_board = new Board("ClueLayout.csv", "ClueLegend.txt");
		ArrayList<Player> test = GUI_board.getPlayers();
		String player = test.get(0).getName();


		JLabel label = new JLabel("Whose Turn");

		String person = player;
		name = person;


		display = new JTextArea(1,10);
		display.setLineWrap(true);

		updateDisplay();

		add(label);
		add(display);

	}

	private void updateDisplay	(){
		display.setText(name);
	}
}
