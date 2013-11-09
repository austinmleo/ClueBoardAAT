package control_GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Board.Board;

public class AccusationDialog extends JDialog {
	
	private Board theboard;
	private String cRoom = "";
	private JButton submit, cancel;
	private JTextArea CurrentRoom;
	private JComboBox<String> people, weapons;
	
	public AccusationDialog(Board input){
		theboard = input;
		setTitle("Make a Guess");
		setSize(360,240);
		
		addComponents();
	}
	
	public JButton getSubmitrButton(){
		return submit;
	}

	
	public void addComponents() {
		final JPanel topPanel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,2);
		topPanel.setLayout(experimentLayout);
		
		JPanel right = new JPanel();
		JLabel roomlabel = new JLabel("Your Room");
	//	roomlabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
		//roomlabel.setHorizontalAlignment(SwingConstants.LEFT);
	
		
		//roomlabel.setHorizontalAlignment(SwingConstants.CENTER);
		right.add(roomlabel, SwingConstants.CENTER);
		
		
		
		JPanel lesft = new JPanel();
		CurrentRoom = new JTextArea();
		cRoom = "";
		CurrentRoom.setPreferredSize(new Dimension(150,50));
		CurrentRoom.setBorder(null);
		CurrentRoom.setEditable(false);
		lesft.add(CurrentRoom);
		
		
		
		JPanel right1 = new JPanel();
		JLabel roomlabel1 = new JLabel("Person");
		right1.add(roomlabel1);
		
		
		
		JPanel personGuess = new JPanel();
		people = new JComboBox<String>();
		people.setPreferredSize(new Dimension(120,50));
		for (int peo = 0; peo < theboard.getPeople().size(); peo++){
			people.addItem(theboard.getPeople().get(peo).getContent());
		}
		personGuess.add(people);
	
		
		
		System.out.println(people.getSelectedItem());
		
		
		//System.out.println(theboard.getRoomCellAt(2).getInitial());
	//	System.out.println(theboard.getRoomCellAt(20).getRoomName());
		
		int currentplace = theboard.getHuman().getCurrentIndex();
		System.out.println(currentplace);
		System.out.println((theboard.getCellAt(currentplace)).isRoom());
		
		if (theboard.getCellAt(currentplace).isRoom()){
			//System.out.println("true this is");
			//System.out.println(theboard.getRoomCellAt(currentplace).getRoomName());
			cRoom = theboard.getRoomCellAt(currentplace).getRoomName();
		//	System.out.println(cRoom.equals("Lounge") + "proveing");
			
			//System.out.println("the room is"  + cRoom);
		}
		else
			cRoom = null;
		
		updateDisplay();
		
		JPanel web = new JPanel();
		JLabel weplab = new JLabel("Weapon");
		web.add(weplab);
		
		
		
		
		
	JPanel weaponGuess = new JPanel();
	weapons = new JComboBox<String>();
	weapons.setPreferredSize(new Dimension(120,50));
	for (int wep = 0; wep < theboard.getWeapons().size(); wep++){
		weapons.addItem(theboard.getWeapons().get(wep).getContent());
	}
	weaponGuess.add(weapons);

	System.out.println(weapons.getSelectedItem());
	

		
	JPanel buttonPanel = new JPanel();
	submit = new JButton("OK");
	cancel = new JButton("Make an accusation");
	buttonPanel.add(submit);
	buttonPanel.add(cancel);
	buttonPanel.setLayout(new GridLayout(0, 2));	
	
	this.getSubmitrButton().addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		
				System.out.println(cRoom);
				System.out.println(people.getSelectedItem());
				System.out.println(weapons.getSelectedItem());
			}
		
	});
	
	
	
	
		
	
		topPanel.add(right);
		topPanel.add(lesft);
		
		topPanel.add(right1);
		topPanel.add(personGuess);
		topPanel.add(web);
		topPanel.add(weaponGuess);
		
		
		
		add(topPanel);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void updateDisplay(){
		CurrentRoom.setText(cRoom);
		
	}

	public void setCurrentRoom(){
		cRoom = theboard.getRoomCellAt(20).getRoomName().toString();
	}
	
	
	
	
	public static void main(String[] args) {
		
		AccusationDialog AccusationDialog = new AccusationDialog(new Board()) ;
		//JOptionPane.showMessageDialog(controller, "You are " + controller.board.getHuman().getName() + ", press Next Player to begin play.", "Welcome to Clue", JOptionPane.INFORMATION_MESSAGE);
		AccusationDialog.setVisible(true);
		
		
	
	}
	
}
