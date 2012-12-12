/**
 * 
 */
package array;

/**
 * @author changsi
 *
 */
public class FindKthElement {
	
	public static int find(int [] array, int k){
		try {
			return find_kth_element(array, 0, array.length-1, k);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int find_kth_element(int[] array, int start, int end, int k) throws Exception{
		if(k>(end-start+1)){
			throw new Exception("error!");
		}
		if(start == end){
			return array[start];
		}
		if(start == end-1){
			if(k==1){
				return array[start]<array[end]? array[start]:array[end];
			}else{
				return array[start]>array[end]? array[start]:array[end];
			}
		}
		int start_pointer =  start;
		int end_pointer = end-1;
		int pivot = (int)(Math.random()*(end-start))+start;
		swich(array, pivot, end);
		while(start_pointer<end_pointer){
			while(start_pointer<end_pointer && array[start_pointer]<array[end]){
				start_pointer++;
			}
			while(start_pointer<end_pointer && array[end_pointer]>=array[end]){
				end_pointer--;
			}
			if(start_pointer != end_pointer){
				swich(array, start_pointer, end_pointer);
			}
		}
		int position;
		if(array[start_pointer]>=array[end]){
			swich(array, start_pointer, end);
			position=start_pointer;
		}else{
			position=end;
		}
		if(position-start+1==k){
			return array[position];
		}
		else{
			if(position-start+1>k){
				return find_kth_element(array, start, position-1,k);
			}else{
				return find_kth_element(array, position+1, end, k-(position-start+1));
			}
		}
		
		
	}
	
	public static void swich(int [] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,2,3,4,5,6,7,12,224,32,65,11,111};
		System.out.println(FindKthElement.find(array, 8));
	}

}
