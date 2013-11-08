package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import Board.Board;
import Board.BoardCell;
import Board.Card;
import Board.Card.type;
import Board.ComputerPlayer;
import Board.Player;

public class testPeopleAndCards {

	private static Board board;
	@BeforeClass
	public static void setUp() {
		board = new Board("ClueLayout.csv", "ClueLegend.txt");

	}
	
	@Test
	public void testPlayers() { //This test ensures each player has the proper name color and starting spot.
		ArrayList<Player> test = board.getPlayers();
		Assert.assertTrue(test.get(0).getName().equalsIgnoreCase("Jesus"));
		Assert.assertTrue(test.get(0).getStrColor().equalsIgnoreCase("White"));
		Assert.assertTrue(test.get(0).getCurrentIndex() == 8);
		
		Assert.assertTrue(test.get(1).getName().equalsIgnoreCase("The Boss"));
		Assert.assertTrue(test.get(1).getStrColor().equalsIgnoreCase("Black"));
		Assert.assertTrue(test.get(1).getCurrentIndex() == 14);
		
		Assert.assertTrue(test.get(2).getName().equalsIgnoreCase("King Awesome"));
		Assert.assertTrue(test.get(2).getStrColor().equalsIgnoreCase("Purple"));
		Assert.assertTrue(test.get(2).getCurrentIndex() == 160);
		
		Assert.assertTrue(test.get(3).getName().equalsIgnoreCase("Uncle Sam"));
		Assert.assertTrue(test.get(3).getStrColor().equalsIgnoreCase("Red"));
		Assert.assertTrue(test.get(3).getCurrentIndex() == 522);
		
		Assert.assertTrue(test.get(4).getName().equalsIgnoreCase("Some Guy"));
		Assert.assertTrue(test.get(4).getStrColor().equalsIgnoreCase("Teal"));
		Assert.assertTrue(test.get(4).getCurrentIndex() == 512);
		
		Assert.assertTrue(test.get(5).getName().equalsIgnoreCase("A Girl"));
		Assert.assertTrue(test.get(5).getStrColor().equalsIgnoreCase("Pink"));
		Assert.assertTrue(test.get(5).getCurrentIndex() == 230);		
	}
	
	@Test
	public void testCardsReadProperly() { //Tests four cards to make sure they exist and have the proper type and content.
		ArrayList<Card> test = board.getTestDeck();
		Assert.assertTrue(test.get(0).getCardType() == type.WEAPON);
		Assert.assertTrue(test.get(0).getContent().equalsIgnoreCase("Plasma Cannon"));
		
		Assert.assertTrue(test.get(5).getCardType() == type.WEAPON);
		Assert.assertTrue(test.get(5).getContent().equalsIgnoreCase("Sword of Sari"));
		
		Assert.assertTrue(test.get(10).getCardType() == type.PERSON);
		Assert.assertTrue(test.get(10).getContent().equalsIgnoreCase("King Awesome"));
		
		Assert.assertTrue(test.get(20).getCardType() == type.ROOM);
		Assert.assertTrue(test.get(20).getContent().equalsIgnoreCase("Billiard Room"));
	}
	
	@Test
	public void testAllCardsDealt() { //Ensures the deck is empty after the deal.
		ArrayList<Card> test = board.getDeck();
		Assert.assertTrue(test.size() == 0);
	}
	
	@Test
	public void testPlayersHaveRoughlyTheSameNumberOfCards() { //Checks that players card numbers are +/- 1 of each other;
		ArrayList<Player> test = board.getPlayers();
		int last = test.get(0).getNumCards();
		int current = test.get(1).getNumCards();
		
		for (int i = 1; (i+1) < test.size(); i++ ) {
			//System.out.println(i + "" + test.get(i).getName() + "" + test.get(i).getNumCards() );
			int abs = Math.abs(current - last);
			Boolean check = false;
			if (abs <= 1)
				check = true;
			Assert.assertTrue(check);
			
			last = current;
			current =  test.get(i+1).getNumCards();
			
			
		}
		//System.out.println("Uncle Sam has " + test.get(3).getCards());
		//System.out.println("what the hell");
		//Assert.assertTrue(2 > 1);
	}
		
	@Test
	public void testNoCardDuplicates() {
		ArrayList<Player> temp = board.getPlayers();
		ArrayList<Card> test = new ArrayList<Card>();
		for (int i = 0; i < temp.size(); i++) {
			test.addAll(temp.get(i).getCards());
		}
		Set<Card> test2 = new HashSet<Card>(test);
		Assert.assertTrue(test.size() == test2.size());

	}
		
	@Test	
	public void testProperAccusation() {
		ArrayList<Card> test = board.getTestDeck();
		board.setSoln(test.get(19),test.get(9),test.get(4));
		Assert.assertTrue(board.makeAccusation(test.get(19).getContent(),test.get(9).getContent(),test.get(4).getContent()));	
	}
			
	@Test	
	public void testWrongRoom() {
		ArrayList<Card> test = board.getTestDeck();
		board.setSoln(test.get(19),test.get(9),test.get(4));
		Assert.assertFalse(board.makeAccusation(test.get(19+1).getContent(),test.get(9).getContent(),test.get(4).getContent()));	
	}
			
