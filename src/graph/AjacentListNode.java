/**
 * 
 */
package graph;

/**
 * @author changsi
 *
 */
public class AjacentListNode {
	
	int vertex;
	int weight;
	AjacentListNode next;
	
	public AjacentListNode(int vertex, int weight, AjacentListNode next){
		this.vertex=vertex;
		this.weight = weight;
		this.next = next;
	}
	
	
}
