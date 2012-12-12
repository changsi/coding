/**
 * 
 */
package tree;

import java.util.Stack;

/**
 * @author changsi
 * 
 */
public class BinarySearchTree {

	TreeNode root;

	public BinarySearchTree() {
		this.root = null;
	}
	
	public void convertToLinkList2(){
		TreeNodePointer header = new TreeNodePointer();
		TreeNodePointer pre = new TreeNodePointer();
		transform2(this.root, pre, header);
		TreeNode temp = header.pointer;
		while(temp.right!=null){
			System.out.print(temp.value+"	");
			temp = temp.right;
		}
		System.out.print(temp.value);
		System.out.println();
		while(temp!=null){
			System.out.print(temp.value+"	");
			temp = temp.left;
		}
	}
	
	public static boolean isBST(TreeNode node, TreeNodePointer pre){
		if(node==null){
			return true;
		}
		if(!isBST(node.left, pre)){
			return false;
		}
		if(pre.pointer!=null && node.value<pre.pointer.value){
			return false;
		}
		pre.pointer = node;
		if(!isBST(node.right, pre)){
			return false;
		}
		return true;
	}
	
	public void transform2(TreeNode node, TreeNodePointer pre, TreeNodePointer header){
		if(node == null){
			return;
		}
		transform2(node.left, pre, header);
		if(pre.pointer!=null){
			pre.pointer.right = node;
			node.left = pre.pointer;
		}else{
			header.pointer = node;
		}
		pre.pointer = node;
		transform2(node.right, pre, header);
	}
	
	public void convertToLinkList(){
		TreeNode head;
		TreeNode temp = this.root;
		while(temp.left!=null){
			temp = temp.left;
		}
		head = temp;
		TreeNode last = transform(this.root, null);
		temp = head;
		while(temp!=null){
			System.out.print(temp.value+"	");
			temp = temp.right;
		}
		System.out.println();
		temp = last;
		while(temp!=null){
			System.out.print(temp.value+"	");
			temp = temp.left;
		}
	}
	
	private TreeNode transform(TreeNode node, TreeNode pre){
		if(node == null){
			return null;
		}
		TreeNode left = transform(node.left, pre);
		if(left !=null){
			left.right = node;
			node.left = left;
		}
		else if(pre != null){
			pre.right = node;
			node.left = pre;
		}
		TreeNode right = transform(node.right, node);
		if(right == null){
			return node;
		}
		else{
			return right;
		}
	}
	
	public boolean isBalanced(TreeNode node, IntegerPointer pointer){
		boolean is_balanced_left = false;
		boolean is_balanced_right = false;
		int height_left = 0;
		int height_right = 0;
		if(node == null){
			pointer.value = 0;
			return true;
		}
		else{
			is_balanced_left = isBalanced(node.left, pointer);
			height_left = pointer.value;
			is_balanced_right = isBalanced(node.right, pointer);
			height_right = pointer.value;
			if(!is_balanced_left || !is_balanced_right){
				return false;
			}else{
				if((height_left - height_right)>1 || ( height_right-height_left)>1){
					return false;
				}else{
					pointer.value = (height_left>height_right? height_left: height_right)+1;
					return true;
				}
			}
		}
	}

	public void Insert(int value) {
		TreeNode node = new TreeNode(value);
		TreeNode temp = root;
		if (root == null) {
			root = node;
		}
		while (temp != null) {
			if (value >= temp.value) {
				if (temp.right == null) {
					temp.right = node;
					return;
				} else {
					temp = temp.right;
				}
			} else {
				if (temp.left == null) {
					temp.left = node;
					return;
				} else {
					temp = temp.left;
				}

			}
		}
	}

	public void inorder_iterate(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp_root = root;
		if(root==null){
			return;
		}
		while (true) {
			stack.push(temp_root);
			if (temp_root.left != null) {
				temp_root = temp_root.left;
			} else {
				break;
			}
		}

		while (!stack.isEmpty()) {
			temp_root = stack.pop();
			if (temp_root.right != null) {
				System.out.println(temp_root.value);
				temp_root = temp_root.right;
				while (true) {
					stack.push(temp_root);
					if (temp_root.left != null) {
						temp_root = temp_root.left;
					} else {
						break;
					}
				}
			} else {
				System.out.println(temp_root.value);
			}
		}
	}

	public static int find_common_ancester(TreeNode root, int node_1, int node_2) {
		while (true) {
			if (root.value > node_1 && root.value > node_2) {
				root = root.left;
			} else if (root.value < node_1 && root.value < node_2) {
				root = root.right;
			} else {
				return root.value;
			}
		}
	}

