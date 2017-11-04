/**
 *  Brian Hanley 
 *  R00015775 
 *  Assignment 2  
 *  Oct. 2017
 */


import java.util.Arrays;

public class MyStaticQueue {

	
	
	
	// --------------------------------------------------
	// Attributes
	// --------------------------------------------------
	private int items[];
	private int numItems;
	private int maxItems;

	
	
	
	// -------------------------------------------------------------------
	// Basic Operation --> Check if myStaticQueue is empty
	// -------------------------------------------------------------------
	/**
	 * The constructor creates 1 instance (1 object) of the class MyStaticQueue
	 * 
	 * @param m
	 *            : int parameter used to set the size of the static array
	 */
	public MyStaticQueue(int m) {
		this.maxItems = m;
		this.numItems = 0;
		this.items = new int[maxItems];
	}

	
	
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyStaticQueue is empty: isEmpty
	//-------------------------------------------------------------------
	/**
	 * Checks the counter for the length of the populated array to return a boolean value.
	 * 
	 * @return Boolean value.
	 */
	public boolean isEmpty(){
//		System.out.println("isEmpty method..."); //for test purposes

		return numItems == 0;

	}
	
	
	
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyStaticQueue: first
	//-------------------------------------------------------------------
	/**
	 * @return int value, of the first token in the array.
	 */
	public int first(){
		return this.items[0];

	}
	
	
	
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to back of MyStaticQueue: add 
	//-------------------------------------------------------------------
	/**
	 * Uses an "if statment" to ensure the array is NOT full & appends a value to the array.
	 * Returns an error message to the console if the array os full.
	 * 
	 * @param element : recieves an int value to be apended to the array
	 */
	public void add(int element) {
//		System.out.println("add method..."); //for test purposes

		if (numItems < maxItems) {
			this.items[numItems] = element;
			this.numItems++;
		}

		else
			errorMessage(" The Array Is Full, current no. items:" + numItems + ", Max no. Items:" + maxItems + ".");
	}

	
	
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyStaticQueue: remove 
	//-------------------------------------------------------------------	
	/**
	 * Uses the "isEmpty()" to check if the array is already empty, & prints an error message if TRUE.
	 * Uses a for loop to iterate through the array reassign each token, 
	 *  & dereferencing the first token to be deleted by garbage collection.
	 * Decrements the counter variable "numItems" after deletion of a token  
	 */
	public void remove() {
//		System.out.println("\nRemove Method...");   //for test purposes

		if (isEmpty()) {
			errorMessage("The Array is Empty- Unable to Remove Token.");
		} else {
			for (int i = 0; i < maxItems - 1; i++) {

				this.items[i] = this.items[i + 1];
			}

			this.items[this.numItems - 1] = 0;
			this.numItems--;
		}
		// System.out.println(this); // for test purposes

	}

	
	
	
	//-------------------------------------------------------------------
	// Error : Output
	//-------------------------------------------------------------------	
	public void errorMessage(String error){
		System.out.println(" #- ERROR: " + error);
	}
	
	
	
	
	//-------------------------------------------------------------------
	// toString
	//-------------------------------------------------------------------	
	@Override
	public String toString() {
		return "MyStaticQueue [items=" + Arrays.toString(items) + ", numItems=" + numItems + ", maxItems=" + maxItems
				+ "]";
	}
	

}
