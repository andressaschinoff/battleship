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


public class player {

	//Save age into a integer
	int age;
	//Name global variable that contains substrings firstName and surname
	String name = "", firstName = "", surname = "";
	//Email global variable
	String email;
	//int to keep hits to each player
	int hit;
	//int to keep misses to each player
	int miss;
	
	//constructor
	public player(String name, int age, String email) {
		//variables equals parameters 
		this.name = name;
		this.age = age;
		this.email = email;
	}	
	

	public void name() {
		//Boolean to look at if it has spaces
		boolean spaceUsed;
		//int to recognise spaces
		int spaceAt;
		
		//boolean value to validate
		boolean valid = false;
		//do while loop to keep running until the input is the full name
		do {
			//Read the input
			Scanner fullName = new Scanner(System.in);
			//Print in the screen which input the user should insert
			System.out.println("What is your full name?");
			//Save the input as a variable
			name = fullName.nextLine();
			//It is to eliminate the space the user can insert for accident, but consider the space between words
			name = name.trim();
			//It is to find the space between first name and surname
			spaceUsed = name.contains(" ");

			//I used the if Statement to do 2 things first to valid the input
			//but also to recognise the first name and surname
			if (spaceUsed) {
				valid = true;
		
				//It is used to recognise the space in the variable, it could be any type of variable
				spaceAt = name.indexOf(' ');
				//Recognise everything is insert before the first space and becomes it into a new variable
				firstName = name.substring(0,spaceAt);
				//Take everything after the first space and becomes it into another variable
				surname = name.substring(spaceAt+1,name.length());
				
			//if it not have first name and surname it's not valid
			}else {
				valid = false;
				//Print in the screen the error message, helping the user solve the problem
				System.out.println("Please, enter your first name and surname.");
			}
		//Anything else is not valid keeps running
		}while(valid == false);
		
	}
	
	public int age() {
		
		//Boolean to valid 
		boolean valid = false;
		//do while loop to keeps running until the right age is inserted
		do {
			//Scanner is used to read the input
			Scanner ageInput = new Scanner(System.in);
			//Print what input the user should insert 
			System.out.println("What is your age?");
			//input read equals variable age
			age = ageInput.nextInt();
			//if statement used to specify the age
			if(age >= 12 && age <= 100) {
				valid = true;
			}
			//anything else keeps running
			else {
				valid = false;
				//message to clarify what is requesting
				System.out.println("Sorry you need have between 12 and 100 to play.");
			}
		}
		//keep it runing until the age be rigth
		while(valid == false);
		//when the methods age is called return the int age
		return age;
	}
	
	 
	public void email() {
		//boolean to valid and stop the do while loop
		boolean valid = false;
		//boolean to valid if it has @
		boolean validAT;
		//boolean to valid if it has .com
		boolean validDotCom;
		//boolean to valid if it has .ie
		boolean validDotIE;
		//do while loop to keeps running until a valid email is inserted
		do {
			//Read the user input
			Scanner emailInput = new Scanner(System.in);
			//Print on screen what input the user should insert
			System.out.println("What is your email?");
			//save the user input as a variable email
			email = emailInput.nextLine();
			//I used 3 variables to look if the variable email contains "@", ".com" and ".ie"
			//I don`t know if has how look the 3 info in the same variable
			//But it was the way I find to validate correctly
			//is true if contains @
			validAT = email.contains("@");
			//is true if contains .com
			validDotCom = email.contains(".com");
			//is true if contains .ie
			validDotIE = email.contains(".ie");
			
			//Use the if statement specify the condition to stop running
			//it`s valid just if it has @ and .com OR @ and .ie
			if(validAT && (validDotCom || validDotIE)) {
				valid = true;
			}
			//Any email the don't contains @ or .com/.ie is not valid
			else {
				valid = false;
				//message to clarify what is request
				System.out.println("Please, enter a valid email.");
			}
		}
		//keeps running until valid is true
		while(valid == false);
	}
}
