import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree implements Iterable<BSTNode> {
	
	public BSTNode root;
	
	public BinarySearchTree(int n) {
		BSTNode node = new BSTNode(n);
		root = node;
	}
	
	public BinarySearchTree() {
		root = null;
	}
	
	/**
	 * Computes the height of the tree
	 * 
	 * @return
	 * 		the int value of the tree's height or -1 if there is no root
	 */
	
	public int height() {
		return recHeight(root);
	}
	
	/**
	 * A helper method to recursively calculate the height of the tree
	 * 
	 * @param n
	 * 		the root of the subtree
	 * @return
	 * 		an int representing the height of the subtree or -1 if the root is null
	 */
	
	private int recHeight(BSTNode n) {
		if(n == null)
			return -1;
		else {
			int leftHeight = recHeight(n.leftChild);
			int rightHeight = recHeight(n.rightChild);
			
			if(leftHeight > rightHeight)
				return 1 + leftHeight;
			else
				return 1 + rightHeight;
		}
	}
	
	/**
	 * Adds a given integer to the tree
	 * 
	 * @param n
	 * 		the int value to be added
	 */
	
	public void addElement(int n) {
		
		if (root == null) {
			BSTNode node = new BSTNode(n);
			root = node;
		}
		else
			recAddElement(n, root);
	}
	
	/**
	 * A helper method to recursively add an element to the tree
	 * 
	 * @param n
	 * 		the int value to be added
	 * @param root
	 * 		the root of the current subtree being evaluated
	 */
	
	private void recAddElement(int n, BSTNode root) {
		int data = root.data;
		
		if(n >= data) {
			if(root.rightChild == null) {
				BSTNode node = new BSTNode(n);
				root.rightChild = node;
			}
			else
				recAddElement(n, root.rightChild);
		}
		
		else {
			if(root.leftChild == null) {
				BSTNode node = new BSTNode(n);
				root.leftChild = node;
			}
			
			else
				recAddElement(n, root.leftChild);
		}
	}
	
	/**
	 * Computes the number of elements that are less than a given int
	 * 
	 * @param n
	 * 		the int value that must be greater than all other values
	 * @return
	 * 		an int representing the number of items less than n
	 */
	
	public int countLess(int n) {
		int count = 0;
		
		InfixIterator iterator = new InfixIterator(root);
		
		while(iterator.hasNext()) {
			if(iterator.next().data < 5000)
				count++;
		}
		
		return count;
	}
	
	public void depthFirstSearch() {
		Stack<BSTNode> stack = new Stack<BSTNode>();
		
		stack.push(this.root);
		BSTNode node = this.root;
		
		while(!stack.isEmpty() && node != null) {
			node = stack.pop();
			System.out.println(node.data);
			stack.push(node.rightChild);
			stack.push(node.leftChild);
		}
	}
	
	/**
	 * Creates a new InfixIterator object
	 * 
	 * @return
	 * 		an InfixIterator object that can iterate through the tree
	 */
	
	public Iterator<BSTNode> iterator() {
		return new InfixIterator(root);
	}
	
	private class InfixIterator implements Iterator<BSTNode> {
		
		private Stack<BSTNode> stack;
		
		public InfixIterator(BSTNode root) {
			stack = new Stack<BSTNode>();
			stack.push(root);
			
			while(stack.peek().leftChild != null) {
				stack.push(stack.peek().leftChild);
			}
		}
		
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		
		public BSTNode next() {
			
			BSTNode current = stack.pop();
			
			if (current.rightChild != null) {
				stack.push(current.rightChild);
				if(current.rightChild.leftChild != null) {
					while(stack.peek().leftChild != null) {
						stack.push(stack.peek().leftChild);
					}
				}
			}
			
			return current;
		}
	}
	
}

