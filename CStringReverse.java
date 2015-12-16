

public class CStringReverse {
	
	public static void main(String args[]) {
		
		String s = "abcde\n";
		
		System.out.println(reverseString(s));
		
	}
	
	public static String reverseString(String s) {
		String newS = "";
		for(int i=s.length()-2; i>=0; i--) {
			newS = newS.concat(String.valueOf(s.charAt(i)));
		}
		
		return newS;
	}
}
