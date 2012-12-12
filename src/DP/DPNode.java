/**
 * 
 */
package DP;

/**
 * @author changsi
 *
 */
public class DPNode {
	
	int value;
	
	char c;
	
	int index;
	
	DPNode previous;
	
	public DPNode(){
		this.c = ' ';
	}
	
	public DPNode(int value, DPNode previous){
		this.value = value;
		this.previous = previous;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
