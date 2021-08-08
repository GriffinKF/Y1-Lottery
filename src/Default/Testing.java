package Default;

import java.util.Scanner;

public class Testing {

	Lottery testLotto = new Lottery();
	userNumbers testUserNumbers = new userNumbers();
	lotteryCalculations testCalcs = new lotteryCalculations();
	
	/**
	 * Menu letting you choose which test to run
	 */
	public void runTestMenu()
    {
        String choice;
        boolean exit=false;
        Scanner s = new Scanner(System.in);
        
        do
        {
        	System.out.println(" ");
        	System.out.println("Test Menu");
            System.out.println("A - Test 1");
            System.out.println("B - Test 2");
            System.out.println("C - Test 3");
            System.out.println("D - Test 4");
            System.out.println("E - Test 5");
            System.out.println("F - Test 6");
            System.out.println("G - Test 7");
            //System.out.println("H - Test 8");
            //System.out.println("I - Test 8");
            System.out.println("H - quit");        
            
            
            
            choice= s.next();
        
            switch (choice)
            {
                case "A":
            		System.out.println("Details of the tests can be found in program documentation");
            		System.out.println("Test 1 Results:");
                	test1();
                	break;
                case "B":
                	System.out.println("Details of the tests can be found in program documentation");
            		System.out.println("Test 2 Results:");
                	test2();
                	break;
                case "C":
                	System.out.println("Details of the tests can be found in program documentation");
            		System.out.println("Test 3 Results:");
                	test3();
                	break;
                case "D":
                	System.out.println("Details of the tests can be found in program documentation");
            		System.out.println("Test 4 Results:");
                	test4();
                	break;
                case "E":
                	System.out.println("Details of the tests can be found in program documentation");
            		System.out.println("Test 5 Results:");
                	test5();
                	break;
                case "F":
                	System.out.println("Details of the tests can be found in program documentation");
            		System.out.println("Test 6 Results:");
                	test6();
                	break;
                case "G":
                	System.out.println("Details of the tests can be found in program documentation");
            		System.out.println("Test 7 Results:");
                	test7();
                	break;
                //case "H":
                	//System.out.println("Details of the tests can be found in program documentation");
            		//System.out.println("Test 8 Results:");
                	//test8();
                	//break;
                //case "I":
                	//System.out.println("Details of the tests can be found in program documentation");
            		//System.out.println("Test 9 Results:");
                	//test9();
                	//break;
                case "H":
                	System.out.println("Goodbye\n");
                      exit=true;
                        break;
                default: System.out.println("That is not a valid choice, please try again");
                        break;         
            }
        } while (!exit);
    }
	
	/**
	 * The first test. Adds two different values to the set, then prints the set.
	 */
	public void test1() {
		testLotto.MySet();
		testLotto.addToSet(44);
		testLotto.addToSet(45);
		testLotto.printSet();
	}
	
	/**
	 * The second test, adds 3 values to the set, 2 of which are identical. And then prints the set. The printed set should only display the two different values.
	 */
	public void test2() {
		testLotto.MySet();
		testLotto.addToSet(44);
		testLotto.addToSet(45);
		testLotto.addToSet(45);
		testLotto.printSet();
		System.out.println("This Set has a Cardinality of " + testLotto.cardinality());
	}

	/**
	 * The third test, tests the generation of a random winning lottery number in between a specified range.
	 */
	public void test3() {
		testLotto.MySet();
		testLotto.generateWinningNo(1, 11);
		System.out.println("The winning numbers are");
		testLotto.printSet();
	}
	
	/**
	 * The fourth test, tests the user being able to select an integer within a range.
	 */
	public void test4() {
		int userInput = testUserNumbers.validIntInput(1, 11);
		System.out.print(userInput);
	}
	
	/**
	 * The fifth test, tests the user being able to select an integer within a specified range. Adds that integer to the users selections set, and asks the user for another selection until 6 different entries are given.
	 */
	public void test5() {
		testUserNumbers.MySet();
		testUserNumbers.chooseNumbers(1, 11);
	}
	
	/**
	 * The sixth test, tests the intersection function that compares the user selection with the winning numbers
	 */
	public void test6() {
		testLotto.MySet();
		testLotto.generateWinningNo(1, 11);
		System.out.println("For testing purposes, the winning numbers are:");
		testLotto.printSet();
		testUserNumbers.MySet();
		testUserNumbers.chooseNumbers(1, 11);
		testCalcs.intersectionPrint(testLotto.returnSet(), testUserNumbers.returnSet());
	}
	
	/**
	 * The seventh test, tests the intersection function that compares the user selection with the winning numbers, as well as outputting how much the user has won, if anything.
	 */
	public void test7() {
		testLotto.MySet();
		testLotto.generateWinningNo(1, 11);
		System.out.println("For testing purposes, the winning numbers are:");
		testLotto.printSet();
		testUserNumbers.MySet();
		testUserNumbers.chooseNumbers(1, 11);
		testCalcs.winnings(testCalcs.intersection(testLotto.returnSet(), testUserNumbers.returnSet()), testLotto.returnSet(), testUserNumbers.returnSet());
	}


}

