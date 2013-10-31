package control_GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Board.Board;

public class ClueGame extends JFrame {

	private Board board;
	private Control_GUI gui;
	DetectiveNotes notes; // = new DetectiveNotes(this.getBoard());
	
    public ClueGame() {
        setTitle("Clue Game");
        setSize(800, 700);
        
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

