/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;

import queue.Queue;


/**
 * @author changsi
 *
 */
public class CloneGraph {
	
	public static Node cloneGraph(Node graph){
		Queue<Node> queue = new Queue<Node>();;
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node clone;
		queue.push(graph);
		clone = new Node();
		map.put(graph, clone);
		while(!queue.isEmpty()){
			Node tmp = queue.pop();
			Node tmpClone;
			tmpClone = map.get(tmp);
			
			ArrayList<Node> tmpNeighbors = tmp.neighbors;
			for(int i=0; i<tmpNeighbors.size(); i++){
				if(map.containsKey(tmpNeighbors.get(i))){
					Node tmpClonedNeighbor = map.get(tmpNeighbors.get(i));
					tmpClone.neighbors.add(tmpClonedNeighbor);
				}else{
					Node tmpClonedNeighbor = new Node();
					map.put(tmpNeighbors.get(i), tmpClonedNeighbor);
					tmpClone.neighbors.add(tmpClonedNeighbor);
					queue.push(tmpNeighbors.get(i));
				}
			}
		}
		return clone;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
