import java.util.ArrayList;
public class LL {
	LL next = null;
	int data;
	
	public LL(int data) {
		this.data = data;
	}
	
	public LL() {
		
	}
	
	//O(n)
	public int size() {
		int count = 0;
		LL ptr = this;
		while(ptr.next!=null) {
			count++;
			ptr = ptr.next;
		}
		count++;
		return count;
	}
	
	public LL appendToTail(int data) {
		LL x = this;
		
		while(x.next!=null) {
			x = x.next;
		}
		
		x.next = new LL(data);
		
		return x.next;
	}
	
	public LL deleteNode(int data) {
		
		if(this.data == data) {
			return this.next;
		}
		
		LL n = this;
		while(n.next!=null) {
			
			if(n.next.data == data) {
				n.next = n.next.next;
				break;
			}
			
			n = n.next;
		}
		
		return this;
	}
	
	//With Buffer O(n^2)
	public void removeDuplicates() {
		LL x = this;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(x.data);
		
		while(x.next!=null) {
			if(arr.indexOf(x.next.data) != -1) {
				x.next = x.next.next;
			}
			x = x.next;
		}
	}
	
	public LL removeDuplicatesWithoutBuffer() {
		LL y = LL.split(this);
		LL x = y;

		while(x.next!=null) {
			if(x.data == x.next.data) {
				x.next = x.next.next;
			}else {
				x = x.next;
			}
		}
		return y;
	}
	
	public static LL split(LL head) {

		int size = head.size();
		
		if(size == 1) {
			return head;
		}
		
		//printLL(head);
		//System.out.println("size= " + size);
		LL h1 = head;
		for(int i=1; i<size/2; i++) {
			if(h1.next!=null)
				h1 = h1.next;
		}
		
		LL h2 = h1.next;
		h1.next = null;
		//printLL(head);
		//printLL(h2);
		LL a1 = split(head);
		LL a2 = split(h2);
		
		return merge(a1, a2);
	}
	
	public static LL merge(LL a1, LL a2) {
		int s1 = a1.size();
		int s2 = a2.size();
		
		LL ptr1 = a1;
		LL ptr2 = a2;
		
		//System.out.print("a1 = ");
		//printLL(a1);
		//System.out.print("a2 = ");
		//printLL(a2);
		
		LL a3 = new LL();
			
		for(int i=0; i<s1+s2-1; i++) {
			a3.appendToTail(0);
		}
		
		LL ptr3 = a3;
		
		while(ptr1!=null || ptr2!=null) {
			
			if(ptr1==null) {
					ptr3.data = ptr2.data;
					ptr2 = ptr2.next;
			}
			
			else if(ptr2==null) {
					ptr3.data = ptr1.data;
					ptr1 = ptr1.next;
				
			}
			
			else if (ptr1.data < ptr2.data) {
				ptr3.data = ptr1.data;
				ptr1 = ptr1.next;
			} 
			
			else {
				ptr3.data = ptr2.data;
				ptr2 = ptr2.next;
			}
			
			ptr3 = ptr3.next;
		}
		
		return a3;
	}
	
	public static void printLL(LL a) {
		LL ptr = a;
		while(ptr!=null) {
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	public static void deleteCurrNode( LL node) {
		LL n = node;
		int x = node.size()-1;
		for(int i=1; i<x; i++) {
			n.data = n.next.data;
			n = n.next;
		}
		
		n.data = n.next.data;
		n.next = null;
	}
	
	public static LL sumOfLL(LL a1, LL a2) {
		
		LL p1 = a1;
		LL p2 = a2;
		int carry = 0;
		int sum = 0;
		
		LL a3 = new LL();
		LL p3 = a3;
		
		printLL(a1);
		printLL(a2);
		
		while(p1!=null || p2!=null) {

			if(p1==null && p2!=null) {
				sum = p2.data + carry;
				p2 = p2.next;
			}
			
			else if(p2==null && p1!=null) {
				sum = p1.data + carry;
				p1 = p1.next;
			}
			
			else {
				sum = p1.data + p2.data + carry;
				p1 = p1.next;
				p2 = p2.next;
			}
			
			carry = sum/10;
			p3.data = sum%10;
			
			if(p1!=null || p2!=null) {
				p3.next = new LL();
				p3 = p3.next;
			}
		}
		
		return a3;
	}
	
	public static LL findFirstNodeInLoop(LL a) {
		LL hare = a;
		LL tt = a;
		
		while(hare!=null) {
			hare = hare.next;
			
			if(hare==null) {
				break;
			}
			
			hare = hare.next;
			tt = tt.next;
			
			if(hare!=null && hare.data == tt.data) {
				
				tt = a;
				
				while(tt.data!=hare.data) {
					hare = hare.next;
					tt = tt.next;
				}
				
				return tt;
			}
		}
		
		return null;
	}
	
	public static void main(String args[]) {
		LL x = new LL(2);
		x.appendToTail(4);
		x.appendToTail(2);
		LL loopNode = x.appendToTail(3);
		x.appendToTail(1);
		LL t = x.appendToTail(8);
		t.next = loopNode;
		
		LL y = new LL(0);
		y.appendToTail(7);
		y.appendToTail(6);
		
		

 		
 		//printLL(LL.split(x).removeDuplicatesWithoutBuffer());
		//LL.deleteCurrNode(x.next.next);
		//printLL(LL.sumOfLL(x, y));	
		LL node = findFirstNodeInLoop(y);
		
		if(node!=null)
			System.out.println(node.data);
		else
			System.out.println("no Loop Node");
 		
	}
}
