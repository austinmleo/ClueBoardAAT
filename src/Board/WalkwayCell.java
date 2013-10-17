package Board;

public class WalkwayCell extends BoardCell {

	public WalkwayCell(int column, int row) {
		super(column, row);
		walkway = true;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		String string = "W (" + column + ", " + row + ")";
		return string;
	}

}
