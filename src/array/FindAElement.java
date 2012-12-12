package array;

public class FindAElement {
	
	public static int binarySearch( int[] array, int start, int end, int target){
		
		if(start> end){
			return -1;
		}
		if(start == end){
			if(target==array[start]){
				return start;
			}
			else return -1;
		}
		
		int mid = start + (end-start)/2;
		
		if(array[mid] == target){
			return mid;
		}
		
		if(array[mid]<target){
			return binarySearch(array, mid+1, end, target);
		}else{
			return binarySearch(array, start, mid-1, target);
		}
		
	}
	
	//search shifted sorted array
	// the same idea as binary search: divided and conquer
	//example {2311, 2999, 1, 2, 5, 8, 11, 34, 342, 1123}
	public static int shiftedArraySearch( int [] array, int start, int end, int target){
		if(start > end){
			return -1;
		}
		if(start == end){
			if(target==array[start]){
				return start;
			}
			else return -1;
		}
		int mid = start + (end - start) / 2;
		if(array[mid] == target){
			return mid;
		}
		
		if(array[start] < array[mid]){ // the left part is sorted
			if(array[mid] > target && target > array[start]){
				return binarySearch(array, start, mid-1, target);
			}else{
				return shiftedArraySearch(array, mid+1, end, target);
			}
		}else{	// the right part is sorted
			if(array[mid] < target && array[end] > target){
				return binarySearch(array, mid+1, end, target);
			}else{
				return shiftedArraySearch(array, start, mid-1, target);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1, 2, 5, 8, 11, 34, 342, 1123, 2311, 2999};
		System.out.println(FindAElement.binarySearch(array, 0, array.length-1, 5));
		System.out.println(FindAElement.binarySearch(array, 0, array.length-1, 100));
		
		int [] array2 = {2311, 2999, 1, 2, 5, 8, 11, 34, 342, 1123};
		System.out.println(FindAElement.shiftedArraySearch(array2, 0, array2.length-1, 2999));
		System.out.println(FindAElement.shiftedArraySearch(array2, 0, array2.length-1, 100));
	}

}
