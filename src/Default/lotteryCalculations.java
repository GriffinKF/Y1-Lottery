package Default;

import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author Taha Kashaf
 * Lottery Calculations class. Handles the comparisons between sets containing user selections and the winning lottery numbers.
 *
 */
public class lotteryCalculations {
	

	/**
	 * A method that handles the comparison between 2 sets to see how many correct numbers the user has selected. Uses temporary references to the actual sets so that the original sets are not modified.
	 * @param tempLotterySet A reference to the set containing the winning lottery numbers.
	 * @param tempUserSet A reference to the set containing the users selected lottery numbers.
	 * @return The number of matching elements.
	 */
	public int intersection(Set<Integer> tempLotterySet, Set<Integer> tempUserSet) {
		tempUserSet.retainAll(tempLotterySet);
		int numberOfMatches = tempUserSet.size();
		//System.out.println("The number of matching numbers is " + numberOfMatches);
		return numberOfMatches;
	}
	
	/**
	 * A method that handles the comparison between 2 sets to see how many correct numbers the user has selected. Uses temporary references to the actual sets so that the original sets are not modified. Also prints out the number of matching elements.
	 * @param tempLotterySet A reference to the set containing the winning lottery numbers.
	 * @param tempUserSet A reference to the set containing the users selected lottery numbers.
	 * @return The number of matching elements.
	 */
	public int intersectionPrint(Set<Integer> tempLotterySet, Set<Integer> tempUserSet) {
		tempUserSet.retainAll(tempLotterySet);
		int numberOfMatches = tempUserSet.size();
		//System.out.println("The number of matching numbers is " + numberOfMatches);
		return numberOfMatches;
	}
	
	/**
	 * A method that uses the number of matching elements to tell the user how much the have one.
	 * @param numberOfMatches The number of matching elements between the two sets.
	 * @param tempLotterySet A reference to the set containing the winning lottery numbers.
	 * @param tempUserSet A reference to the set containing the users selected lottery numbers.
	 */
	public void winnings(int numberOfMatches, Set<Integer> tempLotterySet, Set<Integer> tempUserSet) {
		if (numberOfMatches < 3) {
			System.out.println("The winning numbers were");
			System.out.println(tempLotterySet);
			System.out.println("Your matching numbers were");
			System.out.println(tempUserSet);
			System.out.println("You had less than 3 matches.");
			System.out.println("You win NOTHING");
		} else if (numberOfMatches == 3) {
			System.out.println("The winning numbers were");
			System.out.println(tempLotterySet);
			System.out.println("Yourmatching numbers were");
			System.out.println(tempUserSet);
			System.out.println("You had 3 matches.");
			System.out.println("You win $25, congrats");
		} else if (numberOfMatches == 4) {
			System.out.println("The winning numbers were");
			System.out.println(tempLotterySet);
			System.out.println("Your matching numbers were");
			System.out.println(tempUserSet);
			System.out.println("You had 4 matches.");
			System.out.println("You win $100, congrats");
		} else if (numberOfMatches == 5) {
			System.out.println("The winning numbers were");
			System.out.println(tempLotterySet);
			System.out.println("Your matching numbers were");
			System.out.println(tempUserSet);
			System.out.println("You had 5 matches.");
			System.out.println("You win $1000, congrats");
		} else if (numberOfMatches == 6) {
			System.out.println("The winning numbers were");
			System.out.println(tempLotterySet);
			System.out.println("Your matching numbers were");
			System.out.println(tempUserSet);
			System.out.println("You had 6 matches.");
			System.out.println("YOU HIT THE JACKPOT, YOU WIN ONE MILLION DOLLARS");
		}
	}

	/**
	 * A method that combines winnings() and intersection() to allow the lottery to be played over a specified number of weeks.
	 * @param noOfWeeks The number of weeks the user wants to play over.
	 */
	public void multiWeek(int noOfWeeks) {
		
		userNumbers user = new userNumbers();
		Scanner s = new Scanner(System.in);
		System.out.println("You have selected to play the lottery with a range of 1 to 15, over " + noOfWeeks + " weeks, press anything to continue.");
		s.next();
		user.MySet();
		user.chooseNumbers(1, 16);
		
		for(int i = 1; i <= noOfWeeks; i++) {
			Lottery lotto = new Lottery();
			lotto.MySet();
			lotto.generateWinningNo(1, 16);
			System.out.println("");
			System.out.println("Week " + i + " Results:");
			winnings(intersection(lotto.returnSet(), user.returnSet()), lotto.returnSet(), user.returnSet());
		}
		
	}
	
	/**
	 * A method that combines winnings() and intersection() to allow the lottery to be played over a specified number of weeks, while also allowing a custom range via a user inputed max.
	 * @param noOfWeeks The number of weeks the user wants to play over.
	 * @param maxPlusOne The user selected max range (Plus 1)
	 */
	public void multiWeekCustomRange(int noOfWeeks, int maxPlusOne) {
		
		userNumbers user = new userNumbers();
		Scanner s = new Scanner(System.in);
		System.out.println("You have selected to play the lottery with a custom range of 1 to " + (maxPlusOne - 1) + " over " + noOfWeeks + " weeks, press anything to continue.");
		s.next();
		user.MySet();
		user.chooseNumbers(1, maxPlusOne);
		
		for(int i = 1; i <= noOfWeeks; i++) {
			Lottery lotto = new Lottery();
			lotto.MySet();
			lotto.generateWinningNo(1, maxPlusOne);
			System.out.println("");
			System.out.println("Week " + i + " Results:");
			winnings(intersection(lotto.returnSet(), user.returnSet()), lotto.returnSet(), user.returnSet());
		}
		
	}
	
}
