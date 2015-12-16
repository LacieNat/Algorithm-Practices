import java.util.Arrays;
public class Anagram {
	public static void main(String[] args) {
		String s1 = "dearths";
		String s2 = "hardest";
		
		System.out.println(isAnagram(s1, s2));
	}
	
	public static boolean isAnagram(String s1, String s2) {
		
		if(s1.length()!=s2.length()) {
			return false;
		}
		int[] alpha1 = new int[26];
		int[] alpha2 = new int[26];
		int offset1;
		int offset2;
		int val1;
		int val2;
		
		for(int i=0; i<s1.length(); i++) {
			val1 = (char) s1.charAt(i);
			val2 = (char) s2.charAt(i);
			
			if(val1<=90) {
				offset1 = val1-65;
			} else {
				offset1 = val1-97;
			}
			
			if(val2<=90){
				offset2 = val2-65;
			}else {
				offset2 = val2-97;
			}
			
			alpha1[offset1]++;
			alpha2[offset2]++;
		}
		
		return Arrays.equals(alpha1, alpha2);
	}
}
