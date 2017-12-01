/*
 * Author : Brian Hanley
 * Student Number: 00015775
 * Assignment 2 , Hint 2
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
	// 1. recursiveDisplayElements --> Displays all elements of a MyDynamicList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyDynamicList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyDynamicList we want to display its elements.	  
	 */	
	public void recursiveDisplayElements(MyDynamicList m){

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. MyDynamicList is non-empty
		if (m.length() != 0) 
			scenario = 1;
		
		//Rule 2. MyDynamicList is empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
							
		case 1: //Rule 2. MyDynamicList is non-empty
			
			int i = (m.length()-1);  // the value is decremented to compensate for the list positioning counting from '0'.
			
			int tempInt = m.getElement(i);  // copies the value of the last element in the list to the variable tempInt.

			m.removeElement(i); // removes the last element in the list 'm'.

			// Base case, if statement to check when the list 'm' is empty.
			//  If IS empty : prints out the header "DynamicList Contains..." before reverting out of 
			//      recursive state, printing the values in the correct position.
			//  if NOT empty : calls the same method, passing the list 'm' which is now shorter by 1 element .
			if (i == 0) {
				System.out.println("\nMyDynamicList Contains the following items: ");
			}
			else{
			recursiveDisplayElements(m);
			}
			
			// Prints out the values on the back side of the recursive process to ensure the correct order is maintained.
			System.out.println("Item " + i + ": " + tempInt);

			// Adds the previously removed element to the list 'm'.
			m.addElement(i, tempInt);	
		
			break;
			
			
		case 2://Rule 1. MyDynamicList is empty
			// 1. We print the empty message
			System.out.println("\nError - Empty MyDynamicList.");

			break;
	
		}			
	}

	
	
	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyDynamicList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyDynamicList being smaller than 'e'  
	 * @param m: The MyDynamicList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyDynamicList to.
	 * @return: The new MyDynamicList containing just the elements being smaller than 'e'  
	 */	
	public MyDynamicList smallerMyList(MyDynamicList m, int e){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyDynamicList res = new MyDynamicList();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 				
		
		//Rule 1. MyDynamicList is non-empty
		if (m.length() != 0) 
			scenario = 1;
		//Rule 2. MyDynamicList is empty
		else
			scenario = 2;
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
				case 1: //Rule 1. MyDynamicList is non-empty
					
					int i = (m.length()-1);// the value is decremented to compensate for the list positioning counting from '0'.
					
					int tempInt = m.getElement(i); // copies the value of the last element in the list to the variable tempInt.
					
					m.removeElement(i); // removes the last element in the list 'm'.

					
					// Recursively calls the same method, passing in the now smaller list 'm' with the param 'e'.
					// As the result of each instance of recursion needs to be passed, back to the parent case, 
					//     the dynamicList 'res' needs to be assigned to the call for recursion.
					res = smallerMyList(m,e); 
					
					// Compares the temp variable to the param 'e', will add value to the new list, 
					//    makes use of inherited method from MyDynamicList to keep appending items to the start of the list.
					if (tempInt < e) {
						res.addElement(0, tempInt);
					}
							
					// Adds the previously removed element to the list 'm'.
					m.addElement(0, tempInt);
					
					break;
			
					
				case 2: //Rule 2. MyDynamicList is empty
				    //  Print statement "Empty MyDynamicList" was removed as it gets printed via the recursiveDisplayElements() automatically.
					break;	
		}
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
			
	}

	
	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyDynamicList bigger or equal than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyDynamicList being bigger than 'e'  
	 * @param m: The MyDynamicList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyDynamicList to.
	 * @return: The new MyDynamicList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyDynamicList biggerEqualMyList(MyDynamicList m, int e){
		
		//-----------------------------
				//Output Variable --> InitialValue
				//-----------------------------
				MyDynamicList res = new MyDynamicList();

				//-----------------------------
				//SET OF OPS
				//-----------------------------

				//-----------------------------
				// I. SCENARIO IDENTIFICATION
				//-----------------------------
				int scenario = 0; 				
				
				//Rule 1. MyDynamicList is non-empty
				if (m.length() != 0) 
					scenario = 1;
				//Rule 2. MyDynamicList is empty
				else
					scenario = 2;
				
				//-----------------------------
				// II. SCENARIO IMPLEMENTATION 
				//-----------------------------
				switch(scenario){	
						
						case 1: //Rule 1. MyDynamicList is NOT empty		 	
							
							int i = (m.length()-1); // the value is decremented to compensate for the list positioning counting from '0'.
							
							int tempInt = m.getElement(i); // copies the value of the last element in the list to the variable tempInt.

							m.removeElement(i);  // removes the last element in the list 'm'.

							// Recursivily calls the same method, passing in the now smaller list 'm' with the param 'e'.
							//   As the result of each instance of recursion needs to be passed, back to the parent case, 
							//   the dynamicList 'res' needs to be assigned to the call for recursion.
							
							res = biggerEqualMyList(m,e);
							
							
							// Compares the temp variable to the param 'e', will add value to the new list, 
							//    makes use of inherited method from MyDynamicList to keep appending items to the start of the list.
							if (tempInt >= e) {
								res.addElement(0, tempInt);
							}
								
							// Adds the previously removed element to the list 'm'.
							m.addElement(0, tempInt);
							
							break;
					
						case 2: 
						    //  Print statement "Empty MyDynamicList" was removed as it gets printed via the recursiveDisplayElements() automatically.		
							break;		
				}
				//-----------------------------
				//Output Variable --> Return FinalValue
				//-----------------------------		
				return res;	
	}
		
	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyDynamicList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyDynamicList.   
	 * @param m1: The first MyDynamicList.
	 * @param m2: The second MyDynamicList.
	 * @return: The new MyDynamicList resulting of concatenate the other 2 MyDynamicList
	 */	
	public MyDynamicList concatenate(MyDynamicList m1, MyDynamicList m2){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyDynamicList res = new MyDynamicList();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 				
		
		//Rule 1. Both MyDynamicList m1 and m2 ARE Empty.
		if (m1.length() == 0 && m2.length() == 0) {
			scenario = 1;
		}
		//Rule 2. If the first list 'm1' is empty
		else if (m1.length() == 0 ) {
			scenario = 2;
		}
		//Rule 3. MyDynamicList m1 is non-empty
		else
			scenario = 3;
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
			
		case 1: // If both lists are empty print a message.
			System.out.println(" \nError: Both DynamicLists: m1 and m2 ARE Empty! "); 
			break;
			
		case 2: // If the first list is empty just return the second list by assigning it to the new temp list 'res'.
			res = m2;
			break;
			
		case 3:// recursively appends each element from 'm2' to 'm1' until a base case of an empty 'm2' list is achieved. 
			// Itterivily copies the contents of 'm1' to 'res' and returns it to the parent case.
			// On the back side of the recursion the appropriate elements are removed from 'm1' and joined back to 'm2'.
			
			// Variables
			int i = m1.length();
			int tempInt;	
			
			
			if (m2.length() > 0){
	
				tempInt =  m2.getElement(0);
						
				m2.removeElement(0);
				
				m1.addElement(i, tempInt);
				
				// Recursivily calls the same method, passing in the now bigger list 'm1' and smaller 'm2'.
				// As the result of each instance of recursion needs to be passed, back to the parent case, 
				//     the dynamicList 'res' needs to be assigned to the call for recursion.
				res = concatenate(m1, m2);
				
				// removes the last element of 'm1' and adds it to 'm2' to restore their original state.
				//     makes use of inherited method from MyDynamicList to keep appending items to the start of the list.
				m1.removeElement(i);
				m2.addElement(0, tempInt);
			}
			
			else{
				// When the base case is achieved, the contents of the list 'm1' is copied to the new list 'res' to be returned.
				for(int q = 0 ; q < m1.length() ; q++ ){		
					int e = m1.getElement(q);
					res.addElement(q, e);	
				}
				return res;
			}
			break;
			
		}
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;
		
	}
	
}
