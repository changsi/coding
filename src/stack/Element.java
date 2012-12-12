/**
 * 
 */
package stack;

/**
 * @author changsi
 *
 */
public class Element<T> {
	
	private Element<T> next;
	private T value;
	
	public Element(){
		this.setNext(null);
		this.setValue(null);
	}
	
	public Element(T value){
		this.setNext(null);
		this.setValue(value);
	}
	
	public Element(Element<T> next, T value){
		this.setNext(next);
		this.setValue(value);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setNext(Element<T> next) {
		this.next = next;
	}

	public Element<T> getNext() {
		return next;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

}
