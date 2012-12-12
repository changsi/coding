/**
 * 
 */
package tree;

/**
 * @author changsi
 *
 */
public class PreOrderInOrderBuildingTree {
	
	/*Inorder sequence: D B E A F C
	Preorder sequence: A B D E C F

	In a Preorder sequence, leftmost element is the root of the tree. So we know ‘A’ is root for given sequences. By searching ‘A’ in Inorder sequence, we can find out all elements on left side of ‘A’ are in left subtree and elements on right are in right subtree. So we know below structure now.

	                 A
	               /   \
	             /       \
	           D B E     F C
	We recursively follow above steps and get the following tree.

	         A
	       /   \
	     /       \
	    B         C
	   / \        /
	 /     \    /
	D       E  F
	Algorithm: buildTree()
	1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call.
	2) Create a new tree node tNode with the data as picked element.
	3) Find the picked element’s index in Inorder. Let the index be inIndex.
	4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
	5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
	6) return tNode.
*/
	static int pre_index = 0;
	
	public static TreeNode buildTree(int[] in_order, int in_start, int in_end, int[] pre_order){
		
		if(in_start>in_end){
			return null;
		}
		TreeNode node = new TreeNode(pre_order[pre_index]);
		pre_index++;
		if(in_start == in_end){
			return node;
		}
		int index = search(in_order, in_start, in_end, node.value);
		node.left = buildTree(in_order, in_start, index-1, pre_order);
		node.right = buildTree(in_order, index+1, in_end, pre_order);
		return node;
	}
	
	public static int search(int[] in_order, int in_start, int in_end, int value){
		for(int i=in_start; i<=in_end; i++){
			if(in_order[i]==value){
				return i;
			}
		}
		return -1;
	}
	
	public static void inOrderPrint(TreeNode root){
		if(root != null){
			inOrderPrint(root.left);
			System.out.print(root.value+"	");
			inOrderPrint(root.right);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] in_order = {4, 2, 5, 1, 6, 3};
		int [] pre_order = {1, 2, 4, 5, 3, 6};
		TreeNode root = buildTree(in_order, 0, in_order.length-1, pre_order);
		inOrderPrint(root);
	}

}
