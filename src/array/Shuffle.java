/**
 * 
 */
package array;

/**
 * @author changsi
 *
 */
public class Shuffle {
	
	ShuffleNode [] questions;
	
	public Shuffle(int a){
		this.questions = new ShuffleNode[a];
		for(int i=0;i<a;i++){
			this.questions[i] = new ShuffleNode(i);
		}
	}
	
	public void shuffle(){
		for(int i=0; i<this.questions.length;i++){
			this.questions[i].shuffle_id = (int)(Math.random()*Integer.MAX_VALUE);
		}
		quick_sort(this.questions,0,this.questions.length-1);
		print();
	}
	
	public void print(){
		for(int i=0; i<this.questions.length;i++){
			System.out.print(this.questions[i].card_id+"  "+this.questions[i].shuffle_id+" | ");
		}
		System.out.println();
	}
	
	
	public static void quick_sort(ShuffleNode [] array, int start, int end){
		if(start == end){
			return;
		}
		else{
			if(start == end-1){
				if(array[start].compareTo(array[end])>0 ){
					swich(array, end, start);
					return;
				}
				else{
					return;
				}
			}
			else{
				int mid = (end - start)/2 + start;
				ShuffleNode pivot_value = array[mid];
				swich(array, end, mid);
				int start_pointer = start;
				int end_pointer = end-1;
				while(start_pointer < end_pointer){
					while(array[start_pointer].compareTo(pivot_value)<0 && start_pointer< end_pointer){
						start_pointer++;
					}
					while(array[end_pointer].compareTo(pivot_value)>=0 && end_pointer > start_pointer){
						end_pointer--;
					}
					if(start_pointer<end_pointer){
						swich(array, start_pointer, end_pointer);
					}
					
				}
				swich(array, start_pointer, end);
				
				if(start< start_pointer -1){
					quick_sort( array, start, start_pointer-1);
				}
				if(end>start_pointer +1){
					quick_sort(array, start_pointer+1, end);
				}
				
			}
			
			return;
			
		}
		
	}
	
	private static void swich(ShuffleNode [] array, int index1, int index2){
		ShuffleNode temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shuffle shuffle = new Shuffle(20);
		shuffle.shuffle();
		System.out.println("-----------------------------------------");
		shuffle.shuffle();
	}

}
