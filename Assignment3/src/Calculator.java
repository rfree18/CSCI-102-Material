import java.util.Stack;

public class Calculator {
	
	/**
	 * Converts a legal infix String expression to prefix
	 * 
	 * @param exp
	 * 		a String containing an arithmetic expression in infix notation
	 * @return
	 * 		a String representing the given infix expression in prefix notation
	 */

	public static String infixToPrefix(String exp) {
		String [] vals = exp.split(" ");
		
		String prefix = "";
		
		Stack<String> operands = new Stack<String>();
		Stack<String> operators = new Stack<String>();
		Stack<String> result = new Stack<String>();
		
		for(String e : vals) {
			operands.push(e);
		}
		
		String num1 = "";
		String num2 = "";
		
		while(!operands.isEmpty()) {
			String val = operands.pop();
			
			if(isOperator(val))
				operators.push(val);
			else if(val.equals("(")) {
				
				if(!num1.equals(""))
					result.push(num1);
				if(!num2.equals(""))
					result.push(num2);
				result.push(operators.pop());
				
				num1 = "";
				num2 = "";
			}
			else if(!val.equals(")")) {
				if(num1.equals(""))
					num1 = val;
				else
					num2 = val;
			}
		}
		
		while(!result.isEmpty()) {
			prefix = prefix + result.pop() + " ";
		}

		return prefix;

	}

	/**
	 * Evaluates a legal arithmetic string in prefix notation
	 * 
	 * @param exp
	 * 		a String containing the arithmetic expression in prefix notation
	 * @return
	 * 		the double value of the evaluated expression
	 */

	public static double evalPrefix(String exp) {
		String [] vals = exp.split(" ");

		Stack<String> stack = new Stack<String>();

		int counter = 0;

		for(String s : vals) {

			if(isOperator(s)) {
				stack.push(s);
				counter = 0;
			}
			else if (counter == 1) {
				String conv1 = stack.pop();
				String conv2 = s;
				String operator = stack.pop();

				String value = String.valueOf(performOperation(conv1, conv2, operator));
				stack.push(value);

				counter = 0;
			}

			else {
				stack.push(s);
				counter++;
			}
		}

		String conv2 = stack.pop();
		String conv1 = stack.pop();
		String operator = stack.pop();

		return performOperation(conv1, conv2, operator);

	}

	/**
	 * Determines if a given string is a standard operator
	 * 
	 * @param s
	 * 		a String object to be tested
	 * @return
	 * 		a boolean indicating true if it is an operator or false otherwise
	 */

	private static boolean isOperator(String s) {
		if(s.equals("/"))
			return true;
		else if(s.equals("*"))
			return true;
		else if(s.equals("+"))
			return true;
		else if(s.equals("-"))
			return true;
		else
			return false;
	}

	/**
	 * Performs a single arithmetic operation from given string values
	 * 
	 * @param s1
	 * 		the first value of the expression
	 * @param s2
	 * 		the second value of the expression
	 * @param op
	 * 		the operation to be performed between s1 and s2
	 * @return
	 * 		the double value of the expression 
	 */

	private static double performOperation(String s1, String s2, String op) {
		double conv1 = Double.parseDouble(s1);
		double conv2 = Double.parseDouble(s2);
		String operator = op;

		double finalVal = 0;

		if(operator.equals("+")) 
			finalVal = conv1 + conv2;
		else if(operator.equals("-"))
			finalVal = conv1 - conv2;
		else if(operator.equals("/"))
			finalVal = conv1 / conv2;
		else if(operator.equals("*"))
			finalVal = conv1 * conv2;

		return finalVal;
	}

	
	public static void main(String [] args) {
		System.out.println(evalPrefix("− 5 * 6 7"));
	}
}