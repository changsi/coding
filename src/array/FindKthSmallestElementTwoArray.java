/**
 * 
 */
package array;

/**
 * @author changsi
 *
 */
public class FindKthSmallestElementTwoArray {
	
	/*
		two sorted array like this and find the 6th smallest element
		1, 8, 23, 45, 48, 66, 69, 79, 112, 342
		5, 34, 39, 56, 87, 89, 110, 167, 179
	 */
	public static int findKthSmallestElement(int[] a, int a_start, int a_end, int[] b, int b_start, int b_end, int k){
		if(k==1){
			return a[a_start]>b[b_start] ? b[b_start]:a[a_start];
		}
		if(k==2){
			if(a[a_start]>b[b_start]){
				return a[a_start]>b[b_start+1]?b[b_start+1]:a[a_start];
			}
			else{
				return a[a_start+1]>b[b_start]?b[b_start]:a[a_start+1];
			}
		}
		int index = k%2==0?k/2-1:k/2;
		if(a[a_start+index]>b[b_start+index]){
			return findKthSmallestElement(a, a_start, a_start+index, b, b_start+index, b_end, k-index);
		}else{
			return findKthSmallestElement(a, a_start+index,a_end , b, b_start, b_start+index, k-index);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 8, 23, 45, 48, 66, 69, 79, 112, 342};
		int[] b= {5, 34, 39, 56, 87, 89, 110, 167, 179};
		System.out.println(findKthSmallestElement(a, 0, a.length-1, b, 0, b.length-1, 6));

	}

}
