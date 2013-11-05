package Board;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class HumanPlayer extends Player{



	public HumanPlayer(String name, String strColor, int currentIndex,
			ArrayList<Card> possibleWeapons, ArrayList<Card> possiblePeople,
			ArrayList<Card> possibleRooms) {
		super(name, strColor, currentIndex, possibleWeapons, possiblePeople, possibleRooms);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw (Graphics g){
		
		
	
		int x = (currentIndex % Board.numColumns)*Board.CELL_SIZE;
        int y = (currentIndex / Board.numRows)*Board.CELL_SIZE;
        
         g.setColor(getColor());
         g.fillOval(x, y, Board.CELL_SIZE, Board.CELL_SIZE);
         g.setColor(Color.BLACK);
         g.drawOval(x, y, Board.CELL_SIZE, Board.CELL_SIZE);                
	}
	

		
}


