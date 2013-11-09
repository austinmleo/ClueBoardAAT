package Board;

import java.awt.Color;
import java.awt.Graphics;

public class RoomCell extends BoardCell{

	
	public enum DoorDirection {UP, DOWN, LEFT, RIGHT, NONE};
	private DoorDirection directionOfDoor;
	private char roomInitial;
	private String roomName;
	//private int row;
	//private int column;
	
	public RoomCell(int column, int row, DoorDirection direction, char initial) {
		super(column, row);
		room = true;
		roomInitial = initial;
		directionOfDoor = direction;
		
		if(direction != DoorDirection.NONE){
			this.isDoor = true;
		}
	}
	
	
	/*
	public RoomCell(BoardCell cell) {
		this.row = cell.getRow();
		this.column = cell.getColumn();
		//this.roomInitial = cell.getInitial();
	}
`	*/


	public DoorDirection getDoorDirection(){
		return directionOfDoor;
	}
	
	public char getInitial(){
		return roomInitial;
	}	
	
	public String getRoomName(){
		if (roomInitial == 'S')
			roomName = "Study";
		else if (roomInitial == 'L')
			roomName = "Library";
		else if (roomInitial == 'R')
			roomName = "Billiard Room";
		else if (roomInitial == 'C')
			roomName = "Conservatory";
		else if (roomInitial == 'B')
			roomName = "Ballroom";
		else if (roomInitial == 'K')
			roomName = "Kitchen";
		else if (roomInitial == 'D')
			roomName = "Dining Room";
		else if (roomInitial == 'O')
			roomName = "Lounge";
		else if (roomInitial == 'H')
			roomName = "Hall";
		
		return roomName;
	}
	
	
	@Override
	public String toString() {
		String string = roomInitial + " (" + column + ", " + row + ")";
		return string;
	}

	@Override
	public void draw(Graphics g) {
		
	
		
		int x = this.column * Board.CELL_SIZE;
		int y = this.row * Board.CELL_SIZE;
		
	
		
		g.setColor(Color.GRAY);
        g.fillRect(x, y, Board.CELL_SIZE, Board.CELL_SIZE);

       if (roomInitial == 'X'){

    	   g.setColor(Color.RED.darker().darker());
    	   g.fillRect(x, y, Board.CELL_SIZE, Board.CELL_SIZE);
       }

       if(isTarget){

    	   g.setColor(Color.PINK);
    	   g.fillRect(x, y, Board.CELL_SIZE, Board.CELL_SIZE);
       }

       if (this.isDoor) {
    	   int height = 4;
    	   int width = Board.CELL_SIZE;
    	   switch (directionOfDoor){
    	   case UP:
    		   break;
    	   case DOWN:
    		   y = (y + Board.CELL_SIZE - height);
    		   width = Board.CELL_SIZE;
    		   break;
    	   case RIGHT:
    		   x = (x + Board.CELL_SIZE - height);
    		   height = Board.CELL_SIZE;
    		   break;
    	   case LEFT:
    		   height = Board.CELL_SIZE;
    		   width = 4;
    		   break;
    	   }
    	   g.setColor(Color.BLUE);
    	   g.fillRect(x, y, width, height);
       }


		
	}


	

}
