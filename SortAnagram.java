import java.util.*;
public class SortAnagram {
	public static void main(String[] args) {
		String[] str = {"ab", "aab", "cde", "ba", "baa"};
		
		str = sortArr(str);
		
		for(int i=0; i<str.length; i++) {
			System.out.print(str[i] + ",");
		}
	}
	
	public static String[] sortArr(String[] str) {
		
		//IMPLEMENTATION OF COMPARATOR
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(s1.length() != s2.length()) {
					return s1.length() - s2.length();
				} else {
					if(isAnagram(s1,s2)) {
						return 0;
					} else {
						return s1.compareTo(s2);
					}
				}
			}
			
		});
		
		return str;
	}
	
	public static boolean isAnagram(String s1, String s2) {
		HashMap<Character, Boolean> hm = new HashMap<Character, Boolean> ();
		
		for(int i=0; i<s1.length(); i++) {
			hm.put(s1.charAt(i), true);
		}
		
		for(int i=0; i<s2.length(); i++) {
			if(!hm.containsKey(s2.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
}
