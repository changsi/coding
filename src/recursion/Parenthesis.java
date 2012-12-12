/**
 * 
 */
package recursion;

/**
 * @author changsi
 *
 */
public class Parenthesis {

	public static void parenthesis(int n){
		char[] output = new char[2*n];
		print_parenthesis(0, n, n, output);
	}
	
	public static void print_parenthesis(int index, int opens,int closes, char[] output){
		if(index ==output.length){
			System.out.println(output);
			return;
		}
		if(opens>0){
			output[index] = '(';
			print_parenthesis(index+1, opens-1,closes, output);
		}
		if(closes>0 && opens<closes){
			output[index] = ')';
			print_parenthesis(index+1, opens, closes-1, output);
		}
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parenthesis.parenthesis(4);
	}

}
