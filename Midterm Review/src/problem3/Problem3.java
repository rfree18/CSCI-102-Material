package problem3;

public class Problem3 {
	
	public static double iterative(double x, int n) {
		double sum = x;
		
		for(int i = 0; i < n-1; i++) {
			sum = sum * x;
		}
		
		return sum;
	}
	
	public static double recursive(double x, int n) {
		if(n == 0) {
			return 1.0;
		}
		
		else if(n == 1) {
			return x;
		}
		
		else {
			return recursive(x, n-1) * x;
		}
	}

	public static void main(String[] args) {
		System.out.println(iterative(2, 5));
		
		System.out.println(recursive(2, 5));

	}

}
