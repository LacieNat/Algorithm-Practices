import java.util.ArrayList;
public class MinStack {
	
	private ArrayList<Integer> s;
	private ArrayList<Integer> min;
	private int size;
	
	public MinStack() {
		s = new ArrayList<Integer>();
		min = new ArrayList<Integer>();
		size = 0;
	}
	
	public static void main(String[] args) {
		
		MinStack ms = new MinStack();
		
		ms.push(3);
		ms.push(5);
		ms.push(9);
		ms.push(1);
		ms.push(6);
		System.out.println(ms.min());
		ms.pop();
		ms.pop();
		
		System.out.println(ms.min());
		
	}
	
	public int push(int input) {
		s.add(input);
		
		if(size==0) {
			min.add(input);
		} else {
			if(min.get(size-1) > input) {
				min.add(input);
			} else {
				min.add(min.get(size-1));
			}
		}
		size++;
		return input;
	}
	
	public int pop() {
		min.remove(size-1);
		int input = s.remove(size-1);
		size--;
		return input;
	}
	
	public int min() {
		return min.get(size-1);
	}
}
