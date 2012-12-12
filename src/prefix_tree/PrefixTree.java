/**
 * 
 */
package prefix_tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author changsi
 *
 */
public class PrefixTree {
	
	private Node root;
 	
	
	public PrefixTree(){
		this.root = new Node();
	}


	public Node search(String word){
		char [] char_array = word.toCharArray();
		Node temp = this.root;
		for(int i=0; i<char_array.length; i++){
			char c = char_array[i];
			
			if(c == '$' && temp.get_child(26)!=null){
				return temp.get_child(26);
			}
			else{
				if(c == '$'){
					return null;
				}
				int index = c-'a';
				if(temp.get_child(index) == null){
						return null;
				}
				else{
					temp = temp.get_child(index);
				}
			}
		}
		return null;
	}
	
	public ArrayList<String> search_prefix(String prefix){
		
		char [] char_array = prefix.toCharArray();
		Node temp = this.root;
		for(int i=0; i<char_array.length; i++){
			char c = char_array[i];
			int index = c-'a';
			if(temp.get_child(index) == null){
				return null;
			}
			else{
				temp= temp.get_child(index);
			}
		}
		ArrayList<String> array = traverse(temp);
		return array;
	}
	
	private ArrayList<String> traverse(Node node){
		ArrayList<String> array = new ArrayList<String>();
		if(node.get_child(26)!=null){
			array.add(node.get_child(26).get_value());
		}
		for(int i=0;i<25;i++){
			Node temp_node =null;
			if((temp_node = node.get_child(i))!=null){
				array.addAll(traverse(temp_node));
			}
		}
		return array;
	}

	public boolean insert(String word){

		char [] char_array = word.toCharArray();
		Node temp = this.root;
		for(int i=0; i<char_array.length; i++){
			char c = char_array[i];
			if(c == '$'){
				if(temp.get_child(26) !=null){
					System.out.println("the word is already in the tree!");
					return false;
				}
				else{
					Node node = new Node(c, word, 2);
					temp.add_child(node, 26);
					return true;
				}
			}
			else{
				int index = c-'a';
				if(temp.get_child(index) == null){
					Node node = new Node(c, null, 1);
					temp.add_child(node, index);
				}
				temp = temp.get_child(index);
			}
			
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrefixTree tree = new PrefixTree();
		try {
			BufferedReader reader = new BufferedReader (new FileReader( "company code.txt"));
			String line=reader.readLine();
			
			while(line != null){
				StringTokenizer tokenizer= new StringTokenizer(line);
				String code = tokenizer.nextToken();
				tree.insert(code.toLowerCase()+"$");
				line = reader.readLine();
			}
			
			ArrayList<String> result = tree.search_prefix("a");
			for(int i=0;i<result.size();i++){
				System.out.println(result.get(i));
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		}

	}

}
