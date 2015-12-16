/*
 * This assignment has already been done in Python
 * But for tutorial purposes
 * It is going to teach you how to implement a singleton
 */
public class Employee {
	
	private static Employee emp = new Employee();
	
	/*
	 * A private Constructor prevents any other class from instantiating
	 */
	private Employee() {}
	
	/* Static instance method */
	public static Employee getInstance() {
		return emp;
	}
	
	
}
