public class TreeNode{

	public int mValue = 0;

	public TreeNode(int value){
		mValue = value;
	}

	public TreeNode mLeft = null;

	public TreeNode mRight = null;


	public static TreeNode createTree(){
		TreeNode node = new TreeNode(3);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		node.mLeft = left;
		node.mRight = right;
		left.mLeft = new TreeNode(4);
		left.mRight = new TreeNode(8);
		right.mLeft = new TreeNode(9);
		right.mRight = new TreeNode(1);
		return node;
	}

	public static void preTrace(TreeNode head){
		if (head != null) {
			System.out.println("value: " + head.mValue);
			preTrace(head.mLeft);
			preTrace(head.mRight);
		}
	}


	public static void midTrace(TreeNode head){
		if (head != null) {
			midTrace(head.mLeft);
			System.out.println("value: " + head.mValue);
			midTrace(head.mRight);
		}
	}

	public static void postTrace(TreeNode head){
		if (head != null) {
			postTrace(head.mLeft);
			postTrace(head.mRight);
			System.out.println("value: " + head.mValue);
		}
	}
	public static void main(String[] args) {
		// preTrace(createTree());
		midTrace(createTree());
	}


}