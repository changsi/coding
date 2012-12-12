/**
 * 
 */
package tree;

import tree.TreeNode;
import tree.common_ancester.CommonAncester;

/**
 * @author changsi
 *
 */
public class BinaryTree {
	
	TreeNode root;
	
	public BinaryTree(){
		this.root=null;
	}
	
	public TreeNode addLeft(TreeNode node, int value){
		TreeNode left = new TreeNode(value);
		left.parent = node;
		node.left = left;
		return left;
	}
	
	public TreeNode addRight(TreeNode node, int value){
		TreeNode right = new TreeNode(value);
		right.parent = node;
		node.right = right;
		return right;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(3);
		TreeNode node_5=tree.addLeft(tree.root, 5);
		TreeNode node_1=tree.addRight(tree.root, 1);
		TreeNode node_6=tree.addLeft(node_5, 6);
		TreeNode node_2=tree.addRight(node_5, 2);
		TreeNode node_0=tree.addLeft(node_1, 0);
		TreeNode node_8=tree.addRight(node_1, 8);
		TreeNode node_11=tree.addLeft(node_6, 11);
		TreeNode node_12=tree.addRight(node_6, 12);
		TreeNode node_7=tree.addLeft(node_2, 7);
		TreeNode node_4=tree.addRight(node_2, 4);
		
		System.out.println(CommonAncester.find_with_parent( node_12, node_11).value);
	}

}
