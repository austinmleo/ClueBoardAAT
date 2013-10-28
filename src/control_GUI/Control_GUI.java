package control_GUI;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;









public class Control_GUI extends JFrame {

	// whoseTurnPanel variables
	private String playersName;
	private JTextArea displayPlayer;

	// buttonPanel variables
	private JButton nextPlayerButton, accusationButton;

	//diePanel variables
	private String dieRoll;
	private JTextArea die;

	//guessPanel variables
	private String makeAGuess;
	private JTextArea inputGuess;

	//resultPanel variables
	private String response;
	private JTextArea responseArea;
	
	
	
		
	
	

	public  Control_GUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Clue GUI");
		setSize(800, 200);	
		Controler();
}
	
	
		public void Controler(){

		final JPanel test = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,3);
		test.setLayout(experimentLayout);
		
		// Whose Turn Label and Current Players Turn

		JPanel whoseTurnPanel = new JPanel();
		JLabel turnLabel = new JLabel("Whose Turn");
		playersName = "Todd";
		displayPlayer = new JTextArea(1,10);

		displayPlayer.setBackground(Color.lightGray);
		displayPlayer.setEditable(false);
		displayPlayer.setLineWrap(true);
		whoseTurnPanel.add(turnLabel);
		whoseTurnPanel.add(displayPlayer);
		//add(whoseTurnPanel, BorderLayout.NORTH);


		// Buttons

		JPanel buttonPanel = new JPanel();
		nextPlayerButton = new JButton("Next Player");
		buttonPanel.add(nextPlayerButton);
		//add(buttonPanel, BorderLayout.SOUTH);

		JPanel buttonPanel2 = new JPanel();
		accusationButton = new JButton("Make and accusation");
		buttonPanel2.add(accusationButton);


		// Die

		JPanel diePanel = new JPanel();
		JLabel dieLabel = new JLabel("Die");
		die = new JTextArea(1,10);
		die.setBackground(Color.lightGray);
		die.setEditable(false);
		die.setLineWrap(true);
		Random randomDie = new Random();
		int tempDie = (randomDie.nextInt(5) + 1);
		dieRoll = Integer.toString(tempDie);
		diePanel.add(dieLabel);
		diePanel.add(die);
		//add(diePanel, BorderLayout.WEST);
		
		diePanel.setBorder(new TitledBorder (new EtchedBorder(), "Die"));
	


		// Guess

		JPanel guessPanel = new JPanel();
		JLabel guessLabel = new JLabel("Guess");
		makeAGuess = "Plasma Gun";
		inputGuess = new JTextArea(1,10);
		inputGuess.setBackground(Color.lightGray);
		inputGuess.setEditable(false);
		inputGuess.setLineWrap(true);
		guessPanel.add(guessLabel);
		guessPanel.add(inputGuess);
		//add(guessPanel, BorderLayout.CENTER);
		guessPanel.setBorder(new TitledBorder (new EtchedBorder(), "Guess"));


		// Guess Result
		JPanel resultPanel = new JPanel();
		JLabel resultLabel = new JLabel("Response");
		response = "I have nothing";
		responseArea = new JTextArea(1,10);
		responseArea.setBackground(Color.lightGray);
		responseArea.setEditable(false);
		responseArea.setLineWrap(true);
		resultPanel.add(resultLabel);
		resultPanel.add(responseArea);
		//add(resultPanel, BorderLayout.EAST);
		resultPanel.setBorder(new TitledBorder (new EtchedBorder(), "Guess Reuslt"));


		// Allows text to be updated and dispalyed
		updateDisplay();

		// add panels to the grid
		test.add(whoseTurnPanel);
		test.add(buttonPanel);
		test.add(buttonPanel2);
		test.add(diePanel);
		test.add(guessPanel);
		test.add(resultPanel);


		add(test, BorderLayout.SOUTH);
		//add(new JSeparator(), BorderLayout.CENTER);
	}

	private void updateDisplay	(){
		die.setText(dieRoll);
		displayPlayer.setText(playersName);
		inputGuess.setText(makeAGuess);
		responseArea.setText(response);
	}



	public static void main(String[] args) {
		Control_GUI controler = new Control_GUI() ;
		controler.setVisible(true);

	}
}