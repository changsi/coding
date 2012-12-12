/**
 * 
 */
package graph;

/**
 * @author changsi
 *
 */
public class Vertex {
	
	String name;
	AjacentListNode pointer;
	
	public Vertex(String name){
		this.name=name;
		this.pointer=null;
	}
	
}
