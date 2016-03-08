package MyProject;

public class Area {
	
	
	/**
	 * Computers the area of a circle with the specified radius
	 * precondition: radius > 0
	 * @param radius
	 * 			radius of a circle
	 * @return
	 * 			the radius of a circle with the radius given as a parameter
	 */
	
	public static double computeArea(double radius) {
		if(radius < 0.0)
			throw new IllegalArgumentException("Radius < 0");
		return Math.PI * radius * radius;
	}
	
	/**
	 * 
	 * @param args
	 */
	
	public static void main(String [] args) {
		double r = 2.0;
		System.out.println("Area of a circle of radius " + r + " is " + computeArea(r));
	}

}
