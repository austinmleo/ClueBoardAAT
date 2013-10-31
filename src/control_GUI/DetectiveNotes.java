package control_GUI;

import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.*;

import static java.util.Arrays.asList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Board.Board;

public class DetectiveNotes extends JDialog {

	//private Board theboard;
	
	private JCheckBox 
	people,
	room,
	weapon;

	public DetectiveNotes(){
		//JFrame detectiveNotes = new JFrame();
		//detectiveNotes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//theboard = input;
		setTitle("Detective Notes");
		setSize(550, 500);

		addComponents();

	}

	Board theboard = new Board();

	public void addComponents() {
		final JPanel topPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(3,1);
		topPanel.setLayout(experimentLayout);

		// add people checheck box
		JPanel peoplePanel = new JPanel();
		for (int peo = 0; peo < theboard.getPeople().size(); peo++){
			people = new JCheckBox(theboard.getPeople().get(peo).getContent());
			peoplePanel.add(people);
		}
		peoplePanel.setLayout(new GridLayout(0, 2));
		peoplePanel.setBorder(new TitledBorder (new EtchedBorder(), "People"));


		// add room check box
		JPanel roomPanel = new JPanel();
		for (int rom = 0;  rom < theboard.getRoomCards().size(); rom ++){
			room = new JCheckBox(theboard.getRoomCards().get(rom).getContent());
			roomPanel.add(room);
		}
		roomPanel.setLayout(new GridLayout(0, 2));
		roomPanel.setBorder(new TitledBorder(new EtchedBorder(), "Weapons"));

		// add weapon check box 
		JPanel weaponPanel = new JPanel();
		for (int wep = 0; wep < theboard.getWeapons().size(); wep++	){
			weapon = new JCheckBox(theboard.getWeapons().get(wep).getContent());
			weaponPanel.add(weapon);
		}
		weaponPanel.setLayout(new GridLayout(0, 2));
		weaponPanel.setBorder(new TitledBorder(new EtchedBorder(), "Weapons"));

		// add personGuress ComboBox
		JPanel personGuess = new JPanel();
		JComboBox<String> people = new JComboBox<String>();
		for (int peo = 0; peo < theboard.getPeople().size(); peo++){
			people.addItem(theboard.getPeople().get(peo).getContent());
		}
		personGuess.add(people);
		personGuess.setBorder(new TitledBorder(new EtchedBorder(), "Person Guess"));

		// add roomGuess ComboBox
		JPanel roomGuess = new JPanel();
		JComboBox<String> rooms = new JComboBox<String>();
		for (int rom = 0; rom < theboard.getRoomCards().size(); rom++){
			rooms.addItem(theboard.getRoomCards().get(rom).getContent());
		}
		roomGuess.add(rooms);
		roomGuess.setBorder(new TitledBorder(new EtchedBorder(), "Room Guess"));

		// add weaponGuess ComboBox
		JPanel weaponGuess = new JPanel();
		JComboBox<String> weapons = new JComboBox<String>();
		for (int wep = 0; wep < theboard.getWeapons().size(); wep++){
			weapons.addItem(theboard.getWeapons().get(wep).getContent());
		}
		weaponGuess.add(weapons);
		weaponGuess.setBorder(new TitledBorder(new EtchedBorder(), "Weapon Guess"));


		topPanel.add(peoplePanel);
		topPanel.add(personGuess);
		topPanel.add(roomPanel);
		topPanel.add(roomGuess);
		topPanel.add(weaponPanel);
		topPanel.add(weaponGuess);



		add(topPanel);
	}



	public static void main(String[] args) {
		DetectiveNotes controler = new DetectiveNotes() ;
		controler.setVisible(true);

	}



}
