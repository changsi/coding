/**
 * 
 */
package tree.common_ancester;

import java.util.HashMap;

import tree.TreeNode;

/**
 * @author changsi
 *
 */
public class CommonAncester {
	
	public static TreeNode find_without_parent(TreeNode root, TreeNode a, TreeNode b){
		if(root == null){
			return null;
		}
		if(root==a || root ==b){
			return root;
		}
		TreeNode left = find_without_parent(root.left, a, b);
		TreeNode right = find_without_parent(root.right,a ,b);
		if(left!=null && right!=null){
			return root;
		}
		else{
			return left==null? right: left;
		}
	}
	
	public static TreeNode find_with_parent( TreeNode a, TreeNode b){
		HashMap<TreeNode, TreeNode> hash = new HashMap<TreeNode, TreeNode>();
		while(a!=null || b!=null){
			if(a!=null){
				if(!hash.containsKey(a)){
					hash.put(a, null);
					a = a.parent;
				}else{
					return a;
				}
			}
			if(b!=null){
				if(!hash.containsKey(b)){
					hash.put(b, null);
					b = b.parent;
				}else{
					return b;
				}
			}
		}
		return null;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
