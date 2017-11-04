// Brian Hanley / R00015775 / Assignment 2 / Oct. 2017

public class MyDynamicQueue {

	
	
	
	// --------------------------------------------------
	// Attributes
	// --------------------------------------------------
	private MyNode head;

	
	
	
	
	// -------------------------------------------------------------------
	// Basic Operation --> Construct MyDynamicQueue
	// -------------------------------------------------------------------
	/**
	 * The constructor creates 1 instance (1 object) of the class MyDynamicQueue
	 */
	public MyDynamicQueue() {
		head = null;
	}

	
	
	
	// -------------------------------------------------------------------
	// Basic Operation --> Check if MyDynamicQueue is empty: isEmpty
	// -------------------------------------------------------------------
	/**
	 * uses an "if statement" to check if the "MyDymanicQueue" object is empty &
	 * returns a boolean value
	 * 
	 * @return: Boolean value
	 */
	public boolean isEmpty() {

		if (head == null) {
			return true;
		}
		return false;

	}

	
	
	
	// -------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of
	// MyDynamicQueue: first
	// -------------------------------------------------------------------
	/**
	 * Calls on the isEmpty method to avoid null pointer exception. Returns the
	 * first element in the queue
	 * 
	 * @return: Int value of the element within the queue, or "0" if Queue
	 *          isEmpty.
	 */
	public int first() {
//		System.out.println("\n TEST: Running -> first() ."); //included for test purposes

		int first = 0; // Initialise the int so within the scope of both "if" &
						// return "return" statement

		if (!isEmpty()) {
			first = head.getInfo();// calls the getInfo() from the class "MyNode" to retrieve
									
		} else {
			System.out.println(" Error: Connot return first element as MyDynamicQueue is empty");
		}
		return first;

	}

	
	
	// -------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyDynamicQueue: add
	// -------------------------------------------------------------------
	/**
	 * Instantiates a temporary MyNode object: "temp" to hold the received int value 
	 *  and sets the pointer information to null.
	 * Declares a temporary MyNode object:"currentNode" used for iterating through the queue.
	 * Uses an if statement to ensure the queue is NOT empty. Instantiates "currentNode" with 
	 *  the first element in the queue and keeps iterating through the queue until 
	 *  the end is found. 
	 * The object "temp" is then appended onto the queue. By using the "setNext()" to set 
	 *  the pointer of the current last object from null, to the new object thats being added.
	 * 
	 * @param element : the integer value to be added to the "MyDynamicQueue"
	 */
	public void add(int element) {
//		System.out.println("\n TEST -> Add() :" + element); //included for test purposes

		MyNode temp = new MyNode(element, null);
		MyNode currentNode;

		if (!isEmpty()) {
			currentNode = head;
			while (currentNode.getNext() != null) {

				currentNode = currentNode.getNext();
			}
			currentNode.setNext(temp);
//			System.out.println("\n TEST: Running -> Add() -> if Statment -> added :" + element);  //included for test purposes

		} else {
//			System.out.println("\n TEST: Running -> Add() -> else : (queue isEmpty)");  //included for test purposes
			this.head = temp;
		}

	}
	
	
	

	// -------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of
	// MyDynamicQueue: remove
	// -------------------------------------------------------------------
	/**
	 * NOTE: this method does not require the return of the deleted object, but is included as a provision.
	 * 
	 * Checks that the queue is NOT empty and reassigns the "head" of the queue to the next object, 
	 *  dereferencing the original "head" object for garbage collection to occur.
	 * 
	 * @return temp : returns the MyNode object, that was removed.
	 */
	public MyNode remove() {
//		System.out.println("\n TEST: Running -> Remove() .");  //included for test purposes

		MyNode temp = head;// putting first in a temporary variable

		if (!isEmpty()) {
			head = head.getNext();
		} else {
			System.out.println("\n\tError : Queue is empty.");
		}

		return temp;

	}

	
	// END 
	
}