	public TreeNode delete_min(TreeNode node, IntegerPointer min) {
		if (node == null) {
			return null;
		} else {
			if (node.left == null) {
				min.value= node.value;
				return node.right;
			}
			else{
				node.left=delete_min(node.left,min);
				return node;
			}
		}
	}

	public TreeNode delete(int i, TreeNode node) throws Exception {
		if(node == null){
			throw new Exception("can not find element!");
		}else{
			if(i<node.value){
				node.left= delete(i,node.left);
				return node;
			}
			else if(i>node.value){
				node.right = delete(i, node.right);
				return node;
			}else{
				if(node.left==null || node.right==null){
					TreeNode temp;
					if(node.left==null){
						temp = node.right;
					}else{
						temp = node.left;
					}
					return temp;
				}
				else{
					IntegerPointer min=new IntegerPointer();
					node.right=delete_min(node.right, min);
					node.value = min.value;
					return node;
				}
			}
		}
	}

	public static boolean is_valid(TreeNode root, int max, int min) {
		if (root.value < min || root.value > max) {
			return false;
		} else {
			if (root.value < max) {
				max = root.value;
			}
			if (root.left == null) {
				return true;
			} else {
				if (!is_valid(root.left, min, max)) {
					return false;
				}
			}

			if (root.value > min) {
				min = root.value;
			}
			if (root.right == null) {
				return true;
			} else {
				if (!is_valid(root.right, min, max)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void print_path(TreeNode root, int node_1, int node_2) {
		int common_ancestor = BinarySearchTree.find_common_ancester(root,
				node_1, node_2);
		TreeNode root_temp = root;
		while (true) {
			if (common_ancestor < root_temp.value) {
				root_temp = root_temp.left;
			} else if (common_ancestor > root_temp.value) {
				root_temp = root_temp.right;
			} else {
				break;
			}
		}
		TreeNode common_ancester_node = root_temp;
		Stack<Integer> stack = new Stack<Integer>();
		while (true) {
			if (node_1 < root_temp.value) {

				stack.push(root_temp.value);
				root_temp = root_temp.left;
			} else if (node_1 > root_temp.value) {

				stack.push(root_temp.value);
				root_temp = root_temp.right;
			} else {
				stack.push(node_1);
				break;
			}
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		root_temp = common_ancester_node;
		while (true) {
			if (node_2 < root_temp.value) {
				System.out.println(root_temp.value);
				root_temp = root_temp.left;

			} else if (node_2 > root_temp.value) {

				System.out.println(root_temp.value);
				root_temp = root_temp.right;
			} else {
				System.out.println(node_2);
				break;
			}
		}

	}
	
	public TreeNode add_to_tree(int[] array, int start, int end){
		if(start == end){
			return new TreeNode(array[start]);
		}
		else{
			int mid = (end-start)/2+start;
			TreeNode temp = new TreeNode(array[mid]);
			if(mid>start){
				temp.left = add_to_tree(array, start, mid-1);
			}else{
				temp.left=null;
			}
			if(mid<end){
				temp.right = add_to_tree(array, mid+1, end);
			}else{
				temp.right=null;
			}
			return temp;
		}
		
	}
	
	public void generate_from_sorted_array(int[] array){
		this.root = add_to_tree(array, 0, array.length-1);
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree nums = new BinarySearchTree();
		nums.Insert(23);
		nums.Insert(24);
		nums.Insert(25);
		nums.Insert(16);
		nums.Insert(15);
		nums.Insert(14);
		nums.Insert(13);
		nums.Insert(100);
		nums.Insert(12);
		nums.Insert(32);
		nums.Insert(1);
		nums.Insert(13);
		nums.Insert(10);
		System.out.println(isBST(nums.root,  new TreeNodePointer()));
		//nums.inorder_iterate(nums.root);
		/*if(nums.isBalanced(nums.root, new IntegerPointer())){
			System.out.println("balanced");
		}else{
			System.out.println("unbalanced");
		}*/
		/*
		int [] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		nums.generate_from_sorted_array(array);
		if(nums.isBalanced(nums.root, new IntegerPointer())){
			System.out.println("balanced");
		}else{
			System.out.println("unbalanced");
		}
		*/
		//nums.convertToLinkList2();
		// BinarySearchTree.inorder_iterate(nums.root);
		// BinarySearchTree.print_path(nums.root, 12, 32);

	}

}
