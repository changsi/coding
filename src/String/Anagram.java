/**
 * 
 */
package String;

/**
 * @author changsi
 *
 */
public class Anagram {
	
	/*
	 * check whether two string are anagrams
	 */
	public static boolean check_anagrams(String str1, String str2){
		if(str1==null || str2 == null){
			return false;
		}
		if(str1.equals("") && str2.equals("")){
			return true;
		}
		char [] chars1 = str1.toLowerCase().toCharArray();
		char [] chars2 = str2.toLowerCase().toCharArray();
		int [] index = new int[26];
		int distinct_letter_number = 0;
		for(int i=0; i<chars1.length;i++){
			char temp = chars1[i];
			if(index[temp-'a']==0){
				distinct_letter_number++;
			}
			index[temp-'a']++;
		}
		
		for(int i=0; i<chars2.length;i++){
			char temp = chars2[i];
			if(index[temp-'a']>0){
				index[temp-'a']--;
				if(index[temp-'a']==0){
					distinct_letter_number--;
					if(distinct_letter_number==0){
						return chars2.length-1==i;
					}
				}
				
			}
			else{
				return false;
			}
		}
		return false;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Anagram.check_anagrams("sorftware", "oftsrarwer"));
	}

}

