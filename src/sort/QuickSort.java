/**
 * 
 */
package sort;

/**
 * @author changsi
 *
 */
public class QuickSort {
	
	public static void quick_sort(int [] array, int start, int end){
		if(start == end){
			return;
		}
		else{
			if(start == end-1){
				if(array[start] > array[end]){
					swich(array, end, start);
					return;
				}
				else{
					return;
				}
			}
			else{
				int mid = (end - start)/2 + start;
				int pivot_value = array[mid];
				swich(array, end, mid);
				int start_pointer = start;
				int end_pointer = end-1;
				while(start_pointer < end_pointer){
					while(array[start_pointer]<pivot_value && start_pointer< end_pointer){
						start_pointer++;
					}
					while(array[end_pointer]>=pivot_value && end_pointer > start_pointer){
						end_pointer--;
					}
					if(start_pointer<end_pointer){
						swich(array, start_pointer, end_pointer);
					}
					
				}
				swich(array, start_pointer, end);
				
				if(start< start_pointer -1){
					quick_sort( array, start, start_pointer-1);
				}
				if(end>start_pointer +1){
					quick_sort(array, start_pointer+1, end);
				}
				
			}
			
			return;
			
		}
		
	}
	
	private static void swich(int [] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = new int[]{1,2,3,4,5,6,7};
		
		QuickSort.quick_sort(array, 0, array.length-1);
		for(int i=0; i<array.length;i++){
			System.out.print(array[i]);
		}
	}

}
