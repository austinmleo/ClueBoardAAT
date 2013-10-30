package control_GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Board.Board;

public class ClueGame extends JFrame {

	private Board board;
	
    public ClueGame() {
        setTitle("Clue Game");
        setSize(800, 700);
        
       // createMenuBar();
        createBoard();
       // createControls();
        
    }
	
	public void createMenuBar() {}
	
    public void createBoard() {
        board = new Board();
        add(board, BorderLayout.CENTER);
    }
	
    public void createControls() {}
	
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Board getBoard() {
        return board;
    }
}
