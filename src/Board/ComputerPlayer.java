package Board;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import Board.Card.type;

public class ComputerPlayer extends Player {
	private char lastVisited;
	Card weaponCard;
	Card personCard;
	Card roomCard;

	public ComputerPlayer(String name, String strColor, int currentIndex,
			ArrayList<Card> possibleWeapons, ArrayList<Card> possiblePeople,
			ArrayList<Card> possibleRooms) {
		super(name, strColor, currentIndex, possibleWeapons, possiblePeople, possibleRooms);
	}
	
	public ComputerPlayer(String name, String strColor, int currentIndex) {
		super(name, strColor, currentIndex);
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
	
	public boolean makeSuggestion(ArrayList<Player> players ) {
		boolean suggestionCaught = false;
		
		Random generator = new Random();
		int rand = generator.nextInt(possibleWeapons.size());
		String weapon = possibleWeapons.get(rand).getContent();
		rand = generator.nextInt(possiblePeople.size());
		String person = possiblePeople.get(rand).getContent();
		rand = generator.nextInt(possibleRooms.size());
		String room = possibleRooms.get(rand).getContent();
		Card card = new Card(null, "null");
		weaponCard = new Card(Card.type.WEAPON, weapon);
		personCard = new Card(Card.type.PERSON, person);
		roomCard = new Card(Card.type.ROOM, room);
		
		for(Player p: players){
			if(p.cards.contains(weapon)){
				card = new Card(Card.type.WEAPON, weapon);
				suggestionCaught = true;
				break;
			}
			if(p.cards.contains(person)){
				card = new Card(Card.type.PERSON, person);
				suggestionCaught = true;
				break;
			}
			if(p.cards.contains(room)){
				card = new Card(Card.type.ROOM, room);
				suggestionCaught = true;
				break;
			}
		}
		return suggestionCaught;
		
		
		
	}
	
	public ArrayList<Card> makeAccusation(){
		ArrayList<Card> accusationCards = new ArrayList<Card>();
		accusationCards.add(personCard);
		accusationCards.add(roomCard);
		accusationCards.add(weaponCard);
		
		return accusationCards;
		
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
	
	public char getLastVisited(){
		return lastVisited;
	}
	
	 @Override
     void draw(Graphics g) {
			int x = (currentIndex % Board.numColumns)*Board.CELL_SIZE;
	        int y = (currentIndex / Board.numRows)*Board.CELL_SIZE;
             
             g.setColor(getColor());
             g.fillOval(x, y, Board.CELL_SIZE, Board.CELL_SIZE);
             g.setColor(Color.BLACK);
             g.drawOval(x, y, Board.CELL_SIZE, Board.CELL_SIZE);                
     }
}
