
public class LinkedListString {
	
	private LinkedListStringNode head;
	private int size;
	
	public LinkedListString(String data) {
		head = new LinkedListStringNode(data);
		
		size = 1;
	}
	
	public void addToEnd(String string) {
		LinkedListStringNode node = new LinkedListStringNode(string);
		
		LinkedListStringNode current = head;
		
		if(head.next == null) {
			head.next = node;
		}
		
		else {
			while (current.next != null) {
				current = current.next;
			}
			
			current.next = node;
		}
		
		size++;
	}
	
	public void addToFront(String string) {
		LinkedListStringNode node = new LinkedListStringNode(string);
		
		node.next = head;
		head = node;
		
		size++;
	}
	
	public void insertAfterNode(String string, LinkedListStringNode node2) {
		LinkedListStringNode node1 = new LinkedListStringNode(string);
		
		node1.next = node2.next;
		node2.next = node1;
		
		size++;
	}
	
	public void insertBeforeNode(String string, LinkedListStringNode node2) {
		LinkedListStringNode node1 = new LinkedListStringNode(string);
		
		if(head == node2) {
			addToFront(string);
			
		}
		
		else {
			LinkedListStringNode current = head;
			
			while(current.next != node2 && current.next != null) {
				current = current.next;
			}
			
			if(current.next == null) {
				System.out.println("Error: Node does not exist in this linked list.");
			}
			
			else {
				node1.next = current.next;
				current.next = node1;
			}
			
			size++;
		}
	}
	
	public void removeLastNode() {
		LinkedListStringNode current = head;
		
		while(current.next.next != null) {
			current = current.next;
		}
		
		current.next = null;
		
		size--;
	}
	
	public void removeFirstNode() {
		head = head.next;
		
		size--;
	}
	
	public void removeNode(LinkedListStringNode node) {
		LinkedListStringNode current = head;
		
		while(current.next != node && current.next != null) {
			current = current.next;
		}
		
		if(current.next == null) {
			System.out.println("Error: Node does not exist in this linked list.");
		}
		
		else {
			current.next = current.next.next;
			
			size--;
		}
	}
	
	public void clearList() {
		head = null;
		size = 0;
	}
	
	public boolean contains(LinkedListStringNode string) {
		LinkedListStringNode current = head;
		
		while(!current.data.equals(string) && current != null) {
			current = current.next;
		}
		
		if(current == null) {
			return false;
		}
		
		else {
			return true;
		}
	}
	
	public int size() {
		return size;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		LinkedListStringNode current = head;
		
		while(current != null) {
			builder.append(current.data + "\n");
			current = current.next;
		}
		
		return builder.toString();
	}
	
}
