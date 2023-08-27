
public class Calc {
	public Number compute(String operation, Object x, Object y) {
		double xDouble = Double.valueOf(String.valueOf(x));
		double yDouble = Double.valueOf(String.valueOf(y));

		double total = 0d;

		if (operation.equalsIgnoreCase("add")) {
			total = xDouble + yDouble;
		} else if (operation.equalsIgnoreCase("sub")) {
			total = xDouble - yDouble;
		} else if (operation.equalsIgnoreCase("multiply")) {
			total = xDouble * yDouble;
		} else if (operation.equalsIgnoreCase("divide")) {
			total = xDouble / yDouble;
		}

		if (x.getClass().getSimpleName().equalsIgnoreCase("Integer")) {
			return (int) total;
		} else if (x.getClass().getSimpleName().equalsIgnoreCase("Float")) {
			return (float) total;
		}

		return total;
	}
}
