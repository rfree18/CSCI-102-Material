import java.util.Stack;

public class MyStackMethods {
	
	/**
	 * Checks to see if two stacks contain the same elements
	 * 
	 * @param stack1
	 * 		a stack of elements
	 * @param stack2
	 * 		a stack of elements to be compared to the elements in stack1
	 * @return
	 * 		true if the stacks are equal or false if the stacks are not equal
	 */
	
	public static <E> boolean equalStacks(Stack<E> stack1, Stack<E> stack2) {
		Stack<E> reverseStack1 = new Stack<E>();
		Stack<E> reverseStack2 = new Stack<E>();
		
		while(!stack1.isEmpty()) {
			reverseStack1.push(stack1.pop());
		}
		
		while(!stack2.isEmpty()) {
			reverseStack2.push(stack2.pop());
		}
		
		while(!reverseStack1.isEmpty()) {
			E element1 = reverseStack1.pop();
			E element2 = reverseStack2.pop();
			
			if (!element1.equals(element2)) {
				return false;
			}
			
			stack1.push(element1);
			stack2.push(element2);
		}
		
		return true;
	}
	
	/**
	 * Creates a new stack equal to the given stack
	 * 
	 * @param stack1
	 * 		a stack of elements
	 * @return
	 * 		a new stack of elements equal to the given stack
	 */
	
	public static <E> Stack<E> copyStack(Stack<E> stack1) {
		Stack<E> reverseStack = new Stack<E>();
		Stack<E> copyStack = new Stack<E>();
		
		while(!stack1.isEmpty()) {
			reverseStack.push(stack1.pop());
		}
		
		while(!reverseStack.isEmpty()) {
			E element = reverseStack.pop();
			
			stack1.push(element);
			copyStack.push(element);
		}
		
		return copyStack;
	}
}