package control_GUI;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Board.Board;

public class AccusationDialog extends JDialog {
	
	private Board theboard;
	
	public AccusationDialog(Board input){
		theboard = input;
		setTitle("Make a Guess");
		setSize(200,200);
		
		addComponents();
	}

	
	public void addComponents() {
		final JPanel topPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,2);
		topPanel.setLayout(experimentLayout);
		
		JPanel right = new JPanel();
		JLabel roomlabel = new JLabel("Your Room");
		right.add(roomlabel);
		right.setBorder(new TitledBorder(new EtchedBorder()));
		
		
		JPanel lesft = new JPanel();
		JTextField CurrentRoom = new JTextField("Lounge");
		CurrentRoom.setEditable(false);
		lesft.add(CurrentRoom);
		lesft.setBorder(new TitledBorder(new EtchedBorder()));
		
		
		JPanel right1 = new JPanel();
		JLabel roomlabel1 = new JLabel("Your Not Room");
		right1.add(roomlabel1);
		right1.setBorder(new TitledBorder(new EtchedBorder()));
		
		
		JPanel personGuess = new JPanel();
		JComboBox<String> people = new JComboBox<String>();
		for (int peo = 0; peo < theboard.getPeople().size(); peo++){
			people.addItem(theboard.getPeople().get(peo).getContent());
		}
		personGuess.add(people);
		personGuess.setBorder(new TitledBorder(new EtchedBorder()));
		
		
		JPanel web = new JPanel();
		JLabel weplab = new JLabel("Weapon");
		web.add(weplab);
		web.setBorder(new TitledBorder(new EtchedBorder()));
		
		
		
		
	JPanel weaponGuess = new JPanel();
	JComboBox<String> weapons = new JComboBox<String>();
	for (int wep = 0; wep < theboard.getWeapons().size(); wep++){
		weapons.addItem(theboard.getWeapons().get(wep).getContent());
	}
	weaponGuess.add(weapons);
	weaponGuess.setBorder(new TitledBorder(new EtchedBorder()));
		
		
		
		
		topPanel.add(right);
		topPanel.add(lesft);
		
		topPanel.add(right1);
		topPanel.add(personGuess);
		topPanel.add(web);
		topPanel.add(weaponGuess);
		
		add(topPanel);
	}
	
	
	
	
	public static void main(String[] args) {
		
		AccusationDialog AccusationDialog = new AccusationDialog(new Board()) ;
		//JOptionPane.showMessageDialog(controller, "You are " + controller.board.getHuman().getName() + ", press Next Player to begin play.", "Welcome to Clue", JOptionPane.INFORMATION_MESSAGE);
		AccusationDialog.setVisible(true);
		
	
	}
	
}
