/**
 * 
 */
package recursion;

/**
 * @author changsi
 *
 */
public class PrintBySingleDigit {
	
	public static void print_by_single_digit(int number){
		if(number/10==0){
			System.out.print(number);
		}else{
			print_by_single_digit(number/10);
			System.out.print(number%10);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintBySingleDigit.print_by_single_digit(23456);
	}

}
