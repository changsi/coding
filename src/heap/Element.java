/**
 * 
 */
package heap;

/**
 * @author changsi
 *
 */
public class Element<K,T> {
	
	private K key;
	private T value;
	
	public Element(){
		this.setKey(null);
		this.setValue(null);
	}
	
	public Element(K key, T value){
		this.setKey(key);
		this.setValue(value);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setKey(K key) {
		this.key = key;
	}

	public K getKey() {
		return key;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

}