	@Test	
	public void testWrongPerson() {
		ArrayList<Card> test = board.getTestDeck();
		board.setSoln(test.get(19),test.get(9),test.get(4));
		Assert.assertFalse(board.makeAccusation(test.get(19).getContent(),test.get(9+1).getContent(),test.get(4).getContent()));	
	}
		
	@Test	
	public void testWrongWeapon() {
		ArrayList<Card> test = board.getTestDeck();
		board.setSoln(test.get(19),test.get(9),test.get(4));
		Assert.assertFalse(board.makeAccusation(test.get(19).getContent(),test.get(9).getContent(),test.get(4+1).getContent()));	
	}		
		
	@Test
	public void testSuggestionWithOnlyOneCard() { //Ensures a player will shown the only correct card in their hand. 
		ArrayList<Player> playersTest = board.getPlayers();
		ArrayList<Card> hold0 = playersTest.get(0).getCards();
		ArrayList<Card> newHand = new ArrayList<Card>();
		newHand.add(new Card(type.WEAPON, "Maul"));
		playersTest.get(0).setCards(newHand);
		
		String test = board.handleSuggestion("Some Place", "A Person", "Maul", playersTest.get(3));
		Assert.assertTrue(test.equalsIgnoreCase("Maul"));	
		board.getPlayers().get(0).setCards(hold0);
	}
				
	@Test
	public void testPlayerShowsRandomCard() {
		ArrayList<Player> playersTest = board.getPlayers();
		ArrayList<Card> hold0 = playersTest.get(0).getCards();
		ArrayList<Card> newHand = new ArrayList<Card>();
		newHand.add(new Card(type.WEAPON, "Maul"));
		newHand.add(new Card(type.PERSON, "Jesus"));
		playersTest.get(0).setCards(newHand);
		
		String test = board.handleSuggestion("Some Place", "Jesus", "Maul", playersTest.get(3));
		//System.out.println(test);
		Assert.assertTrue(test.equalsIgnoreCase("Maul") || test.equalsIgnoreCase("Jesus"));	
		board.getPlayers().get(0).setCards(hold0);
	}
	
	@Test
	public void testPlayersQueriedInOrder() { // This tests that the players are surveyed in order to see if they hold the cards.
		ArrayList<Player> playersTest = board.getPlayers();
		ArrayList<Card> hold3 = playersTest.get(3).getCards();
		ArrayList<Card> newHand = new ArrayList<Card>();
		newHand.add(new Card(type.WEAPON, "MiniGun"));
		playersTest.get(3).setCards(newHand);
		
		Player accuser = playersTest.get(0);
		String room = "Some Place";
		String person = "A Person";
		String weapon = "Minigun";
		int playerCounter = 0;
		
		String info = null;
		ArrayList<String> dissapprovals = new ArrayList<String>();
		Boolean cardShown = false;
		for (int i = 0; i < playersTest.size(); i++ ) {
			if (cardShown)
				break;
			if (playersTest.get(i).getName().equalsIgnoreCase(accuser.getName()))
				continue;
			else {
				for (int j = 0; j < playersTest.get(i).getCards().size(); j++) {
					if (playersTest.get(i).getCards().get(j).getContent().equalsIgnoreCase(room)
						|| playersTest.get(i).getCards().get(j).getContent().equalsIgnoreCase(person)
						|| playersTest.get(i).getCards().get(j).getContent().equalsIgnoreCase(weapon)) {
							dissapprovals.add(playersTest.get(i).revealCard(playersTest.get(i).getCards().get(j)).getContent());
							cardShown = true;
					}			
				}
			}
			playerCounter++;
		}
		if (dissapprovals.size() > 0) {
			Random generator = new Random();
			info = dissapprovals.get(generator.nextInt(dissapprovals.size()));
		}
	
		Assert.assertTrue(info.equalsIgnoreCase("MiniGun"));	
		Assert.assertTrue(playerCounter == 3);	
		board.getPlayers().get(3).setCards(hold3);
	}
		
	@Test
	public void testPlayerForThatTurnDoesNotShowACard() { //This ensures the accusing player will not show his cards.
		ArrayList<Player> playersTest = board.getPlayers();
		ArrayList<Card> hold0 = playersTest.get(0).getCards();
		ArrayList<Card> newHand = new ArrayList<Card>();
		newHand.add(new Card(type.WEAPON, "Minigun"));
		//newHand.add(new Card(type.PERSON, "Jesus"));
		playersTest.get(0).setCards(newHand);
		
		String test = board.handleSuggestion("Some Place", "A Person", "MiniGun", playersTest.get(0));
		//System.out.println(test);
		Assert.assertTrue(test == null);	
		board.getPlayers().get(0).setCards(hold0);
	}
	
