package Board;

public abstract class BoardCell {

	protected int row;
	protected int column;
	
	protected boolean direction = false;
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
		return direction;
	}
	
	public abstract void draw();

	

}
