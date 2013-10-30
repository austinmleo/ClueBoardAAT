package Board;

import java.awt.Color;
import java.awt.Graphics;

public class WalkwayCell extends BoardCell {

	public WalkwayCell(int column, int row) {
		super(column, row);
		walkway = true;
	}
	@Override
	public String toString() {
		String string = "W (" + column + ", " + row + ")";
		return string;
	}
	
	
	@Override
	public void draw(Graphics g) {
		
		int x = this.column * Board.CELL_SIZE;
        int y = this.row * Board.CELL_SIZE;
       
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, Board.CELL_SIZE, Board.CELL_SIZE);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, Board.CELL_SIZE, Board.CELL_SIZE);  
		
		
	}
	
	

}
