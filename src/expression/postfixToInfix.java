/**
 * 
 */
package expression;

import java.util.Stack;

/**
 * @author changsi
 *
 */
public class postfixToInfix {
	
	public static String convert_postfix_to_infix(String exp){
		
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<exp.length();i++){
			char temp = exp.charAt(i);
			if(postfixToInfix.is_operand(temp)){
				stack.push(String.valueOf(temp));
			}
			if(postfixToInfix.is_operator(temp)){
				String a=stack.pop();
				String b=stack.pop();
				stack.push('('+a+temp+b+')');
			}
		}
		return stack.pop();
	}
	
	private static boolean is_operator(char a){
		if(a=='+' || a=='-' || a=='*' || a=='/'){
			return true;
		}else{
			return false;
		}
	}
	
	private static boolean is_operand(char b){
		if((b<='9'&& b>='0')||(b>='a' && b<='z')){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "abc*+de*f+g*+";
		System.out.println(postfixToInfix.convert_postfix_to_infix(exp));
	}

}
