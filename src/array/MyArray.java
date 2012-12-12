/**
 * 
 */
package array;

/**
 * @author changsi
 *
 */
public class MyArray {
	 int [] array;
	 int pointer;
	
	public MyArray(int [] array){
		this.array = array;
		this.pointer=0;
	}
	
	public int nextGEQ(int a){
		int d=this.array[pointer];
		while(d<a){
			this.pointer++;
			if(this.pointer==this.array.length){
				return Integer.MAX_VALUE;
			}
			d=this.array[pointer];
		}
		return d;
	}

}
