/**
 * 
 */
package tree;

/**
 * @author changsi
 *
 */
public class TreeNode {
	
	public int value;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	
	public TreeNode(int value){
		this.value=value;
		this.left = null;
		this.right = null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNodePointer{
	public TreeNode pointer;
}
