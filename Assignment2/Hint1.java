/*
 * Author : Brian Hanley
 * Student Number: 00015775
 * Assignment 2 , Hint 1
 * Last Modified: 25/11/17
 */


/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}

	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyDynamicList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyDynamicList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyDynamicList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyDynamicList m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. MyDynamicList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyDynamicList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		//Rule 1. MyDynamicList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyDynamicList");

			break;

			//Rule 2. MyDynamicList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyDynamicList Contains the following " + size + " items: ");

			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));

			break;

		}

	}

	//-------------------------------------------------------------------
	// 1. maxInt --> Computes the maximum item of MyDynamicList 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the maximum item of m (-1 if m is empty). 
	 * @param m: The MyDynamicList we want to compute its maximum item.
	 * @return: The maximum item of MyDynamicList	  
	 */	
	public int maxInt(MyDynamicList m){
		
		//-----------------------------
				//Output Variable --> InitialValue
				//-----------------------------
				int res = -1;
				//-----------------------------
				//SET OF OPS
				//-----------------------------

				
				if (m.length() != 0) {
					
					int e0 = m.getElement(0);//1. We get the first element of MyDynamicList

					m.removeElement(0); //2. We remove the first element from MyDynamicList we just checked

					res = maxInt(m); //3. We recursively solve the smaller problem

					//4. We compare the two variables, and assign a value to 'res' if applicable .
					if (e0 > res){
						res = e0;
					}

					//5. We also add the element back to m, so as to not to modify its original state
					m.addElement(0, e0);
				}
	
				//-----------------------------
				//Output Variable --> Return FinalValue
				//-----------------------------		
				return res;	
		
	}

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyDynamicList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes whether m is sorted in decreasing order or not.  
	 * @param m: The MyDynamicList we want to check.
	 * @return: Whether m is sorted in decreasing order or not.  
	 */	
	public boolean isReverse(MyDynamicList m){
			
		//-----------------------------
		//Variables
		//-----------------------------
		boolean result = false;
		int length = m.length();
		
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. MyDynamicList is empty.
		if (length <= 1) 
			scenario = 1;
		//Rule 2. MyDynamicList has some elements.
		else
			scenario = 2;		

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		case 1: // MyDynamicList is empty. 
			result = true;

			break;

		case 2: // My Dynamic list is NOT empty.

			// We get the first two elements of MyDynamicList.
			int e0 = m.getElement(0);
			int e1 = m.getElement(1);
			
			// The two values are compared, if the values are decreasing, recursion is implemented to test the next two elements.
			if (e0 >= e1){
			
			//. We remove the first element from MyDynamicList.
			m.removeElement(0);

			// Recursively solve the smaller problem, passing the now smaller MyDynamicList as a param.
			result = isReverse(m);
			
			// Add the previously removed element back to 'm', to restore its original state.
			m.addElement(0, e0);
			}
			
			// is the two checked elements are not decreasing in value, the statement is false, and the value is assigned to the var 'result'
			else{
				result = false;
			}
			
			break;
		}		

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		

		return result;
	}

	// -------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer
	// appears in MyDynamicList
	// -------------------------------------------------------------------
	/**
	 * The function computes the amount of times that the integer n appears in m.
	 * Note:  the returned variable is initialised as 0 if there is no elements the same value as 'n'.
	 * @param m:The MyDynamicList we want to use. 
	 * @param n:The number we want to compute its appearances for.           
	 * @return: The amount of appearances of n into m
	 */
	public int getNumAppearances(MyDynamicList m, int n) {

		// -----------------------------
		// Variables
		// -----------------------------
		int result = 0;
		int length = m.length();
		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// Rule 1. MyDynamicList is NOT empty
		if (length > 0) {

			
			// We get the first element of MyDynamicList.
			int e0 = m.getElement(0);  
			
			// We remove the first element from MyDynamicList we just checked.
			m.removeElement(0);

			// Recursively solve the smaller problem, passing in the now smaller dynamic list 'm' and the reference int 'n'.
			result = getNumAppearances( m, n);

            // if the previously removed element has the same value as the reference int 'n', the result counter is incremented by 1.
			if (e0 == n) {
				result++;
			}

			// Add the previously removed element back to 'm', to restore its original state.
			m.addElement(0, e0);

		}
			
		// -----------------------------
		// Output Variable --> Return FinalValue
		// -----------------------------
		return result; 
	}

	// -------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	
	/**
	 * The function computes n to the power of m.
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.  
	 */	

	public int power(int n, int m) {

		
		// -----------------------------
		// Variables
		// -----------------------------
		int result = 0;

		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;

		// if the power number or the base number are less then 2.
		if (n < 2 || m < 2) {
			scenario = 1;
		} else {
			scenario = 2;
		}

		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {

		case 1: // 'n' (base number) or 'm' (power) is less than 2. assign result 'n'.
			if(m > -1){
				result = n;
			}
			else{
				System.out.print("Error, this function does not accept negitive powers; ");
			}

			break;

		case 2:

			// Decrement the power variable 'm' by 1 and assign the variable
			// 'result' to the recursive method call.
			m--;
			result = power(n, m);

			// On the back side of the recursive process , the passed variable
			// 'result' is multiplied by the base number 'n'.
			result = n * result;

			break;
		}

		return result;
	}

	 
	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Lucas series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int lucas(int n){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = 0;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// if the input param 'n' is equal to 0.
		if (n == 0){
			scenario = 1;
		}
		// if the input param 'n' is equal to 1.
		else if ((n == 1)) {
			scenario = 2;
		} 
		// if the input param 'n' is greater than 1.
		else {
			scenario = 3;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		case 1: // n==0
			// Assign res to 2.
			res = 2;
			
			break;

		case 2: //n == 1
			//1. Assign res to 1
			res = 1;

			break;	

		case 3:  // n>1
			// Recursively solve the the smaller problem of computing n-1
			int n1 = lucas(n-1);

			// Recursively solve the the smaller problem of computing n-2
			int n2 = lucas(n-2);

			// Compute the final result 
			res = n1 + n2; 

			break;
		}		

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	
	/**
	 * The function prints prints a pattern of a given length.
	 * Implements another method 'drawLine()'.
	 * *
	 * **
	 * ***
	 * ... 
	 * @param n: The length of the desired pattern
	 */	
	public void drawImage(int n) {

		// checks that int 'n' is a positive number. 
		if (n > 0) {

			// reduce the value of 'n' by one 
			n--;

			// recursivally call the method passing in the now decremented int 'n'.
			drawImage(n);

			// If statement to test for base case and print a new line to format the output . 
			if(n==0){
				System.out.print("\n");
			}
			
			// Calls another recursive method that will print out 'n' number of characters.
			drawLine(n + 1);
			
			
		// tests if a negative number has been entered and prints an error message.
		} else if( n < 0) {
			System.out.println("\n\n Error, input parameter must be a positive integer.");
		}
	}

	 
	//-------------------------------------------------------------------
	// 7. drawLine --> Prints a line of a given length
	//-------------------------------------------------------------------	
	public void drawLine(int n) {

		if (n > 0) {

			// reduce the value of 'n' by one
			n--;

			// recursivally call the method passing in the now decremented int 'n'.
			drawLine(n);

			System.out.print("#");

		}
		// at the base case a new line character is printed at the end of the line.
		else if (n == 0) {
			System.out.print("\n");
		} 
		// prints out an error message in the case of incorrect parameter
		else {
			System.out.println("\n\n Error, input parameter must be a positive integer.");
		}

	}

}
