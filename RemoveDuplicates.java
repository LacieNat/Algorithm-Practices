
public class RemoveDuplicates {
	public static int checker1;
	public static int checker2;
	public static int checker3;
	public static int checker4;
	
	public static void main(String args[]) {
		checker1=0;
		checker2=0;
		checker3=0;
		checker4=0;
		
		String s = "abcc  caddsadkslf;as234   ";
		System.out.println(replace(s));
	}
	
	//O(n) n = no. of str chars?
	public static String replace(String s) {
		StringBuffer newStr = new StringBuffer();
		for(int i=0; i<s.length(); i++) {
			int val = (int)s.charAt(i);
			
			int quotient = val/32;
			int remainder = val%32;
			
			if(quotient == 0) {
				if((checker1 & ( 1<< remainder)) == 0) {
					checker1 |= (1<<remainder);
					newStr.append((char) val);
				}
			} else if(quotient == 1) {
				if((checker2 & ( 1<< remainder)) == 0) {
					checker2 |= (1<<remainder);
					newStr.append((char) val);				
				}	

			} else if(quotient == 2) {
				if((checker3 & ( 1<< remainder)) == 0) {
					checker3 |= (1<<remainder);
					newStr.append((char) val);
				}
			} else if(quotient == 3) {
				if((checker4 & ( 1<< remainder)) == 0) {
					checker4 |= (1<<remainder);
					newStr.append((char) val);
				}
				
			}
		}
		
		
		
		return newStr.toString();
	}
	
	
}
