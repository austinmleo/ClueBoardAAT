package control_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Board.Card;
import Board.Card.type;
import Board.Board;
import Board.HumanPlayer;

public class ClueGame extends JFrame {
	
	private Board board;
	private Control_GUI gui;
	AccusationDialog makeAGuess;
	JButton button1;
	 boolean firstturn = true;
	 private boolean Accusation = false;
	
	
	DetectiveNotes notes; // = new DetectiveNotes(this.getBoard());
	
	
    public ClueGame() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Clue Game");
        setSize(1000, 800);
        setResizable(false);
 
        createMenuBar();
        createBoard();
        createControls();     
        notes = new DetectiveNotes(this.getBoard());
   
    }
	
   /* public void startUpDialog() {
    	JDialog startUp = new JDialog();
    	startUp.setTitle("Clue Gdfdsfsdame");
    	startUp.setSize(200, 100);
    	button1 = new JButton("OK");
    	ButtonListener listener = new ButtonListener();
    	button1.addActionListener(listener);
    	add(button1, BorderLayout.SOUTH);
    
    	
    }*/

    class ButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		
    		}
    	}
    
    
	public void createMenuBar() {
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(openNotes());
	}
	
    public void createBoard() {
        board = new Board();
        add(board, BorderLayout.CENTER);
    }
	
    public Control_GUI getControl(){
    	return gui;
    }
    
    public void createControls() {
    	gui = new Control_GUI(this.getBoard());
    	add(gui, BorderLayout.SOUTH);
    	
    	//makeAGuess = new AccusationDialog(this.getBoard());
    	
    	
    	JPanel humanCards = new JPanel();
    	//humanCards.setLayout(new BoxLayout(humanCards, BoxLayout.Y_AXIS))
    	humanCards.setLayout(new GridLayout(0,1));
    	humanCards.setPreferredSize(new Dimension(250, 10));
    	humanCards.setBorder(new TitledBorder(new EtchedBorder(), "Cards in Players Hand"));
    	humanCards.add(displayCards("People", board.getHuman().getCards(), type.PERSON));
    	humanCards.add(displayCards("Weapons", board.getHuman().getCards(), type.WEAPON));
    	humanCards.add(displayCards("Rooms", board.getHuman().getCards(), type.ROOM));
    	add(humanCards, BorderLayout.EAST);
    	
    	
    	
    	gui.getNextPlayerButton().addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			if(firstturn) {
    				board.makeMove(board.getHuman());
    				
    				firstturn = false;
    				
    			}
    			else {
    				board.nextTurn();
    				gui.setResponse();
    				gui.setPlayerName();
    				gui.setRollDie();
    				
    			}
    		}
    	});
    	
    	
	gui.getaccusationButton().addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			
    			Accusation = true;
    			board.openAccusationDialog(Accusation);
    			System.out.println("good job");
    		
    			
    		}
    	});
    	
    }
    
    public boolean getAccusationBoolean(){
    	return Accusation;
    }
   
    
    public JPanel displayCards(String title, ArrayList<Card> cards, type type) {
    	JPanel cardDisplay = new JPanel();
    	cardDisplay.setBorder(new TitledBorder(new EtchedBorder(), title));
    	cardDisplay.setPreferredSize(new Dimension(5,2));
    	
    	for (Card c: cards) {
    		if(c.getCardType() == type) { 
    			cardDisplay.setLayout(new GridLayout(0,1));
    			JTextArea textField = new JTextArea(c.getContent());
    		
    			textField.setEditable(false);
    			
    			cardDisplay.add(textField);
    			
   
    		}
    	}
    	return cardDisplay;
    }
    

    
    public Board getBoard() {
        return board;
    }
    
    public Control_GUI getGui() {
    	return gui;
    }
    
    private JMenu openNotes() {
		JMenu menu = new JMenu("File");
		menu.add(detectiveNotes());
		menu.add(exit());
		return menu;
	}
	
	private JMenuItem detectiveNotes() {
		//final ClueGame temp = this;
		JMenuItem item = new JMenuItem("Detective Notes");
		class MenuItemListener  implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				notes.setVisible(true);
			
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;	
	}
	
	private JMenuItem exit() {
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener  implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
		
	}
	

	
	



public static void main(String[] args) {
	
	ClueGame controller = new ClueGame() ;
	JOptionPane.showMessageDialog(controller, "You are " + controller.board.getHuman().getName() + ", press Next Player to begin play.", "Welcome to Clue", JOptionPane.INFORMATION_MESSAGE);
	controller.setVisible(true);
	
}
}