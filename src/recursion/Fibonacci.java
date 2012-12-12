/**
 * 
 */
package recursion;

/**
 * @author changsi
 *
 */
public class Fibonacci {

	public static int fibonacci(int a){
		if(a==0){
			return 0;
		}
		if(a==1){
			return 1;
		}
		int first = 1;
		int second = 0;
		for(int i=2;i<=a;i++){
			int temp = first+second;
			second = first;
			first = temp; 
		}
		return first;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Fibonacci.fibonacci(12));
	}

}
