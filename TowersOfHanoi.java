import java.util.Stack;
public class TowersOfHanoi {
	
	public static void main(String[] args) {
		
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();
		
		s1.push(7);
		s1.push(5);
		s1.push(3);
		s1.push(1);
		
		solve(4, s1, s2, s3);
		
		while(!s3.isEmpty()) {
			System.out.println(s3.pop());
		}
		
	}
	
	public static void solve(int n, Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {
		if(n == 1) {
			s3.push(s1.pop());
		}else {
			solve(n-1, s1, s3, s2);
			s3.push(s1.pop());
			solve(n-1, s2, s1, s3);
		}
	}
}
