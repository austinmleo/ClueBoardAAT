package Board;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Random;

import Board.Card.type;
import Board.RoomCell.DoorDirection;


//Authors: Arnaud Filliat and Vy Ta
//Make sure to note that for the cells we use (x,y) coordinates so (column, row)
public class Board {

	private ArrayList<BoardCell> cells;
	private int numRows;
	private int numColumns;
	private Map<Character, String> rooms;
	private Map<Integer, ArrayList<Integer>> adjs = new HashMap<Integer, ArrayList<Integer>>();
	private LinkedList<Integer> adjList;
	private ArrayList<Integer> visited = new ArrayList<Integer>();
	private Set<BoardCell> targets = new HashSet<BoardCell>();
	private String LegendFile;
	private String BoardFile;
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<Card> testDeck = new ArrayList<Card>(); //Only used for testing.
	private ArrayList<Card> Solution = new ArrayList<Card>();
	
	public Board(String BoardFile, String LegendFile) {	
		this.LegendFile = LegendFile;
		this.BoardFile = BoardFile;
		try {
		loadConfigFiles();
		calcAdjacencies();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public Board() {
		this.BoardFile = "ClueLayout.csv";
		this.LegendFile = "legend.txt";
		try {
		loadConfigFiles();
		calcAdjacencies();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public void loadConfigFiles() {
		try {
			loadLegend(LegendFile);
			loadBoard(BoardFile);
			loadPlayers("People.txt");
			loadCards("cards.txt");
			dealCards();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadBoard(String fileName) throws BadConfigException, FileNotFoundException {
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		cells = new ArrayList<BoardCell>();
		numRows = 0;
		numColumns = -1;

		while(in.hasNextLine()){
			String line = in.nextLine();
			String[] line2 = line.split(",");

			//check columns
			if(line2.length != numColumns && numColumns != -1){
				throw new BadConfigException();
			}
			numColumns = line2.length;

			//add celldata to arraylist
			for(int i = 0; i < line2.length; i++){

				//adds doors
				if(line2[i].length() == 2){
					if(line2[i].charAt(1) == 'U'){
						cells.add(new RoomCell(i, numRows, RoomCell.DoorDirection.UP, line2[i].charAt(0)));
					}else if(line2[i].charAt(1) == 'D'){
						cells.add(new RoomCell(i, numRows, RoomCell.DoorDirection.DOWN, line2[i].charAt(0)));
					}else if(line2[i].charAt(1) == 'R'){
						cells.add(new RoomCell(i, numRows, RoomCell.DoorDirection.RIGHT, line2[i].charAt(0)));
					}else if(line2[i].charAt(1) == 'L'){
						cells.add(new RoomCell(i, numRows, RoomCell.DoorDirection.LEFT, line2[i].charAt(0)));
					} else {
						throw new BadConfigException();
					}
				} else{
					//add walkway
					if( line2[i].equalsIgnoreCase("w")){
						cells.add(new WalkwayCell(i, numRows));
						
						//add other rooms
					} else if(rooms.containsKey((Character)line2[i].charAt(0))){
						cells.add(new RoomCell(i, numRows, RoomCell.DoorDirection.NONE, line2[i].charAt(0)));
					} else {
						throw new BadConfigException();
					}
				}
			}
			numRows++;
		}
	}

	public void loadLegend(String fileName) throws FileNotFoundException, BadConfigException {
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		rooms = new HashMap<Character, String>();

		while(in.hasNextLine()){
			String line = in.nextLine();
			String line2 = line.substring(3);

			//check format
			if(line.charAt(1) == ',' && !line2.contains(",")) {
				rooms.put(line.charAt(0), line.substring(3));
			} else {
				throw new BadConfigException();
			}
		}
	}

	public void loadPlayers(String fileName) throws BadConfigException, FileNotFoundException {
		
			FileReader reader = new FileReader(fileName);
			Scanner in = new Scanner(reader);
			players.clear();
			
			while(in.hasNextLine()){
				String line = in.nextLine();
				String[] data = line.split(",");
				
				String name = data[0];
				String color = data[1];
				String spot = data[2];
				int index = Integer.parseInt(spot);
				
				Player next = new Player (name, color, index);
				players.add(next);				
			}
	}
			
	public void loadCards(String fileName) throws BadConfigException, FileNotFoundException  {
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		deck.clear();
		type cardType;
		
		while(in.hasNextLine()){
			String line = in.nextLine();
			String[] data = line.split(",");
			
			if (data[0].equalsIgnoreCase("w"))
				 cardType = type.WEAPON;
			else if (data[0].equalsIgnoreCase("p"))
				cardType = type.PERSON;
			else
				cardType = type.ROOM;
			
			String content = data[1];
			
			Card next = new Card  (cardType, content);
			deck.add(next);				
		}	
		
		testDeck.clear();
		for(int i = 0; i < deck.size() ; i++) {
			testDeck.add(deck.get(i));
		}
		
		
		//testDeck = deck;
	}
	
	public void dealCards () {
		System.out.println(testDeck);
		Random generator = new Random();
		int choice = generator.nextInt(9);
		Solution.add(deck.get(choice + 12));
		deck.remove(choice + 12);
		choice = generator.nextInt(6);
		Solution.add(deck.get(choice + 6));
		deck.remove(choice + 6);
		choice = generator.nextInt(6);
		Solution.add(deck.get(choice));
		deck.remove(choice);
		//System.out.println("Soln " + Solution);
		
		while(!(deck.isEmpty())) {
			for (int i = 0 ; i < players.size(); i++) {
				choice = generator.nextInt(deck.size());
				players.get(i).getCards().add(deck.get(choice));
				//if(i != 5)
				//	players.get(i +1).getCards().add(deck.get(choice));
				//else
				//	players.get(1).getCards().add(deck.get(choice));
				//System.out.println("Gave " + players.get(i).getName() + deck.get(choice));
				deck.remove(choice);
				if (deck.isEmpty())
					break;
			}
		}
	}
	
	public int getNumRows() {
		return numRows;
	}

	public int getNumColumns(){
		return numColumns;
	}

	public RoomCell getRoomCellAt(int column, int row){
		int index = calcIndex(column, row);
		if(cells.get(index).isRoom()){
			return (RoomCell) cells.get(index);
		} else {
			return null;
		}
	}
	
	public RoomCell getRoomCellAt(int index){
		if(cells.get(index).isRoom()){
			return (RoomCell) cells.get(index);
		} else {
			return null;
		}
	}

	public BoardCell getCellAt(int index){
		BoardCell cell = cells.get(index);
		return cell;
	}
	
	public int calcIndex(int col, int row) {
		if (col == this.getNumColumns() && row == this.getNumRows()) {
			return calcIndex(col -1, row -1);
		}
 		else {return col + row*(numColumns);}
	}

	public Map<Character, String> getRooms() {
		return rooms;
	}

	public void calcAdjacencies() {
		int index;
		for (index = 0; index <= calcIndex(getNumColumns(), getNumRows()); index ++ ) {
			
			if(index > 117){
			int i = 0;
			}
			
			
			ArrayList<Integer> spots = new ArrayList<Integer>();
			if (cells.get(index).isWalkway() || cells.get(index).isDoorway()) {
				if ((index+1) % (getNumColumns()) != 0) {
					RoomCell testRoom = getRoomCellAt(index + 1);
					if (cells.get(index + 1).isWalkway()|| ((cells.get(index + 1).isDoorway()) && testRoom.getDoorDirection() == DoorDirection.LEFT )){
						spots.add(index + 1);
					}
				}
				if (index % getNumColumns() != 0){
					RoomCell testRoom = getRoomCellAt(index - 1);
					if (cells.get(index - 1).isWalkway() || ((cells.get(index - 1).isDoorway()) && testRoom.getDoorDirection() == DoorDirection.RIGHT )) {
						spots.add(index - 1);
					}
				}
				if ((index + this.getNumColumns()) <= calcIndex(this.getNumColumns(), this.getNumRows())){
					RoomCell testRoom = getRoomCellAt(index + this.getNumColumns());
					if (cells.get(index + this.getNumColumns()).isWalkway() || ((cells.get(index + this.getNumColumns()).isDoorway()) && testRoom.getDoorDirection() == DoorDirection.UP )) {
						spots.add(index + this.getNumColumns());
					}
				}
				if (index - this.getNumColumns() >= 0){
					RoomCell testRoom = getRoomCellAt(index - this.getNumColumns());
					if (cells.get(index - this.getNumColumns()).isWalkway() || ((cells.get(index - this.getNumColumns()).isDoorway()) && testRoom.getDoorDirection() == DoorDirection.DOWN )) {
						spots.add(index - this.getNumColumns());
					}
				}
			}	
			adjs.put(index, spots);
			//System.out.println("Cell indexed " + index + " " + adjs.get(index));
		}
	}
	
	public ArrayList<Integer> getAdjList(int index) {
		return adjs.get(index);
	}
	
	public void startTargets(int index, int numSteps){
		visited.clear();
		visited.add(index);
		targets.clear();
		calcTargets(index, numSteps);
	}
	
	public void calcTargets(int index, int numSteps) {
		ArrayList<Integer> possibleSpots = new ArrayList<Integer>();
		for (Integer i : getAdjList(index)) {
			if (!(visited.contains(i))) {
				possibleSpots.add(i);
			}
		}
		
		for (Integer j: possibleSpots) {
			visited.add(j);
			if (this.getCellAt(j).isDoorway())
				targets.add(this.getCellAt(j));
			else if (numSteps == 1) {
				targets.add(this.getCellAt(j));
				visited.remove(j);
			}
			else {		
				calcTargets(j, numSteps - 1);
				visited.remove(j);
			}
		}
	}
	
	public Set<BoardCell> getTargets() {
		return targets;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public ArrayList<Card> getTestDeck() {
		return testDeck;
	}
	
	public static void main(String [ ] args) {

		//Board b = new Board("ClueLayout.csv" , "Legend.txt");
		Board b = new Board("ClueLayouttest.csv", "ClueLegend.txt");
		//System.out.println(b.getAdjList(7));
		//System.out.println(b.getAdjList(505));
		//System.out.println(b.getAdjList(b.calcIndex(15,6)));
		//System.out.println(b.getAdjList(b.calcIndex(7,4)));
		//System.out.println(b.getNumRows());
		//System.out.println(b.getNumColumns());
		//System.out.println(b.calcIndex(b.getNumColumns(), b.getNumRows()));
		
	}
}
