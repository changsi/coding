/**
 * 
 */
package String;

/**
 * @author changsi
 *
 */
public class FindFirsrNonRepeatedCharacter {
	
	public static Character find_first_nonrepeated_character(String str){
		//build a hashtable for each character
		//the key is the character and value is counts
		if(str == null){
			return null;
		}
		
		int [] hashmap = new int [128];
		int length = str.length();
		if(length == 0){
			return null;
		}
		int i=0;
		while(i<length){
			char temp = str.charAt(i);
			hashmap[(int)temp]++;
			i++;
		}
		
		i = 0;
		while(i<length){
			char temp = str.charAt(i);
			if(hashmap[(int)temp]==1){
				return temp;
			}
			i++;
		}
		return null;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character a = null;
		if((a = FindFirsrNonRepeatedCharacter.find_first_nonrepeated_character("aabccd")) != null){
			System.out.println(a);
		}
		else{
			System.out.println("null");
		}
	}

}
