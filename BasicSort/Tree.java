import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Tree{
	public static void main(String[] args) {
		testDepth();
		testBreadth();
		testPrintZ();
	}

	private static void testDepth(){
		depthFirstSearch(TreeNode.buildTest());
	}

	private static void testBreadth(){
		breadthFirstSearch(TreeNode.buildTest());
	}

	private static void testPrintZ(){
		printTreeZ(TreeNode.buildTest());
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


	/***
	**	树的深度优先遍历方法
	**/
	public static void depthFirstSearch(TreeNode root){
		if (root != null) {
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			while(!stack.isEmpty()){
				TreeNode node = stack.pop();
				if (node != null) {
					System.out.println(" depth: " + node.value);
					stack.push(node.right);
					stack.push(node.left);
				}
			}
		}
	}

	/***
		树的广度优先遍历
	**/
	public static void breadthFirstSearch(TreeNode root){
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()){
				TreeNode node = queue.poll();
				if (node != null) {
					System.out.println(" breadth: " + node.value);
					queue.add(node.left);
					queue.add(node.right);
				}
			}
		}
	}

	/***之字形打印树**/
	public static ArrayList<ArrayList<Integer>> printTreeZ(TreeNode root){
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (root != null) {
			Stack<TreeNode> oddStack = new Stack<>();
			oddStack.push(root);
			Stack<TreeNode> evenStack = new Stack<>();
			int index = 1;
			while(!oddStack.isEmpty() || !evenStack.isEmpty()){
				if (index % 2 != 0) {
					ArrayList<Integer> tt = new ArrayList<>();
					while(!oddStack.isEmpty()){
						TreeNode node = oddStack.pop();
						if (node != null) {
							System.out.println(" odd: " + node.value);
							tt.add(node.value);
							evenStack.push(node.left);
							evenStack.push(node.right);
						}
					}
					if (!tt.isEmpty()) {
						list.add(tt);
						index++;
					}
				}else{
					ArrayList<Integer> aa = new ArrayList<>();
					while(!evenStack.isEmpty()){
						TreeNode node = evenStack.pop();
						if (node != null) {
							aa.add(node.value);
							System.out.println(" even: " + node.value);
							oddStack.push(node.right);
							oddStack.push(node.left);
						}
					}
					if (!aa.isEmpty()) {
						list.add(aa);
						index++;
					}
				}
			}
		}

		return list;
	}


}