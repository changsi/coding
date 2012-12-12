/**
 * 
 */
package queue;

import stack.Element;

/**
 * @author changsi
 *
 */
public class Queue<T> {
	
	int size;
	Element<T> front;
	Element<T> end;
	
	public Queue(){
		this.size=0;
		this.front=null;
		this.end=null;
	}
	
	public void push(T element){
		Element<T> temp = new Element<T>(element);
		if(this.size==0){
			this.front=temp;
			this.end = temp;
		}
		else{
			this.end.setNext(temp);
			this.end=temp;
		}
		this.size++;
	}
	
	public T pop(){
		Element<T> temp = this.front;
		if(temp == null){
			return null;
		}else{
			this.front=this.front.getNext();
			if(this.size==1){
				this.end=null;
			}
			this.size--;
			return temp.getValue();
		}
	}
	
	public boolean isEmpty(){
		if(this.size==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
