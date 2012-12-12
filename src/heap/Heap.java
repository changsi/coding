/**
 * 
 */
package heap;

import java.util.ArrayList;

/**
 * @author changsi
 * 
 */
public class Heap< T> {

	private int size;
	private ArrayList<Element<Integer, T>> array;

	public Heap() {
		this.setSize(0);
		this.setArray(new ArrayList<Element<Integer, T>>());
	}

	public Heap(int size) {
		this.setSize(0);
		this.setArray(new ArrayList<Element<Integer, T>>(size));
	}

	public boolean insert(Integer key, T value) {
		Element<Integer, T> temp = new Element<Integer, T>(-1, value);
		this.size++;
		this.array.add(this.size-1, temp);
		if(this.increase_key(this.size-1, key)){
			return true;
		}
		else return false;
	}

	public Element<Integer, T> maximum() {
		if (this.size > 0) {
			return this.array.get(0);
		} else
			return null;
	}

	public  T extract_maximum() {
		if(this.size==0){
			System.out.println("the heap is empty");
			return null;
		}
		else{
			Element<Integer, T> temp = this.array.get(0);
			this.array.set(0, this.array.get(this.size-1));
			this.array.set(this.size-1, null);
			this.size--;
			if(this.size!=0){	
				this.heapify(0);
			}
			return temp.getValue();
			
			
		}
	}
	public  Element<Integer, T> extract_maximum1() {
		if(this.size==0){
			System.out.println("the heap is empty");
			return null;
		}
		else{
			Element<Integer, T> temp = this.array.get(0);
			this.array.set(0, this.array.get(this.size-1));
			this.array.set(this.size-1, null);
			this.size--;
			if(this.size!=0){	
				this.heapify(0);
			}
			return temp;
			
			
		}
	}
	
	public boolean isEmpty(){
		if(this.size==0){
			return true;
		}else{
			return false;
		}
	}

	private boolean increase_key(int index, Integer key) {
		if(index >= this.size){
			System.out.println("the index "+index+" is out of bound!");
			return false;
		}
		if(key < this.array.get(index).getKey()){
			System.out.println("the current key "+key+" is less than the original one "+this.array.get(index).getKey());
			return false;
		}
		
		this.array.get(index).setKey(key);
		while(index>0 && this.array.get(index).getKey()>this.array.get(this.get_parent(index)).getKey()){
			Element<Integer, T> temp = this.array.get(index);
			this.array.set(index, this.array.get(this.get_parent(index)));
			this.array.set(this.get_parent(index), temp);
			index = this.get_parent(index);
		}
		return true;
		
	}

	private boolean heapify( int index ){
		if(index >= this.size){
			System.out.println("the index "+index+" is out of bound!");
			return false;
		}
		int left = this.get_left(index);
		int right = this.get_right(index);
		int largest;
		if(left < this.size && this.array.get(index).getKey()<this.array.get(left).getKey()){
			largest = left;
		}
		else{
			largest = index;
		}
		if(right < this.size && this.array.get(largest).getKey()<this.array.get(right).getKey()){
			largest = right;
		}
		if(largest != index){
			Element<Integer, T> temp = this.array.get(index);
			this.array.set(index, this.array.get(largest));
			this.array.set(largest, temp);
			heapify(largest);
		}
		return true;
	}

	private int get_left(int index) {
		int left = (index + 1) * 2 - 1;
		return left;

	}

	private int get_right(int index) {
		int right = (index + 1) * 2;
		return right;
	}

	private int get_parent(int index) {
		int parent = (index + 1) / 2 - 1;
		return parent;
	}
	
	public void print_heap(){
		StringBuffer str = new StringBuffer();
		for(int i=0;i<this.array.size();i++){
			str.append(this.array.get(i).getKey()+" ");
		}
		System.out.println(str.toString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap<String> heap = new Heap<String>(100);
		Element<Integer, String> element;
		element= heap.maximum();
		if(element !=null){
			System.out.println("key: "+ element.getKey()+" value: "+ element.getValue());
		}
		else{
			System.out.println("null");
		}
		
		element= heap.extract_maximum1();
		if(element !=null){
			System.out.println("key: "+ element.getKey()+" value: "+ element.getValue());
		}
		else{
			System.out.println("null");
		}
		heap.insert(100, "100");
		heap.insert(200, "200");
		heap.insert(1, "1");
		heap.insert(23, "23");
		heap.insert(234, "234");
		heap.insert(56, "56");
		heap.print_heap();
		int i=0;
		while(i<10){
			element= heap.extract_maximum1();
			if(element !=null){
				System.out.println("key: "+ element.getKey()+" value: "+ element.getValue());
			}
			else{
				System.out.println("null");
			}
			i++;
		}
	}

	public void setArray(ArrayList<Element<Integer, T>> array) {
		this.array = array;
	}

	public ArrayList<Element<Integer, T>> getArray() {
		return array;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

}
