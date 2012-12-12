/**
 * 
 */
package array;

import java.util.Comparator;

/**
 * @author changsi
 *
 */
public class ShuffleNode implements Comparable<ShuffleNode> {

	int card_id;
	int shuffle_id;
	
	public ShuffleNode(int card_id){
		this.card_id=card_id;
	}

	public int compareTo(ShuffleNode o) {
		// TODO Auto-generated method stub
		if(this.shuffle_id>o.shuffle_id){
			return 1;
		}
		else if (this.shuffle_id<o.shuffle_id){
			return -1;
		}
		return 0;
	}

	
}
