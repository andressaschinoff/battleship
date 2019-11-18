package Battleship;


import java.util.ArrayList;
import java.util.Scanner;

/*
 * ========================================
 *
 * Student: Andressa Martins Schinoff Alves
 * Student number: 2017280
 * Teacher: Ken Healy
 *
 * ========================================
 */


public class GameBoard {
	//ints width e height to keeps inputs 
	int width, height;
	//array 2d to print the board
	String[][] board;
	//array 2d to keep the ship
	String[][] ship;
	//int to keep hits
	int hit = 0;
	//int to keep misses
	int miss = 0;
	//int to define how long is the ship
	int shipSize;
	//int to keep input
	int row;
	//int to keep input
	int col;
	//constructor
	public GameBoard(int col, int row){
    	//calling methods
		board();
    	drawBoard();
    	GenerateBattleship();
    	//parameter equals global variable
    	this.width = col;
    	//parameter equals global variable
    	this.height = row;
	}
	
	public void board() {
		//boolean to valid
		boolean valid = false;
		//try catch to take any bug
		try {
			//do while loop to keeps running until number is between 10-20
			do {
				//message to specify what is request
				System.out.println("\n"+"Enter the number of rows between 10 and 20");
				//read input
				Scanner row = new Scanner(System.in);
				//keeps input into a global variable
				height = row.nextInt();
				//if statement to specify it condition to stop run
				if(height >= 10 && height <= 20) {
					valid = true;
				}
				//anything else keeps run
				else {
					valid = false;
					//message to clarify what is request
					System.out.println("Please insert a valid number: min.10, max.20");
				}
			}
			//keeps run until valid is true
			while(valid == false);
			//do while loop to keep running until number is between 10-20
			do {
				//message to specify what is request
				System.out.println("Enter the number of columns between 10 and 20");
				//read input
				Scanner col = new Scanner(System.in);
				//keeps input into a global variable
				width = col.nextInt();
				//if statement to specify it condition to stop run
				if(width >= 10 && width<= 20) {
					valid = true;
				}
				//anything else keeps running
				else {
					valid = false;
					//message to clarify what is request
					System.out.println("Please insert a valid number: min.10, max.20");
				}
				
			}
			//keeps run until valid is true
			while(valid == false);
			//specify number of rows and columns 
			ship = new String[height+2][width+2];
			//specify number of rows and columns
			board = new String[height+2][width+2];
			//specify what is the ship size
			shipSize = width/3;
		}
		//catch the errors
		catch (Exception e) {System.out.println("Invalid input " + e);
		}
	}
	
	//Print the empty board
	public void drawBoard() {	
		//array to fill index to column
		int[] m = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		//array to fill index to row
		int[] n = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		
		//say to user what which symbol means
		System.out.println("\n" + "This is your board : " + "\n" + "		'**' means hited and '~~' means missed" + "\n");
		//for loop to fill the board
		for(int i = 0; i < height+1; i++){
			for(int j = 0; j < width+1; j++) {
				//fill index column
				board[i][0] = String.valueOf(m[i]);
				//fill index row
				board[0][j] = String.valueOf(n[j]);
				//fill anything else
				board[i+1][j+1] = "&";
				System.out.print(board[i][j] + "\t");
				//ship is equals board
				this.ship[i][j] = board[i][j];
			}
			//print board on the screen
			System.out.println();
		}
	}
	
	//Print the board with new plays
	public void NewBoard() {
		//array to fill index to column
		int[] m = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		//array to fill index to row
		int[] n = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		
		//say to user what which symbol means
		System.out.println("\n" + "This is your board : " + "\n" + "		'**' means hited and '~~' means missed" + "\n");
		
		//for loop to fill the board
		for(int i = 0; i < height+1; i++){
			for(int j = 0; j < width+1; j++) {
				//fill index column
				board[i][0] = String.valueOf(m[i]);
				//fill index row
				board[0][j] = String.valueOf(n[j]);
				//condition to write a new symbol if it is a hit
				if (board[row][col].equals("H")){
					board[row][col] = "**";
				}
				//condition to write a new symbol if it is a miss
				else if(board[row][col].equals("M")) {
					board[row][col] = "~~";
				}
				System.out.print(board[i][j] + "\t"); 
			}
			//print board on the screen
			System.out.println();
		}
	}
	
