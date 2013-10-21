package Board;

public class Card {

	public enum type {WEAPON, ROOM, PERSON}
	private type cardType;
	private String content;
	
	
	public Card(type cardType, String content) {
		super();
		this.cardType = cardType;
		this.content = content;
	}


	public type getCardType() {
		return cardType;
	}


	public String getContent() {
		return content;
	}
	
	
	
	
	
}
