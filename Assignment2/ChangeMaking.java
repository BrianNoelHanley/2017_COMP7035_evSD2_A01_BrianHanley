/*
 * Author : Brian Hanley
 * Student Number: 00015775
 * Assignment 2 , Hint 3
 * Last Modified: 30/11/17
 */

public class ChangeMaking {
	/**
	 * Method: testChangeMaking
	 * 
	 * Tests and compares the algorithm for making change.
	 */
	public static void testChangeMaking()
	{
	
			int[] denoms = new int[4];

			// possible changes of coins 
			denoms[0]=20; // coin of value 20
			denoms[1]=10; // coin of value 10
			denoms[2]=5;  // coin of value 5
			denoms[3]=1;  // coin of value 1
	
			int val1 = 0; // maximum amount of money
			int val2 = 35; // maximum amount of money
			int val3 = 53; // maximum amount of money
			int val4 = 103; // maximum amount of money
			int val5 = -53; // maximum amount of money
			
		    System.out.println("(Greedy solution) Number of coins needed: " + makeChangeGreedy(denoms, val1));
			System.out.println("(Greedy solution) Number of coins needed: " + makeChangeGreedy(denoms, val2));
			System.out.println("(Greedy solution) Number of coins needed: " + makeChangeGreedy(denoms, val3));
			System.out.println("(Greedy solution) Number of coins needed: " + makeChangeGreedy(denoms, val4));
			System.out.println("(Greedy solution) Number of coins needed: " + makeChangeGreedy(denoms, val5));

	
	}

	/**
	 * Method: makeChangeGreedy
	 * 
	 * Implements the greedy algorithm for solving
	 * the change making problem.
	 * 
	 * @param denoms array containing the different denominations
	 * @param val the target sum
	 * @return the number of coins needed
	 */
	public static int makeChangeGreedy(int[] denoms, int val) {
		int curBal = 0;  // Contains the current balance the coins are adding to.
		int coinCounter = 0;  // Counts the number of coins used
		int denomValPointer = 0;  // Is used as a pointer in the denom[], to point to different denominations.

		System.out.print("\n\n"); // Used for formatting the output

		// if statement to check for a positive int to be calculated.
		if (val > 0) {  
			
			// while statement checks and runs if the current result is less then the target
			while (curBal < val) {

				// If statement checks if the denomination currently being referenced within the array is not 
				//    greater then the difference between the existing balance and target balance.
				if ((val - curBal) >= denoms[denomValPointer]) {

					// Adds the value that is referenced to within the array to the current balance.
					curBal += denoms[denomValPointer];

					// As a 'coin' has been used the var coinCounter is incremented.
					coinCounter++;

					// prints to the console the value of the coin used throughout the iteration process.
					System.out.println("\t +" + denoms[denomValPointer]);
				} 
				
				// Is the current denomination being referenced is too big to be used, increment 'denomValPointer' 
				//    to point to a lesser value denomination within the array.
				else {
					// As the parameters are of type integer and the smallest denomination is 1,
					//  there is no possibility of denomValPointer causing an exception.
					denomValPointer++;
				}
			}
		} else {
			System.out.println(" Target Value is not a positive int, no coins needed");
		}
		return coinCounter; // return the amount of coins used.
	}

	/**
	 * Main.
	 */
	public static void main(String[] args)
	{
		testChangeMaking();
	}
}
