/**
 * 
 */
package graph;

/**
 * @author changsi
 *
 */
public class TrackNode {
	
	boolean visited;
	int distance;
	int last_vertex;
	
	public TrackNode(boolean visited, int distance, int last_vertex){
		this.visited=visited;
		this.distance=distance;
		this.last_vertex = last_vertex;
	}
	
}
