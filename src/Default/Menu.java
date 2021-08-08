package Default;

import java.util.Scanner;

/**
 * 
 * @author Taha Kashaf
 * Menu Class
 *
 */
public class Menu {
	
	/**
	 * The Main Method. This only calls the method for the main menu.
	 * @param args
	 */
	public static void main(String args[])
    {
    	Menu mainMenu = new Menu();
    	mainMenu.displayMenu();
    	mainMenu.processUserChoices();
    }
	
	
	/**
     * A simple method that displays menu choices
     */
	public void displayMenu()
	{
	 System.out.println("Please select one of the options below (Enter a number 0-5)");
	 System.out.println("1. Play the lottery with a range of 1 to 15");
	 System.out.println("2. Play the lottery with a custom range");
	 System.out.println("3. Play the lottery with a range of 1 to 15, over a custom number of weeks");
	 System.out.println("4. Play the lottery with a custom range, over a custom number of weeks");
	 System.out.println("5. Enter testing menu");
	 System.out.println("0. Exit");
	}
	
	
	/**
     * A large method to deal with the choice the user inputs. A while loop is used both to repeat the menu until the user selects 	exit, and to repeat the menu if an invalid input in given.
     */
	public void processUserChoices()
	{
	
		int repeat = 0;
		String userChoice = "Default";
		
		Lottery lotto = new Lottery();
		userNumbers user = new userNumbers();
		lotteryCalculations calc = new lotteryCalculations();
		
	
		while (repeat == 0) 
		{
			Scanner s = new Scanner(System.in);
			userChoice = s.nextLine();
			
			switch (userChoice)
			{
				case "1":
					System.out.println("You have selected to play the lottery with a range of 1 to 15, enter anything to continue");
					s.next();
					lotto.MySet();
					lotto.generateWinningNo(1, 16);
					user.MySet();
					user.chooseNumbers(1, 16);
					calc.winnings(calc.intersection(lotto.returnSet(), user.returnSet()), lotto.returnSet(), user.returnSet());
					System.out.println("Press anything to return to the main menu");
					s.next();
					repeat = 0;
					displayMenu();
					break;		

				case "2":
					System.out.println("You have selected to play the lottery with a custom max, enter anything to continue");
					s.next();
					System.out.println("Please enter an integer greater than 6, to act as the maximum for your lottery range.");
					int customMax = validIntInput();
					lotto.MySet();
					lotto.generateWinningNo(1, (customMax + 1));
					user.MySet();
					user.chooseNumbers(1, (customMax + 1));
					calc.winnings(calc.intersection(lotto.returnSet(), user.returnSet()), lotto.returnSet(), user.returnSet());
					System.out.println("Press anything to return to the main menu");
					s.next();
					repeat = 0;
					displayMenu();
					break;

				case "3":
					System.out.println("You have selected to play the lottery over a custom number of weeks. Please enter the number of weeks you would like to play over.");
					int noOfWeeks = validIntInputWeeks();
					calc.multiWeek(noOfWeeks);
					System.out.println("Press anything to return to the main menu");
					s.next();
					repeat = 0;
					displayMenu();
					break;
					
				case "4":
					System.out.println("You have selected to play the lottery over a custom number of weeks. Please enter the number of weeks you would like to play over.");
					int noOfWeeks2 = validIntInputWeeks();
					System.out.println("You have ALSO selected to play the lottery with a custom max, enter a whole number greater than 6, to act as this max");
					int customMax2 = validIntInput();
					calc.multiWeekCustomRange(noOfWeeks2, (customMax2 + 1));
					System.out.println("Press anything to return to the main menu");
					s.next();
					repeat = 0;
					displayMenu();
					break;
					
				case "5":
					
					Testing autoTests = new Testing();
					autoTests.runTestMenu();
					System.out.println("Press anything to return to the main menu");
					s.next();
					repeat = 0;
					displayMenu();
					break;

				case "0":
					
					System.out.println("Bye");
					repeat = 1;
					break;

				default:
					System.out.println("That is not a valid selection, please enter a valid option from the displayed Menu");
					displayMenu();
					repeat = 0;
					break;
			}    
		
		}
	
	}
	
	
	/**
	 * A method which only allows an integer greater than or equal to 6 to be inputed
	 * @return A integer greater than or equal to 6
	 */
	public int validIntInput() {
		
		int userChoice;
		Scanner s = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("Please enter a whole number greater than 6");
		do {
		    while (!s.hasNextInt()) {
		        System.out.println("That is not a valid input, enter a WHOLE NUMBER greater than 6");
		        s.next();
		    }
		    userChoice = s.nextInt();
		    while (userChoice < 6) {
		    	System.out.println("That is not a valid input, enter an number greater than 6");
		    	while (!s.hasNextInt()) {
			        System.out.println("That is not a valid input, enter a NUMBER greater than 6");
			        s.next();
			    }
		    userChoice = s.nextInt();
		    }	    
		} while (userChoice < 6);

		return userChoice;
	}

	/**
	 * A method which only allows an integer greater than or equal to 2 to be inputed
	 * @return A integer greater than or equal to 2
	 */
	public int validIntInputWeeks() {
		
		int userChoice;
		Scanner s = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("Please enter a whole number greater than 1");
		do {
		    while (!s.hasNextInt()) {
		        System.out.println("That is not a valid input, enter a WHOLE NUMBER greater than 1");
		        s.next();
		    }
		    userChoice = s.nextInt();
		    while (userChoice < 2) {
		    	System.out.println("That is not a valid input, enter an number greater than 1");
		    	while (!s.hasNextInt()) {
			        System.out.println("That is not a valid input, enter a NUMBER greater than 1");
			        s.next();
			    }
		    userChoice = s.nextInt();
		    }	    
		} while (userChoice < 2);

		return userChoice;
	}

}
