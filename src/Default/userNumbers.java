package Default;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;



public class userNumbers {

	private Set<Integer> userSet;
	
	public void MySet() {
		userSet = new HashSet<Integer>();
	}
	
	/**
	 * This method will attempt to add an integer to the set. The integer will only be added if it does not already exist in the set.
	 * @param number The number you would like to add to the set
	 */
	public void addToSet(int number) {
		userSet.add(number);
	}
	
	/**
	 * This method prints all the elements of the set
	 */
	public void printSet() {
		System.out.println(userSet);
	}
	
	/**
	 * This method returns the cardinality of the set.
	 * @return Number of elements in the set.
	 */
	public int cardinality() {
		return userSet.size();
	}
	
	/**
	 * This method checks if the set already contains an integer passed to it.
	 * @param userSelection The integer passed to the method to be checked.
	 * @return True if the integer is already in the set, False if not.
	 */
	public boolean contains(int userSelection) {
		 return userSet.contains(userSelection);
	}
	
	/**
	 * A method that returns a reference to the set containing the users selection.
	 * @return A reference to the set containing the users selection
	 */
	public Set<Integer> returnSet() {
		return userSet;
	}
	
	/**
	 * A method allowing the user to select 6 different numbers to act as there lottery numbers.
	 * @param min Always 1.
	 * @param maxPlusOne The max range for the lottery (plus 1)
	 */
	public void chooseNumbers(int min, int maxPlusOne) {
		
		System.out.println("Please pick the first (of 6) numbers you would like to select for your lottery ticket, only select values between " + min + " and " + (maxPlusOne -1));
		int userSelection = validIntInput(min, maxPlusOne);
		addToSet(userSelection);
		
		
		System.out.println("Please pick the second (of 6) numbers you would like to select for your lottery ticket, only select values that have not already been selected between " + min + " and " + (maxPlusOne -1));
		System.out.println("Your current selection is");
		printSet();
		userSelection = validIntInput(min, maxPlusOne);
		
		while (contains(userSelection) == true) {
			System.out.println("You have already selected that number, please select a different number between " + min + " and " + (maxPlusOne -1));
			System.out.println("Your current selection is");
			printSet();
			userSelection = validIntInput(min, maxPlusOne);
		}
		
		addToSet(userSelection);
		
		System.out.println("Please pick the third (of 6) numbers you would like to select for your lottery ticket, only select values that have not already been selected between " + min + " and " + (maxPlusOne -1));
		System.out.println("Your current selection is");
		printSet();
		userSelection = validIntInput(min, maxPlusOne);
		
		while (contains(userSelection) == true) {
			System.out.println("You have already selected that number, please select a different number between " + min + " and " + (maxPlusOne -1));
			System.out.println("Your current selection is");
			printSet();
			userSelection = validIntInput(min, maxPlusOne);
		}
		
		addToSet(userSelection);
		
		System.out.println("Please pick the fourth (of 6) numbers you would like to select for your lottery ticket, only select values that have not already been selected between " + min + " and " + (maxPlusOne -1));
		System.out.println("Your current selection is");
		printSet();
		userSelection = validIntInput(min, maxPlusOne);
		
		while (contains(userSelection) == true) {
			System.out.println("You have already selected that number, please select a different number between " + min + " and " + (maxPlusOne -1));
			System.out.println("Your current selection is");
			printSet();
			userSelection = validIntInput(min, maxPlusOne);
		}
		
		addToSet(userSelection);
		
		System.out.println("Please pick the fifth (of 6) numbers you would like to select for your lottery ticket, only select values that have not already been selected between " + min + " and " + (maxPlusOne -1));
		System.out.println("Your current selection is");
		printSet();
		userSelection = validIntInput(min, maxPlusOne);
		
		while (contains(userSelection) == true) {
			System.out.println("You have already selected that number, please select a different number between " + min + " and " + (maxPlusOne -1));
			System.out.println("Your current selection is");
			printSet();
			userSelection = validIntInput(min, maxPlusOne);
		}
		
		addToSet(userSelection);
		
		System.out.println("Please pick the sixth (of 6) numbers you would like to select for your lottery ticket, only select values that have not already been selected between " + min + " and " + (maxPlusOne -1));
		System.out.println("Your current selection is");
		printSet();
		userSelection = validIntInput(min, maxPlusOne);
		
		while (contains(userSelection) == true) {
			System.out.println("You have already selected that number, please select a different number between " + min + " and " + (maxPlusOne -1));
			System.out.println("Your current selection is");
			printSet();
			userSelection = validIntInput(min, maxPlusOne);
		}
		
		addToSet(userSelection);
		
		System.out.println("Your selected numbers are");
		printSet();
		
	}
	
	/**
	 * 
	 * This method asks the user to input an Int that fits into a specified range. Depending on what type of lottery they want to play. This has validation built into it.
	 * @return int This returns an int which is a valid number that the user has selected.
	 * @param min The minimum for the user input, always 1.
	 * @param maxPlusOne The maximum allowed user input (plus 1)
	 * 
	 */
	public int validIntInput(int min, int maxPlusOne) {
		
		int userChoice;
		Scanner s = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("Please enter a whole number between 1 and " + (maxPlusOne - 1));
		do {
		    while (!s.hasNextInt()) {
		        System.out.println("That is not a valid input, enter a WHOLE NUMBER from 1 to " + (maxPlusOne - 1));
		        s.next();
		    }
		    userChoice = s.nextInt();
		    while (userChoice < 1 || userChoice >= maxPlusOne) {
		    	System.out.println("That is not a valid input, enter an number FROM 1 TO " + (maxPlusOne - 1));
		    	while (!s.hasNextInt()) {
			        System.out.println("That is not a valid input, enter a NUMBER from 1 to " + (maxPlusOne - 1));
			        s.next();
			    }
		    userChoice = s.nextInt();
		    }	    
		} while (userChoice < 1 || userChoice >= maxPlusOne);

		return userChoice;
	}

}
