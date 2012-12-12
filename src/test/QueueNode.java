/**
 * 
 */
package test;

/**
 * @author changsi
 *
 */
public class QueueNode implements Comparable<QueueNode> {
	int id;
	double value;
	
	public QueueNode(int id, double value){
		this.id=id;
		this.value=value;
	}
	
	public int compareTo(QueueNode o){
		if(o.value>this.value){
			return 1;
		}else{
			if(o.value==this.value){
				return 0;
			}else{
				return -1;
			}
		}
	}

}
