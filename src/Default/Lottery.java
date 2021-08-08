package Default;

import java.util.Set;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Taha Kashaf
 * 02/08/18
 * This class deals with the Lottery Set.
 */
public class Lottery {

	private Set<Integer> lotterySet;
	
	/**
	 * This method just creates a set named lotterySet
	 */
	public void MySet() {
		lotterySet = new HashSet<Integer>();
	}
	
	/**
	 * This method will attempt to add an integer to the set. The integer will only be added if it does not already exist in the set.
	 * @param number The number you would like to add to the set
	 */
	public void addToSet(int number) {
		lotterySet.add(number);
	}
	
	/**
	 * This method prints all the elements of the set
	 */
	public void printSet() {
		System.out.println(lotterySet);
	}
	
	/**
	 * This method returns the cardinality of the set.
	 * @return Number of elements in the set.
	 */
	public int cardinality() {
		return lotterySet.size();
	}
	
	/**
	 * This method adds 6 different randomly generated integers to the lotterySet as elements. These are the winning lottery numbers. The method allows a custom definition for the range.
	 * @param min The minimum for the range in which the lottery is played.
	 * @param maxPlusOne The maximum (plus one) for the range in which the lottery is played.
	 */
	public void generateWinningNo(int min, int maxPlusOne) {
		while (cardinality() != 6) {
			addToSet(randomNo(min, maxPlusOne));
		}
	}
	
	/**
	 * A method which returns a random integer within a specified range.
	 * @param min The minimum for the range.
	 * @param maxPlusOne The maximum (plus one) for the range.
	 * @return A random integer in the specified range.
	 */
	public int randomNo(int min, int maxPlusOne) {
		return ThreadLocalRandom.current().nextInt(min, maxPlusOne);
	}
	
	/**
	 * This method returns a reference to the lotterySet.
	 * @return A reference to lotterySet.
	 */
	public Set<Integer> returnSet() {
		return lotterySet;
	}

}

