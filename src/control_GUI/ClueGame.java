package control_GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Board.Card;
import Board.Card.type;
import Board.Board;
import Board.HumanPlayer;

public class ClueGame extends JFrame {

	private Board board;
	private Control_GUI gui;
	DetectiveNotes notes; // = new DetectiveNotes(this.getBoard());
	
    public ClueGame() {
        setTitle("Clue Game");
        setSize(900, 800);
        
        createMenuBar();
        createBoard();
        createControls();     
        notes = new DetectiveNotes(this.getBoard());
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
	
    public void createControls() {
    	gui = new Control_GUI();
    	add(gui, BorderLayout.SOUTH);
    	
    	
    	JPanel humanCards = new JPanel();
    	humanCards.setLayout(new BoxLayout(humanCards, BoxLayout.Y_AXIS));
    	//ArrayList<Card> cards = board.getHuman().getCards();
    	humanCards.add(new JLabel("Cards in hand"));
    	humanCards.add(displayCards("People", board.getHuman().getCards(), type.PERSON));
    	humanCards.add(displayCards("Weapons", board.getHuman().getCards(), type.WEAPON));
    	humanCards.add(displayCards("Rooms", board.getHuman().getCards(), type.ROOM));
    	add(humanCards, BorderLayout.EAST);
    	
    }
    
    public JPanel displayCards(String title, ArrayList<Card> cards, type type){
    	JPanel cardDisplay = new JPanel();
    	cardDisplay.setBorder(new TitledBorder(new EtchedBorder(), title));
    	
    	for (Card c: cards){
    		if(c.getCardType() == type){
    			cardDisplay.add(new JLabel(c.getContent()));
    			System.out.println(c.getContent());
    			
   
    		}
    	}
    	return cardDisplay;
    }
    

    
    public Board getBoard() {
        return board;
    }
    
    public Control_GUI getGui(){
    	return gui;
    }
    
    public static void main(String[] args) {
    	ClueGame controler = new ClueGame() ;
		controler.setVisible(true);
	}
    
    private JMenu openNotes(){
		JMenu menu = new JMenu("File");
		menu.add(detectiveNotes());
		return menu;
	}
	
	private JMenuItem detectiveNotes(){
		//final ClueGame temp = this;
		JMenuItem item = new JMenuItem("Detective Notes");
		class MenuItemListener  implements ActionListener{
			public void actionPerformed(ActionEvent e){
				notes.setVisible(true);
			
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;	
	}  
}

