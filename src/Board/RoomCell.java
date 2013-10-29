package Board;

import java.awt.Color;
import java.awt.Graphics;

public class RoomCell extends BoardCell{

	
	public enum DoorDirection {UP, DOWN, LEFT, RIGHT, NONE};
	private DoorDirection directionOfDoor;
	private char roomInitial;
	private int row;
	private int column;
	
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
	
	
	@Override
	public String toString() {
		String string = roomInitial + " (" + column + ", " + row + ")";
		return string;
	}

	@Override
	public void draw(Graphics g) {
		
		int x = column * Board.CELL_SIZE;
		int y = row * Board.CELL_SIZE;
		
		if (false){
			g.setColor(new Color(51,204,255));
			g.fillRect(x, y, Board.CELL_SIZE, Board.CELL_SIZE);
		}
		
		if(directionOfDoor != DoorDirection.NONE){
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
				break;
			}
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		
	}


	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
