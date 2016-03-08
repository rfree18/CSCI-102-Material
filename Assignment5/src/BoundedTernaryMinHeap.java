public class BoundedTernaryMinHeap {

	private int[] heapArray;
	private int size;
	private int minCount = 0;
	private final int MAX_SIZE = 1000;

	public BoundedTernaryMinHeap() {
		heapArray = new int[MAX_SIZE];
		size = 0;
	}

	/**
	 * Determines if the BoundedTernaryMinHeap is empty
	 * 
	 * @return
	 * 		a boolean value representing if the BoundedTernaryMinHeap is empty
	 */

	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}

		return false;
	}

	/**
	 * Gets the number of elements in the heap
	 * 
	 * @return
	 * 		an int representing the number of elements in the heap
	 */

	public int getSize() {
		return size;
	}

	/**
	 * Adds a given element to the BoundedTernaryMinHeap
	 * 
	 * @param i
	 * 		the int value to be added
	 */

	public void addElement(int i) {
		heapArray[size] = i;

		siftUp();
		size++;
	}

	/**
	 * Shifts last added element up to the appropriate position where it is less than its children
	 */

	private void siftUp() {
		int loc = size;
		int current = heapArray[loc];
		int i = 3;
		int parent = heapArray[(loc-1)/i];

		while(parent != 0 && parent > current) {
			heapArray[loc] = parent;
			heapArray[(loc-1)/i] = current;

			loc = (loc-1)/i;
			parent = heapArray[(loc-1)/i];
		}
	}

	/**
	 * Gets the minimum value of the BoundedTernaryMinHeap
	 * 
	 * @return
	 * 		the minimum value of the BoundedTernaryMinHeap
	 */

	public int getMin() {
		return heapArray[0];
	}

	/**
	 * Removes the minimum value of the BoundedTernaryMinHeap
	 */

	public void removeMin() {

		if(!this.isEmpty()) {
			heapArray[0] = heapArray[size-1];
			heapArray[size-1] = 0;
			size--;

			siftDown();
		}
	}

	/**
	 * Shifts element at top of BoundedTernaryMinHeap until it satisfies min heap conditions
	 */

	private void siftDown() {
		int loc0 = 0;
		int loc1 = 1;
		int loc2 = 2;
		int loc3 = 3;

		int current = heapArray[loc0];
		int child1 = heapArray[loc1];
		int child2 = heapArray[loc2];
		int child3 = heapArray[loc3];

		int smallest = MAX_SIZE+1;
		int smallestLoc = MAX_SIZE+1;
		
		if(child1 != 0 ) {
			smallest = child1;
			smallestLoc = loc1;
		}

		if(child2 < smallest && child2 != 0) {
			smallest = child2;
			smallestLoc = loc2;
		}
		if(child3 < smallest && child3 != 0) {
			smallest = child3;
			smallestLoc = loc3;
		}

		while(current > smallest) {
			heapArray[smallestLoc] = current;
			heapArray[loc0] = smallest;

			loc0 = smallestLoc;
			loc1 = loc0 * 3 + 1;
			loc2 = loc1 + 1;
			loc3 = loc2 + 1;

			if(loc3 > MAX_SIZE) {
				break;
			}

			child1 = heapArray[loc1];
			child2 = heapArray[loc2];
			child3 = heapArray[loc3];

			smallest = child1;
			smallestLoc = loc1;

			if(smallest == 0) {
				break;
			}

			if(child2 < smallest && child2 != 0) {
				smallest = child2;
				smallestLoc = loc2;
			}
			if(child3 < smallest && child3 != 0) {
				smallest = child3;
				smallestLoc = loc3;
			}

		}
	}

	public String toString() {
		String s = "Heap: ";

		for(int i : heapArray) {
			if(i != 0)
				s = s + i + " ";
		}

		return s;
	}

	/**
	 * Returns an array of all values in the BoundedTernaryMinHeap smaller than a given value
	 * 
	 * @param k
	 * 		an int representing the upper bound for all elements returned
	 * @return
	 * 		an array of all integers smaller than k
	 */

	public int[] getSmallerThanK(int k) {
		int[] result = new int [size];
		smallerThanKRecurs(k, result, 0);
		this.minCount = 0;
		return result;
	}

	/**
	 * A helper method to construct an array of values in the BinaryTernaryMinHeap smaller than a given value
	 * 
	 * @param k
	 * 		an int representing the upper bound for all elements returned
	 * @param result
	 * 		an array of ints smaller than k
	 * @param loc
	 * 		the location of the element in the BinaryTernaryMinHeap to be evaluated
	 */

	private void smallerThanKRecurs(int k, int[] result, int loc) {
		if(loc < size && heapArray[loc] < k) {
			result[minCount] = heapArray[loc];
			minCount++;
			smallerThanKRecurs(k, result, loc * 3 + 1);
			smallerThanKRecurs(k, result, loc * 3 + 2);
			smallerThanKRecurs(k, result, loc * 3 + 3);
		}
	}


}
