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

public class Game {
    //array list to keep the information to each player
	static ArrayList<player> myplayer = new ArrayList<player>();
	//main method
    public static void main(String[] args) {
    	//name parameter
    	String name = "";
    	//age parameter
    	int age = 0;
    	//email parameter
    	String email = "";
    	//row parameter
    	int row = 0;
    	//col parameter
    	int col = 0;
    	
    	//int to keep how many players will play
    	//Also runs the method numberOfPlayers()
    	int howManyPlayers = numberOfPlayers();
    	//Runs the constructor class player
    	player Player = new player(name, age, email);
    	//parameter name is equal global variable in class player
    	name = Player.name;
    	//parameter age is equal global variable in class player
    	age = Player.age;
    	//parameter email is equal global variable in class player
    	email = Player.email;
    	//for loop to save players info into array list and take the info to each player
        for (int i=0;i <howManyPlayers;i++) {
        	//Print on the screen what the user should insert
    		//I used the int i to clarify for the user which information is being request
        	System.out.println("\n" + "Insert player " + (i+1) + " details");
        	//runs method name() in player
        	Player.name();
        	//runs method age() in player
        	Player.age();
        	//runs method email() in player
        	Player.email();
        	//add the info in array list
        	myplayer.add(Player);
        }
        //runs the constructor class GameBoard
        GameBoard Battleship = new GameBoard(row, col);
        //runs method GetPlayer() in GameBoard
        Battleship.GetPlayer(myplayer);
     
    }
    /*this method is run methods numberOfPlayers, name, email and age after run it 
	 * save the player info a array list, also after it is in loop
	 * to run how many times it is request.*/
    public static int numberOfPlayers(){
		//boolean to validate how many players since it can have min.1 and max.4 players
		boolean valid = false;
		int howManyPlayers;
		//Prints on the screen what the user should insert
		System.out.println("How many players will play? (Min.1 - Max.4)");
		//do while to keeps running until the number is between 1-4
		do {
			//read the user input
			Scanner players = new Scanner(System.in);
			//Save the input of how many players will play into a int
			howManyPlayers = players.nextInt();
			//Specify the condition to the do while loop stop
			if(howManyPlayers >= 1 && howManyPlayers <= 4) {
				valid = true;
			//anything else keeps running
			}else {
				valid = false;
				//message to clarify what is request
				System.out.println("Please, enter a valid number.");
			}
			//while valid is not true keeps running
		}while(valid == false);
		//when numberOfPlayers is call returns howManyPlayers
		return howManyPlayers;
	}
    
}