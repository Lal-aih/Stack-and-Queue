package assignment1q1;

import java.util.Iterator;


//Queue class
public class Queue<integer> implements Iterable<Integer> {

	private Node first, last;
	
	//Node class
	private class Node{
		int item;
		Node next;
	}
	
	
	public Iterator<Integer> iterator() { return new QueueIterator();}
	
	// Iterator class
	private class QueueIterator implements Iterator<Integer>{
		private Node current = first;
		public boolean hasNext() { return current != null;}
		public Integer next() {
			int item = current.item;
			current = current.next;
			return item;
		}
		
		//Function to check if the current index of the queue is less than the current minimum
		public Boolean isLess(Integer m) {
			if (current.item < m) {
				return true;
			}
			else return false;
		}
		
		// Item getter function
		public Integer getItem() {
			return current.item;
		}
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enque(Integer item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;
	}
	
	public Integer deque() {
		int item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		return item;
	}
	
	// Function to iterate through queue and obtain the minimum
	public void getMin() {
		
		QueueIterator it = new QueueIterator();
		int min = it.next();
		while (it.hasNext()) {
		if (it.isLess(min)) {
			min = it.getItem();
		}
		it.next();
		}
		
		System.out.println(min);
			
		
	}

	//main
	public static void main(String[] args) {
		
		Queue<Integer> q1 = new Queue<>();
		
		q1.enque(-1);
		q1.enque(2);
		q1.enque(4);
		q1.deque();
		q1.getMin();
		q1.enque(-1);
		q1.enque(5);
		q1.getMin();
		
	}
}
