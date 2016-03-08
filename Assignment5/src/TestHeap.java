import java.util.Random;

public class TestHeap {

	public static void main(String[] args) {
		
		BoundedTernaryMinHeap heap = new BoundedTernaryMinHeap();
		
		System.out.println("Is Empty: " + heap.isEmpty());
		heap.removeMin();
		
		Random random = new Random();
		
		for(int i = 0; i < 10; i++ ) {
			heap.addElement(random.nextInt(1000)+1);
		}
		
		System.out.println(heap);
		
		System.out.println("Is empty: " + heap.isEmpty());
		
		System.out.println("Min value: " + heap.getMin());
		
		heap.removeMin();
		
		System.out.println(heap);
		System.out.println("Min value: " + heap.getMin());
		
		smallerThanKTest(heap);
		
		while(!heap.isEmpty()) {
			heap.removeMin();
			System.out.println(heap);
			
			smallerThanKTest(heap);
		}
		
		System.out.println("Is empty: " + heap.isEmpty());

	}
	
	/**
	 * Tests the smallerThanK method and prints out the values returned by smallerThanK
	 * 
	 * @param heap
	 * 		the BoundedTernaryMinHeap to retrieve all values less than 500
	 */
	
	public static void smallerThanKTest(BoundedTernaryMinHeap heap) {
		System.out.print("Values smaller than 500: ");
		
		for(int i : heap.getSmallerThanK(500)) {
			if(i != 0)
				System.out.print(i + " ");
		}
		System.out.println();
	}

}
