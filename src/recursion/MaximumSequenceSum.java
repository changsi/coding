/**
 * 
 */
package recursion;

/**
 * @author changsi
 *
 */
public class MaximumSequenceSum {
	
	public static int maximum_sequence_sum(int [] array){
		return maximum_sequence(array, 0, array.length-1);
	}
	
	private static int max(int a, int b, int c){
		if(a>b){
			if(a>c){
				return a;
			}
			else{
				return c;
			}
		}
		else{
			if(b>c){
				return b;
			}
			else{
				return c;
			}
		}
	}
	
	private static int maximum_sequence(int [] array, int left, int right){
		if(left == right){
			return array[left];
		}
		else{
			int maximum_left_sum;
			int maximum_right_sum;
			int center = (right - left)/2+left;
			maximum_left_sum = maximum_sequence(array, left, center);
			maximum_right_sum = maximum_sequence(array, center+1, right);
			int sum_left=0;
			int maximum_left_border_sum=array[center];
			int maximum_right_border_sum=array[center+1];
			for(int i=center; i>=left; i--){
				sum_left = sum_left+array[i];
				if(sum_left>maximum_left_border_sum){
					maximum_left_border_sum = sum_left;
				}
			}
			
			int sum_right=0;
			for(int i=center+1; i<=right; i++){
				sum_right = sum_right+array[i];
				if(sum_right>maximum_right_border_sum){
					maximum_right_border_sum = sum_right;
				}
			}
			
			return max(maximum_left_sum, maximum_right_sum, maximum_right_border_sum+maximum_left_border_sum);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {4, -3, 5, -2,-1,2,6,-2};
		System.out.println(MaximumSequenceSum.maximum_sequence_sum(array));
	}

}