	public void GenerateBattleship() {
		//generate a random number to define if the ship will be on horizontal or vertical position
		int a = (int) (Math.random()*2);
		//generate a random number to the column where the ship goes
		int horizontal = (int)(Math.random()*width)+1;
		//generate a random number to the row where the ship goes
		int vertical = (int)(Math.random()*height)+1;
		//fill the ship with letters
		String[] fillShip  = {"A", "B","C","D","E","F"};
		//int to keep vertical or vertical + i or vertical - i
		int v;
		//int to keep horizontal or horizontal + i or horizontal - i
		int h;
		
		//If a is 1 add or subtract to vertical
		if(a==1) {
			//loop to add or subtract the ship position
			for(int i = 0; i < shipSize; i++) {
				//if vertical + i is less than height add i
				if (vertical+i < height){
					//keep in a int vertical + i
					//made this int to be pratical
					v = vertical+i;
					//int to be pratical
					h = horizontal;
					//System.out.println(" col" + h + " row" + v);
					//fill ship with letters
					ship[v][h] = fillShip[i];
				}
				//if vertical + i is great than height sub i
				else if (vertical+i > height){
					//keep in a int vertical - i
					//made this int to be pratical
					v = vertical-i;
					//int to be pratical
					h = horizontal;
					//System.out.println(" col" + h + " row" + v);
					//fill ship with letters
					ship[v][h] = fillShip[i];
				}
			}
		}
		//If a is 0 add or subtract to horizontal	
		else {
			//loop to add or subtract the ship position
			for(int i = 0; i < shipSize; i++){
				//if horizontal + i is less than height add i
				if (horizontal+i < width){
					//int to be pratical
					v = vertical;
					//keep in a int horizontal + i
					//made this int to be pratical
					h = horizontal+i;
					//System.out.println(" col" + h + " row" + v);
					//fill ship with letters
					ship[v][h] = fillShip[i];
				}
				//if horizontal + i is great than height sub i
				else if(horizontal+i > width) {
					//int to be pratical
					v = vertical;
					//keep in a int horizontal - i
					//made this int to be pratical
					h = horizontal-i;
					//System.out.println(" col" + h + " row" + v);
					//fill ship with letters
					ship[v][h] = fillShip[i];
				}
			}
		}
	}
	//method to do validation on row input
	public void getRow() {
		//boolean to validated
		boolean valid = false;
		//do while loop to runs until row be a number equals or less than height
		do {
			//Scanner is used to read the input
			Scanner input = new Scanner(System.in);
			//Print what input the user should insert 
			System.out.println("Please, enter a row number: ");
			//input read equals variable age
			row = input.nextInt();
			//condition to stop run 
			if(row <= height) {
				valid = true;
			}
			//anything else keep runs
			else {
				valid = false;
				//message to clarify
				System.out.println("Please, pick a valid number.");
			}
		}
		//until valid is not true keeps running
		while(valid == false);
	}
	
	//method to do validation on col input
	public void getCol() {
		//boolean to validated
		boolean valid = false;
		//do while loop to runs until col be a number equals or less than width
		do {
			//Scanner is used to read the input
			Scanner input = new Scanner(System.in);
			//Print what input the user should insert 
			System.out.println("Please, enter a col number: ");
			//input read equals variable age
			col = input.nextInt();
			//condition to stop run 
			if(col <= width) {
				valid = true;
			}
			//anything else keep runs
			else {
				valid = false;
				//message to clarify
				System.out.println("Please, pick a valid number.");
			}
		}
		//until valid is not true keeps running
		while(valid == false);
	}

	public void guess() {
		//call method getRow()
		getRow();
		//call method getCol()
		getCol();
		
		//condition to be a hit
		if (ship[row][col].matches("[A-F]+")) {
			//add 1 to hit
			hit++;
			//fill the ship[row][col] position with H
			ship[row][col] = "H";
			//make board position equals ship position
			board[row][col] = ship [row][col];
			//message to user
			System.out.println("\n"+"Hey! You hit it!");
			//print a fresh board
			NewBoard();
		}
		//if it has M or H it was picked already
		else if(ship[row][col].equals("M") || ship[row][col].equals("H")){
			//message to user
			System.out.println("\n"+"Sorry! It was already picked!");
		}
		//if don't the position chosen don't match if any of the options on top
		else {
			//add 1 to miss
			miss++;
			//fill the ship[row][col] position with M
			ship[row][col] = "M";
			//make board position equals ship position
			board[row][col] = ship [row][col];
			//message to user
			System.out.println("\n" + "Sorry, you miss it!" + "\n");
			//print a fresh board
			NewBoard();
		}
	}

	
	public void GetPlayer(ArrayList<player> myplayer) {
		//boolean to valid
		boolean win = false;
		//loop to runs until players find the whole ship
		do {
			//loop to change the player
			for(int i = 0; i < myplayer.size(); i++) {
				//message to knows each player is playing
				System.out.println("\n" + "Player " + (i+1) + " turn.");
				//get the players
				myplayer.get(i);{
					//runs the guess() method
					guess();
				}
			}
			//condition to stop the game
			if(hit==shipSize) {
				//message to the winner
				System.out.println("\n"+"Hey! You win!");
				System.out.println("Hey! You win!");
				System.out.println("Hey! You win!");
				//validations is true so stops
				win = true;
			}
			//anything else continues run
			else {
				win = false;
			}
		//if win is not true keeps running 	
		}while(win==false);
	}
		
}