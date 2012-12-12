/**
 * 
 */
package String;

/**
 * @author changsi
 *
 */
public class RemoveDuplicateChars {
	
	public static char[] removeDuplicateChars(char [] str){
		int tail=0;
		boolean unique=true;
		if(str==null|| str.length<=1){
			return null;
		}
		else{
			for(int i=0;i<str.length;i++){
				for(int j=0; j<tail;j++){
					if(str[j]==str[i]){
						unique=false;
						break;
					}
				}
				if(unique){
					str[tail]=str[i];
					tail++;
				}
				unique = true;
			}
		}
		char [] result = new char[tail];
		for(int i=0; i<tail; i++){
			result[i]=str[i];
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "";
		String b = "aabbb";
		String c = "aaaa";
		char [] temp;
		if((temp=RemoveDuplicateChars.removeDuplicateChars(a.toCharArray()))==null){
			System.out.println("null");
		}else{
			System.out.println(temp);
		}
		if((temp=RemoveDuplicateChars.removeDuplicateChars(null))==null){
			System.out.println("null");
		}else{
			System.out.println(temp);
		}
		System.out.println(RemoveDuplicateChars.removeDuplicateChars(b.toCharArray()));
		System.out.println(RemoveDuplicateChars.removeDuplicateChars(c.toCharArray()));


	}

}
