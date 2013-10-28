package control_GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class DetectiveNotes extends JFrame {
	
	private JCheckBox 
	missScarlet, colonelMustard, mrGreen, mrsWhite, mrsPeacock, professorPlum,
	kitchen, diningRoom, lounge, ballRoom, conservatory, hall, study, library, billiardRoom,
	wrongWeapon;
	
	public DetectiveNotes(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Clue GUI");
		setSize(350, 300);
		
		addPeople();
	}
	
	
	
	
	public void addPeople() {
		final JPanel topPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(3,0);
		topPanel.setLayout(experimentLayout);
		
		JPanel whoseTurnPanel = new JPanel();
		missScarlet = new JCheckBox("Miss Scarlet");
		colonelMustard = new JCheckBox("Colonel Mustard");
		mrGreen = new JCheckBox("Mr. Green");
		mrsWhite = new JCheckBox("Mrs. White");
		mrsPeacock = new JCheckBox("Mrs. Peacock");
		professorPlum = new JCheckBox("Professor Plum");
		whoseTurnPanel .add(missScarlet);
		whoseTurnPanel .add(colonelMustard);
		whoseTurnPanel .add(mrGreen);
		whoseTurnPanel .	add(mrsWhite);
		whoseTurnPanel .add(mrsPeacock);
		whoseTurnPanel. add(professorPlum);
	
		
	whoseTurnPanel.setLayout(new GridLayout(0, 2));
	
	whoseTurnPanel.setBorder(new TitledBorder (new EtchedBorder(), "People"));
	
	JPanel roomPanel = new JPanel();
	kitchen = new JCheckBox("Kitchen");
	diningRoom = new JCheckBox("Dining Room");
	lounge = new JCheckBox("Lounge");
	ballRoom = new JCheckBox("Ball Room");
	conservatory = new JCheckBox("Conservatory");
	hall = new JCheckBox("Hall");
	library = new JCheckBox("Library");
	billiardRoom = new JCheckBox("Billiard Room");
	roomPanel .add(kitchen);
	roomPanel .add(diningRoom);
	roomPanel .add(lounge);
	roomPanel .	add(ballRoom);
	roomPanel .add(library);
	roomPanel. add(billiardRoom);
	roomPanel.setLayout(new GridLayout(0, 2));
	roomPanel.setBorder(new TitledBorder (new EtchedBorder(), "Rooms"));
	
	
	topPanel.add(whoseTurnPanel);
	topPanel.add(roomPanel);
	
	add(topPanel);
	}
	

	
	public static void main(String[] args) {
		DetectiveNotes controler = new DetectiveNotes() ;
		controler.setVisible(true);

	}
	
	

}
