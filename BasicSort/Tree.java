import java.util.Stack;


public class Tree{
	public static void main(String[] args) {
		testDepth();
	}

	private static void testDepth(){
		depthFirstSearch(TreeNode.buildTest());
	}


	public static class TreeNode{
		public TreeNode left;
		public TreeNode right;

		public int value;

		public TreeNode(int value){
			this.value = value;
		}

		/**
		*    0
		*   / \
		*	1  2
		**/
		public static TreeNode buildTest(){
			TreeNode root = new TreeNode(0);
			TreeNode node = new TreeNode(1);
			TreeNode node1 = new TreeNode(2);
			TreeNode node2 = new TreeNode(3);
			TreeNode node3 = new TreeNode(4);
			TreeNode node4 = new TreeNode(5);
			TreeNode node5 = new TreeNode(6);
			root.left = node;
			root.right = node1;
			node.left = node2;
			node.right = node3;
			node1.left = node4;
			node1.right = node5;
			return root;
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
					stack.push(node.right);
					stack.push(node.left);
				}
			}
		}
	}
}