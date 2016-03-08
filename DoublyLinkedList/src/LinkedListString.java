
public class LinkedListString {
	
	LinkedListStringNode head;
	LinkedListStringNode tail;
	
	public LinkedListString(String data) {
		LinkedListStringNode newNode = new LinkedListStringNode(data);
		head = newNode;
		newNode.next = null;
		newNode.previous = null;
		tail = newNode;
	}
	
	public void addNewStringToEnd(String data) {
		LinkedListStringNode newNode = new LinkedListStringNode(data);
		newNode.next = null;
		newNode.previous = tail;
		tail = newNode;
	}
	
	public void addNewStringToFront(String data) {
		LinkedListStringNode newNode = new LinkedListStringNode(data);
		newNode.next = head;
		newNode.previous = null;
		head = newNode;
	}

}
