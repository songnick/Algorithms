import java.util.Stack;


public class Tree{
	public static void main(String[] args) {
		
	}

	public static class TreeNode{
		public TreeNode left;
		public TreeNode right;

		public int value;

		public TreeNode(int value){
			this.value = value;
		}

		public static TreeNode buildTest(){

			return null;
		}

		public static TreeNode build(int[] data){

			return null;
		}
	}


	public static void depthFirstSearch(TreeNode root){
		if (root != null) {
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			while(!stack.isEmpty()){
				TreeNode node = stack.pop();
				if (node != null) {
					System.out.println(" node: " + node.value);
					stack.push(node.left);
					stack.push(node.right);
				}
			}
		}
	}
}