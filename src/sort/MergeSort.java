/**
 * 
 */
package sort;

/**
 * @author changsi
 *
 */
public class MergeSort {
	
	public static void merge_sort(int array[], int temp[],  int start, int end){
		if(start == end){
			return;
		}
		else{
			int mid = (end - start) /2 + start;
			merge_sort(array, temp, start, mid);
			merge_sort(array, temp, mid+1, end);
			
			for(int i=start; i<=end; i++ ){
				temp[i] = array[i];
			}
			int first_pointer = start;
			int second_pointer = mid+1;
			int index = start;
			while(first_pointer <= mid && second_pointer <=end ){
				if(temp[first_pointer]> temp[second_pointer]){
					array[index]=temp[second_pointer];
					index++;
					second_pointer++;
				}
				else{
					array[index]=temp[first_pointer];
					index++;
					first_pointer++;
				}
			}
			if(first_pointer<=mid){
				while(first_pointer <= mid){
					array[index] = temp[first_pointer];
					index++;
					first_pointer++;
				}
			}
			if(second_pointer<=end){
				while(second_pointer <= end){
					array[index] = temp[second_pointer];
					index++;
					second_pointer++;
				}
			}
			
		}
	}
	
	
	
	private static void print_array(int [] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = new int[]{3,7,8,5,2,1,9,5,2,3,4,43,4};
		int [] temp = new int[array.length];
		MergeSort.merge_sort(array, temp, 0, array.length-1);
		MergeSort.print_array(array);
	}

}
