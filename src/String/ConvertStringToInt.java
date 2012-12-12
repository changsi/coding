/**
 * 
 */
package String;

import java.util.ArrayList;

/**
 * @author changsi
 *
 */
public class ConvertStringToInt {
	
	public static int convertStringToInt(String str){
		char [] chars = str.toCharArray();
		int j=0;
		int result=0;
		for(int i=chars.length-1;i>=0;i--){
			int tenth = 1;
			for(int k=1;k<=j;k++){
				tenth = tenth * 10;
			}
			result = result + ((int)(chars[i]-'0') * tenth);
			j++;
		}
		return result;
	}
	
	// testing case 0 -1 1 123 -123 positive and negative upper bound
	public static int string_to_integer(String numb){
		int result=0;
		boolean neg=false;
		int i=0;
		if(numb.charAt(i)=='-'){
			neg = true;
			i++;
		}	
		while(i<numb.length()){
			result = result * 10 + (int)(numb.charAt(i)-'0');
			i++;
		}
		
		if(neg){
			result = result*-1;
		}
		return result;

	}
	// testing cases 0, -1, 1, 123, -123, maximum, minimum
	public static String integer_to_string(int numb){
		char [] result = new char[11];
		boolean neg=false;
		if(numb<0){
			neg=true;
			numb = numb*(-1);
		}
		
		int i=0;
		do{
			result[i++]=(char)(numb%10+'0');
			numb = numb/10;
		}while(numb>0);
		if(neg){
			result[i++]='-';
		}
		i--;
		reverse_char_array(result, 0, i);
		return new String(result, 0, i+1);
		
	}

	public static void reverse_char_array(char[] a, int start, int end){
		while(start<end){
			char temp = a[start];
			a[start]=a[end];
			a[end]=temp;
			start++;
			end--;
		}
	}
	
	public static int convertStringToInt2(String str){
		char [] chars =str.toCharArray();
		boolean negative = false;
		if(chars[0]=='-'){
			negative = true;
		}
		int result = 0;
		for(int i=0;i<chars.length;i++){
			if(chars[i]<='9' && chars[i]>='0'){
				result = result *10;
				result = result +(int) chars[i]-'0';
			}
		}
		
		if(negative){
			result = result*-1;
		}
		return result;
	}
	
	public static char[] convertIntToString(int integer){
		StringBuffer chars = new StringBuffer();
		while(integer >= 10){
			int temp = integer%10;
			chars.append((char) (temp+'0'));
			integer = integer /10;
		}
		chars.append((char) (integer+'0'));
		char[] result = chars.toString().toCharArray();
		reverse_str(result, 0, result.length-1);
		return result;
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
		int [] a = new int[10];
		for(int i=0; i<a.length;i++){
			System.out.println(a[i]);
		}
		
	}

}
