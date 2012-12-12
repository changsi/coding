/**
 * 
 */
package prefix_tree;

/**
 * @author changsi
 *
 */

//
public class Node{

	private char c;		// the label for this node
	private Node[] children;	// the array of children pointer
	private String value;	//for the leaf node the value is the reference to the string you want to store
				  // for inner node the value is null
	private int type;	// 1 represent inner node; 2 represent leaf node

	public Node(){
		this.c=' ';
		this.children = new Node[27];
		this.value = null;
		this.type = 1;
	}

	public Node(char c, String value, int type){
		this.c = c;
		this.value = value;
		this.children = new Node[27];
		this.type = type;
	}
	
	public char get_c(){
		return this.c;
	}

	public void set_c(char c){
		this.c = c;	
	}

	public String get_value(){
		return this.value;
	}

	public void set_value(String value){
		this.value = value;
	}

	public void add_child(Node node, int index){
		this.children[index] = node;
	}

	public Node get_child(int index){
		return this.children[index];
	}
	
	public void set_type(int type){
		this.type = type;
	}

	public int get_type(){
		return this.type;
	}
}
