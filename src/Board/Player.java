package Board;

import java.util.ArrayList;

public class Player {

	protected String name;
	protected String color;
	protected int currentIndex;
	public ArrayList<Card> cards = new ArrayList<Card>();
	protected int numCards;
	protected ArrayList<Card> possibleWeapons;
	protected ArrayList<Card> possiblePeople;
	protected ArrayList<Card> possibleRooms;
	
	
	
	
	public Player(String name, String color, int currentIndex) {
		super();
		this.name = name;
		this.color = color;
		this.currentIndex = currentIndex;
	}

	public Player(String name, String color, int currentIndex,
			ArrayList<Card> possibleWeapons, ArrayList<Card> possiblePeople,
			ArrayList<Card> possibleRooms) {
		super();
		this.name = name;
		this.color = color;
		this.currentIndex = currentIndex;
		this.possibleWeapons = possibleWeapons;
		this.possiblePeople = possiblePeople;
		this.possibleRooms = possibleRooms;
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

	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public int getNumCards() {
			return cards.size();
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", color=" + color + ", currentIndex="
				+ currentIndex + "]";
	}
	
	public void setCards(ArrayList<Card> hand) {
		cards = hand;
	}
	
	public Card revealCard(Card toReveal) {
		return toReveal;
	}
	
	
}
