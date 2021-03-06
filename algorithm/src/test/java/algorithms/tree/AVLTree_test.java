package algorithms.tree;

public class AVLTree_test {
	
	
	
	private TreeNode insertIntoAVL(TreeNode root, int value){
		if(root == null){
			return new TreeNode(value);
		}
		if(root.data < value){
			root.right = insertIntoAVL(root.right, value);
		}
		else if(root.data > value){
			root.left = insertIntoAVL(root.left, value);
		}
		
		int balance = getBalance(root.left, root.right);
		if(balance > 1){
			if(height(root.left.left) >= height(root.left.right)){
				root = rightRotate(root);
			}else{
				root.left = leftRotate(root.left);
				root = rightRotate(root);
			}
		}
		else if(balance < -1){
			if(height(root.right.right) <= height(root.right.left)){
				root = leftRotate(root);
			}else{
				root.right = leftRotate(root.right);
				root = rightRotate(root);
			}
		}
		else{
			root.height = setHeight(root);
		}
		return root;
	}

	private int setHeight(TreeNode root) {
		if(root == null){
			return 0;
		}
		return 1+ (Math.max(root.left != null? root.left.height : 0, 
				root.right != null ? root.right.height : 0));
	}

	private TreeNode rightRotate(TreeNode root) {
		
		TreeNode newRoot = root.left;
		root.left = root.left.right;
		newRoot.right = root;
		
		newRoot.height = setHeight(newRoot);
		root.height=setHeight(root);		
		return newRoot;
	}
	
	private TreeNode leftRotate(TreeNode root){
		TreeNode newRoot = root.right;
		root.right = root.right.left;
		newRoot.left = root;
		
		newRoot.height = setHeight(newRoot);
		root.height = setHeight(root);
		return newRoot;
	}

	private int getBalance(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		return height(left) - height(right);
	}

	private int height(TreeNode root) {
		if(root == null){
			return 0;
		}
		else{
			return root.height; 
		}
	}

}
