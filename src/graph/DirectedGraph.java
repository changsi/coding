/**
 * 
 */
package graph;

import heap.Heap;

import java.util.ArrayList;
import java.util.HashMap;

import queue.Queue;

/**
 * @author changsi
 *
 */
public class DirectedGraph {
	// contains the adjacent list
	Vertex[] array;
	//
	int count;
	// contains the vertex name to array position mapping
	HashMap<String, Integer> map;
	
	public DirectedGraph(int n){
		array = new Vertex[n];
		map = new HashMap<String, Integer>(n);
		this.count = 0;
	}
	
	public int addNode(String name){
		if(map.containsKey(name)){
			return map.get(name);
		}else{
			Vertex vertex = new Vertex(name);
			array[this.count]=vertex;
			map.put(name, this.count);
			int result = this.count;
			this.count++;
			return result;
		}
		
	}
	
	public void addEdge(String node1, String node2, int weight){
		int position_node1=-1;
		int position_node2 = -1;
		if(!this.map.containsKey(node1)){
			position_node1=addNode(node1);
		}else{
			position_node1=map.get(node1);
		}
		if(!this.map.containsKey(node2)){
			position_node2=addNode(node2);
		}else{
			position_node2=map.get(node2);
		}
		AjacentListNode edge_node = new AjacentListNode(position_node2, weight, this.array[position_node1].pointer);
		this.array[position_node1].pointer = edge_node;
	}
	
	public void print(){
		for(int i=0; i<this.array.length;i++){
			if(array[i]==null){
				System.out.println("null");
			}else{
				System.out.print(array[i].name+": ");
				AjacentListNode temp = array[i].pointer;
				while(temp!=null){
					System.out.print("->"+array[temp.vertex].name+"("+temp.weight+")    ");
					temp=temp.next;
				}
				System.out.println();
			}
		}
	}
	
	public void breath_first_search(String start, String end){
		Queue<Vertex> queue = new Queue<Vertex>();
		int start_position = this.map.get(start);
		int end_position = this.map.get(end);
		TrackNode[] track_table= new TrackNode[this.array.length];
		for(int i=0; i<this.array.length;i++){
			track_table[i]=new TrackNode(false, 0, -1);
		}
		queue.push(this.array[start_position]);
		track_table[start_position].visited=true;
		track_table[start_position].distance=0;
		while(!queue.isEmpty()){
			Vertex temp = queue.pop();
			AjacentListNode temp_node = temp.pointer;
			while(temp_node!=null){
				if(!track_table[temp_node.vertex].visited){
					if(temp_node.vertex==end_position){
						System.out.print(end+"->");
						int last = this.map.get(temp.name);
						while(last!=start_position){
							System.out.print(this.array[last].name+"->");
							last = track_table[last].last_vertex;
						}
						System.out.print(start);
						return;
					}
					queue.push(this.array[temp_node.vertex]);
					track_table[temp_node.vertex].visited=true;
					track_table[temp_node.vertex].last_vertex=this.map.get(temp.name);
				}
				temp_node = temp_node.next;
			}
		}
	}
	
	public void uniform_search(String start, String end){
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectedGraph graph = new DirectedGraph(7);
		for(int i=1; i<8; i++){
			graph.addNode("v"+i);
		}
		graph.addEdge("v3", "v1", 4);
		graph.addEdge("v3", "v6", 5);
		graph.addEdge("v1", "v4", 1);
		graph.addEdge("v1", "v2", 2);
		graph.addEdge("v4", "v3", 2);
		graph.addEdge("v4", "v6", 8);
		graph.addEdge("v4", "v5", 2);
		graph.addEdge("v4", "v7", 4);
		graph.addEdge("v2", "v4", 3);
		graph.addEdge("v2", "v5", 10);
		graph.addEdge("v5", "v7", 6);
		graph.addEdge("v7", "v6", 1);
		graph.print();
		graph.breath_first_search("v1", "v7");
	}

}
