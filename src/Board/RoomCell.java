package Board;

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
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
