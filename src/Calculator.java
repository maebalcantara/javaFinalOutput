
public class Calculator{
	public int compute(String operation, int x, int y) {
		int total = 0;
		if(operation.equalsIgnoreCase("add")) {
			total = (Integer)x+(Integer)y;
		} else if (operation.equalsIgnoreCase("sub")) {
			total =  (Integer)x-(Integer)y;
		} else if (operation.equalsIgnoreCase("multiply")) {
			total =  (Integer)x*(Integer)y;
		} else if (operation.equalsIgnoreCase("divide")) {
			total =  (Integer)x/(Integer)y;
		}
		return total;
	}
	
	public double compute(String operation, double x, double y) {
		double total = 0;
		if(operation.equalsIgnoreCase("add")) {
			total = x+y;
		} else if (operation.equalsIgnoreCase("sub")) {
			total = x-y;
		} else if (operation.equalsIgnoreCase("multiply")) {
			total = x*y;
		} else if (operation.equalsIgnoreCase("divide")) {
			total = x/y;
		}
		return total ;
	}
	
	public float compute(String operation, float x, float y) {
		float total = 0;
		if(operation.equalsIgnoreCase("add")) {
			total = x+y;
		} else if (operation.equalsIgnoreCase("sub")) {
			total = x-y;
		} else if (operation.equalsIgnoreCase("multiply")) {
			total = x*y;
		} else if (operation.equalsIgnoreCase("divide")) {
			total = x/y;
		}
		return total ;
	} 

}
