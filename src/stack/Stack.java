/**
 * 
 */
package stack;

/**
 * @author changsi
 * 
 */
public class Stack<T> {

	private Element<T> header;

	public Stack() {
		this.header = null;
	}

	public boolean push(T value) {
		Element<T> element = new Element<T>(value);
		element.setNext(this.header);
		this.header = element;
		return true;
	}
	
	public T pop(){
		if(this.header == null){
			System.out.println("this stack is empty!");
			return null;
		}
		else{
			Element<T> temp= this.header;
			this.header = this.header.getNext();
			return temp.getValue();
		}
	}
	
	public boolean delete_stack(){
		while(this.header !=null){
			this.header= this.header.getNext();
		}
		return true;
	}
	
	public void print_stack(){
		Element<T> temp= this.header;
		while(temp!=null){
			System.out.println(temp.getValue().toString());
			temp= temp.getNext();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<String> stack = new Stack<String>();
		if(stack.push("1a")){
			System.out.println("push 1a");
		}
		if(stack.push("2a")){
			System.out.println("push 2a");
		}
		if(stack.push("3a")){
			System.out.println("push 3a");
		}
		if(stack.push("4a")){
			System.out.println("push 4a");
		}
		stack.print_stack();
		String value = null;
		for(int i=0;i<10;i++){
			if((value = stack.pop()) !=null){
				System.out.println("pop "+value);
			}
		}
		
		
		
		
		
	}

}
