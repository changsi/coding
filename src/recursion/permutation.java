/**
 * 
 */
package recursion;

/**
 * @author changsi
 *
 */
public class permutation {
	
	public static void permutation_string( char[] chars){
		char[] list = new char[chars.length];
		boolean [] used = new boolean[chars.length];
		permutation_print(list, chars, used, 0);
	}
	
	public static void permutation_print(char [] list, char[] chars, boolean[] used, int index){
		if(index == chars.length){
			System.out.println(list);
		}
		else{
			for(int i = 0; i< chars.length; i++){
				if(!used[i]){
					list[index] = chars[i];
					used[i]=true;
					permutation_print(list, chars, used, index +1);
					used[i]=false;
				}
				
			}
		}
	}
	
	public static void combination(String str){
		char [] chars = str.toCharArray();
		for(int i=1;i<=chars.length;i++){
			char [] output = new char[i];
			combination_print(output, chars, 0, i, 0);
		}
	}
	
	public static void combination_print( char[] output, char[] input, int input_index, int level, int output_index){
		if(level == 0){
			System.out.println(output);
		}
		else{
			for(;input_index< input.length;input_index++){
				output[output_index]=input[input_index];
				combination_print(output, input, input_index+1, level-1, output_index+1);
			}
		}
	}
	
	public static void phone_number(char [] numbers){
		char [][] keyboard= {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
		char [] letters = new char[numbers.length];
		phone_print(keyboard, numbers, letters, numbers.length, 0);
		
	}
	
	private static void phone_print(char[][] keyboard, char[] numbers, char[] letters, int length, int index){
		if(index == length){
			System.out.println(letters);
		}
		else{
			if(numbers[index] == '1' || numbers[index]=='0'){
				letters[index]=numbers[index];
				phone_print(keyboard, numbers, letters, length, index+1);
			}
			else{
				int keyboard_index = numbers[index]-'2';
				for(int i=0; i<keyboard[keyboard_index].length;i++){
					letters[index]= keyboard[keyboard_index][i];
					phone_print(keyboard, numbers, letters, length, index+1);
				}
			}
			
		}
	}
	
	public static int maxdiff(int [] array){
		for(int i=array.length-1; i>0; i--){
			int start=0;
			int end = 0+i;
			while(end<array.length){
				if(array[start]<array[end]){
					return i;
				}
				else{
					start++;
					end++;
				}
			}
		}
		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//497-1927
		//permutation.phone_number(new char[]{'4','9','7','1','9','2','7'});
		
		System.out.println(permutation.maxdiff(new int[]{5,1,2,3,4,1,2,3,1,1,1,1,1}));
	}

}
