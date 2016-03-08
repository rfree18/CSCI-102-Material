import java.util.Iterator;
import java.util.Random;

public class Assignment4 {

	public static void main(String[] args) {
		
		testIterator();
		testCountLess();
		
		int count = 0;
		int sum = 0;
		
		while(count < 1000) {
			sum += testHeight();
			count++;
		}
		
		System.out.println("Average height: " + sum/count);

	}
	
	/**
	 * Creates a BinarySearchTree of random ints and iterates through the values to print
	 */
	
	public static void testIterator() {
		BinarySearchTree tree = new BinarySearchTree();
		
		for(int i = 0; i < 20; i++) {
			Random random = new Random();
			
			tree.addElement(random.nextInt(100)+1);
		}
		
		Iterator<BSTNode> iterator = tree.iterator();
		
		for(int i = 0; i < 5; i++) {
			System.out.println(iterator.next().data);
		}
		
		for(int i = 0; i < 20; i++) {
			Random random = new Random();
			
			tree.addElement(random.nextInt(100)+101);
		}
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next().data);
		}
	}
	
	/**
	 * Creates a BinarySearchTree of random ints and finds the number of values less than 5000
	 */
	
	public static void testCountLess() {
		BinarySearchTree tree = new BinarySearchTree();
		
		int count = 0;
		
		for(int i = 0; i < 1000; i++) {
			Random random = new Random();
			
			int newInt = random.nextInt(10000)+1;
			
			if(newInt < 5000) {
				count++;
			}
			
			tree.addElement(newInt);
		}
		
		System.out.println("Counted values less than 5000: " + count);
		System.out.println("Computed values less than 5000: " + tree.countLess(5000));
	}
	
	/**
	 * Creates a BinarySearchTree of random ints and returns the height of the tree
	 * 
	 * @return
	 * 		an int representing the height of the tree
	 */
	
	public static int testHeight() {
		BinarySearchTree tree = new BinarySearchTree();
		
		for(int i = 0; i < 1000; i++) {
			Random random = new Random();
			
			int num = random.nextInt(10000)+1;
			tree.addElement(num);
		}
		
		return tree.height();
		
	}

}
