package Board;

import java.util.ArrayList;

public class Player {

	private String name;
	private String color;
	private int currentIndex;
	public ArrayList<Card> cards;
	
	public Player(String name, String color, int currentIndex) {
		super();
		this.name = name;
		this.color = color;
		this.currentIndex = currentIndex;
	}


	public String getName() {
		return name;
	}


	public String getColor() {
		return color;
	}


	public int getCurrentIndex() {
		return currentIndex;
	}


	@Override
	public String toString() {
		return "Player [name=" + name + ", color=" + color + ", currentIndex="
				+ currentIndex + "]";
	}
	
	
	
}
