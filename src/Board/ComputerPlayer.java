package Board;

import java.util.ArrayList;
import java.util.Random;
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
		Random generator = new Random();
		int selected = currentIndex;
		ArrayList<BoardCell> temp = new ArrayList<BoardCell>();
		Boolean roomFound = false;
		
		for (BoardCell c: targets) {
			if (c.isRoom() && ((RoomCell)c).getInitial() != lastVisited) {
				selected = c.getIndex();
				roomFound = true;
			}
			else
				temp.add(c);
		}
			
		if (!roomFound)
			selected = temp.get(generator.nextInt(temp.size())).getIndex();
		
		currentIndex = selected;
	}
	
	public void makeSuggestion() {
		Random generator = new Random();
		
		int rand = generator.nextInt(possibleWeapons.size());
		String weapon = possibleWeapons.get(rand).getContent();
		rand = generator.nextInt(possiblePeople.size());
		String person = possiblePeople.get(rand).getContent();
		rand = generator.nextInt(possibleRooms.size());
		String room = possibleRooms.get(rand).getContent();
		
		
		
	}
	
	public void updatePossibilities(Card seen) {
		if(seen.getCardType() == type.WEAPON)
			possibleWeapons.remove(seen);
		else if (seen.getCardType() == type.PERSON)
			possiblePeople.remove(seen);
		else if (seen.getCardType() == type.ROOM)
			possibleRooms.remove(seen);
	}

	public void setLastVisited(char lastVisited) {
		this.lastVisited = lastVisited;
	}
	
}
