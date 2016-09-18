import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
                
		int count = 1;
                
		while(!input.equals("end")) {
			char[] containers = input.toCharArray();

			for(char c: containers) {
				if (stacks.size()==0) {
					Stack<Integer> s = new Stack<Integer>();
					s.push((int)c);
					stacks.add(s);
				} else {
					int min = Integer.MAX_VALUE;
					int minStack = 0;
					for(int i=0; i<stacks.size(); i++) {
						Stack<Integer> s = stacks.get(i);
						if (s.peek()<min && s.peek()>=c) {
							minStack = i;
							min = s.peek();
						}
					}
					
					if(c<=min && min!=Integer.MAX_VALUE) {
						stacks.get(minStack).push((int)c);
					} else {
						Stack<Integer> s = new Stack<Integer>();
						s.push((int)c);
						stacks.add(s);
					}
				}
			}

			pw.println("Case "+count+ ": "+ stacks.size());
			count++;
            stacks.clear();
			input = new StringTokenizer(br.readLine()).nextToken();
		}
		
		pw.close();
	}
}
