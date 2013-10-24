package Board;

import java.util.ArrayList;
import java.util.Set;

import Board.Card.type;

public class ComputerPlayer extends Player {
	private char lastVisited;

	public ComputerPlayer(String name, String color, int currentIndex,
			ArrayList<Card> possibleWeapons, ArrayList<Card> possiblePeople,
			ArrayList<Card> possibleRooms) {
		super(name, color, currentIndex, possibleWeapons, possiblePeople, possibleRooms);
	}
	
	public ComputerPlayer(String name, String color, int currentIndex) {
		super(name, color, currentIndex);
	}
	
	public void selectTarget(Set<BoardCell> targets) {
		int selected = currentIndex;
		
		
		
		currentIndex = selected;
	}
	
	public void makeSuggestion() {
		
	}
	
	public void updatePossibilities(Card seen) {
		if(seen.getCardType() == type.WEAPON)
			possibleWeapons.remove(seen.getContent());
		else if (seen.getCardType() == type.PERSON)
			possiblePeople.remove(seen.getContent());
		else if (seen.getCardType() == type.ROOM)
			possibleRooms.remove(seen.getContent());
	}

	public void setLastVisited(char lastVisited) {
		this.lastVisited = lastVisited;
	}
	
}
