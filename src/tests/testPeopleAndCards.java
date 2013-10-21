package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import Board.Board;
import Board.Card;
import Board.Card.type;
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
		Assert.assertTrue(test.get(0).getColor().equalsIgnoreCase("White"));
		Assert.assertTrue(test.get(0).getCurrentIndex() == 8);
		
		Assert.assertTrue(test.get(1).getName().equalsIgnoreCase("The Boss"));
		Assert.assertTrue(test.get(1).getColor().equalsIgnoreCase("Black"));
		Assert.assertTrue(test.get(1).getCurrentIndex() == 14);
		
		Assert.assertTrue(test.get(2).getName().equalsIgnoreCase("King Awesome"));
		Assert.assertTrue(test.get(2).getColor().equalsIgnoreCase("Purple"));
		Assert.assertTrue(test.get(2).getCurrentIndex() == 160);
		
		Assert.assertTrue(test.get(3).getName().equalsIgnoreCase("Uncle Sam"));
		Assert.assertTrue(test.get(3).getColor().equalsIgnoreCase("Red"));
		Assert.assertTrue(test.get(3).getCurrentIndex() == 522);
		
		Assert.assertTrue(test.get(4).getName().equalsIgnoreCase("Some Guy"));
		Assert.assertTrue(test.get(4).getColor().equalsIgnoreCase("Teal"));
		Assert.assertTrue(test.get(4).getCurrentIndex() == 512);
		
		Assert.assertTrue(test.get(5).getName().equalsIgnoreCase("A Girl"));
		Assert.assertTrue(test.get(5).getColor().equalsIgnoreCase("Pink"));
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
	public void testAllCardsDealt() {
		ArrayList<Card> test = board.getDeck();
		Assert.assertTrue(test.size() == 0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
