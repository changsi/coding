/**
 * 
 */
package HashTable;

/**
 * @author changsi
 *
 */
public class MyHashTable<K, T> {
	
	private Item<K, T> [] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyHashTable(){
		this.array = new Item[100];
		this.size = 100;
	}
	
	@SuppressWarnings("unchecked")
	public MyHashTable(int numb){
		this.array = new Item[numb];
		this.size = numb;
	}
	
	public void put(K key, T value){
		int index = this.hash(key);
		Item<K, T> temp = new Item<K, T>(key, value);
		if(this.array[index]==null){
			this.array[index] = temp;
			return;
		}
		else{
			temp.next = this.array[index];
			this.array[index] = temp;
		}
		
	}
	
	public T get(K key){
		Item<K, T> start = this.array[this.hash(key)];
		while(start != null){
			if(start.key.equals(key)){
				return start.value;
			}
			else{
				start = start.next;
			}
		}
		return null;
	}
	
	public void print(){
		for(int i=0; i<this.size;i++){
			Item<K, T> start = this.array[i];
			System.out.print("index "+i+"     ");
			while(start!=null){
				System.out.print(start.key+" "+start.value+"	");
				start = start.next;
			}
			System.out.println("null");
		}
	}
	
	
	
	private int hash(K key){
		return key.hashCode()%this.size;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashTable<String, Integer> hashtable = new MyHashTable<String, Integer>(100);
		for(int i=0; i<200;i++){
			hashtable.put(Integer.toString(i), i);
		}
		hashtable.print();
		
		System.out.println(hashtable.get("187"));
		System.out.println(hashtable.get("32"));
	}

}



class Item<K, T>{
	K key;
	T value;
	Item<K, T> next;
	
	public Item(){
		this.key=null;
		this.value = null;
		this.next = null;
	}
	
	public Item(K key, T value){
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	
}
