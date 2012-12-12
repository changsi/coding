/**
 * 
 */
package recursion;

/**
 * @author changsi
 *
 */
public class BinarySearch {
	
	public static int binarySearch(int [] array, int start, int end, int value){
		if(start == end){
			if(array[start]==value){
				return start;
			}
			else{
				return -1;
			}
		}
		if(start> end){
			return -1;
		}
		else{
			int mid = (end-start)/2+start;
			if(array[mid]>value){
				return binarySearch( array, start, mid-1, value);
			}
			else{
				if(array[mid]<value){
					return binarySearch(array, mid+1, end, value);
				}
				else{
					return mid;
				}
			}
		}
	}
	
	public static int binarySearch_iterative(int [] array, int start, int end, int value){
		if(start == end){
			if(array[start]==value){
				return start;
			}
			else{
				return -1;
			}
		}
		else if(start>end){
			return -1;
		}
		else{
			while(true){
				int mid = start+(end-start)/2;
				if(start == end){
					if(array[start]==value){
						return start;
					}
					else{
						return -1;
					}
				}
				if(value>array[mid]){
					start = mid+1;
				}
				else if(value < array[mid]){
					end = mid -1;
				}
				else{
					return mid;
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,3,5,6,12,34,65,76,87,90,112,113,2345,24455,323342};
		System.out.println(BinarySearch.binarySearch_iterative(array, 0, array.length-1,34));
	}

}
