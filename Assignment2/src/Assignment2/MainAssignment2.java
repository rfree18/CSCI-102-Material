import java.util.ArrayList;
import java.util.Random;

public class MainAssignment2 {
	
	public static void testInsertionSort() {
		Random rand = new Random();
		
		ArrayList<Integer> randomNums = new ArrayList<Integer>(20);
		
		for(int i = 0; i < 20; i++) {
			randomNums.add(rand.nextInt(101));
		}
		
		System.out.println("Random numbers: " + randomNums);
		
		Assignment2.insertionSort(randomNums);
		
		
		// Checks if randomNums is in fact sorted
		boolean isSorted = true;
		
		for(int i = 1; i < randomNums.size()-1; i++) {
			if(randomNums.get(i) < randomNums.get(i-1) || randomNums.get(i) > randomNums.get(i+1)) {
				isSorted = false;
			}
		}
		
		if(isSorted)
			System.out.println("Sorted numbers:" + randomNums);
		
		else
			System.out.println("Error - The array is not properly sorted:" + randomNums);
	}
	
	public static void testMostFrequentElement() {
		Random rand = new Random();
		
		ArrayList<Integer> randomNums = new ArrayList<Integer>(40);
		
		for(int i = 0; i < 40; i++) {
			randomNums.add(rand.nextInt(11));
		}
		
		System.out.println("Random numbers" + randomNums);

		System.out.println("Most frequent element: " + Assignment2.mostFrequentElement(randomNums));
	}
	
	public static void testLongestIncrSubsequence() {
		Random rand = new Random();
		
		ArrayList<Integer> randomNums = new ArrayList<Integer>(40);
		
		for(int i = 0; i < 40; i++) {
			randomNums.add(rand.nextInt(11));
		}
		
		
		System.out.println("Random numbers: " + randomNums);
		
		ArrayList<Integer> result = Assignment2.longestIncrSubsequence(randomNums);
		System.out.println("Longest increasing subsequence: " + result);
		
	}

	public static void main(String[] args) {
		
		testInsertionSort();
		testMostFrequentElement();
		testLongestIncrSubsequence();

	}

}
