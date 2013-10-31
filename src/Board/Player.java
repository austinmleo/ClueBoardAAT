package Board;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Player {

	protected String name;
	protected String strColor;
	protected int currentIndex;
	public ArrayList<Card> cards = new ArrayList<Card>();
	protected int numCards;
	protected Color color;
	protected ArrayList<Card> possibleWeapons;
	protected ArrayList<Card> possiblePeople;
	protected ArrayList<Card> possibleRooms;
	
	protected BoardCell location;

	
	
	
	
	public Player(String name, String strColor, int currentIndex) {
		super();
		this.name = name;
		this.strColor = strColor;
		this.currentIndex = currentIndex;
		this.color = this.convertColor(strColor);
	}

	public Player(String name, String strColor, int currentIndex,
			ArrayList<Card> possibleWeapons, ArrayList<Card> possiblePeople,
			ArrayList<Card> possibleRooms) {
		super();
		this.name = name;
		this.strColor = strColor;
		this.currentIndex = currentIndex;
		this.possibleWeapons = possibleWeapons;
		this.possiblePeople = possiblePeople;
		this.possibleRooms = possibleRooms;
		this.color = this.convertColor(strColor);
	}

	public String getName() {
		return name;
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
		return "Player [name=" + name + ", color=" + strColor + ", currentIndex="
				+ currentIndex + "]";
	}
	
	public void setCards(ArrayList<Card> hand) {
		cards = hand;
	}
	
	public Card revealCard(Card toReveal) {
		return toReveal;
	}

	public ArrayList<Card> getPossibleWeapons() {
		return possibleWeapons;
	}

	public ArrayList<Card> getPossiblePeople() {
		return possiblePeople;
	}

	public ArrayList<Card> getPossibleRooms() {
		return possibleRooms;
	}

	public void setPossibleWeapons(ArrayList<Card> possibleWeapons) {
		this.possibleWeapons = possibleWeapons;
	}

	public void setPossiblePeople(ArrayList<Card> possiblePeople) {
		this.possiblePeople = possiblePeople;
	}

	public void setPossibleRooms(ArrayList<Card> possibleRooms) {
		this.possibleRooms = possibleRooms;
	}
	
	public void  setLocation(BoardCell location){
		this.location = location;
	}
	
	public BoardCell getLocation(){
		
		return location;
	}
	
	public void setColor(Color toSet){
		this.color = toSet;
	}

	public String getStrColor() {
		return strColor;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Color convertColor(String strColor) {
		Color color; 
		try {     
			// We can use reflection to convert the string to a color
			//System.out.println(strColor.trim());
			Field field = Class.forName("java.awt.Color").getField(strColor.trim());     
			color = (Color)field.get(null); } 
		catch (Exception e) {  
			color = null; // Not defined } 
		}
		return color;
	}
	
	void draw(Graphics g){}

}
