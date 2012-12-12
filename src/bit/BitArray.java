/**
 * 
 */
package bit;

/**
 * @author changsi
 *
 */
public class BitArray {
	
	private int array[];
	
	public BitArray(int size){
		this.array =new int[(size>>5)+1];
	}
	
	
	public boolean get(int position){
		int words = position>>5;
		int pos = position & 0x1F;
		return ((this.array[words]>>pos) & 0x01)!=0;
	}
	
	public void set(int position){
		int words = position>>5;
		int pos = position & 0x1F;
		this.array[words] = this.array[words] | (0x01<<pos);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BitArray array = new BitArray(65535);
		System.out.println(array.get(4320));
		array.set(4320);
		System.out.println(array.get(4320));
		
		
	}

}
