package Board;

import Board.RoomCell.DoorDirection;

public abstract class BoardCell {

	protected int row;
	protected int column;
	
	protected boolean isDoor = false;
	protected boolean room = false;
	protected boolean walkway = false;
	
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	
	public BoardCell(int column, int row) {
		this.row = row;
		this.column = column;
	}
	
	public boolean isWalkway(){
		return walkway;
	
	}
	
	public boolean isRoom(){
		return room;
	}
	
	public boolean isDoorway(){
		return isDoor;
	}
	
	/*
	public DoorDirection getDoorDirection() {
		RoomCell room = new RoomCell(this);
		return room. getDoorDirection();
	}
	*/
	
	public abstract void draw();

	

}
