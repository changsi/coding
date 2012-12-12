/**
 * 
 */
package expression;

import java.util.Stack;

/**
 * @author changsi
 *
 */
public class InfixToPostfix {
	
	public static String convert_infix_to_postfix(String infix){
		StringBuffer postfix = new StringBuffer();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<infix.length();i++){
			char temp = infix.charAt(i);
			if(temp =='('){
				stack.push(temp);
			}
			else if(temp ==')'){
				char a;
				while(!stack.isEmpty()&&(a=stack.pop())!='('){
					postfix.append(a);
				}
				
			}else if(InfixToPostfix.is_operand(temp)){
				postfix.append(temp);
			}
			else{
				while(true){
					if(stack.isEmpty()){
						stack.add(temp);
						break;
					}
					else{
						if(InfixToPostfix.is_precedent(temp, stack.peek())){
							stack.add(temp);
							break;
						}else{
							postfix.append(stack.pop());
						}
					}
					
				}
				
			}
		}
		while(!stack.isEmpty()){
			postfix.append(stack.pop());
		}
		return postfix.toString();
	}
	
	private static boolean is_precedent(char a, char b){
		if(((a=='*' || a =='/')&& (b=='+' || b=='-')) || b=='('){
			return true;
		}else{
			return false;
		}
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
		String exp = "(a+b*c)+((d*e+f)*g)";
		System.out.println(InfixToPostfix.convert_infix_to_postfix(exp));

	}

}
