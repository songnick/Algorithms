import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
public class DFS{
	public static void main(String[] args) {
		dfs(buildTest());
		bfs(buildTest());
	}

	public static void dfs(TreeNode root){
		if (root == null) {
			return ;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.println(" node: " + node.value);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	public static void bfs(TreeNode root){
		if (root == null) {
			return ;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int index = 1;
		while(!queue.isEmpty()){
			int size = queue.size();
			System.out.println(" index: " + index);
			ArrayList<Integer> list = new ArrayList<>();
			for (int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				if(index % 2 == 0){
					list.add(node.value);
				}else{
					list.add(0, node.value);
				}
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			System.out.println("->"+ list);
			index++;
		}
	}

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

}