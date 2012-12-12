/**
 * 
 */
package String;

/**
 * @author changsi
 *
 */
public class ReverseStringWords {
	
	public static void reverse_string_words(String str){
		char [] chars = str.toCharArray();
		ReverseStringWords.reverse_str(chars, 0 , chars.length-1);
		int start = 0;
		int i=0;
		int length = chars.length;
		while(i<length){
			if(chars[i]==' '){
				ReverseStringWords.reverse_str(chars, start , i-1);
				start = i+1;
			}
			i++;
		}
		ReverseStringWords.reverse_str(chars, start, length-1);
		System.out.println(chars);
	}
	
	public static void reverse_str(char [] chars, int start, int end){
		while(end > start){
			char temp = chars[end];
			chars[end] = chars[start];
			chars[start] = temp;
			end--;
			start++;
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "chang si si ai wei wei";
		ReverseStringWords.reverse_string_words(str);
	}

}
