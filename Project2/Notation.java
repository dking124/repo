/**
 * 
 * @author Darren King
 *
 */
public class Notation {
	public Notation() {
		
	}
	/**
	 * Method that takes given infix expression and converts it into a postfix expression.
	 * @param infix
	 * @return postfix
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		String postfix = "";
		NotationQueue<Character> queue = new NotationQueue<>(infix.length());
		NotationStack<Character> operatorStack = new NotationStack<>(infix.length());
		for(int i = 0; i < infix.length(); i++) {
			Character currentChar = infix.charAt(i);
			if(currentChar == ' ') {
				
			}
			else if(currentChar == '0' || currentChar == '1' || currentChar == '2' || currentChar == '3' || currentChar == '4' || currentChar == '5'
					|| currentChar == '6' || currentChar == '7' || currentChar == '8' || currentChar == '9') {
				try {
					queue.enqueue(currentChar);
				} catch (QueueOverflowException e) {
					e.getMessage();
				}
			}
			else if(currentChar == '(') {
				try {
					operatorStack.push(currentChar);
				} catch (StackOverflowException e) {
					e.getMessage();
				}
			}
			else if(currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
				try {
					if(operatorStack.top() >= currentChar && !operatorStack.isEmpty()) {
						queue.enqueue(operatorStack.pop());
					}
					operatorStack.push(currentChar);
				} catch (StackUnderflowException e) {
					e.getMessage();
					throw new InvalidNotationFormatException();
				} catch (QueueOverflowException e) {
					e.getMessage();
					throw new InvalidNotationFormatException();
				} catch (StackOverflowException e) {
					e.getMessage();
					throw new InvalidNotationFormatException();
				}
			}
			else if(currentChar == ')') {
				try {
					Character c = operatorStack.pop();
					while(c != '(') {
						queue.enqueue(c);
						c = operatorStack.pop();
					}
					
				} catch (StackUnderflowException e) {
					e.getMessage();
					throw new InvalidNotationFormatException();
				} catch (QueueOverflowException e) {
					e.getMessage();
					throw new InvalidNotationFormatException();
				}
			}
			else
				throw new InvalidNotationFormatException();
		}
		
		try {
			while(!operatorStack.isEmpty()) {
				Character c = operatorStack.pop();
				queue.enqueue(c);
			}
		} catch (StackUnderflowException e) {
			e.getMessage();
		} catch (QueueOverflowException e) {
			e.getMessage();
		}
			
		postfix = queue.toString();
		return postfix;
	}
	/**
	 * Method that takes given postfix expression and converts it into infix expression
	 * @param postfix
	 * @return string
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		NotationStack<String> string = new NotationStack<>();
		for(int i = 0; i < postfix.length(); i++) {
			Character currentChar = postfix.charAt(i);
			if(currentChar == ' ') {
				
			}
			else if(currentChar == '0' || currentChar == '1' || currentChar == '2' || currentChar == '3' || currentChar == '4' || currentChar == '5'
					|| currentChar == '6' || currentChar == '7' || currentChar == '8' || currentChar == '9') {
				try {
					string.push(String.valueOf(currentChar));
				} catch (StackOverflowException e) {
					e.getMessage();
				}
				}
			else if(currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
				try {
					String s1 = string.pop();
					String s2 = string.pop();
					String temp = "" + s2 + currentChar + s1;
					String encapsulate = "(" + temp + ")";
					string.push(encapsulate);
				} catch (StackUnderflowException e) {
					e.getMessage();
					throw new InvalidNotationFormatException();
				} catch (StackOverflowException e) {
					e.getMessage();
					throw new InvalidNotationFormatException();
				}
			}
			else
				throw new InvalidNotationFormatException();
		}
		if(string.size() > 1)
			throw new InvalidNotationFormatException();
		return string.toString();
	}
	/**
	 * Method that takes given postfix expression, evaluates it, and returns the answer
	 * @param postfixExpr
	 * @return result
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		double result = 0;
		NotationStack<Double> doubleStack = new NotationStack<>();
		for(int i = 0; i < postfixExpr.length(); i++) {
			Character currentChar = postfixExpr.charAt(i);
			if(currentChar == ' ') {
				
			}
			else if(currentChar == '0' || currentChar == '1' || currentChar == '2' || currentChar == '3' || currentChar == '4' || currentChar == '5'
					|| currentChar == '6' || currentChar == '7' || currentChar == '8' || currentChar == '9') {
				try {
					doubleStack.push((double)(currentChar - '0'));
				} catch (StackOverflowException e) {
					e.getMessage();
				}
			}
			else if(currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
				try {
					double value1 = doubleStack.pop();
					double value2 = doubleStack.pop();
					if(currentChar == '+')
						doubleStack.push(value2 + value1);
					else if(currentChar == '-')
						doubleStack.push(value2 - value1);
					else if(currentChar == '*')
						doubleStack.push(value2 * value1);
					else if(currentChar == '/')
						doubleStack.push(value2 / value1);
					
				} catch (StackUnderflowException e) {
					e.getMessage();
					throw new InvalidNotationFormatException();
				} catch (StackOverflowException e) {
					e.getMessage();
					throw new InvalidNotationFormatException();
				}
			}
			else
				throw new InvalidNotationFormatException();
		}
		try {
			result = doubleStack.pop();
		} catch (StackUnderflowException e) {
			e.getMessage();
		}
		return result;
	}
}
