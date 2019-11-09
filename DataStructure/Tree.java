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


	/**从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行**/
	public static ArrayList<ArrayList<Integer>> printFromTop(TreeNode root){
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
							oddStack.push(node.left);
							oddStack.push(node.right);
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

	public static class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}

	/***剑指offer：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针**/

	public static TreeLinkNode getNext(TreeLinkNode node){
		if (node == null) {
			return null;
		}
		TreeLinkNode target = null;
		if (node.right != null) {
			target = node.right;
			while(target != null){
				target = target.left;
			}
			return target;
		}else{
			if (node.next != null) {
				target = node.next;
				TreeLinkNode cur = node;
				//判定当前节点是否为父亲节点的左子树，如果是父亲节点的左子树直接返回，否则为右子树
				while (target != null && target.left != cur) {
					cur = target;
					target = target.left;
				}
				return target;
			}
		}
		return target;
	}

	/***剑指offer：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的**/

	public static boolean isSymmetrical(TreeNode node1, TreeNode node2){
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			
			return false;
		}
		//两个值相等则证明是对称的；
		if (node1.value == node2.value) {
			
			return true;
		}

		return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
	}

	/**
	*这里定义一个二叉搜索树类型的类，相关的算法在这里实现
	**/
	public static class BSTree{

		/**leetcode——Increasing Order Search Tree：给定一个二叉搜索树，输出为只有右子树的二叉树***/
		TreeNode head = null;
		TreeNode node = null;
		public static TreeNode increasingBST(TreeNode root){
			increasingMidBST(root);
			return head;
		}

		public static void increasingMidBST(TreeNode root){
			if(root != null){
	            midOrder(root.left);
	            if(node == null){
	                node = root;
	                head = root;
	            }else{
	                node.right = new TreeNode(root.value);
	                node = node.right;
	            }
	            System.out.println("Node: " + node.value);
	            midOrder(root.right);
	        }else{
	            return;
	        }
		}
	}

}