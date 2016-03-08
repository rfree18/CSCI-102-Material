import java.util.ArrayList;

public class Assignment2 {
	
	/**
	 * Sorts a given ArrayList using insertion sort
	 * 
	 * @param array
	 * 		an ArrayList of Comparable objects
	 * 
	 * @return
	 */
	
	public static <E extends Comparable<E>> void insertionSort(ArrayList<E> array) {
		
		for(int i = 0; i < array.size(); i++) {
			int j = i;
			
			while(j>0 && array.get(j-1).compareTo(array.get(j)) > 0) {
				E temp = array.get(j);
				array.set(j, array.get(j-1));
				array.set(j-1, temp);
				
				j--;
			}
		}
		
	}
	
	/**
	 * Finds the most frequent element in a given ArrayList
	 * 
	 * @param array
	 * 		an ArrayList containing Comparable objects
	 * @return
	 * 		the most frequent element in the ArrayList
	 */
	
	public static <E> E mostFrequentElement(ArrayList<E> array) {
		
		int[] frequentNums = new int[array.size()];
		ArrayList<E> usedNums = new ArrayList<E>(array.size());
		
		
		for (int i = 0; i < array.size(); i++) {
			
			int counter = 1;
			
			for (int j = 0; j < array.size(); j++) {
				
				if(j > i && !usedNums.contains(array.get(i))) {
					if(array.get(j).equals(array.get(i)))
						counter++;
				}
				
			}
			
			usedNums.add(array.get(i));
			frequentNums[i] = counter;
		}
		
		int maxIndex = 0;
		int maxNum = 0;
		
		for(int l = 0; l < frequentNums.length; l++) {
			if(frequentNums[l] > maxNum) {
				maxNum = frequentNums[l];
				maxIndex = l;
				
			}
		}
		
		System.out.println("Number of times most frequent element appears: " + frequentNums[maxIndex]);
		
		return array.get(maxIndex);
	}
	
	
	/**
	 * Finds the longest increasing subsequence in a given ArrayList
	 * 
	 * @param array
	 * 		an ArrayList of Comparable objects
	 * @return
	 * 		an ArrayList of the longest increasing subsequence
	 */
	
	public static <E extends Comparable<E>> ArrayList<E> longestIncrSubsequence(ArrayList<E> array) {
		ArrayList<E> sequence = new ArrayList<E>(array.size());
		
		E maxValue = null;
		
		sequence = findLongestIncreasingSubsequence(array, array.size()-1, maxValue);
		return sequence;
	}
	
	/**
	 * A helper method to find the longest increasing subsequence
	 * 
	 * @param array
	 * 		an ArrayList of Comparable objects
	 * @param end
	 * 		the index of the last element in the array
	 * @param maxValue
	 * 		the maximum value for the objects in the array
	 * @return
	 * 		an ArrayList containing the longest increasing subsequence with the given parameters
	 */
	
	private static <E extends Comparable<E>> ArrayList<E> findLongestIncreasingSubsequence(ArrayList<E> array, int end, E maxValue) {
		ArrayList<E> seq1 = new ArrayList<E>(array.size());
		
		if(end < 0) {
			return seq1;
		}
		
		seq1 = findLongestIncreasingSubsequence(array, end-1, maxValue);
		
		if(maxValue != null && array.get(end).compareTo(maxValue) != -1) {
			return seq1;
		}
		
		ArrayList<E> seq2 = findLongestIncreasingSubsequence(array, end-1, array.get(end));
		seq2.add(array.get(end));
		
		if(seq1.size() > seq2.size()) {
			return seq1;
		}
		
		else
			return seq2;
		
	}
	

}
