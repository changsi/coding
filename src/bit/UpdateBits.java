/**
 * 
 */
package bit;

/**
 * @author changsi
 *
 */
public class UpdateBits {
	
	public static int update_bits(int a, int b, int i, int j){
		int left = (1<<i)-1;
		int right = -1^((1<<(j))-1);
		return (a &(left | right)) | (b<<i);
	}
	
	public static void printBinary(int a){
		for(int i=31; i>=0; i--){
			int b = a>>i;
			if((b&1)>0){
				System.out.print("1");
			}else{
				System.out.print("0");
			}
		}
		System.out.println();
	}
	
	public static int largest(int a){
		int b=0;
		for(int i=0; i<32;i++){
			if(((a>>i)&1)>0){
				b++;
			}
		}
		int temp = smallest_util(b);
		return temp<<(32-b);
	}
	
	public static int smallest_util(int a){
		int result =0;
		for(int i=0;i<a;i++){
			result = result+(1<<i);
		}
		return result;
	}
	
	
	public static int smallest(int a){
		int b=0;
		for(int i=0; i<32;i++){
			if(((a>>i)&1)>0){
				b++;
			}
		}
		return smallest_util(b);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int a= 1024;
		UpdateBits.printBinary(UpdateBits.update_bits(1024, 21, 2, 6));
		UpdateBits.printBinary(-1^((1<<(6))-1));*/
		UpdateBits.printBinary(21);
		UpdateBits.printBinary(UpdateBits.largest(21));
		UpdateBits.printBinary(UpdateBits.smallest(21));
	}

}
