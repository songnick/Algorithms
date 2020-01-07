public class MirrorTree{
	public static void main(String[] args) {
		
	}

	public void mirrorTree(TreeNode root){
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null){
			return;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		if(root.left != null){
			mirrorTree(root.left);
		}
		if (root.right != null) {
			mirrorTree(root.right);
		}
	}
}