	@Test
	public void testComputerMoveSelctionWithRoom() { //Ensures the computer will pick a room if they have not visited it last.
		ComputerPlayer testBot = new ComputerPlayer("Bot", "Nobody cares", 75);
		board.startTargets(75,  1);
		Set<BoardCell> test = board.getTargets();
		testBot.selectTarget(test);
		Assert.assertTrue(testBot.getCurrentIndex() == 52);
	}
	
	@Test
	public void testComputerMoveSelctionWithoutRoom() { //Checks to see the computer will pick one of the possible spots at random.
		ComputerPlayer testBot = new ComputerPlayer("Bot", "Nobody cares", board.calcIndex(15, 15));
		board.startTargets(board.calcIndex(15, 15),  1);
		Set<BoardCell> test = board.getTargets();
		testBot.selectTarget(test);
		Assert.assertTrue(testBot.getCurrentIndex() == board.calcIndex(14, 15)
				|| testBot.getCurrentIndex() == board.calcIndex(15, 14)
				|| testBot.getCurrentIndex() == board.calcIndex(16, 15)
				|| testBot.getCurrentIndex() == board.calcIndex(15, 16));
	}
	
	@Test
	public void testComputerMoveSelctionWithVisitedRoom() { //Checks to see the computer will pick one of the possible spots at random since the room has been visited.
		ComputerPlayer testBot = new ComputerPlayer("Bot", "Nobody cares", board.calcIndex(6, 3));
		board.startTargets(board.calcIndex(6, 3),  1);
		Set<BoardCell> test = board.getTargets();
		testBot.setLastVisited('s');
		testBot.selectTarget(test);
		Assert.assertTrue(testBot.getCurrentIndex() == board.calcIndex(6, 2)
				|| testBot.getCurrentIndex() == board.calcIndex(6, 4)
				|| testBot.getCurrentIndex() == board.calcIndex(7, 3)
				|| testBot.getCurrentIndex() == board.calcIndex(5, 3));
	}
	
	@Test
	public void testSuggestionWithOnlyOnePossible() {
		Random generator = new Random();
		ArrayList<Card> cards = board.getTestDeck(); 
		ArrayList<Card> people = new ArrayList<Card>();
		ArrayList<Card> rooms = new ArrayList<Card>();
		ArrayList<Card> weapons = new ArrayList<Card>();
	 	people.add(new Card(type.PERSON, "Joe"));
	 	weapons.add(new Card(type.WEAPON, "Gun"));
	 	rooms.add(new Card(type.ROOM, "A Place"));
		
		ComputerPlayer test = new ComputerPlayer("Bot" , "A color" , 42, weapons, people, rooms); 
		
		int rand = generator.nextInt(test.getPossibleWeapons().size());
		String weapon = test.getPossibleWeapons().get(rand).getContent();
		rand = generator.nextInt(test.getPossiblePeople().size());
		String person = test.getPossiblePeople().get(rand).getContent();
		rand = generator.nextInt(test.getPossibleRooms().size());
		String room = test.getPossibleRooms().get(rand).getContent();
		
		Assert.assertTrue(weapon.equalsIgnoreCase("gun"));
		Assert.assertTrue(room.equalsIgnoreCase("A place"));
		Assert.assertTrue(person.equalsIgnoreCase("Joe"));	
	}
	
	@Test
	public void testSuggestionWithMoreThenOnePossible() {
		Random generator = new Random();
		ArrayList<Card> cards = board.getTestDeck(); 
		ArrayList<Card> people = new ArrayList<Card>();
		ArrayList<Card> rooms = new ArrayList<Card>();
		ArrayList<Card> weapons = new ArrayList<Card>();
	 	people.add(new Card(type.PERSON, "Tim"));
	 	people.add(new Card(type.PERSON, "Joe"));
	 	rooms.add(new Card(type.ROOM, "Office"));
	 	rooms.add(new Card(type.ROOM, "Patio"));
	 	weapons.add(new Card(type.WEAPON, "Gun"));
	 	weapons.add(new Card(type.WEAPON, "Grenade"));
	 	weapons.add(new Card(type.WEAPON, "Large Puppy"));
		
		ComputerPlayer test = new ComputerPlayer("Bot" , "A color" , 42, weapons, people, rooms); 
		
		test.updatePossibilities(new Card(type.PERSON, "Tim"));
		test.updatePossibilities(new Card(type.WEAPON, "Gun"));
		
		int rand = generator.nextInt(test.getPossibleWeapons().size());
		String weapon = test.getPossibleWeapons().get(rand).getContent();
		rand = generator.nextInt(test.getPossiblePeople().size());
		String person = test.getPossiblePeople().get(rand).getContent();
		rand = generator.nextInt(test.getPossibleRooms().size());
		String room = test.getPossibleRooms().get(rand).getContent();
		
		Assert.assertTrue(weapon.equalsIgnoreCase("Grenade")  || weapon.equalsIgnoreCase("Large Puppy") || weapon.equalsIgnoreCase("Gun"));
		Assert.assertTrue(room.equalsIgnoreCase("Patio")  || room.equalsIgnoreCase("Office"));
		Assert.assertTrue(person.equalsIgnoreCase("Tim")  || person.equalsIgnoreCase("Joe"));	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
