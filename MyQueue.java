import java.util.Stack;
import java.util.NoSuchElementException;
//A MyQueue class that implements a queue with 2 stacks
public class MyQueue {
	public Stack<Integer> inbox;
	public Stack<Integer> outbox;
	
	public MyQueue () {
		inbox = new Stack<Integer>();
		outbox = new Stack<Integer>();
	}
	
	public void enqueue(int input) {
		inbox.push(input);
	}
	
	public int dequeue() {
		if(inbox.isEmpty() && outbox.isEmpty()) {
			throw new NoSuchElementException("No Element to Dequeue");
		}
		
		if(outbox.isEmpty()) {
			while(!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		
		return outbox.pop();
	}
	
	public static void main(String[] args) {
		MyQueue mq = new MyQueue();
		
		mq.enqueue(3);
	}
	
	
}
