package isUnique;
//import java.util.*;

public class isUnique {
	
	public static int checker1;
	public static int checker2;
	public static int checker3;
	public static int checker4;
	
	public static void main(String args[]) {
		String x = "123&8'-=";
		
		System.out.println(x + " isUnique: " + isUniqueStringA(x) +" " + isUniqueStringB(x));
	}
	
	//With Array Data Structure
	public static boolean isUniqueStringA(String x) {
		boolean[] alphabets = new boolean[128];
		
		for(int i=0; i<x.length(); i++) {
			char val = x.charAt(i);
			
			
			if(alphabets[(int) val]) {
				return false;
			}
			alphabets[(int)val] = true;
		}
		
		return true;
	}
	
	public static boolean isUniqueStringB(String x) {
		if(x.length()>128) {
			return false;
		}
		checker1 = 0;
		checker2 = 0;
		checker3 = 0;
		checker4 = 0;
		
		boolean flag = true;
		
		for(int i=0; i<x.length(); i++) {
			int val = x.charAt(i);
			
			int residue = val/32;
			
			switch(residue){	
				case 0:
					flag = helper(checker1, val%32, residue); break;
				case 1:
					flag = helper(checker2, val%32, residue); break;
				case 2:
					flag = helper(checker3, val%32, residue); break;
				case 3:
					flag = helper(checker4, val%32, residue); break;
			}
			
			if(!flag) {
				return flag;
			}			
		}
		return true;
	}
	
	public static boolean helper(int checker, int val, int residue) {
		
		if((checker & (1 << val)) > 0) {
			return false;
		}
		
		checker = checker | (1<<val);
		
		switch(residue) {
		case 0:
			checker1 = checker; break;
		case 1:
			checker2 = checker; break;
		case 2:
			checker3 = checker; break;
		case 3:
			checker4 = checker; break;
		}
		return true;
	}
	
}
